package clinic.service.core;


import clinic.dao.api.EventDao;
import clinic.dto.EventDTO;
import clinic.dto.EventOutDTO;
import clinic.entities.Event;
import clinic.entities.enums.EventStatus;
import clinic.entities.enums.ManipulationType;
import clinic.mappers.EventMapper;
import clinic.service.api.EventService;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl extends AbstractServiceImpl<Event, EventDTO, EventDao, EventMapper>
        implements EventService {
    private final AmqpTemplate template;

    @Autowired
    public EventServiceImpl(EventDao dao, EventMapper mapper, AmqpTemplate template) {
        super(dao, mapper);
        this.template = template;
    }

    private static final Logger log = Logger.getLogger(EventServiceImpl.class);

    @Transactional
    public List<EventDTO> getAllEvents() {
        List<EventDTO> events = mapToDTO(dao.findAll());
        checkEventFailed(events);
        return events;
    }


    @Transactional
    public List<EventDTO> getAllByPatientId(Integer patientId) {
        List<EventDTO> events = mapToDTO(dao.findAllByPatientId(patientId));
        checkEventFailed(events);
        return events;
    }

    @Transactional
    public List<EventDTO> getAllEventsToday() {
        return mapToDTO(dao.findAllByDate(LocalDate.now()));
    }

    @Transactional
    public List<EventDTO> getAllEventsNow() {
        LocalDate date = LocalDate.now();
        LocalTime endTime = LocalTime.now().plusHours(1);
        LocalTime startTime = LocalTime.now().minusHours(1);
        return mapToDTO(dao.findAllByDateTime(date, startTime, endTime));
    }

    @Transactional
    public List<EventDTO> getAllByCaseId(Long caseId) {
        List<EventDTO> events = mapToDTO(dao.findAllByCaseId(caseId));
        checkEventFailed(events);
        return events;
    }

    @Transactional
    public List<EventDTO> getAllByPrescriptionId(Long prescriptionId) {
        return mapToDTO(dao.findAllByPrescriptionId(prescriptionId));
    }

    @Transactional
    public List<EventDTO> getEventsPlannedByCaseId(Long caseId) {
        return getAllByCaseId(caseId).stream()
                .filter(eventDTO -> eventDTO.getStatus().equals("planned"))
                .collect(Collectors.toList());
    }

    @Transactional
    public void eventDone(Long eventId) {
        EventDTO eventDTO = getOneById(eventId);
        eventDTO.setStatus(EventStatus.COMPLETED.getDescription());
        dao.update(mapToEntity(eventDTO));
        template.convertAndSend("queue1", "Message to queue - eventDone");
        log.info("The event#" + eventId + " completed");
        log.info("send message: Message to queue - eventDone");
    }

    @Transactional
    public void eventCancel(Long eventId, String comment) {
        EventDTO eventDTO = getOneById(eventId);
        eventDTO.setStatus(EventStatus.CANCELED.getDescription());
        eventDTO.setComment(comment);
        dao.update(mapToEntity(eventDTO));
        template.convertAndSend("queue1", "Message to queue - eventCancel");
        log.info("The event#" + eventId + " canceled");
        log.info("send message: Message to queue - eventCancel");
    }

    @Override
    public EventDTO eventCreate(EventDTO eventDto) {
        eventDto = checkTime(eventDto);
        if (eventDto.getDate().equals(LocalDate.now())) {
            template.convertAndSend("queue1", "Message to queue - eventCreate");
            log.info("send message: Message to queue - eventCreate");
        }
        return mapToDTO(dao.save(mapToEntity(eventDto)));
    }

    private EventDTO checkTime(EventDTO eventDTO) {
        if (!eventDTO.getManipulation().getType().equals(ManipulationType.PROCEDURE)) {
            return eventDTO;
        }
        while (true) {
            List<EventDTO> list = getAllByPatientId(eventDTO.getPatient().getId())
                    .stream().filter(e -> e.getDate().equals(eventDTO.getDate())
                            && e.getTime().equals(eventDTO.getTime())
                            && e.getManipulation().getType().equals(ManipulationType.PROCEDURE))
                    .collect(Collectors.toList());
            if (list.size() == 0) {
                break;
            } else {
                eventDTO.setTime(eventDTO.getTime().plusHours(1));
            }
        }
        return eventDTO;
    }

    @Override
    public List<EventOutDTO> getEventsToInfoBoard() {
        List<EventDTO> events = getAllEventsToday();
        return convertDTOtoOut(events);
    }

    private List<EventOutDTO> convertDTOtoOut(List<EventDTO> eventDTOList) {
        List<EventOutDTO> result = new ArrayList<>();
        eventDTOList.forEach(eventDTO ->
                result.add(convertDTOtoOut(eventDTO))
        );
        return result;
    }

    private EventOutDTO convertDTOtoOut(EventDTO dto) {
        EventOutDTO outDTO = new EventOutDTO();
        outDTO.setId(dto.getId());
        outDTO.setPatient(dto.getPatient().getSecondName() + " "
                + dto.getPatient().getFirstName().charAt(0) + "."
                + dto.getPatient().getMiddleName().charAt(0) + ".");
        outDTO.setDoctor(dto.getPrescription().getPatientCase().getDoctor().getLogin());
        outDTO.setTime(dto.getTime().toString());
        return outDTO;
    }

    private void checkEventFailed(List<EventDTO> events) {
        events.forEach(eventDTO -> {
            if (eventDTO.getStatus().equals(EventStatus.PLANNED.getDescription())
                    && eventDTO.getDate().isBefore(LocalDate.now())) {
                eventDTO.setStatus(EventStatus.FAILED.getDescription());
                dao.update(mapToEntity(eventDTO));
            }
        });
    }
}

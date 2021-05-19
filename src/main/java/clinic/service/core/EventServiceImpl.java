package clinic.service.core;

import clinic.dao.api.EventDao;
import clinic.dto.EventDTO;
import clinic.entities.Event;
import clinic.entities.enums.EventStatus;
import clinic.mappers.EventMapper;
import clinic.service.api.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl extends AbstractServiceImpl<Event, EventDTO, EventDao, EventMapper>
        implements EventService {
    @Autowired
    public EventServiceImpl(EventDao dao, EventMapper mapper) {
        super(dao, mapper);
    }

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
    }

    @Transactional
    public void eventCancel(Long eventId, String comment) {
        EventDTO eventDTO = getOneById(eventId);
        eventDTO.setStatus(EventStatus.CANCELED.getDescription());
        eventDTO.setComment(comment);
        dao.update(mapToEntity(eventDTO));
    }

    private void checkEventFailed(List<EventDTO> events) {
        events.forEach(eventDTO -> {
            if (eventDTO.getStatus().equals(EventStatus.PLANNED.getDescription())
                    && eventDTO.getDate().isBefore(LocalDate.now().minusDays(1))) {
                eventDTO.setStatus(EventStatus.FAILED.getDescription());
                dao.update(mapToEntity(eventDTO));
            }
        });
    }
}

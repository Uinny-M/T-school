package clinic.service.core;

import clinic.controller.PatientController;
import clinic.dao.api.PrescriptionDao;
import clinic.dto.EventDTO;
import clinic.dto.PrescriptionDTO;
import clinic.entities.Prescription;
import clinic.entities.enums.EventStatus;
import clinic.exception.BusinessException;
import clinic.mappers.PrescriptionMapper;
import clinic.service.api.CaseService;
import clinic.service.api.EventService;
import clinic.service.api.ManipulationService;
import clinic.service.api.PrescriptionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class PrescriptionServiceImpl extends AbstractServiceImpl<Prescription, PrescriptionDTO,
        PrescriptionDao, PrescriptionMapper> implements PrescriptionService {

    private final CaseService caseService;
    private final ManipulationService manipulationService;
    private final EventService eventService;

    @Autowired
    public PrescriptionServiceImpl(PrescriptionDao dao, PrescriptionMapper mapper, CaseService caseService, ManipulationService manipulationService, EventService eventService) {
        super(dao, mapper);
        this.caseService = caseService;
        this.manipulationService = manipulationService;
        this.eventService = eventService;
    }
    private static Logger log = Logger.getLogger(PrescriptionServiceImpl.class);

    @Transactional
    @Override
    public List<PrescriptionDTO> getAllByPatientId(Integer patientId) {
        return mapToDTO(dao.findAllByPatientId(patientId));
    }

    @Transactional
    @Override
    public List<PrescriptionDTO> getAllByCaseId(Long caseId) {
        return mapToDTO(dao.findAllByCaseId(caseId));
    }

    @Transactional
    @Override
    public PrescriptionDTO createPrescription(PrescriptionDTO prescriptionDTO, Long caseId) {
//        if (!caseService.getOneById(caseId).isOpenCase()){
//            throw new BusinessException("The case is already closed");
//        }

        validate(prescriptionDTO);
        Set<DayOfWeek> days = prescriptionDTO.getWeekdays();
        Set<String> times = prescriptionDTO.getTimes();
        prescriptionDTO.setManipulation(manipulationService.getOneByTitle(prescriptionDTO.getManipulationTitle()));
        prescriptionDTO.setPatientCase(caseService.getOneById(caseId));
        prescriptionDTO.setPatient(caseService.getOneById(caseId).getPatient());
        Prescription prescription = dao.save(mapToEntity(prescriptionDTO));
        //create events
        List<LocalTime> timePattern = timePattern(times);
        List<LocalDate> dayPattern = dayPattern(days, prescriptionDTO.getDuration(), timePattern);
        for (int i = 0; i < dayPattern.size(); i++) {
            for (int j = 0; j < timePattern.size(); j++) {
                EventDTO eventDTO = new EventDTO();
                eventDTO.setPatient(prescriptionDTO.getPatient());
                eventDTO.setPrescription(mapToDTO(prescription));
                eventDTO.setManipulation(prescriptionDTO.getManipulation());
                eventDTO.setDate(dayPattern.get(i));
                eventDTO.setTime(timePattern.get(j));
                eventDTO.setStatus(EventStatus.PLANNED.getDescription());
                eventService.eventCreate(eventDTO);
            }
        }
        log.info("New prescription in case#" + caseId + " created");
        return prescriptionDTO;
    }

    @Transactional
    @Override
    public void prescriptionCancel(Long prescriptionId) {
        PrescriptionDTO prescription = getOneById(prescriptionId);
        prescription.setClosed(true);
        dao.update(mapToEntity(prescription));

        eventService.getAllByPrescriptionId(prescriptionId).forEach(eventDTO -> {
            LocalDate now = LocalDate.now();
            if (eventDTO.getDate().isAfter(now.minusDays(1))) {
                eventService.eventCancel(eventDTO.getId(), "by doctor");
            }
        });
        log.info("Prescription #" + prescriptionId + " closed");
    }

    private List<LocalDate> dayPattern(Set<DayOfWeek> days, byte duration, List<LocalTime> timePattern) {
        List<LocalDate> dayPattern = new ArrayList<>();
        LocalTime now = LocalTime.now().plusMinutes(30);
        LocalDate date = LocalDate.now();
        if (timePattern.stream().noneMatch(t -> t.isAfter(now))) {
            date = date.plusDays(1);
        }
        while (!days.contains(date.getDayOfWeek())) {
            date = date.plusDays(1);
        }
        dayPattern.add(date); //start Date
        while (duration > 1) {
            date = date.plusDays(1);
            if (days.contains(date.getDayOfWeek())) {
                dayPattern.add(date);
            }
            duration--;
        }
        return dayPattern;
    }

    private List<LocalTime> timePattern(Set<String> times) {
        List<LocalTime> timePattern = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        times.forEach(t -> timePattern.add(LocalTime.parse(t, formatter)));
        return timePattern;
    }

    public void validate(Long caseId){
        if (!caseService.getOneById(caseId).isOpenCase()){
            throw new BusinessException("The case is already closed");
        }
    }
    private void validate (PrescriptionDTO prescriptionDTO){
        StringBuilder msg = new StringBuilder("");
        if(prescriptionDTO.getDuration() <= 0) {
            msg.append("duration must be > 0; ");
        }
        if (prescriptionDTO.getWeekdays().size()==0){
            msg.append("Days of week cannot be empty; ");
        }
        if (prescriptionDTO.getTimes().size()==0){
            msg.append("Time of day cannot be empty; ");
        }
        if (!msg.isEmpty()){
            throw new BusinessException("Incorrect data: " + msg.toString());
        }
    }
}

package clinic.service.core;

import clinic.dao.api.PrescriptionDao;
import clinic.dto.EventDTO;
import clinic.dto.PrescriptionDTO;
import clinic.entities.Prescription;
import clinic.entities.enums.EventStatus;
import clinic.mappers.PrescriptionMapper;
import clinic.service.api.CaseService;
import clinic.service.api.EventService;
import clinic.service.api.ManipulationService;
import clinic.service.api.PrescriptionService;
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
        Set<DayOfWeek> days = prescriptionDTO.getWeekdays();
        Set<String> times = prescriptionDTO.getTimes();
        prescriptionDTO.setManipulation(manipulationService.getOneByTitle(prescriptionDTO.getManipulationTitle()));
        prescriptionDTO.setPatientCase(caseService.getOneById(caseId));
        prescriptionDTO.setPatient(caseService.getOneById(caseId).getPatient());
        Prescription prescription = dao.save(mapToEntity(prescriptionDTO));
        //create events
        List<LocalDate> dayPattern = dayPattern(days, prescriptionDTO.getDuration());
        List<LocalTime> timePattern = timePattern(times);
        for (int i = 0; i < dayPattern.size(); i++) {
            for (int j = 0; j < timePattern.size(); j++) {
                EventDTO eventDTO = new EventDTO();
                eventDTO.setPatient(prescriptionDTO.getPatient());
                eventDTO.setPrescription(mapToDTO(prescription));
                eventDTO.setManipulation(prescriptionDTO.getManipulation());
                eventDTO.setDate(dayPattern.get(i));
                eventDTO.setTime(timePattern.get(j));
                eventDTO.setStatus(EventStatus.PLANNED.getDescription());
                eventService.create(eventDTO);
            }
        }
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
                eventService.eventCancel(eventDTO.getId(), "по решению врача");
            }
        });
    }

    private List<LocalDate> dayPattern(Set<DayOfWeek> days, byte duration) {
        List<LocalDate> dayPattern = new ArrayList<>();
        LocalDate date = LocalDate.now().plusDays(1);
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
}

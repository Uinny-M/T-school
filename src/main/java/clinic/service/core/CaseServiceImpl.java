package clinic.service.core;

import clinic.dao.api.CaseDao;
import clinic.dao.api.PrescriptionDao;
import clinic.dto.CaseDTO;
import clinic.dto.EmployeeDTO;
import clinic.entities.Case;
import clinic.entities.enums.EventStatus;
import clinic.mappers.CaseMapper;
import clinic.service.api.CaseService;
import clinic.service.api.EmployeeService;
import clinic.service.api.EventService;
import clinic.service.api.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaseServiceImpl extends AbstractServiceImpl<Case, CaseDTO, CaseDao, CaseMapper> implements CaseService {
    private final EventService eventService;
    private final PatientService patientService;
    private final EmployeeService employeeService;
    private final PrescriptionDao prescriptionDao;

    @Autowired
    private CaseServiceImpl(CaseDao dao, CaseMapper mapper, EventService eventService, PatientService patientService,
                            EmployeeService employeeService, PrescriptionDao prescriptionDao) {
        super(dao, mapper);
        this.eventService = eventService;
        this.patientService = patientService;
        this.employeeService = employeeService;
        this.prescriptionDao = prescriptionDao;
    }

    @Transactional
    public List<CaseDTO> getCasesByPatientId(Integer patientId) {
        return mapToDTO(dao.findCasesByPatientId(patientId));
    }

    @Transactional
    public List<CaseDTO> getAllOpenCases() {
        return mapToDTO(dao.findAll().stream().filter(Case::isOpenCase).collect(Collectors.toList()));
    }

    @Transactional
    public void closeCase(Long caseId) {
        CaseDTO caseDTO = getOneById(caseId);
        caseDTO.setOpenCase(false);
        caseDTO.setEndDate(LocalDate.now());
        dao.update(mapToEntity(caseDTO));

        prescriptionDao.findAllByCaseId(caseId).forEach(prescription -> {
                    if (!prescription.isClosed()) {
                        prescription.setDeleted(true);
                        prescriptionDao.update(prescription);
                    }
                }
        );

        eventService.getAllByCaseId(caseId).forEach(eventDTO -> {
            LocalDate now = LocalDate.now();
                if (eventDTO.getDate().isAfter(now.minusDays(1))) {
                eventService.eventCancel(eventDTO.getId(), "по решению врача");
            }
        });
    }

    @Transactional
    public CaseDTO createCase(String diagnosis, Integer patientId) {
        CaseDTO caseDTO = new CaseDTO();
        caseDTO.setDoctor(getCurrentUser());
        caseDTO.setPatient(patientService.getOneById(patientId));
        caseDTO.setStartDate(LocalDate.now());
        if (!diagnosis.isEmpty()) {
            caseDTO.setDiagnosis(diagnosis);
        } else {
            caseDTO.setDiagnosis("Не установлен");
        }
        dao.save(mapToEntity(caseDTO));
        return caseDTO;
    }

    @Transactional
    public CaseDTO updateCase(String diagnosis, Long caseId) {
        CaseDTO caseDTO = getOneById(caseId);
        caseDTO.setDiagnosis(diagnosis);
        caseDTO.setId(caseId);
        dao.update(mapToEntity(caseDTO));
        return caseDTO;
    }

    private EmployeeDTO getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return employeeService.getEmployeeByUsername(username);
    }
}

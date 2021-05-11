package clinic.service.core;

import clinic.dao.api.CaseDao;
import clinic.dao.api.EventDao;
import clinic.dto.CaseDTO;
import clinic.entities.Case;
import clinic.mappers.CaseMapper;
import clinic.service.api.CaseService;
import clinic.service.api.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaseServiceImpl extends AbstractServiceImpl<Case, CaseDTO, CaseDao, CaseMapper> implements CaseService {
 private final EventService eventService;
    @Autowired
    private CaseServiceImpl(CaseDao dao, CaseMapper mapper, EventService eventService) {
        super(dao, mapper);
        this.eventService = eventService;
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
    public List<Case> getCases(Integer i) {
        return dao.findAll().stream().filter(Case::isOpenCase).collect(Collectors.toList());
    }

    @Transactional
    public void closeCase(Long caseId) {
        eventService.getAllByCaseId(caseId); //todo
    }
}

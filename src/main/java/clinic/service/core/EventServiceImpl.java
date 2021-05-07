package clinic.service.core;

import clinic.dao.api.EventDao;
import clinic.dto.EventDTO;
import clinic.entities.Event;
import clinic.mappers.EventMapper;
import clinic.service.api.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Service
public class EventServiceImpl extends AbstractServiceImpl<Event, EventDTO, EventDao, EventMapper>
        implements EventService {
    @Autowired
    public EventServiceImpl(EventDao dao, EventMapper mapper) {
        super(dao, mapper);
    }

    @Transactional
    public List<EventDTO> getAllByPatientId(Integer patientId) {
        return mapToDTO(dao.findAllByPatientId(patientId));
    }

    @Transactional
    public List<EventDTO> getAllEventsToday() {
        return mapToDTO(dao.findAllByDate(LocalDate.now()));
    }

    @Transactional
    public List<EventDTO> getAllEventsNow() {
        LocalDate date = LocalDate.now();
        LocalTime endTime = LocalTime.now().plusHours(1);
        return mapToDTO(dao.findAllByDateTime(date, endTime));
    }

    @Transactional
    public List<EventDTO> getAllByCaseId(Long caseId) {
        return mapToDTO(dao.findAllByCaseId(caseId));
    }
}

package clinic.dao.api;

import clinic.entities.Event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface EventDao extends AbstractDao<Event> {
    List<Event> findAllByPatientId(Integer patientId);
    List<Event> findAllByDate(LocalDate date);
    List<Event> findAllByDateTime(LocalDate date, LocalTime startTime, LocalTime endTime);
    List<Event> findAllByCaseId(Long caseId);
}

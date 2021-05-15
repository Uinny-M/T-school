package clinic.dao.core;

import clinic.dao.api.EventDao;
import clinic.entities.Event;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public class EventDaoImpl extends AbstractHibernateDao<Event> implements EventDao {
    public EventDaoImpl() {
        super(Event.class);
    }

    @Override
    public List<Event> findAllByDate(LocalDate date) {
        return em.createQuery(
                "SELECT e FROM Event e WHERE e.date = :date AND e.status = 1 ")
                .setParameter("date", date)
                .getResultList();
    }

    @Override
    public List<Event> findAllByPatientId(Integer patientId) {
        return em.createQuery(
                "SELECT e FROM Event e WHERE e.patient.id = :patientId " +
                        " ORDER BY date")
                .setParameter("patientId", patientId)
                .getResultList();
    }

    @Override
    public List<Event> findAllByDateTime(LocalDate date, LocalTime starttime, LocalTime endtime) {
        return em.createQuery(
                "SELECT e FROM Event e WHERE e.date = :date " +
                        " AND e.time < :endtime AND e.time > :starttime AND e.status = 1 " +
                        " ORDER BY time ")
                .setParameter("date", date)
                .setParameter("starttime", starttime)
                .setParameter("endtime", endtime)
                .getResultList();
    }

    @Override
    public List<Event> findAllByCaseId(Long caseId) {
        return em.createQuery(
                "SELECT e FROM Event e WHERE e.prescription.patientCase = :caseId ORDER BY time")
                .setParameter("caseId", caseId)
                .getResultList();
    }
}

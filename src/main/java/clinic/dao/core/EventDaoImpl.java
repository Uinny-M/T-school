package clinic.dao.core;

import clinic.dao.api.EventDao;
import clinic.entities.Event;
import clinic.entities.enums.EventStatus;
import org.springframework.stereotype.Repository;

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
                "SELECT e FROM Event e WHERE e.date = :date AND e.status = :status ")
                .setParameter("status", EventStatus.PLANNED)
                .setParameter("date", date)
                .getResultList();
    }

    @Override
    public List<Event> findAllByPatientId(Integer patientId) {
        return em.createQuery(
                "SELECT e FROM Event e WHERE e.patient.id = :patientId " +
                        " ORDER BY e.date desc ")
                .setParameter("patientId", patientId)
                .getResultList();
    }

    @Override
    public List<Event> findAllByDateTime(LocalDate date, LocalTime starttime, LocalTime endtime) {
        return em.createQuery(
                "SELECT e FROM Event e WHERE e.date = :date " +
                        " AND e.time < :endtime AND e.time > :starttime AND e.status = :status " +
                        " ORDER BY e.time DESC ")
                .setParameter("date", date)
                .setParameter("status", EventStatus.PLANNED)
                .setParameter("starttime", starttime)
                .setParameter("endtime", endtime)
                .getResultList();
    }

    @Override
    public List<Event> findAllByCaseId(Long caseId) {
        return em.createQuery(
                "SELECT e FROM Event e WHERE e.prescription.patientCase.id = :caseId ORDER BY e.time desc ")
                .setParameter("caseId", caseId)
                .getResultList();
    }

    @Override
    public List<Event> findAllByPrescriptionId(Long prescriptionId) {
        return em.createQuery(
                "SELECT e FROM Event e WHERE e.prescription.id = :prescriptionId ORDER BY e.time desc ")
                .setParameter("prescriptionId", prescriptionId)
                .getResultList();
    }
}

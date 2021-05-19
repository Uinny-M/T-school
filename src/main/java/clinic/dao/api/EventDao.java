package clinic.dao.api;

import clinic.entities.Event;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Event's dao
 *
 * CRUD for event from AbstractDao
 * Get list of events by patient
 * Get list of events for today
 * Get list of events for the next our
 * Get list of events by case
 */
public interface EventDao extends AbstractDao<Event> {

    /**
     * Get list of events by patient's id
     * @param patientId patient's id
     */
    List<Event> findAllByPatientId(Integer patientId);

    /**
     * Get list of events for date
     * @param date date
     */
    List<Event> findAllByDate(LocalDate date);

    /**
     * Get list of events for date in the period of time
     * @param date date
     * @param startTime from time
     * @param endTime to time
     */
    List<Event> findAllByDateTime(LocalDate date, LocalTime startTime, LocalTime endTime);

    /**
     * Get list of events by case's id
     * @param caseId case's id
     */
    List<Event> findAllByCaseId(Long caseId);

    /**
     * Get list of events by prescription's Id
     * @param prescriptionId prescription's Id
     */
    List<Event> findAllByPrescriptionId(Long prescriptionId);
}

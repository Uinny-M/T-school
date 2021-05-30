package clinic.service.api;

import clinic.dto.EventDTO;
import clinic.entities.Event;

import java.util.List;

/**
 * Event's service
 * <p>
 * CRUD for event from AbstractService
 * Get list of events by patient
 * Get list of events for today
 * Get list of events for the next our
 * Get list of events by case
 * Get list of planned events by case
 */
public interface EventService extends AbstractService<Event, EventDTO> {

    /**
     * Get list of events by patient's id
     *
     * @param patientId patient's id
     */
    List<EventDTO> getAllByPatientId(Integer patientId);

    /**
     * Get list of all events with check failed events
     *
     */
    List<EventDTO> getAllEvents();

    /**
     * Get list of events for today
     */
    List<EventDTO> getAllEventsToday();

    /**
     * Get list of events for the next our
     */
    List<EventDTO> getAllEventsNow();

    /**
     * Get list of events by case's id
     *
     * @param caseId case's id
     */
    List<EventDTO> getAllByCaseId(Long caseId);

    /**
     * Get list of events by prescription's Id
     *
     * @param prescriptionId case's id
     */
    List<EventDTO> getAllByPrescriptionId(Long prescriptionId);

    /**
     * Get list of planned events by case's id
     *
     * @param caseId case's id
     */
    List<EventDTO> getEventsPlannedByCaseId(Long caseId);

    /**
     * Change eventStatus to completed
     *
     * @param eventId event's id
     */
    void eventDone(Long eventId);

    /**
     * Change eventStatus to canceled
     *
     * @param eventId event's id
     * @param comment reason for cancellation
     */
    void eventCancel(Long eventId, String comment);
}

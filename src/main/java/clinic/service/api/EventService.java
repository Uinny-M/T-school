package clinic.service.api;

import clinic.dto.EventDTO;
import clinic.entities.Event;

import java.util.List;

public interface EventService extends AbstractService<Event, EventDTO> {
    List<EventDTO> getAllByPatientId(Integer patientId);

    List<EventDTO> getAllEventsToday();

    List<EventDTO> getAllEventsNow();

    List<EventDTO> getAllByCaseId(Long caseId);

    List<EventDTO> getEventsPlannedByCaseId(Long caseId);
}

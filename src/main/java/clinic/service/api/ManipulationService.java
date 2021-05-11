package clinic.service.api;

import clinic.dto.ManipulationDTO;
import clinic.entities.Manipulation;

import java.util.List;

public interface ManipulationService extends AbstractService<Manipulation, ManipulationDTO> {
List<ManipulationDTO> getAllManipulation();
}

package clinic.service.api;

import clinic.dto.ManipulationDTO;
import clinic.entities.Manipulation;

import java.util.List;
/**
 * Manipulation's service
 *
 * CRUD for manipulation from AbstractService
 */
public interface ManipulationService extends AbstractService<Manipulation, ManipulationDTO> {
    /**
     * Get Manipulation by title
     * @param title manipulation's title
     */
    ManipulationDTO getOneByTitle(String title);
}

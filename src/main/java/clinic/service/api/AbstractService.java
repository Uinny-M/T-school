package clinic.service.api;


import java.util.List;
/**
 * Abstract service
 *
 * CRUD for all entities
 * Convert Entity to DTO
 * Convert DTO to Entity
 */
public interface AbstractService <T, DTO>{
    /**
     * Get a DTO by DTO's id
     * @param id DTO's id
     */
    DTO getOneById(Number id);

    /**
     * Get all DTOs
     */
    List<DTO> getAll();

    /**
     * Create a DTO by DTO's data
     * @param dto DTO's data
     */
    DTO create(DTO dto);

    /**
     * Update the DTO by DTO's data
     * @param dto DTO's data
     */
    DTO update(DTO dto);

    /**
     * Create or update the DTO by DTO's data
     * @param dto DTO's data
     */
    DTO createOrUpdate(DTO dto);

    /**
     * Delete the DTO by DTO's data
     * @param dto DTO's data
     */
    void delete(DTO dto); //todo изменить на софт

    /**
     * Delete the DTO by DTO's id
     * @param entityId DTO's id
     */
    void deleteById(Number entityId);

    /**
     * Convert Entity to DTO
     * @param entity Entity's data
     */
    DTO mapToDTO(T entity);

    /**
     * Convert list of Entities to list of DTOs
     * @param entities list of Entities
     */
    List<DTO> mapToDTO(List<T> entities);

    /**
     * Convert DTO to Entity
     * @param dto dto's data
     */
    T mapToEntity(DTO dto);

    /**
     * Convert list of DTOs to list of Entities
     * @param dtoList list of dtos
     */
    List<T> mapToEntity(List<DTO> dtoList);
}

package clinic.service.api;


import java.util.List;

public interface AbstractService <T, DTO>{
    DTO getOneById(Number id);

    List<DTO> getAll();

    DTO create(DTO dto);

    DTO update(DTO dto);

    DTO createOrUpdate(DTO dto);

    void delete(DTO dto); //todo изменить на софт

    void deleteById(Number entityId);

    DTO mapToDTO(T entity);

    List<DTO> mapToDTO(List<T> entities);

    T mapToEntity(DTO dto);

    List<T> mapToEntity(List<DTO> dtoList);
}

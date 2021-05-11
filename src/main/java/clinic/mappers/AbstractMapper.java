package clinic.mappers;

import java.util.List;

public interface AbstractMapper<T, DTO>{
    T mapDtoToEntity(DTO dto);
    DTO mapEntityToDto(T entity);

    List<T> mapDtoToEntity(List<DTO> dto);
    List<DTO> mapEntityToDto(List<T> entity);
}

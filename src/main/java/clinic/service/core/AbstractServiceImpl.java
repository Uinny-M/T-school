package clinic.service.core;

import clinic.dao.api.AbstractDao;
import clinic.mappers.AbstractMapper;
import clinic.service.api.AbstractService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


public abstract class AbstractServiceImpl<T, DTO, Dao extends AbstractDao, Mapper extends AbstractMapper>
        implements AbstractService<T,DTO> {


    protected final Dao dao;
    protected final Mapper mapper;

    public AbstractServiceImpl(Dao dao, Mapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }


    @Override
    @Transactional(readOnly = true)
    public DTO getOneById(Number id) {
        return mapToDTO((T) dao.findById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<DTO> getAll() {
        return mapToDTO(dao.findAll());
        //return mapToDTO(dao.findAll());
    }

    @Override
    @Transactional
    public DTO create(DTO dto) {
        return mapToDTO((T) dao.save(mapToEntity(dto)));
    }

    @Override
    @Transactional
    public DTO update(DTO dto) {
        return mapToDTO((T) dao.update(mapToEntity(dto)));
    }

    @Transactional
    @Override
    public DTO createOrUpdate(DTO dto) {
        if (getAll().contains(dto)) {
            update(dto);
        }
        else create(dto);
        return dto;
    }

    @Override
    @Transactional
    public void delete(DTO dto) {
        dao.delete(mapToEntity(dto));
    }

    @Override
    @Transactional
    public void deleteById(Number entityId) {
        dao.deleteById(entityId);
    }

    @Override
    public DTO mapToDTO(T entity){

    return (DTO) mapper.mapEntityToDto(entity);
    }

    @Override
    public List<DTO> mapToDTO(List<T> entities) {
        return entities.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public T mapToEntity(DTO dto){
       return (T) mapper.mapDtoToEntity(dto);
    }

    @Override
    public List<T> mapToEntity(List<DTO> dtos) {
        return dtos.stream().map(this::mapToEntity).collect(Collectors.toList());
    }
}

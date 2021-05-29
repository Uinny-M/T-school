package clinic.mappers;

import clinic.dto.ManipulationDTO;
import clinic.entities.Manipulation;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-29T20:37:39+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 13.0.2 (AdoptOpenJDK)"
)
@Component
public class ManipulationMapperImpl implements ManipulationMapper {

    @Override
    public List<Manipulation> mapDtoToEntity(List<ManipulationDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<Manipulation> list = new ArrayList<Manipulation>( dto.size() );
        for ( ManipulationDTO manipulationDTO : dto ) {
            list.add( mapDtoToEntity( manipulationDTO ) );
        }

        return list;
    }

    @Override
    public List<ManipulationDTO> mapEntityToDto(List<Manipulation> entity) {
        if ( entity == null ) {
            return null;
        }

        List<ManipulationDTO> list = new ArrayList<ManipulationDTO>( entity.size() );
        for ( Manipulation manipulation : entity ) {
            list.add( mapEntityToDto( manipulation ) );
        }

        return list;
    }

    @Override
    public ManipulationDTO mapEntityToDto(Manipulation entity) {
        if ( entity == null ) {
            return null;
        }

        ManipulationDTO manipulationDTO = new ManipulationDTO();

        manipulationDTO.setId( entity.getId() );
        manipulationDTO.setTitle( entity.getTitle() );
        manipulationDTO.setType( entity.getType() );
        manipulationDTO.setDeleted( entity.isDeleted() );

        return manipulationDTO;
    }

    @Override
    public Manipulation mapDtoToEntity(ManipulationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Manipulation manipulation = new Manipulation();

        manipulation.setId( dto.getId() );
        manipulation.setTitle( dto.getTitle() );
        manipulation.setType( dto.getType() );
        manipulation.setDeleted( dto.isDeleted() );

        return manipulation;
    }
}

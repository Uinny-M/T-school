package clinic.mappers;

import clinic.dto.ManipulationDTO;
import clinic.entities.Manipulation;
import clinic.entities.enums.ManipulationType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-12T01:46:51+0300",
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
        if ( entity.getType() != null ) {
            manipulationDTO.setType( entity.getType().name() );
        }
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
        if ( dto.getType() != null ) {
            manipulation.setType( Enum.valueOf( ManipulationType.class, dto.getType() ) );
        }
        manipulation.setDeleted( dto.isDeleted() );

        return manipulation;
    }
}

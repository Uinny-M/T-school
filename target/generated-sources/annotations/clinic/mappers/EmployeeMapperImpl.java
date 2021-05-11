package clinic.mappers;

import clinic.dto.EmployeeDTO;
import clinic.entities.Employee;
import clinic.entities.enums.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-11T10:46:37+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 13.0.2 (AdoptOpenJDK)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public List<Employee> mapDtoToEntity(List<EmployeeDTO> dto) {
        if ( dto == null ) {
            return null;
        }

        List<Employee> list = new ArrayList<Employee>( dto.size() );
        for ( EmployeeDTO employeeDTO : dto ) {
            list.add( mapDtoToEntity( employeeDTO ) );
        }

        return list;
    }

    @Override
    public List<EmployeeDTO> mapEntityToDto(List<Employee> entity) {
        if ( entity == null ) {
            return null;
        }

        List<EmployeeDTO> list = new ArrayList<EmployeeDTO>( entity.size() );
        for ( Employee employee : entity ) {
            list.add( mapEntityToDto( employee ) );
        }

        return list;
    }

    @Override
    public EmployeeDTO mapEntityToDto(Employee entity) {
        if ( entity == null ) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setId( entity.getId() );
        employeeDTO.setSecondName( entity.getSecondName() );
        employeeDTO.setFirstName( entity.getFirstName() );
        employeeDTO.setMiddleName( entity.getMiddleName() );
        employeeDTO.setPosition( entity.getPosition() );
        employeeDTO.setLogin( entity.getLogin() );
        employeeDTO.setPassword( entity.getPassword() );
        employeeDTO.setDeleted( entity.isDeleted() );
        if ( entity.getRole() != null ) {
            employeeDTO.setRole( entity.getRole().name() );
        }

        return employeeDTO;
    }

    @Override
    public Employee mapDtoToEntity(EmployeeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( dto.getId() );
        employee.setSecondName( dto.getSecondName() );
        employee.setFirstName( dto.getFirstName() );
        employee.setMiddleName( dto.getMiddleName() );
        employee.setPosition( dto.getPosition() );
        employee.setLogin( dto.getLogin() );
        employee.setPassword( dto.getPassword() );
        employee.setDeleted( dto.isDeleted() );
        if ( dto.getRole() != null ) {
            employee.setRole( Enum.valueOf( Role.class, dto.getRole() ) );
        }

        return employee;
    }
}

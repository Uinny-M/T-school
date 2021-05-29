package clinic.mappers;

import clinic.dto.EmployeeDTO;
import clinic.entities.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-29T22:30:55+0300",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 13.0.2 (AdoptOpenJDK)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Autowired
    private RoleMapper roleMapper;

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
        employeeDTO.setRole( roleMapper.mapEnumToString( entity.getRole() ) );
        employeeDTO.setEnabled( entity.isEnabled() );

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
        employee.setEnabled( dto.isEnabled() );
        employee.setRole( roleMapper.mapStringToEnum( dto.getRole() ) );

        return employee;
    }
}

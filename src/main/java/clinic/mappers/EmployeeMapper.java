package clinic.mappers;

import clinic.dto.EmployeeDTO;
import clinic.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
uses = {RoleMapper.class})
public interface EmployeeMapper extends AbstractMapper<Employee, EmployeeDTO>{
    EmployeeDTO mapEntityToDto(Employee entity);

    Employee mapDtoToEntity(EmployeeDTO dto);
}

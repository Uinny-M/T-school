package clinic.mappers;

import clinic.dto.EmployeeDTO;
import clinic.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper extends AbstractMapper<Employee, EmployeeDTO>{
    EmployeeDTO mapEntityToDto(Employee entity);

    Employee mapDtoToEntity(EmployeeDTO dto);
}

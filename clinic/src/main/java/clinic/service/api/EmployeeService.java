package clinic.service.api;


import clinic.dto.EmployeeDTO;
import clinic.entities.Employee;

/**
 * Employee's service
 *
 * CRUD for employee from AbstractService
 */
public interface EmployeeService extends AbstractService<Employee, EmployeeDTO> {
    EmployeeDTO getEmployeeByUsername(String username);
}

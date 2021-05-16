package clinic.service.api;


import clinic.dto.EmployeeDTO;
import clinic.entities.Employee;

import java.util.List;

/**
 * Employee's service
 *
 * CRUD for employee from AbstractService
 */
public interface EmployeeService extends AbstractService<Employee, EmployeeDTO> {
    EmployeeDTO getEmployeeByUsername(String username);
}

package clinic.dao.api;

import clinic.entities.Employee;

import java.util.List;

/**
 * Employee's dao
 *
 * CRUD for employee from AbstractDao
 */
public interface EmployeeDao extends AbstractDao<Employee>{
    List<Employee> findByUsername(String username);
}

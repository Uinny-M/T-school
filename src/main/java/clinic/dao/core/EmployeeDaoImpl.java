package clinic.dao.core;


import clinic.dao.api.EmployeeDao;
import clinic.entities.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl extends AbstractHibernateDao<Employee> implements EmployeeDao {
    public EmployeeDaoImpl(){super(Employee.class);}
}

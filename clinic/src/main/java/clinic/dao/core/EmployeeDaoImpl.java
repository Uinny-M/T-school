package clinic.dao.core;


import clinic.dao.api.EmployeeDao;
import clinic.entities.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDaoImpl extends AbstractHibernateDao<Employee> implements EmployeeDao {
    public EmployeeDaoImpl() {
        super(Employee.class);
    }

    @Transactional
    public List<Employee> findByUsername(String username) {
        return em.createQuery(
                "SELECT e FROM Employee e WHERE e.login = :username")
                .setParameter("username", username)
                .getResultList();
    }
}

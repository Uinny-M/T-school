package clinic.service.core;

import clinic.dao.api.EmployeeDao;
import clinic.dto.EmployeeDTO;
import clinic.entities.Employee;
import clinic.mappers.EmployeeMapper;
import clinic.service.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl extends AbstractServiceImpl<Employee, EmployeeDTO, EmployeeDao, EmployeeMapper> implements EmployeeService {
    @Autowired
    public EmployeeServiceImpl(EmployeeDao dao, EmployeeMapper mapper) {
        super(dao, mapper);
    }
}

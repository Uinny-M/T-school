package clinic.service.core;

import clinic.dao.api.EmployeeDao;
import clinic.dto.EmployeeDTO;
import clinic.dto.PrescriptionDTO;
import clinic.entities.Employee;
import clinic.exception.BusinessException;
import clinic.mappers.EmployeeMapper;
import clinic.service.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl extends AbstractServiceImpl<Employee, EmployeeDTO, EmployeeDao, EmployeeMapper> implements EmployeeService {
    @Autowired
    public EmployeeServiceImpl(EmployeeDao dao, EmployeeMapper mapper) {
        super(dao, mapper);
    }

    @Transactional
    public EmployeeDTO getEmployeeByUsername(String username){
        return mapToDTO(dao.findByUsername(username).get(0));
    }

    @Override
    public EmployeeDTO create(EmployeeDTO employeeDTO) {
        validate(employeeDTO);
        return super.create(employeeDTO);
    }

    private void validate (EmployeeDTO employeeDTO) {
        StringBuilder msg = new StringBuilder("");
        if (employeeDTO.getSecondName().isEmpty()) {
            msg.append("SecondName; ");
        }
        if (employeeDTO.getFirstName().isEmpty()) {
            msg.append("FirstName; ");
        }
        if (employeeDTO.getPosition().isEmpty()) {
            msg.append("Position; ");
        }
        if (employeeDTO.getLogin().isEmpty()) {
            msg.append("Login; ");
        }
        if (employeeDTO.getPassword().isEmpty()) {
            msg.append("Password; ");
        }
        if (employeeDTO.getRole()==null) {
            msg.append("Role; ");
        }
        if (!msg.isEmpty()){
            throw new BusinessException("The fields cannot be empty: " + msg.toString());
        }
    }
}

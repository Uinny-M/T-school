package clinic.service.core;

import clinic.dao.api.ManipulationDao;
import clinic.dto.ManipulationDTO;
import clinic.entities.Manipulation;
import clinic.mappers.ManipulationMapper;
import clinic.service.api.ManipulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManipulationServiceImpl extends AbstractServiceImpl<Manipulation, ManipulationDTO, ManipulationDao, ManipulationMapper>
        implements ManipulationService {
    @Autowired
    public ManipulationServiceImpl(ManipulationDao dao, ManipulationMapper mapper){
        super(dao, mapper);
    }
}

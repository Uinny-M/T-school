package clinic.mappers;

import clinic.dto.PrescriptionDTO;
import clinic.entities.Prescription;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses ={EmployeeMapper.class, CaseMapper.class})
public interface PrescriptionMapper extends AbstractMapper<Prescription, PrescriptionDTO> {
    PrescriptionDTO mapEntityToDto(Prescription entity);
    Prescription mapDtoToEntity(PrescriptionDTO dto);
}

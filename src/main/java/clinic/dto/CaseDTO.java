package clinic.dto;

import clinic.entities.Employee;
import clinic.entities.Patient;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class CaseDTO {

    private Long id;

    //patient
    private PatientDTO patient;

    //patient's diagnosis
    private String diagnosis;

    //doctor in charge of the case
    private EmployeeDTO doctor;

    //start day of case
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    //finish day of case
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    //status of the case (patient's therapy continues?)
    private boolean openCase;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public EmployeeDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(EmployeeDTO doctor) {
        this.doctor = doctor;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isOpenCase() {
        return openCase;
    }

    public void setOpenCase(boolean openCase) {
        this.openCase = openCase;
    }
}

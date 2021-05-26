package clinic.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventDTO {

    private Long id;

    //patient's id
    private PatientDTO patient;

    //date of the event
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    //time of the event
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime time;

    //type of the manipulation
    private ManipulationDTO manipulation;

    //prescription
    private PrescriptionDTO prescription;

    //status of event (planned/completed/canceled/failed)
    private String status;

    //comment on the procedure
    private String comment;

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public ManipulationDTO getManipulation() {
        return manipulation;
    }

    public void setManipulation(ManipulationDTO manipulation) {
        this.manipulation = manipulation;
    }

    public PrescriptionDTO getPrescription() {
        return prescription;
    }

    public void setPrescription(PrescriptionDTO prescription) {
        this.prescription = prescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

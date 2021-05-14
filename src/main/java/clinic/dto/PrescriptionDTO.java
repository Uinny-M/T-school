package clinic.dto;

import clinic.entities.Case;
import clinic.entities.Manipulation;
import clinic.entities.Patient;
import clinic.entities.enums.Times;
import clinic.entities.enums.Weekday;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

public class PrescriptionDTO {

    private Long id;

    //patient
    private PatientDTO patient;

    //case
    private CaseDTO patientCase;

    //type of the manipulation
    private ManipulationDTO manipulation;

    //start day of prescription
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    //duration of manipulation (number of days)
    private byte duration;

    //select weekdays for manipulation
    private Set<Weekday> weekdays;

    //select time for manipulation
    @DateTimeFormat(pattern="HH:mm:ss")
    private Set<String> times;

    // manipulation's schedule
    private String schedule;

    //how many times a day
    private byte dailyChart;

    //name of the drug
    private String drug;

    //dosage of medication
    private String dosage;

    //is the prescription deleted
    private boolean isClosed;

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

    public CaseDTO getPatientCase() {
        return patientCase;
    }

    public void setPatientCase(CaseDTO patientCase) {
        this.patientCase = patientCase;
    }

    public ManipulationDTO getManipulation() {
        return manipulation;
    }

    public void setManipulation(ManipulationDTO manipulation) {
        this.manipulation = manipulation;
    }

    public Set<Weekday> getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(Set<Weekday> weekdays) {
        this.weekdays = weekdays;
    }

    public Set<String> getTimes() {
        return times;
    }

    public void setTimes(Set<String> times) {
        this.times = times;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public byte getDuration() {
        return duration;
    }

    public void setDuration(byte duration) {
        this.duration = duration;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public byte getDailyChart() {
        return dailyChart;
    }

    public void setDailyChart(byte dailyChart) {
        this.dailyChart = dailyChart;
    }

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public boolean isDeleted() {
        return isClosed;
    }

    public void setDeleted(boolean deleted) {
        isClosed = deleted;
    }
}

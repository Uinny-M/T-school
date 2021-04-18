package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Entity prescription
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prescription")
public class Prescription {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //patient's id
    @ManyToOne
    @Column(name = "patient_id", nullable = false)
    private Patient patient;

    //case's id
    @ManyToOne
    @Column(name = "case_id", nullable = false)
    private Case patientCase;

    //type of the manipulation
    @ManyToOne
    @Column(name = "manipulation_id", nullable = false)
    private Manipulation manipulation;

    //start day of prescription
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    //duration of manipulation (number of days)
    @Column(name = "duration", nullable = false)
    private byte duration;

    //select weekdays for manipulation
    @Column(name = "weekday")
    private String weekday;

    //how many times a day
    @Column(name = "daily_chart", nullable = false)
    private byte dailyChart;

    //name of the drug
    @Column(name = "drug", length = 40)
    private String drug;

    //dosage of medication
    @Column(name = "dosage")
    private String dosage;

    //is the perscription deleted
    @Column(name = "deleted", nullable = false, columnDefinition = "false")
    private boolean isDeleted;
}

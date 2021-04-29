package clinic.entities;

import clinic.entities.enums.EventStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Entity event
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "event")
public class Event {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //patient's id
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    //date and time of the event
    @Column(name = "date", nullable = false)
    private LocalDate date;

    //time of the event
    @Column(name = "time", nullable = false)
    private LocalTime time;

    //type of the manipulation
    @ManyToOne
    @JoinColumn(name = "manipulation_id", nullable = false)
    private Manipulation manipulation;

    //status of event (planned/completed/canceled/failed)
    @Column(name = "status", columnDefinition = "planned")
    @Enumerated(EnumType.ORDINAL)
    private EventStatus status;

    //comment on the procedure
    @Column(name = "comment")
    private String comment;

    //is the event deleted
    @Column(name = "deleted", nullable = false, columnDefinition = "false")
    private boolean isDeleted;
}

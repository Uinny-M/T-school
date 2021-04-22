package clinic.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Entity patient
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //patient's second name
    @Column(name = "second_name", nullable = false, length = 20)
    private String secondName;

    //patient's first name
    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    //patient's middle name
    @Column(name = "middle_name", nullable = false, length = 20)
    private String middleName;

    //patient's age
    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    //patient's gender
    @Column(name = "gender")
    private String gender;

    //patient's insurance policy number
    @Column(name = "insurance", nullable = false)
    private String insurance;
}

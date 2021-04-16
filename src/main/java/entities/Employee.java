package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Entity medical employee (doctor or nurse)
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
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

    //type of medical employee (doctor/nurse)
    @Column(name = "position", nullable = false)
    private String position;
}

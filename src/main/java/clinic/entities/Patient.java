package clinic.entities;

import clinic.entities.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * Entity patient
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patient")
public class Patient implements Serializable {

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
    @Enumerated(EnumType.STRING)
    private Gender gender;

    //patient's insurance policy number
    @Column(name = "insurance", nullable = false)
    private String insurance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getFirstName() {
        return firstName;
    }
}

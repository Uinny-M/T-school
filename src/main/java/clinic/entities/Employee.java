package clinic.entities;

import clinic.entities.enums.Role;
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

    //login for auth
    @Column(name = "username", nullable = false, length = 20)
    private String login;

    //password for auth
    @Column(name = "password", nullable = false, length = 20, columnDefinition = "password")
    private String password;

    //is the employee deleted
    @Column(name = "enabled", nullable = false, columnDefinition = "false")
    private boolean enabled;

    //employee's role
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

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

    public String getFirstName() {
        return firstName;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

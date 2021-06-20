package clinic.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class EmployeeDTO {
    private Integer id;

    //patient's second name
    @Length(min = 2)
    @NotEmpty(message = "Name cannot be empty")
    private String secondName;

    //patient's first
    @NotBlank(message = "Name cannot be empty")
    private String firstName;

    //patient's middle name
    @NotBlank(message = "Name cannot be empty")
    private String middleName;

    //type of medical employee (doctor/nurse/admin)
    private String position;

    //login for auth
    @NotBlank(message = "Login cannot be empty")
    private String login;

    //password for auth
    @NotBlank(message = "Password cannot be empty")
    private String password;

    //is the employee enabled
    private boolean enabled;

    //employee's role
    private String role;


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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnable() {
        return enabled;
    }

    public void setEnable(boolean enable) {
        this.enabled = enable;
    }
}

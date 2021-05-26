package clinic.entities;

import clinic.entities.enums.ManipulationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Entity manipulation
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "manipulation")
public class Manipulation {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte id;

    //name of manipulation
    @Column(name = "title", nullable = false)
    private String title;

    //type of manipulation
    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ManipulationType type;

    //is the manipulation deleted
    @Column(name = "deleted", nullable = false, columnDefinition = "false")
    private boolean isDeleted;

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ManipulationType getType() {
        return type;
    }

    public void setType(ManipulationType type) {
        this.type = type;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}

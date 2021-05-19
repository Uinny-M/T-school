package clinic.dto;

import clinic.entities.enums.ManipulationType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
public class ManipulationDTO {

    private byte id;

    //name of manipulation
    private String title;

    //type of manipulation
    private ManipulationType type;

    //is the manipulation deleted
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

package vu.lt.entities.keys;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class ProgramKey implements Serializable {

    @Column(name = "PERSON_ID")
    private Integer personId;

    @Column(name = "COACH_ID")
    private Integer coachId;

    @Override
    public int hashCode() {
        return Objects.hash(personId, coachId);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgramKey coPilotKey = (ProgramKey) o;
        return Objects.equals(personId, coPilotKey.personId) &&
                Objects.equals(coachId, coPilotKey.coachId);
    }

    public ProgramKey(){

    }
}
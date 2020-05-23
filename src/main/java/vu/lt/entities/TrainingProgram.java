package vu.lt.entities;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.keys.ProgramKey;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "TrainingProgram.findAll", query = "select a from TrainingProgram as a")
})
@Table(name = "TrainingProgram")
@Getter
@Setter
public class TrainingProgram {

    @EmbeddedId
    private ProgramKey id;

    @ManyToOne
    @MapsId("PERSON_ID")
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @ManyToOne
    @MapsId("COACH_ID")
    @JoinColumn(name = "COACH_ID")
    private Coach coach;

    /*@OneToMany(mappedBy = "program", fetch = FetchType.EAGER)
    private List<Exercise> programExercises = new ArrayList();

    @OneToMany(mappedBy = "program")
    private List<Person> personList = new ArrayList<>();*/

    private String name;

    public TrainingProgram(){

    }

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer version;

    @ManyToMany(mappedBy = "programs")
    private Collection<Exercise> exercises;

    public Collection<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(Collection<Exercise> exercises) {
        this.exercises = exercises;
    }
}

package vu.lt.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "TrainingProgram.findAll", query = "select a from TrainingProgram as a")
})
@Table(name = "TrainingProgram")
@Getter
@Setter
public class TrainingProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "program")
    private List<Exercise> programExercises;

    @OneToMany(mappedBy = "program")
    private List<Person> personList = new ArrayList<>();

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer version;
}

package vu.lt.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Exercise.findAll", query = "select a from Exercise as a"),
})

@Table(name = "Exercise")
@Getter
@Setter
public class Exercise implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Name")
    private String name;

    @Size(max = 50)
    @Column(name = "URL")
    private String url;

    @Column(name = "TimesPerApproach")
    private Integer timesPerApproach;

    @Column(name = "Approaches")
    private Integer approaches;

    @ManyToMany
    @JoinColumn(name = "program_id")
    List<TrainingProgram> programs;

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercise ex = (Exercise) o;
        return Objects.equals(id, ex.id) &&
                Objects.equals(timesPerApproach, ex.timesPerApproach)
                && Objects.equals(approaches, ex.approaches)
                && Objects.equals(name, ex.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timesPerApproach, approaches);
    }
}

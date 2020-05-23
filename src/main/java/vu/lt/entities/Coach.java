package vu.lt.entities;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "Coach.findAll", query = "select t from Coach as t")
})
@Table(name = "COACH")
@Getter @Setter
public class Coach {

    public Coach(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "coach", fetch = FetchType.EAGER)
    private List<Person> persons = new ArrayList<>();

    @OneToMany(mappedBy = "coach")
    private Set<TrainingProgram> trainingPrograms;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coach c = (Coach) o;
        return Objects.equals(name, c.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

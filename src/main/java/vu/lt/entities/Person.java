package vu.lt.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Person.findAll", query = "select a from Person as a")
})
@Table(name = "Person")
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "Birthdate")
    private String birthdate;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private TrainingProgram program;

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthdate);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(birthdate, person.birthdate);
    }
}

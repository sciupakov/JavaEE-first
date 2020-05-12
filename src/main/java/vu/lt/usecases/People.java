package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Exercise;
import vu.lt.entities.Person;
import vu.lt.persistence.ExercisesDAO;
import vu.lt.persistence.PersonDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class People {

    @Inject
    private PersonDAO personDAO;

    @Getter
    @Setter
    private Person personToCreate = new Person();

    @Getter
    private List<Person> allPeople;

    @PostConstruct
    public void init(){
        loadAllPpl();
    }

    private void loadAllPpl(){
        this.allPeople = personDAO.loadAll();
    }

    @Transactional
    public String createPpl(){
        this.personDAO.persist(personToCreate);
        return "index?faces-redirect=true";
    }
}

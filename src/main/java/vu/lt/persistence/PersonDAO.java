package vu.lt.persistence;

import vu.lt.entities.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class PersonDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Person> loadAll() {
        return em.createNamedQuery("Person.findAll", Person.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Person person){
        this.em.persist(person);
    }

    public Person findOne(Integer id) {
        return em.find(Person.class, id);
    }

}

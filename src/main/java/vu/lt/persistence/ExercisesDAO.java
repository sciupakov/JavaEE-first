package vu.lt.persistence;
/*
import vu.lt.entities.Exercise;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class ExercisesDAO {

    @PersistenceContext
    private EntityManager em;

    public void persist(Exercise exercise){
        this.em.persist(exercise);
    }

    public Exercise findOne(Integer id) {
        return em.find(Exercise.class, id);
    }

    public List<Exercise> findAll(Integer id) {
        return em.createNamedQuery("Exercise.findByProgram", Exercise.class).setParameter("program_id", id).getResultList();
    }

    public List<Exercise> loadAll() {
        return em.createNamedQuery("Exercise.findAll", Exercise.class).getResultList();
    }
}
*/
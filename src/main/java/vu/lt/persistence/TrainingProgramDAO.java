package vu.lt.persistence;

import vu.lt.entities.TrainingProgram;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class TrainingProgramDAO {

    @PersistenceContext
    private EntityManager em;

    public void persist(TrainingProgram pr){
        this.em.persist(pr);
    }

    public TrainingProgram findOne(Integer id) {
        return em.find(TrainingProgram.class, id);
    }

    public List<TrainingProgram> loadAll() {
        return em.createNamedQuery("TrainingProgram.findAll", TrainingProgram.class).getResultList();
    }
}

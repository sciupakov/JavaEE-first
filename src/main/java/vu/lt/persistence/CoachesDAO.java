package vu.lt.persistence;

import vu.lt.entities.Coach;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class CoachesDAO {
    @PersistenceContext
    private EntityManager em;

    public List<Coach> loadAll() {
        return em.createNamedQuery("Coach.findAll", Coach.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Coach c){
        this.em.persist(c);
    }

    public Coach findOne(Integer id) {
        return em.find(Coach.class, id);
    }
}

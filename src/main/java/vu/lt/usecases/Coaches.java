package vu.lt.usecases;
import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Coach;
import vu.lt.persistence.CoachesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Coaches {
    @Inject
    private CoachesDAO coachesDAO;

    @Getter @Setter
    private Coach coachToCreate = new Coach();

    @Getter
    private List<Coach> allCoaches;

    @PostConstruct
    public void init(){
        loadAllClasses();
    }

    @Transactional
    public String createCoach(){
        this.coachesDAO.persist(coachToCreate);
        return "index?faces-redirect=true";
    }

    private void loadAllClasses(){
        this.allCoaches = coachesDAO.loadAll();
    }
}

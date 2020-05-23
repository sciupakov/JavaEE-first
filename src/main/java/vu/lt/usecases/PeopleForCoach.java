package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Coach;
//import vu.lt.entities.Exercise;
import vu.lt.entities.Person;
import vu.lt.persistence.CoachesDAO;
//import vu.lt.persistence.ExercisesDAO;
import vu.lt.persistence.PersonDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Model
public class PeopleForCoach implements Serializable {

    @Inject
    private CoachesDAO coachDAO;

    @Inject
    private PersonDAO personDAO;

    @Getter @Setter
    private Coach coach;

    @Getter
    @Setter
    private Person personToCreate = new Person();

    @PostConstruct
    public void init() {

        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
            Integer coachId = Integer.parseInt(requestParameters.get("coachId"));
            this.coach = coachDAO.findOne(coachId);
    }

    @Transactional
    public String createPerson(){
        personToCreate.setCoach(this.coach);
        this.personDAO.persist(personToCreate);
        return "people?faces-redirect=true&coachId="+this.coach.getId();
    }
}

package vu.lt.usecases;

import jdk.jfr.SettingDefinition;
import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Coach;
//import vu.lt.entities.Exercise;
import vu.lt.entities.Person;
import vu.lt.entities.TrainingProgram;
import vu.lt.entities.keys.ProgramKey;
import vu.lt.persistence.CoachesDAO;
//import vu.lt.persistence.ExercisesDAO;
import vu.lt.persistence.PersonDAO;
import vu.lt.persistence.TrainingProgramDAO;
import vu.lt.services.Helper;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Model
public class TrainingPrograms {


    @Inject
    private TrainingProgramDAO trainingProgramDAO;

    @Inject
    private PersonDAO personDAO;

    @Inject
    private CoachesDAO coachesDAO;

    @Inject
    private Helper helper;

    @Getter @Setter
    private Coach coach;

    @Getter @Setter
    private Person person;

    @Getter
    @Setter
    private TrainingProgram programToCreate = new TrainingProgram();

    @Getter @Setter
    private ProgramKey programKey = new ProgramKey();

    @Getter
    private List<TrainingProgram> allPrograms;

    @Getter @Setter
    private TrainingProgram currentTrainingProgram;

    @PostConstruct
    public void init(){

        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();


            Integer coachId = Integer.parseInt(requestParameters.get("coachId"));
            Integer personId = Integer.parseInt(requestParameters.get("personId"));

            this.coach = coachesDAO.findOne(coachId);
            this.person = personDAO.findOne(personId);


            programKey.setPersonId(this.person.getId());
            programKey.setCoachId(this.coach.getId());
            findCoPilot();
            programToCreate.setId(programKey);


        /*//loadAllPrograms();
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        //if (requestParameters.get("programId") != null){
            Integer programId = Integer.parseInt(requestParameters.get("programId"));
            this.programExercises = exercisesDAO.findAll(programId);
            this.program = trainingProgramDAO.findOne(programId);

        //}*/

    }

    private void findCoPilot() {
        this.currentTrainingProgram = trainingProgramDAO.findTrainingProgram(programKey);
    }

    /*private void SetPrgExercise(){
        this.program.
    }*/

    @PreDestroy
    public void clearList(){
        helper.clearList();
    }

    @Transactional
    public String createProgram() {
        this.programToCreate.setPerson(this.person);
        this.programToCreate.setCoach(this.coach);
        this.trainingProgramDAO.saveOrUpdate(programToCreate);
        return "programs?faces-redirect=true&coachId="+this.coach.getId()+"&personId="+this.person.getId();
    }

    /*private void AddExercise(Exercise ex){
        exercisesDAO.persist(ex);
    }

    private void loadAllPrograms(){
        this.allPrograms = trainingProgramDAO.loadAll();
    }*/

    /*@Transactional
    public String createProgram(){
        this.trainingProgramDAO.persist(programToCreate);
        return "programs?programId="+programToCreate.getId();
    }*/



}

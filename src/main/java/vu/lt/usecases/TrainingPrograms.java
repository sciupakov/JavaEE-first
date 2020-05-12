package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Exercise;
import vu.lt.entities.TrainingProgram;
import vu.lt.persistence.ExercisesDAO;
import vu.lt.persistence.TrainingProgramDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class TrainingPrograms {

    @Inject
    private TrainingProgramDAO trainingProgramDAO;

    @Getter
    @Setter
    private TrainingProgram programToCreate = new TrainingProgram();

    @Getter
    private List<TrainingProgram> allPrograms;

    @PostConstruct
    public void init(){
        loadAllExcs();
    }

    private void loadAllExcs(){
        this.allPrograms = trainingProgramDAO.loadAll();
    }

    @Transactional
    public String createExc(){
        this.trainingProgramDAO.persist(programToCreate);
        return "index?faces-redirect=true";
    }

}

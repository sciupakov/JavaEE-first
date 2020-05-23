package vu.lt.usecases;
/*
import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Exercise;
import vu.lt.persistence.ExercisesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Exercises {

    @Inject
    private ExercisesDAO exercisesDAO;

    @Getter
    @Setter
    private Exercise exerciseToCreate = new Exercise();

    @Getter
    private List<Exercise> allExercises;

    @PostConstruct
    public void init(){
        loadAllExcs();

    }

    private void loadAllExcs(){
        this.allExercises = exercisesDAO.loadAll();
    }

    @Transactional
    public String createExc(){
        this.exercisesDAO.persist(exerciseToCreate);
        return "index?faces-redirect=true";
    }
}*/

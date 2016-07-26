package interfaces;

import entities.Cours;
import entities.Parcours;

import javax.ejb.Local;


@Local
public interface Search {

    public Parcours findParcoursByIntitule(String intitule);
    public Cours findCoursById(String id);

    }

package interfaces;

import entities.Cours;
import entities.Etudiant;
import entities.Parcours;

import javax.ejb.Local;


@Local
public interface Search {

    Parcours findParcoursByIntitule(String intitule);
    Cours findCoursById(String id);
    Etudiant findEtudiantByNumEtu(String numeroEtu);

}

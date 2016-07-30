package interfaces;

import entities.Cours;
import entities.Etudiant;
import entities.Parcours;

import javax.ejb.Local;


@Local
public interface Search {

    public Parcours findParcoursByIntitule(String intitule);
    public Cours findCoursById(String id);
    public Etudiant findEtudiantByNumEtu(String numeroEtu);

}

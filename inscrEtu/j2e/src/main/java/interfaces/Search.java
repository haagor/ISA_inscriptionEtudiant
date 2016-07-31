package interfaces;

import entities.Cours;
import entities.Etudiant;
import entities.Parcours;

import javax.ejb.Local;
import java.util.List;


@Local
public interface Search {

    Parcours findParcoursByIntitule(String intitule);
    Cours findCoursById(String id);
    Etudiant findEtudiantByNumEtu(String numeroEtu);
    String afficheEtudiantsInParcours(String parcours);
    List<Etudiant> findAllEtudiants();
    String EtudiantsByParcours(List<Etudiant> l, String intitule);
    String afficheEtudiantPeriode(String numeroEtu);

    }

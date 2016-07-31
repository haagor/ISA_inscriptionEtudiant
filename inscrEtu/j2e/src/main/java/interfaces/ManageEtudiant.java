package interfaces;

import entities.Cours;

import javax.ejb.Local;

@Local
public interface ManageEtudiant {

    void creatParcoursEtu(String intitule);
    void creatEtudiant(String nom, String prenom, String numeroEtu) throws Exception;
    void selectParcoursForEtudiant(String numeroEtu, String intitule);
    Boolean addCoursEtu(String parcours, Cours cours);
    void suppressParcoursOfEtu(String numeroEtu);

    }

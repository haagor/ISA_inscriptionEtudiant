package interfaces;

import entities.Cours;

import javax.ejb.Local;

@Local
public interface ManageEtudiant {

    public void creatEtudiant(String nom, String prenom, String numeroEtu) throws Exception;
    public void selectParcoursForEtudiant(String numeroEtu, String intitule);
    public Boolean addCoursEtu(String parcours, Cours cours);

    }

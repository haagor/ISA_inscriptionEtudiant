package interfaces;

import javax.ejb.Local;

@Local
public interface ManageEtudiant {

    public void creatEtudiant(String nom, String prenom, String numeroEtu) throws Exception;
    public void selectParcoursForEtudiant(String numeroEtu, String intitule);

}
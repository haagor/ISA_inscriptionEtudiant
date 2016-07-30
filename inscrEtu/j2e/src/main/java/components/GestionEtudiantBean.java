package components;

import entities.Etudiant;
import entities.ParcoursEtu;
import interfaces.ManageEtudiant;
import interfaces.Search;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GestionEtudiantBean implements ManageEtudiant {

    @PersistenceContext
    private EntityManager entityManager;

    @EJB
    private Search search;

    @Override
    public void creatEtudiant(String nom, String prenom, String numeroEtu) {
        ParcoursEtu pe = new ParcoursEtu();
        Etudiant e = new Etudiant(nom, prenom, numeroEtu, pe);
        //check annuaire
        e = entityManager.merge(e);
        entityManager.persist(e);
    }

}

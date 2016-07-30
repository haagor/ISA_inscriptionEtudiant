package components;

import entities.Etudiant;
import entities.Parcours;
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
    public void creatEtudiant(String nom, String prenom, String numeroEtu) throws Exception{
        ParcoursEtu pe = new ParcoursEtu();
        Etudiant e = new Etudiant(nom, prenom, numeroEtu, pe);
        //check annuaire
        if (!search.findEtudiantByNumEtu(numeroEtu).equals(null)) {
            throw new Exception("etudiant deja saisi");
        }
        e = entityManager.merge(e);
        entityManager.persist(e);
    }

    @Override
    public void selectParcoursForEtudiant(String numeroEtu, String intitule) {
        Etudiant e = search.findEtudiantByNumEtu(numeroEtu);
        Parcours p = search.findParcoursByIntitule(intitule);
        ParcoursEtu pe = new ParcoursEtu(p.getIntitule(), p.getCours(), numeroEtu);
        e.setParcoursEtu(pe);
        e = entityManager.merge(e);
        entityManager.persist(e);
    }



}

package components;

import entities.Parcours;
import interfaces.ManageParcours;
import interfaces.Search;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

@Stateless
public class GestionParcoursBean implements ManageParcours {

    @PersistenceContext
    private EntityManager entityManager;

    @EJB
    private Search search;

    @Override
    public void creatParcours(String intitule) {
        ArrayList<String> c = new ArrayList<String>();
        Parcours p = new Parcours(intitule, c);
        p = entityManager.merge(p);
        entityManager.persist(p);
    }

    @Override
    public void addCoursP(String parcours, String cours) {
        Parcours p = search.findParcoursByIntitule(parcours);
        p.addCours(cours);
        p = entityManager.merge(p);
        entityManager.persist(p);
    }

}

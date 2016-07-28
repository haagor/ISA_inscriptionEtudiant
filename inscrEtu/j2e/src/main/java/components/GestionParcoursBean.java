package components;

import entities.Cours;
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
        ArrayList<Cours> c = new ArrayList<Cours>();
        Parcours p = new Parcours(intitule, c);
        p = entityManager.merge(p);
        entityManager.persist(p);
    }

    @Override
    public Boolean addCoursP(String parcours, Cours cours) {
        Parcours p = search.findParcoursByIntitule(parcours); //    /!\ catch null
        ArrayList<Cours> list_cours = p.getCours();

        // un cours est deja sur ce creneau?
        for (int i = 0; i < list_cours.size(); i++) {
            Cours c = list_cours.get(i);

            if (cours.getPeriode() == c.getPeriode() || cours.getPeriode() == 3 || c.getPeriode() == 3) {
                if (cours.getEmplacementJour() == c.getEmplacementJour()) {
                    if (cours.getEmplacementHeure() == c.getEmplacementHeure()) {
                        return false;
                    }
                }
            }
        }

        p.addCours(cours);

        if ((p.countECTS()) > 12) {
            p.removeCours(cours);
            p = entityManager.merge(p);
            entityManager.persist(p);
            System.out.println("trop de cours");
            return false;
        }

        if ((p.countECTS()) == 12) {
            if (!p.corequisOK()) {
                p.removeCours(cours);
                p = entityManager.merge(p);
                entityManager.persist(p);
                System.out.println("corequis pas respectés");
                return false;
            }
        }

        if (!p.prerequisOK(cours)) {
            p.removeCours(cours);
            p = entityManager.merge(p);
            entityManager.persist(p);
            System.out.println("prerequis pas respectés");
            return false;
        }


        p = entityManager.merge(p);
        entityManager.persist(p);
        return true;
    }
}

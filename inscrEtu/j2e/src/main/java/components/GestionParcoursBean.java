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
        Parcours p = search.findParcoursByIntitule(parcours);
        ArrayList<Cours> list_cours = p.getCours();
        int accECTS;
        if (cours.getPeriode() == 3) {
            accECTS = 4;
        } else {
            accECTS = 2;
        }

        // un cours est deja sur ce creneau?
        for (int i = 0; i < list_cours.size(); i++) {
            Cours c = list_cours.get(i);

            // calculer les ECTS *bien moche*
            if (c.getPeriode() == 3) {
                accECTS += 4;
            } else {
                accECTS += 2;
            }

            if (cours.getPeriode() == c.getPeriode() || cours.getPeriode() == 3 || c.getPeriode() == 3) {
                if (cours.getEmplacementJour() == c.getEmplacementJour()) {
                    if (cours.getEmplacementHeure() == c.getEmplacementHeure()) {
                        return false;
                    }
                }
            }
        }

        p.addCours(cours);

        if (!p.prerequisOK(cours)) {
            p.removeCours(cours);
            return false;
        }

        p = entityManager.merge(p);
        entityManager.persist(p);
        return true;
    }
}

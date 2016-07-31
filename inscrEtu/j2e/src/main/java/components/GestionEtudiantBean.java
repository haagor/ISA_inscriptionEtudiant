package components;

import entities.Cours;
import entities.Etudiant;
import entities.Parcours;
import entities.ParcoursEtu;
import interfaces.ManageEtudiant;
import interfaces.Search;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

@Stateless
public class GestionEtudiantBean implements ManageEtudiant {

    @PersistenceContext
    private EntityManager entityManager;

    @EJB
    private Search search;

    @Override
    public void creatParcoursEtu(String intitule) {
        ArrayList<Cours> c = new ArrayList<Cours>();
        Parcours p = new Parcours(intitule, c);
        p = entityManager.merge(p);
        entityManager.persist(p);
    }

    @Override
    public void creatEtudiant(String nom, String prenom, String numeroEtu) throws Exception {
        Etudiant e = new Etudiant(nom, prenom, numeroEtu);
        //check annuaire
        if (!(search.findEtudiantByNumEtu(numeroEtu) == null)) {
            throw new Exception("studentAlreadyExistException");
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

    // duplicate parce que par la suite il pourrait etre necessaire d'ajouter de nouvelles contraintes
    // (ex : option spcecifique, interdite pour certains parcours...)
    @Override
    public Boolean addCoursEtu(String numeroEtu, Cours cours) {
        Parcours p = search.findEtudiantByNumEtu(numeroEtu).getParcoursEtu(); //    /!\ catch null
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

        if ((p.countECTS()) > 24) {
            p.removeCours(cours);
            p = entityManager.merge(p);
            entityManager.persist(p);
            System.out.println("trop de cours");
            return false;
        }

        if ((p.countECTS()) == 24) {
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

    @Override
    public void suppressParcoursOfEtu(String numeroEtu) {
        Etudiant e = search.findEtudiantByNumEtu(numeroEtu);
        e.setParcoursEtu(null);
        e = entityManager.merge(e);
        entityManager.persist(e);
    }

}

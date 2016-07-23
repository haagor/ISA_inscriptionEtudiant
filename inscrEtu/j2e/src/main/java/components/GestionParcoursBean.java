package components;

import entities.Cours;
import entities.Parcours;
import interfaces.ManageParcours;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

@Stateless
public class GestionParcoursBean implements ManageParcours {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void creatParcours(String name) {
        ArrayList<Cours> l = new ArrayList<Cours>() ;
        Parcours p = new Parcours(name, l);
        p = entityManager.merge(p);
        entityManager.persist(p);
    }
}

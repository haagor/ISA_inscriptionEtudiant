package persistence;

import arquillian.AbstractTest;
import entities.Cours;
import entities.Etudiant;
import entities.Parcours;
import interfaces.ManageParcours;
import interfaces.Search;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

import static org.junit.Assert.*;


@RunWith(Arquillian.class)
@Transactional(TransactionMode.COMMIT)
public class StorageTest extends AbstractTest {

    @PersistenceContext
    private EntityManager entityManager;

    @EJB
    private ManageParcours manageParcours;

    @EJB
    private Search search;


    @Test
    public void storingParcours() throws Exception {
        ArrayList<Cours> ac = new ArrayList<Cours>();
        Parcours p = new Parcours("AL", ac);
        assertEquals(0, p.getId());

        entityManager.persist(p);

        int id = p.getId();
        assertNotEquals(0, id);

        Parcours stored = (Parcours) entityManager.find(Parcours.class, id);
        assertTrue(stored.getIntitule() == "AL");
        assertEquals(p, stored);
    }

    @Test
    public void storingCours() throws Exception {
        ArrayList<Cours> ac = new ArrayList<Cours>();
        Parcours p = new Parcours("AL", ac);
        assertEquals(0, p.getId());
        entityManager.persist(p);
        manageParcours.addCoursP("AL", Cours.EP5I9161);
        p = search.findParcoursByIntitule("AL");
        assertTrue(p.getCours().contains(Cours.EP5I9161));

    }

    @Test
    public void storingEtudiant() throws Exception {
        Etudiant e = new Etudiant("flantier", "noel", "fn7");
        assertEquals(0, e.getId());
        entityManager.persist(e);

        int id = e.getId();
        assertNotEquals(0, id);
        Etudiant stored = (Etudiant) entityManager.find(Etudiant.class, id);
        assertTrue(stored.getNom() == "flantier");
        assertEquals(e, stored);
    }
}

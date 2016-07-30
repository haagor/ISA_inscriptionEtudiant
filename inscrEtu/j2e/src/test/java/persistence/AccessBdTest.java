package persistence;

import arquillian.AbstractTest;
import entities.Cours;
import entities.Etudiant;
import entities.Parcours;
import entities.ParcoursEtu;
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

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(Arquillian.class)
@Transactional(TransactionMode.COMMIT)
public class AccessBdTest extends AbstractTest {

    @EJB
    private ManageParcours manageParcours;

    @EJB
    private Search search;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void accessParcours() throws Exception {
        sleep(1000);
        ArrayList<Cours> cours = new ArrayList<Cours>();
        Parcours p = new Parcours("AL", cours);
        entityManager.persist(p);
        p = search.findParcoursByIntitule("AL");
        assertEquals(p.getIntitule(), "AL");

    }

    @Test
    public void storingEtudiant() throws Exception {
        ParcoursEtu pe = new ParcoursEtu();
        Etudiant e = new Etudiant("flantier", "noel", "fn123456", pe);
        assertEquals(0, e.getId());
        entityManager.persist(e);

        assertNotEquals(e.getParcours(), null);
        e = search.findEtudiantByNumEtu("fn123456");
        assertEquals(e.getNom(), "flantier");
        assertNotEquals(e.getParcours(), null);
    }
}

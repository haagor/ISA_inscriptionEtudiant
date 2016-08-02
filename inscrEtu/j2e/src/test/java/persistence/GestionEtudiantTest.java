package persistence;

import arquillian.AbstractTest;
import entities.Cours;
import entities.Etudiant;
import entities.Parcours;
import interfaces.ManageEtudiant;
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

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


@RunWith(Arquillian.class)
@Transactional(TransactionMode.COMMIT)
public class GestionEtudiantTest extends AbstractTest {

    @PersistenceContext
    private EntityManager entityManager;

    @EJB
    private ManageEtudiant manageEtudiant;

    @EJB
    private ManageParcours manageParcours;

    @EJB
    private Search search;


    @Test(expected = Exception.class)
    public void CreatEtudiant() throws Exception {
        manageEtudiant.creatEtudiant("nova", "anna", "gg777777");
        manageEtudiant.creatEtudiant("nova", "anna", "gg777777");
    }

    @Test
    public void selectParcours() {
        Etudiant e = new Etudiant("flantier", "noel", "fn2");
        entityManager.persist(e);

        ArrayList<Cours> ac = new ArrayList<Cours>();
        Parcours p = new Parcours("AL", ac);
        entityManager.persist(p);

        manageEtudiant.selectParcoursForEtudiant("fn2", "AL");
        Etudiant e1 = search.findEtudiantByNumEtu("fn2");
        assertEquals(e1.getParcoursEtu().getIntitule(), "AL");
    }

    @Test
    public void addCours() throws Exception {
        Etudiant e = new Etudiant("flantier", "noel", "fn3");
        entityManager.persist(e);

        ArrayList<Cours> ac = new ArrayList<Cours>();
        Parcours p = new Parcours("T", ac);
        entityManager.persist(p);
        assertTrue(manageParcours.addCoursP("T", Cours.EP5I9161));
        assertTrue(manageParcours.addCoursP("T", Cours.EP5EU301));
        assertTrue(manageParcours.addCoursP("T", Cours.EP5I9270));
        assertTrue(manageParcours.addCoursP("T", Cours.EP5I9212));
        assertTrue(manageParcours.addCoursP("T", Cours.EP5I9264));
        assertTrue(manageParcours.addCoursP("T", Cours.EP5I9193));

        manageEtudiant.selectParcoursForEtudiant("fn3", "T");
        assertTrue(manageEtudiant.addCoursEtu("fn3", Cours.EP5I9217));
        assertFalse(manageEtudiant.addCoursEtu("fn3", Cours.EP5I9217));
    }

    @Test
    public void addCoursECTSLimit() throws Exception {
        Etudiant e = new Etudiant("flantier", "noel", "fn4");
        entityManager.persist(e);

        ArrayList<Cours> ac = new ArrayList<Cours>();
        Parcours p = new Parcours("S", ac);
        entityManager.persist(p);
        assertTrue(manageParcours.addCoursP("S", Cours.EP5I9161));
        assertTrue(manageParcours.addCoursP("S", Cours.EP5EU301));
        assertTrue(manageParcours.addCoursP("S", Cours.EP5I9270));
        assertTrue(manageParcours.addCoursP("S", Cours.EP5I9212));
        assertTrue(manageParcours.addCoursP("S", Cours.EP5I9264));
        assertTrue(manageParcours.addCoursP("S", Cours.EP5I9193));

        manageEtudiant.selectParcoursForEtudiant("fn4", "S");
        assertTrue(manageEtudiant.addCoursEtu("fn4", Cours.EP5I9262));
        assertTrue(manageEtudiant.addCoursEtu("fn4", Cours.EP5I9261));
        assertTrue(manageEtudiant.addCoursEtu("fn4", Cours.EP5I9xxx));
        assertTrue(manageEtudiant.addCoursEtu("fn4", Cours.EP5I9162));
        assertFalse(manageEtudiant.addCoursEtu("fn4", Cours.EP5I9106));
        assertTrue(manageEtudiant.addCoursEtu("fn4", Cours.EP5I9217));

    }

}

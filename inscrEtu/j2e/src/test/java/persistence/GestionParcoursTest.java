package persistence;

import arquillian.AbstractTest;
import entities.Cours;
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

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;


@RunWith(Arquillian.class)
@Transactional(TransactionMode.COMMIT)
public class GestionParcoursTest extends AbstractTest {

    @PersistenceContext
    private EntityManager entityManager;

    @EJB
    private ManageParcours manageParcours;

    @EJB
    private Search search;


    @Test
    public void CoursSameTime() throws Exception {
        ArrayList<Cours> ac = new ArrayList<Cours>();
        Parcours p = new Parcours("AL", ac);
        entityManager.persist(p);
        manageParcours.addCoursP("AL", Cours.EP5I9161);
        p = search.findParcoursByIntitule("AL");
        assertFalse(manageParcours.addCoursP("AL", Cours.EP5I9112));
        assertFalse(p.getCours().contains(Cours.EP5I9112));
    }

    @Test
    public void addCours() throws Exception {
        ArrayList<Cours> ac = new ArrayList<Cours>();
        Parcours p = new Parcours("IAM", ac);
        entityManager.persist(p);


        assertTrue(manageParcours.addCoursP("IAM", Cours.EP5I9161));
        assertFalse(manageParcours.addCoursP("IAM", Cours.EP5I9161)); //same time
        assertTrue(manageParcours.addCoursP("IAM", Cours.EP5EU301));
        assertFalse(manageParcours.addCoursP("IAM", Cours.EP5I9212)); //miss prerequis
        assertTrue(manageParcours.addCoursP("IAM", Cours.EP5I9270));
        assertTrue(manageParcours.addCoursP("IAM", Cours.EP5I9212));
        assertTrue(manageParcours.addCoursP("IAM", Cours.EP5I9264));
        assertFalse(manageParcours.addCoursP("IAM", Cours.EP5I9262)); //not enought ECTS for corequis
        assertFalse(manageParcours.addCoursP("IAM", Cours.EP5I9261)); //not enought ECTS for corequis
        assertTrue(manageParcours.addCoursP("IAM", Cours.EP5I9193));

    }
}

/*package business;

import arquillian.AbstractTest;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


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
    public void creat() throws InterruptedException {
        manageParcours.creatParcours("IAM");
        Parcours p = search.findParcoursByIntitule("IAM");
        assertEquals(p.getCours(), null);

        manageParcours.addCoursP("IAM", "EP5I9161");

        p = search.findParcoursByIntitule("IAM");
        assertNotEquals(p.getCours(), null);
    }
}*/
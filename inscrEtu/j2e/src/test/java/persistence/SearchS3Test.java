package persistence;

import arquillian.AbstractTest;
import interfaces.ManageEtudiant;
import interfaces.Search;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

@RunWith(Arquillian.class)
@Transactional(TransactionMode.COMMIT)
public class SearchS3Test extends AbstractTest {

    @EJB
    private ManageEtudiant manageEtudiant;

    @EJB
    private Search search;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void finyParcoursdB() throws Exception { // /!\ pas d'asserte
        System.out.println(search.EtudiantsByParcours(search.findAllEtudiants(), "AL"));
        System.out.println(search.EtudiantsByParcours(search.findAllEtudiants(), "S"));
        System.out.println(search.EtudiantsByParcours(search.findAllEtudiants(), "T"));

        System.out.println(search.afficheEtudiantsInParcours("AL"));

    }

    @Test
    public void finEtudiantPeriode() throws Exception { // /!\ pas d'asserte
        System.out.println(search.afficheEtudiantPeriode("fn4"));

    }

    @Test
    public void supressParcoursEtu() throws Exception {
        System.out.println(search.afficheEtudiantPeriode("fn4"));
        assertFalse(search.findEtudiantByNumEtu("fn4").getParcoursEtu() == null);
        manageEtudiant.suppressParcoursOfEtu("fn4");
        assertTrue(search.findEtudiantByNumEtu("fn4").getParcoursEtu() == null);
    }
}

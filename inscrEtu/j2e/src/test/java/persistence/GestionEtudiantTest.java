package persistence;

import arquillian.AbstractTest;
import entities.Cours;
import entities.Etudiant;
import entities.Parcours;
import entities.ParcoursEtu;
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
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


@RunWith(Arquillian.class)
@Transactional(TransactionMode.COMMIT)
public class GestionEtudiantTest extends AbstractTest {

    @PersistenceContext
    private EntityManager entityManager;

    @EJB
    private ManageEtudiant manageEtudiant;

    @EJB
    private Search search;


    @Test(expected=Exception.class)
    public void CreatEtudiant() throws Exception {
        manageEtudiant.creatEtudiant("flantier", "noel", "fn123456");
        manageEtudiant.creatEtudiant("flantier", "noel", "fn123456");
    }

    @Test
    public void selectParcours() {
        ParcoursEtu pe = new ParcoursEtu();
        Etudiant e = new Etudiant("flantier", "noel", "fn123456", pe);
        entityManager.persist(e);

        ArrayList<Cours> ac = new ArrayList<Cours>();
        Parcours p = new Parcours("AL", ac);
        entityManager.persist(p);

        manageEtudiant.selectParcoursForEtudiant("fn123456", "AL");
        Etudiant e1 = search.findEtudiantByNumEtu("fn123456");
        assertEquals(e1.getParcoursEtu().getIntitule(), "AL");
    }

}

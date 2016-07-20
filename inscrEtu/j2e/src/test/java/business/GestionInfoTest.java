package business;

import arquillian.AbstractTest;
import interfaces.Afficher;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.assertTrue;


@RunWith(Arquillian.class)
public class GestionInfoTest extends AbstractTest {

    @PersistenceContext
    private EntityManager entityManager;

    @EJB
    private Afficher afficher;

    @Before
    public void setUpContext() {
        memory.flush();

    }

    @Test
    public void afficher(){
        String temperature = afficher.afficherTemperature("haut");
        System.out.println(temperature);
        assertTrue(memory.howManyTemps() == 1);

    }

}

package persistence;

import arquillian.AbstractTest;
import entities.Temperature;
import interfaces.Afficher;
import interfaces.MakeBulletin;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.Instant;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
@Transactional(TransactionMode.COMMIT)
public class AccessBdTest extends AbstractTest {

    @EJB
    private Afficher afficher;

    @EJB
    private MakeBulletin makeBulletin;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void accessLastTemperature() throws Exception {
        sleep(1000);
        Temperature temperature = new Temperature(Instant.now().getEpochSecond(), "haut", 0.42f);
        entityManager.persist(temperature);
        Temperature t = makeBulletin.findLastTemperature("haut");
        assertEquals(t.getTemperature(), 0,42f);
        sleep(1000);
        temperature = new Temperature(Instant.now().getEpochSecond(), "haut", 0.43f);
        entityManager.persist(temperature);
        t = makeBulletin.findLastTemperature("haut");
        assertEquals(t.getTemperature(), 0,43f);

    }

}

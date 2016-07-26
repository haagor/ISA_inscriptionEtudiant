package persistence;

import arquillian.AbstractTest;
import entities.Cours;
import entities.Parcours;
import entities.Temperature;
import interfaces.Afficher;
import interfaces.MakeBulletin;
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
import java.time.Instant;
import java.util.ArrayList;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
@Transactional(TransactionMode.COMMIT)
public class AccessBdTest extends AbstractTest {

    @EJB
    private Afficher afficher;

    @EJB
    private MakeBulletin makeBulletin;

    @EJB
    private ManageParcours manageParcours;

    @EJB
    private Search search;

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

    @Test
    public void accessParcours() throws Exception {
        sleep(1000);
        ArrayList<Cours> cours = new ArrayList<Cours>();
        Parcours p = new Parcours("AL", cours);
        entityManager.persist(p);
        p = search.findParcoursByIntitule("AL");
        assertEquals(p.getIntitule(), "AL");

    }
}

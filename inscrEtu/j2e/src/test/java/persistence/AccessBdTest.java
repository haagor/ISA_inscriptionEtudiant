package persistence;

import arquillian.AbstractTest;
import entities.*;
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
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

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
    public void accessPisteByName() throws Exception {
        Piste p4 = new Piste("nashkel", Levels.JAUNE, AreaEnum.PRO, false);
        entityManager.persist(p4);

        Piste piste1 = makeBulletin.findPisteByName("yolo");
        assertNull(piste1);
        Piste piste2 = makeBulletin.findPisteByName("nashkel");
        assertNotNull(piste2);

    }

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
    public void accessLastWind() throws Exception {
        sleep(1000);
        Wind wind = new Wind(Instant.now().getEpochSecond(), "haut", 20);
        entityManager.persist(wind);
        Wind w = makeBulletin.findLastWind("haut");
        System.out.println(w.getWind());
        assertTrue(w.getWind() == 20);
        sleep(1000);
        wind = new Wind(Instant.now().getEpochSecond(), "haut", 21);
        entityManager.persist(wind);
        w = makeBulletin.findLastWind("haut");
        System.out.println(w.getWind());
        assertTrue(w.getWind() == 21);

    }

    @Test
    public void accessLastSnow() throws Exception {
        sleep(1000);
        Snow snow = new Snow(Instant.now().getEpochSecond(), "haut", 98);
        entityManager.persist(snow);
        Snow s = makeBulletin.findLastSnow("haut");
        System.out.println(s.getSnow());
        assertTrue(s.getSnow() == 98);
        sleep(1000);
        snow = new Snow(Instant.now().getEpochSecond(), "haut", 99);
        entityManager.persist(snow);
        s = makeBulletin.findLastSnow("haut");
        System.out.println(s.getSnow());
        assertTrue(s.getSnow() == 99);

    }


}

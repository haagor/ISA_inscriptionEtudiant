package persistence;

import arquillian.AbstractTest;
import entities.*;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.Assert.*;


@RunWith(Arquillian.class)
@Transactional(TransactionMode.COMMIT)
public class StorageTest extends AbstractTest {

    @PersistenceContext
    private EntityManager entityManager;


    @Test
    public void storingTemperature() throws Exception {
        Temperature t = new Temperature(Instant.now().getEpochSecond(), "haut", 0.5f);
        assertEquals(0,t.getId());

        t = entityManager.merge(t);
        entityManager.persist(t);

        int id = t.getId();
        assertNotEquals(0,id);
        System.out.println(">>>>>>>>>id>>>>>>>>>> " + id);
        System.out.println(">>>>>>>>>>>>>>>>>>> " + t.getTemperature());


        Temperature stored = (Temperature) entityManager.find(Temperature.class, id);
        assertTrue(stored.getTemperature() == 0.5f);
        assertEquals(t, stored);

        System.out.println(" >>> PersistenceStorageTest Temperature <<<");
    }

    @Test
    public void storingWind() throws Exception {
        Wind w = new Wind(Instant.now().getEpochSecond(), "bas", 100);
        assertEquals(0,w.getId());

        entityManager.persist(w);
        int id = w.getId();
        assertNotEquals(0,id);

        Wind stored = (Wind) entityManager.find(Wind.class, id);
        assertEquals(w, stored);

        System.out.println(" >>> PersistenceStorageTest Wind <<<");
    }

    @Test
    public void storingPiste() throws Exception {
        Temperature t = new Temperature(Instant.now().getEpochSecond(), "haut", 0.5f);
        Wind w = new Wind(Instant.now().getEpochSecond(), "bas", 100);

        Piste p = new Piste("KIDDINGME", Levels.VERT, AreaEnum.BEGINNER, true);
        assertEquals(0,p.getId());

        entityManager.persist(p);
        int id = p.getId();;
        assertNotEquals(0,id);

        Piste stored = (Piste) entityManager.find(Piste.class, id);
        assertEquals(p, stored);

        System.out.println(" >>> PersistenceStorageTest Piste <<<");
    }

    @Test
    public void storingBulletin() throws Exception {
        Temperature th = new Temperature(Instant.now().getEpochSecond(), "haut", 0.5f);
        Wind wh = new Wind(Instant.now().getEpochSecond(), "haut", 100);
        Snow sh = new Snow(Instant.now().getEpochSecond(), "haut", 200);
        Temperature tb = new Temperature(Instant.now().getEpochSecond(), "bas", 0.5f);
        Wind wb = new Wind(Instant.now().getEpochSecond(), "bas", 100);
        Snow sb = new Snow(Instant.now().getEpochSecond(), "bas", 200);
        Piste p1 = new Piste("Caradhras", Levels.VERT, AreaEnum.BEGINNER, true);
        Piste p2 = new Piste("ThDeathValloon", Levels.VERT, AreaEnum.BEGINNER, false);
        entityManager.persist(p1);
        entityManager.persist(p2);
        ArrayList<Piste> ps = new ArrayList<>();
        ps.add(p1);
        ps.add(p2);
        Bulletin b = new Bulletin(ps, th, tb, wh, wb, sh, sb);
        assertEquals(0,b.getId());
        entityManager.persist(b);
        int id = b.getId();

        Bulletin stored = (Bulletin) entityManager.find(Bulletin.class, id);
        assertEquals(b, stored);

        System.out.println(" >>> PersistenceStorageTest Bulletin <<<");
    }

    @Test
    public void removingBulletin() throws Exception {
        Temperature th = new Temperature(Instant.now().getEpochSecond(), "haut", 0.5f);
        Wind wh = new Wind(Instant.now().getEpochSecond(), "haut", 100);
        Snow sh = new Snow(Instant.now().getEpochSecond(), "haut", 200);
        Temperature tb = new Temperature(Instant.now().getEpochSecond(), "bas", 0.5f);
        Wind wb = new Wind(Instant.now().getEpochSecond(), "bas", 100);
        Snow sb = new Snow(Instant.now().getEpochSecond(), "bas", 200);
        Piste p1 = new Piste("Caradhras", Levels.VERT, AreaEnum.BEGINNER, true);
        Piste p2 = new Piste("ThDeathValloon", Levels.VERT, AreaEnum.BEGINNER, false);
        entityManager.persist(p1);
        entityManager.persist(p2);
        ArrayList<Piste> ps = new ArrayList<>();
        ps.add(p1);
        ps.add(p2);
        Bulletin b = new Bulletin(ps, th, tb, wh, wb, sh, sb);
        entityManager.persist(b);

        assertNotNull(entityManager.find(Bulletin.class, b.getId()));
        assertNotNull(entityManager.find(Piste.class, p1.getId()));
        assertNotNull(entityManager.find(Temperature.class, th.getId()));
        assertNotNull(entityManager.find(Temperature.class, th.getId()));

        entityManager.remove(b);

        assertNull(entityManager.find(Bulletin.class, b.getId()));
        assertNotNull(entityManager.find(Piste.class, p1.getId()));
        assertNotNull(entityManager.find(Temperature.class, th.getId()));

    }
}

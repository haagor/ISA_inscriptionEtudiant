package persistence;

import arquillian.AbstractTest;
import entities.Temperature;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.Instant;

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
}

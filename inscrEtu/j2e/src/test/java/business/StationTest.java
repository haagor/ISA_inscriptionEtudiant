package business;

import arquillian.AbstractTest;
import entities.Temperature;
import interfaces.Collect;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.Instant;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(Arquillian.class)
public class StationTest extends AbstractTest {

	@PersistenceContext
	private EntityManager entityManager;

	@EJB private Collect collect;

	@Before
	public void setUpContext() {
		memory.flush();

	}

	@Test
	public void collectTemperature() throws InterruptedException {
		Temperature temperatureCollected1 = collect.collectTemperature("haut");
		//assertTrue(temperatureCollected1.getTemperature() > -50.1 && temperatureCollected1.getTemperature() < 50.1);
		sleep(1000);
		assertTrue(temperatureCollected1.getTime() <= Instant.now().getEpochSecond());
		assertFalse(temperatureCollected1.getTime() > Instant.now().getEpochSecond());

		Temperature temperatureCollected2 = collect.collectTemperature("haut");
		assertTrue(temperatureCollected2.getTemperature() > -50.1 && temperatureCollected1.getTemperature() < 50.1);
		assertTrue(temperatureCollected2.getTime() > temperatureCollected1.getTime());

	}
}

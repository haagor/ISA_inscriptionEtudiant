package business;

import arquillian.AbstractTest;
import entities.Snow;
import entities.Temperature;
import entities.Wind;
import interfaces.Collect;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;


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

	@Test
	public void collectWind() throws InterruptedException {
		Wind windCollected1 = collect.collectWind("haut");
		assertTrue(windCollected1.getWind() >= 0 );
		assertTrue(windCollected1.getWind() <= 250 );
		sleep(1000);
		assertTrue(windCollected1.getTime() <= Instant.now().getEpochSecond());
		assertFalse(windCollected1.getTime() > Instant.now().getEpochSecond());

		Wind windCollected2 = collect.collectWind("haut");
		assertTrue(windCollected2.getTime() > windCollected1.getTime());

	}

    @Test
    public void collectSnow() throws InterruptedException {
        Snow snowCollected1 = collect.collectSnow("haut");
        assertTrue(snowCollected1.getSnow() >= 0 && snowCollected1.getSnow() <= 500);
        sleep(1000);
        assertTrue(snowCollected1.getTime() <= Instant.now().getEpochSecond());
        assertFalse(snowCollected1.getTime() > Instant.now().getEpochSecond());

        Snow snowCollected2 = collect.collectSnow("haut");
        assertTrue(snowCollected2.getSnow() >= 0 && snowCollected1.getSnow() <= 500);
        assertTrue(snowCollected2.getTime() > snowCollected1.getTime());

    }
}

package components;

import entities.Temperature;
import interceptors.TemperatureCounter;
import interfaces.Collect;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.Instant;
import java.util.Random;


@Stateless
public class StationBean implements Collect {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Interceptors({TemperatureCounter.class})
	public Temperature collectTemperature(String pos) {
        float temperature;
        Random r = new Random();
		if (r.nextBoolean()) { temperature = (float) (-1 * r.nextDouble() * r.nextInt(50)); }
        else { temperature = (float) r.nextDouble() * r.nextInt(50); }
        Temperature tmp = new Temperature(Instant.now().getEpochSecond(), pos, temperature);
		tmp = entityManager.merge(tmp);
		entityManager.persist(tmp);

		return tmp;
	}
}




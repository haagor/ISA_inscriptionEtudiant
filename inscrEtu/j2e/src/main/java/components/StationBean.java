package components;

import entities.Snow;
import entities.Temperature;
import entities.Wind;
import interceptors.TemperatureCounter;
import interfaces.Collect;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

	@Override
	//@Interceptors({WindCounter.class})
	public Wind collectWind(String pos) {
        Random r = new Random();
        Wind wind = new Wind(Instant.now().getEpochSecond(), pos, r.nextInt(250));
		wind = entityManager.merge(wind);
		entityManager.persist(wind);

		return wind;
	}

    @Override
    public Snow collectSnow(String pos) {
        int snow;
        Random r = new Random();
        snow =(int) (r.nextDouble() * r.nextInt(500)); // 5 mètres de neige c'est honnete
        Snow sw = new Snow(Instant.now().getEpochSecond(), pos, snow);
        sw = entityManager.merge(sw);
        entityManager.persist(sw);

        return sw;
    }
/*
    public double truncate(double value, int places) {
        double multiplier = Math.pow(10, places);
        return Math.floor(multiplier * value) / multiplier;
    }
*/
}




package utils;
import entities.Temperature;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.Instant;

@Startup
@Singleton
public class Database {

    @PersistenceContext
    private EntityManager entityManager;

	private int tempCounter = 0;

	public void incrementTemps() {
		tempCounter++;
	}

	public int howManyTemps() {
		return tempCounter;
	}

	public Database() {
		flush();
	}

	public void flush() { tempCounter = 0; }

    @PostConstruct
    void init() {
		Temperature th = new Temperature(Instant.now().getEpochSecond(), "haut", -1.0f);
        entityManager.persist(th);

    }

}
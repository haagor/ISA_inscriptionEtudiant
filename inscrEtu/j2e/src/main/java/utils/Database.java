package utils;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

@Startup
@Singleton
public class Database {

    @PersistenceContext
    private EntityManager entityManager;

	private ArrayList<String> authentificator = new ArrayList<>();

	public void addAuthentificator(String id) {
		authentificator.add(id);
	}

	public boolean authentificatorContains(String id) {
		return authentificator.contains(id);
	}

	public Database() {
		flush();
	}

	public void flush() { authentificator = new ArrayList<>(); }

    @PostConstruct
    void init() {}

}
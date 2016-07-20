package persistence;


import arquillian.AbstractTest;
import entities.*;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

@RunWith(Arquillian.class)
public class LazyLoadingTest extends AbstractTest {

	@PersistenceContext private EntityManager entityManager;
    @Resource private UserTransaction manual;


    @Test
	public void lazyLoadingDemo() throws Exception {
		// Code executed inside a given transaction
		manual.begin();
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
			Bulletin sameTransaction = loadBulletin(b.getId()) ;
			assertEquals(b, sameTransaction);
			assertEquals(2, b.getPistes().size()); // piste are attached in this transaction => available
            assertNotEquals(3, b.getPistes().size());
		manual.commit();

		// Code executed outside the given transaction
		Bulletin detached = loadBulletin(b.getId()) ;
		assertNotEquals(b, detached);
		assertNull(detached.getPistes()); // piste are not attached outside of the transaction => null;

	}


	private Bulletin loadBulletin(int id) {
		return entityManager.find(Bulletin.class, id);
	}

}
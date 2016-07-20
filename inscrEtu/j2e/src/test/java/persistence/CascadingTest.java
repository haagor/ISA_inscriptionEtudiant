/*package persistence;

import arquillian.AbstractTest;
import entities.*;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.RollbackException;
import javax.transaction.UserTransaction;
import java.time.LocalTime;
import java.util.ArrayList;

@RunWith(Arquillian.class)
public class CascadingTest extends AbstractTest {

	@PersistenceContext private EntityManager entityManager;
	@Resource private UserTransaction manual;

	@Test(expected = RollbackException.class)
	public void cannotStoreBulletinWithTransientTemperature() throws Exception {
		Temperature t = new Temperature(LocalTime.now(), "haut", 0.5);
		Snow s = new Snow(LocalTime.now(), "bas", 200);
		Wind w = new Wind(LocalTime.now(), "bas", 100);
		Piste p1 = new Piste("caradhras", Levels.VERT, AreaEnum.BEGINNER, true);
		Piste p2 = new Piste("ThDeathValloon", Levels.VERT, AreaEnum.BEGINNER, false);
		ArrayList<Piste> ps = new ArrayList<>();
		ps.add(p1);
		ps.add(p2);
		Bulletin b = new Bulletin(ps, t, w, s);
        manual.begin();
			entityManager.persist(b); // the Temperature is not persistent => the Bulletin cannot persist by itself
		manual.commit();
	}


}
*/
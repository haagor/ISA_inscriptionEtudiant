package business;

import arquillian.AbstractTest;
import interfaces.ManageParcours;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@RunWith(Arquillian.class)
public class GestionParcoursTest extends AbstractTest {

    @PersistenceContext
    private EntityManager entityManager;

    @EJB
    private ManageParcours manageParcours;

    @Test
    public void creat(){
        manageParcours.creatParcours("AL");
        // yolo sans assert -_-
    }
}

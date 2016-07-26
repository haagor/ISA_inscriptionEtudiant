package arquillian;

import components.GestionParcoursBean;
import components.StationBean;
import entities.Parcours;
import entities.Temperature;
import interfaces.Collect;
import interfaces.ManageParcours;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import utils.Database;

import javax.ejb.EJB;

public abstract class AbstractTest {


	@EJB
	protected Database memory;

	@Deployment
	public static WebArchive createDeployment() {
		// Building a Web ARchive (WAR) containing the following elements:
		return ShrinkWrap.create(WebArchive.class)
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				// Utils
				.addPackage(Database.class.getPackage())
				// Entities
				.addPackage(Temperature.class.getPackage())
				.addPackage(Parcours.class.getPackage())

				// Components Interfaces
				.addPackage(Collect.class.getPackage())
				.addPackage(ManageParcours.class.getPackage())
				// Cart components
				// Exceptions
				// Components implementations
				.addPackage(StationBean.class.getPackage())
				.addPackage(GestionParcoursBean.class.getPackage())
				// Persistence file
				.addAsManifestResource(new ClassLoaderAsset("META-INF/persistence.xml"), "persistence.xml");
	}

}

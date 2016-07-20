package arquillian;

import components.GestionInfoBean;
import components.StationBean;
import entities.Bulletin;
import entities.Piste;
import entities.Temperature;
import entities.Wind;
import interfaces.Collect;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import utils.Database;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

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
				.addPackage(Wind.class.getPackage())
				.addPackage(Bulletin.class.getPackage())
				.addPackage(Piste.class.getPackage())

				// Components Interfaces
				.addPackage(Collect.class.getPackage())
				// Cart components
				// Exceptions
				// Components implementations
				.addPackage(StationBean.class.getPackage())
				// Persistence file
				.addAsManifestResource(new ClassLoaderAsset("META-INF/persistence.xml"), "persistence.xml");
	}

}

package arquillian;

import components.GestionParcoursBean;
import entities.Parcours;
import interfaces.ManageParcours;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

public abstract class AbstractTest {


	//@EJB
	//protected Database memory;

	@Deployment
	public static WebArchive createDeployment() {
		// Building a Web ARchive (WAR) containing the following elements:
		return ShrinkWrap.create(WebArchive.class)
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				// Utils
				//.addPackage(Database.class.getPackage())
				// Entities
				.addPackage(Parcours.class.getPackage())

				// Components Interfaces
				.addPackage(ManageParcours.class.getPackage())
				// Cart components
				// Exceptions
				// Components implementations
				.addPackage(GestionParcoursBean.class.getPackage())
				// Persistence file
				.addAsManifestResource(new ClassLoaderAsset("META-INF/persistence.xml"), "persistence.xml");
	}

}

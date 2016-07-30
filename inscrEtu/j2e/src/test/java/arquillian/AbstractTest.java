package arquillian;

import components.GestionEtudiantBean;
import components.GestionParcoursBean;
import entities.Etudiant;
import entities.Parcours;
import entities.ParcoursEtu;
import interfaces.ManageEtudiant;
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
				.addPackage(Etudiant.class.getPackage())
				.addPackage(ParcoursEtu.class.getPackage())


				// Components Interfaces
				.addPackage(ManageParcours.class.getPackage())
				.addPackage(ManageEtudiant.class.getPackage())
				// Cart components
				// Exceptions
				// Components implementations
				.addPackage(GestionParcoursBean.class.getPackage())
				.addPackage(GestionEtudiantBean.class.getPackage())
				// Persistence file
				.addAsManifestResource(new ClassLoaderAsset("META-INF/persistence.xml"), "persistence.xml");
	}

}

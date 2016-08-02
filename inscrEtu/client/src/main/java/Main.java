import stubs.inscr.Cours;
import stubs.inscr.InscrWebService;
import stubs.inscr.InscrWebServiceImplService;

import javax.xml.ws.BindingProvider;
import java.net.URL;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("#### Collecting arguments (host, port)");
		String host = ( args.length == 0 ? "localhost" : args[0] );
		String port = ( args.length < 2  ? "8080"      : args[1] );
		InscrWebService ws = initialize(host, port);
		System.out.println("#### Running the demo");
		demoS1(ws);
		demoS2(ws);
        demoS3(ws);
	}

	private static void demoS1(InscrWebService ws) throws Exception {
		System.out.println("\n >>> début du scenario S1 <<<\n");

        if (ws.authenticate("h1234", "1234")) {
            System.out.println("*** authentification success ***");

            ws.creatParcours("AL");
            System.out.println("Parcours AL crée");

            //(same as GestionParcoursTest)
            ws.addCoursP("AL", Cours.EP_5_I_9161);     System.out.println("-1");
            ws.addCoursP("AL", Cours.EP_5_I_9161);     System.out.println("-2");
            ws.addCoursP("AL", Cours.EP_5_EU_301);     System.out.println("-3");
            ws.addCoursP("AL", Cours.EP_5_I_9212);     System.out.println("-4");
            ws.addCoursP("AL", Cours.EP_5_I_9270);     System.out.println("-5");
            ws.addCoursP("AL", Cours.EP_5_I_9212);     System.out.println("-6");
            ws.addCoursP("AL", Cours.EP_5_I_9264);     System.out.println("-7");
            ws.addCoursP("AL", Cours.EP_5_I_9262);     System.out.println("-8");
            ws.addCoursP("AL", Cours.EP_5_I_9261);     System.out.println("-9");
            ws.addCoursP("AL", Cours.EP_5_I_9193);     System.out.println("-10");

        } else {
            System.out.println("*** authentification fail ***");
        }

    }

	private static void demoS2(InscrWebService ws) throws Exception {
		System.out.println("\n >>> début du scenario S2 <<<\n");

        if (ws.authenticate("w2345", "2345")) {
            System.out.println("*** authentification success ***");

            ws.creatEtudiant("flantier", "noel", "fn123456");
            System.out.println("Etudiant saisi");
            // decommenter cette ligne pour : "==>> erreur si l’étudiant existe déjà"
            //ws.creatEtudiant("flantier", "noel", "fn123456");
            ws.selectParcoursForEtudiant("fn123456", "AL");
            System.out.println("AL selectionné pour Flantier");

            ws.addCoursEtu("fn123456", Cours.EP_5_I_9262);		System.out.println("-1");
            ws.addCoursEtu("fn123456", Cours.EP_5_I_9262);		System.out.println("-2");
            ws.addCoursEtu("fn123456", Cours.EP_5_I_9261);		System.out.println("-3");
            ws.addCoursEtu("fn123456", Cours.EP_5_I_9_XXX);		System.out.println("-4");
            ws.addCoursEtu("fn123456", Cours.EP_5_I_9162);		System.out.println("-5");
            ws.addCoursEtu("fn123456", Cours.EP_5_I_9106);		System.out.println("-6");
            ws.addCoursEtu("fn123456", Cours.EP_5_I_9217);		System.out.println("-7");

        } else {
            System.out.println("*** authentification fail ***");
        }

    }

    private static void demoS3(InscrWebService ws) throws Exception {
        ws.creatEtudiant("yolo", "yolo", "yolo");
        ws.selectParcoursForEtudiant("yolo", "AL");
        ws.addCoursEtu("yolo", Cours.EP_5_I_9217);
        ws.addCoursEtu("yolo", Cours.EP_5_I_9162);

        System.out.println("\n >>> début du scenario S3 <<<\n");

        if (ws.authenticate("w2345", "2345")) {
            System.out.println("*** authentification success ***");

            System.out.println(ws.afficheEtudiantsInParcours("AL"));
            System.out.println(ws.afficheEtudiantPeriode("fn123456"));
            ws.suppressParcoursOfEtu("fn123456");
            System.out.println(ws.afficheEtudiantsInParcours("AL"));

        } else {
            System.out.println("*** authentification fail ***");
        }
    }

	private static InscrWebService initialize(String host, String port) {
        System.out.println("#### Loading the WSDL contract");
		URL wsdlLocation = Main.class.getResource("/InscrWS.wsdl");
        System.out.println("#### Instantiating the WS Proxy");
		InscrWebServiceImplService factory = new InscrWebServiceImplService(wsdlLocation);
		InscrWebService ws = factory.getInscrWebServiceImplPort();
        System.out.println("#### Updating the endpoint address dynamically");
		String address = "http://"+host+":"+port+"/j2e-1.0-SNAPSHOT/webservices/InscrWS";
		System.out.println(address);
		((BindingProvider) ws).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
		return ws;
	}



}

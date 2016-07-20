package demo;

import stubs.affichage.AffichageWebService;
import stubs.affichage.AffichageWebServiceImplService;


import javax.xml.ws.BindingProvider;
import java.net.URL;

public class AffichageWSDemo {

	public static void main(String[] args) throws Exception {
		System.out.println("#### Collecting arguments (host, port)");
		String host = ( args.length == 0 ? "localhost" : args[0] );
		String port = ( args.length < 2  ? "8080"      : args[1] );
		AffichageWebService ws = initialize(host, port);
		System.out.println("#### Running the demo");
		demo(ws);

	}

	private static void demo(AffichageWebService ws) throws Exception {
		System.out.println(ws.afficheTemperature("haut"));
		System.out.println(ws.afficheTemperature("bas"));
		//ws.test();
		//System.out.println("ok");
	}

	private static AffichageWebService initialize(String host, String port) {
        System.out.println("#### Loading the WSDL contract");
		URL wsdlLocation = AffichageWSDemo.class.getResource("/AffichageWS.wsdl");
        System.out.println("#### Instantiating the WS Proxy");
		AffichageWebServiceImplService factory = new AffichageWebServiceImplService(wsdlLocation);
		AffichageWebService ws = factory.getAffichageWebServiceImplPort();
        System.out.println("#### Updating the endpoint address dynamically");
		String address = "http://"+host+":"+port+"/j2e-1.0-SNAPSHOT/webservices/AffichageWS";
		((BindingProvider) ws).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
		return ws;
	}



}

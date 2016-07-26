package demo;

import stubs.inscr.InscrWebService;
import stubs.inscr.InscrWebServiceImplService;

import javax.xml.ws.BindingProvider;
import java.net.URL;

public class InscrWSDemo {

	public static void main(String[] args) throws Exception {
		System.out.println("#### Collecting arguments (host, port)");
		String host = ( args.length == 0 ? "localhost" : args[0] );
		String port = ( args.length < 2  ? "8080"      : args[1] );
		InscrWebService ws = initialize(host, port);
		System.out.println("#### Running the demo");
		demo(ws);

	}

	private static void demo(InscrWebService ws) throws Exception {
		ws.creatParcours("AL");
        System.out.println("Parcours AL crée");
		//ws.test();
		//System.out.println("ok");
	}

	private static InscrWebService initialize(String host, String port) {
        System.out.println("#### Loading the WSDL contract");
		URL wsdlLocation = InscrWSDemo.class.getResource("/InscrWS.wsdl");
        System.out.println("#### Instantiating the WS Proxy");
		InscrWebServiceImplService factory = new InscrWebServiceImplService(wsdlLocation);
		InscrWebService ws = factory.getInscrWebServiceImplPort();
        System.out.println("#### Updating the endpoint address dynamically");
		String address = "http://"+host+":"+port+"/j2e-1.0-SNAPSHOT/webservices/InscrWS";
		((BindingProvider) ws).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
		return ws;
	}



}

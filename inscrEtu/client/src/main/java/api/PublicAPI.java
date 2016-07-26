package api;

import stubs.affichage.AffichageWebService;
import stubs.affichage.AffichageWebServiceImplService;
import stubs.inscr.InscrWebService;
import stubs.inscr.InscrWebServiceImplService;

import javax.xml.ws.BindingProvider;
import java.net.URL;

public class PublicAPI {

	public AffichageWebService affichage;

	public InscrWebService inscr;


	public PublicAPI(String host, String port) {
		initAffichage(host, port);
        initInscr(host, port);
	}

	private void initAffichage(String host, String port) {
		URL wsdlLocation = PublicAPI.class.getResource("/AffichageWS.wsdl");
		AffichageWebServiceImplService factory = new AffichageWebServiceImplService(wsdlLocation);
		this.affichage = factory.getAffichageWebServiceImplPort();
		String address = "http://" + host + ":" + port + "/j2e-1.0-SNAPSHOT/webservices/AffichageWS";
		((BindingProvider) affichage).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
	}

	private void initInscr(String host, String port) {
		URL wsdlLocation = PublicAPI.class.getResource("/InscrWS.wsdl");
		InscrWebServiceImplService factory = new InscrWebServiceImplService(wsdlLocation);
		this.inscr = factory.getInscrWebServiceImplPort();
		String address = "http://" + host + ":" + port + "/j2e-1.0-SNAPSHOT/webservices/InscrWS";
		((BindingProvider) inscr).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
	}


}

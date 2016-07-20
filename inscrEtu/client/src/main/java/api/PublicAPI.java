package api;

import stubs.affichage.AffichageWebService;
import stubs.affichage.AffichageWebServiceImplService;

import javax.xml.ws.BindingProvider;
import java.net.URL;

public class PublicAPI {

	public AffichageWebService affichage;

	public PublicAPI(String host, String port) {
		initAffichage(host, port);
	}

	private void initAffichage(String host, String port) {
		URL wsdlLocation = PublicAPI.class.getResource("/AffichageWS.wsdl");
		AffichageWebServiceImplService factory = new AffichageWebServiceImplService(wsdlLocation);
		this.affichage = factory.getAffichageWebServiceImplPort();
		String address = "http://" + host + ":" + port + "/j2e-1.0-SNAPSHOT/webservices/AffichageWS";
		((BindingProvider) affichage).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
	}



}

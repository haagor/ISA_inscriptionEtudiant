
package stubs.inscr;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "InscrWebServiceImplService", targetNamespace = "http://polytech.unice.fr/si/4a/isa/bf", wsdlLocation = "file:///home/user/SI4/RATTRAPAGE/ISA/ISA_inscriptionEtudiant/inscrEtu/client/src/main/resources/InscrWS.wsdl")
public class InscrWebServiceImplService
    extends Service
{

    private final static URL INSCRWEBSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException INSCRWEBSERVICEIMPLSERVICE_EXCEPTION;
    private final static QName INSCRWEBSERVICEIMPLSERVICE_QNAME = new QName("http://polytech.unice.fr/si/4a/isa/bf", "InscrWebServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:///home/user/SI4/RATTRAPAGE/ISA/ISA_inscriptionEtudiant/inscrEtu/client/src/main/resources/InscrWS.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        INSCRWEBSERVICEIMPLSERVICE_WSDL_LOCATION = url;
        INSCRWEBSERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public InscrWebServiceImplService() {
        super(__getWsdlLocation(), INSCRWEBSERVICEIMPLSERVICE_QNAME);
    }

    public InscrWebServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), INSCRWEBSERVICEIMPLSERVICE_QNAME, features);
    }

    public InscrWebServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, INSCRWEBSERVICEIMPLSERVICE_QNAME);
    }

    public InscrWebServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, INSCRWEBSERVICEIMPLSERVICE_QNAME, features);
    }

    public InscrWebServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public InscrWebServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns InscrWebService
     */
    @WebEndpoint(name = "InscrWebServiceImplPort")
    public InscrWebService getInscrWebServiceImplPort() {
        return super.getPort(new QName("http://polytech.unice.fr/si/4a/isa/bf", "InscrWebServiceImplPort"), InscrWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns InscrWebService
     */
    @WebEndpoint(name = "InscrWebServiceImplPort")
    public InscrWebService getInscrWebServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://polytech.unice.fr/si/4a/isa/bf", "InscrWebServiceImplPort"), InscrWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (INSCRWEBSERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw INSCRWEBSERVICEIMPLSERVICE_EXCEPTION;
        }
        return INSCRWEBSERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}
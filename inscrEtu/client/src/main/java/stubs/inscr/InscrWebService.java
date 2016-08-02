
package stubs.inscr;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "InscrWebService", targetNamespace = "http://webservices/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface InscrWebService {


    /**
     * 
     * @param arg1
     * @param arg0
     * @throws Exception_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "addCoursP", targetNamespace = "http://webservices/", className = "stubs.inscr.AddCoursP")
    @ResponseWrapper(localName = "addCoursPResponse", targetNamespace = "http://webservices/", className = "stubs.inscr.AddCoursPResponse")
    public void addCoursP(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        Cours arg1)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "selectParcoursForEtudiant", targetNamespace = "http://webservices/", className = "stubs.inscr.SelectParcoursForEtudiant")
    @ResponseWrapper(localName = "selectParcoursForEtudiantResponse", targetNamespace = "http://webservices/", className = "stubs.inscr.SelectParcoursForEtudiantResponse")
    public void selectParcoursForEtudiant(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "addCoursEtu", targetNamespace = "http://webservices/", className = "stubs.inscr.AddCoursEtu")
    @ResponseWrapper(localName = "addCoursEtuResponse", targetNamespace = "http://webservices/", className = "stubs.inscr.AddCoursEtuResponse")
    public void addCoursEtu(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        Cours arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "afficherEtus", targetNamespace = "")
    @RequestWrapper(localName = "afficheEtudiantsInParcours", targetNamespace = "http://webservices/", className = "stubs.inscr.AfficheEtudiantsInParcours")
    @ResponseWrapper(localName = "afficheEtudiantsInParcoursResponse", targetNamespace = "http://webservices/", className = "stubs.inscr.AfficheEtudiantsInParcoursResponse")
    public String afficheEtudiantsInParcours(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(name = "authentificate", targetNamespace = "")
    @RequestWrapper(localName = "authenticate", targetNamespace = "http://webservices/", className = "stubs.inscr.Authenticate")
    @ResponseWrapper(localName = "authenticateResponse", targetNamespace = "http://webservices/", className = "stubs.inscr.AuthenticateResponse")
    public Boolean authenticate(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "afficherPeriodeEtu", targetNamespace = "")
    @RequestWrapper(localName = "afficheEtudiantPeriode", targetNamespace = "http://webservices/", className = "stubs.inscr.AfficheEtudiantPeriode")
    @ResponseWrapper(localName = "afficheEtudiantPeriodeResponse", targetNamespace = "http://webservices/", className = "stubs.inscr.AfficheEtudiantPeriodeResponse")
    public String afficheEtudiantPeriode(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "suppressParcoursOfEtu", targetNamespace = "http://webservices/", className = "stubs.inscr.SuppressParcoursOfEtu")
    @ResponseWrapper(localName = "suppressParcoursOfEtuResponse", targetNamespace = "http://webservices/", className = "stubs.inscr.SuppressParcoursOfEtuResponse")
    public void suppressParcoursOfEtu(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @throws Exception_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "creatEtudiant", targetNamespace = "http://webservices/", className = "stubs.inscr.CreatEtudiant")
    @ResponseWrapper(localName = "creatEtudiantResponse", targetNamespace = "http://webservices/", className = "stubs.inscr.CreatEtudiantResponse")
    public void creatEtudiant(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "creatParcours", targetNamespace = "http://webservices/", className = "stubs.inscr.CreatParcours")
    @ResponseWrapper(localName = "creatParcoursResponse", targetNamespace = "http://webservices/", className = "stubs.inscr.CreatParcoursResponse")
    public void creatParcours(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
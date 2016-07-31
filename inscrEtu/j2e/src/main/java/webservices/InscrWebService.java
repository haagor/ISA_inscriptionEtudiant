package webservices;

import entities.Cours;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface InscrWebService {

    @WebMethod
    @WebResult(name = "creatParcours") // utilise si return autre chose que void
    void creatParcours(String intitule);

    @WebMethod
    @WebResult(name = "addCoursP")
    void addCoursP(String intitule, Cours cours) throws Exception;

    @WebMethod
    @WebResult(name = "creatEtudiant")
    void creatEtudiant(String nom, String prenom, String numeroEtu) throws Exception;

    @WebMethod
    @WebResult(name = "selectParcours")
    void selectParcoursForEtudiant(String numeroEtu, String intitule);

    @WebMethod
    @WebResult(name = "addCoursEtu")
    void addCoursEtu(String numeroEtu, Cours cours);

    @WebMethod
    @WebResult(name = "afficherEtus")
    String afficheEtudiantsInParcours(String intitule);

    @WebMethod
    @WebResult(name = "afficherPeriodeEtu")
    String afficheEtudiantPeriode(String numeroEtu);

    @WebMethod
    @WebResult(name = "suppressParcours")
    void suppressParcoursOfEtu(String numeroEtu);


    }

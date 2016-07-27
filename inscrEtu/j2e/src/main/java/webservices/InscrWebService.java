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
    @WebResult(name = "addCoursP") // utilise si return autre chose que void
    void addCoursP(String intitule, Cours cours);
}

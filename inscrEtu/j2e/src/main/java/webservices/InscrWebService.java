package webservices;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface InscrWebService {

    @WebMethod
    @WebResult(name = "creatParcours") // utilise si return autre chose que void
    void creatParcours(String intitule);
}

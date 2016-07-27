package webservices;

import entities.Cours;
import interfaces.ManageParcours;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;


@WebService(targetNamespace = "http://polytech.unice.fr/si/4a/isa/bf")
@Stateless(name = "InscrWS")
public class InscrWebServiceImpl implements InscrWebService {

    @EJB
    private ManageParcours manageParcours;

    @Override
    public void creatParcours(String name) { manageParcours.creatParcours(name); }

    @Override
    public void addCoursP(String intitule, Cours cours) { manageParcours.addCoursP(intitule, cours); }

}
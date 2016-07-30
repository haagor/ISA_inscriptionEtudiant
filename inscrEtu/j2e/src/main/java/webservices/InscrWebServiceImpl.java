package webservices;

import entities.Cours;
import interfaces.ManageEtudiant;
import interfaces.ManageParcours;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;


@WebService(targetNamespace = "http://polytech.unice.fr/si/4a/isa/bf")
@Stateless(name = "InscrWS")
public class InscrWebServiceImpl implements InscrWebService {

    @EJB
    private ManageParcours manageParcours;

    @EJB
    private ManageEtudiant manageEtudiant;

    @Override
    public void creatParcours(String name) {
        manageParcours.creatParcours(name);
    }

    @Override
    public void addCoursP(String intitule, Cours cours) throws Exception {
        manageParcours.addCoursP(intitule, cours);
    }

    @Override
    public void creatEtudiant(String nom, String prenom, String numeroEtu) throws Exception {
        manageEtudiant.creatEtudiant(nom, prenom, numeroEtu);
    }

    @Override
    public void selectParcoursForEtudiant(String numeroEtu, String intitule) {
        manageEtudiant.selectParcoursForEtudiant(numeroEtu, intitule);
    }

    @Override
    public void addCoursEtu(String numeroEtu, Cours cours) {
        manageEtudiant.addCoursEtu(numeroEtu, cours);
    }

}
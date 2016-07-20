package webservices;

import interfaces.Afficher;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;


@WebService(targetNamespace = "http://polytech.unice.fr/si/4a/isa/bf")
@Stateless(name = "AffichageWS")
public class AffichageWebServiceImpl implements AffichageWebService {


	@EJB private Afficher afficher;

	@Override
	public String afficheTemperature(String pos) {
		return afficher.afficherTemperature(pos);
	}

	@Override
	public void test() {
	}

}
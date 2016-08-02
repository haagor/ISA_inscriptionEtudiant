package components;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import interfaces.Authenticate;
import org.apache.log4j.BasicConfigurator;
import org.json.JSONObject;

import javax.ejb.Stateless;


@Stateless
public class AuthenticatorBean implements Authenticate {

    @Override
    public Boolean authenticate(String id, String mdp) {

        try {
            BasicConfigurator.configure();
            HttpResponse<JsonNode> retRequest = Unirest.get("http://127.0.0.1:8081/" + id)
                    .asJson();
            JSONObject res = retRequest.getBody().getObject();
            if (res.get("id").equals(id) || res.get("password").equals(mdp)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("*** ANNUAIRE INJOIGNABLE ***");
            return false;
        }
    }
}

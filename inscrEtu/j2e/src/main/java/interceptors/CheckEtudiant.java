package interceptors;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.apache.log4j.BasicConfigurator;
import org.json.JSONObject;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

public class CheckEtudiant implements Serializable {

    @AroundInvoke
    public Object intercept(InvocationContext ctx) throws Exception {
        Object result = ctx.proceed();  // do what you're supposed to do
        String nom = (String) ctx.getParameters()[0];
        String prenom = (String) ctx.getParameters()[1];
        String numeroETU = (String) ctx.getParameters()[2];
        System.out.println("        INTERCEPTOR         " + nom + " " + prenom + " " + numeroETU);

        try {
            BasicConfigurator.configure();
            HttpResponse<JsonNode> retRequest = Unirest.get("http://127.0.0.1:8081/" + numeroETU)
                    .asJson();
            JSONObject res = retRequest.getBody().getObject();
            if (res.get("name").equals(nom) || res.get("id").equals(numeroETU)) {
                System.out.println("*** " + numeroETU + " FAIT BIEN PARTI DE L'ANNUAIRE" + " ***");
            } else {
                System.out.println("*** " + numeroETU + " NE FAIT PAS PARTI DE L'ANNUAIRE" + " ***");
            }
        } catch (Exception e) {
            System.out.println("*** ANNUAIRE INJOIGNABLE ***");
        }


        return result;
    }
}


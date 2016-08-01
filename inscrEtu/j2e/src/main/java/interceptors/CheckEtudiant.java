package interceptors;

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
        return result;
    }
}


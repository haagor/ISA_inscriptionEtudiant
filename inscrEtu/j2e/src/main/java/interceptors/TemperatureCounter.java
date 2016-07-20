package interceptors;

import utils.Database;

import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

public class TemperatureCounter
{

    @EJB private Database memory;

    @AroundInvoke
    public Object intercept(InvocationContext ctx) throws Exception {
        Object result = ctx.proceed();  // do what you're supposed to do
        memory.incrementTemps();
        System.out.println(" Temperature collected: " + memory.howManyTemps());
        return result;
    }
}

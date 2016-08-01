package interfaces;

import javax.ejb.Local;


@Local
public interface Authenticate {

    boolean authenticate(String id, String mdp);

    }

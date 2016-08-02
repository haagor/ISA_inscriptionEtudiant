package interfaces;

import javax.ejb.Local;


@Local
public interface Authenticate {

    Boolean authenticate(String id, String mdp);

    }

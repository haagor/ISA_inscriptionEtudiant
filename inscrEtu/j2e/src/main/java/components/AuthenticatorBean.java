package components;

import interfaces.Authenticate;

import javax.ejb.Stateless;


@Stateless
public class AuthenticatorBean implements Authenticate {

    @Override
    public boolean authenticate(String id, String mdp) {
        //consult annuaire
        return true;
    }
}

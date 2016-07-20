package interfaces;

import javax.ejb.Local;


@Local
public interface Afficher {

    String afficherTemperature(String pos);
    }

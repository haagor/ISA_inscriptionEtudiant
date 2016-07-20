package interfaces;

import entities.Bulletin;
import entities.Levels;
import entities.Piste;
import entities.Temperature;

import javax.ejb.Local;
import java.util.List;


@Local
public interface Afficher {

    String afficherTemperature(String pos);
    String afficherWind(String pos);
    String afficherSnow(String pos);
    }

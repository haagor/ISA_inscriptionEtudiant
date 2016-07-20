package interfaces;

import entities.*;

import javax.ejb.Local;
import java.util.List;

@Local
public interface MakeBulletin {

    public List<Piste> findPisteByLevel(Levels lvl);
    public Piste findPisteByName(String name);
    public Temperature findLastTemperature(String pos);
    public Temperature updateTemperature(String pos);
    public Wind findLastWind(String pos);
    public Wind updateWind(String pos);
    public Snow findLastSnow(String pos);
    public Snow updateSnow(String pos);

}

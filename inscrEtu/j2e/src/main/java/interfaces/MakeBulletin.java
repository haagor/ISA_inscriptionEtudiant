package interfaces;

import entities.Temperature;

import javax.ejb.Local;

@Local
public interface MakeBulletin {

    public Temperature findLastTemperature(String pos);
    public Temperature updateTemperature(String pos);

}

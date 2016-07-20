package interfaces;

import entities.Snow;
import entities.Temperature;
import entities.Wind;

import javax.ejb.Local;


@Local
public interface Collect {

	Temperature collectTemperature(String pos);
	Wind collectWind(String pos);
	Snow collectSnow(String pos);

	}

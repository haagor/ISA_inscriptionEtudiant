package interfaces;

import entities.Temperature;

import javax.ejb.Local;


@Local
public interface Collect {

	Temperature collectTemperature(String pos);

	}

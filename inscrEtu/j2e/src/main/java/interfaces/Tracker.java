package interfaces;

import entities.Bulletin;

import javax.ejb.Local;

@Local
public interface Tracker {

	boolean status(String pisteId) throws Exception;

}

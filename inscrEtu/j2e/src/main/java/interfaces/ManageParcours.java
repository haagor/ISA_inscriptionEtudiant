package interfaces;

import entities.Cours;

import javax.ejb.Local;

@Local
public interface ManageParcours {

    void creatParcours(String intitule);
    Boolean addCoursP(String intitule, Cours cours) throws Exception;

}

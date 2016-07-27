package interfaces;

import entities.Cours;

import javax.ejb.Local;

@Local
public interface ManageParcours {

    public void creatParcours(String intitule);
    public Boolean addCoursP(String intitule, Cours cours);

}

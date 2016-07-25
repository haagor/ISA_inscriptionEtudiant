package interfaces;

import javax.ejb.Local;

@Local
public interface ManageParcours {

    public void creatParcours(String intitule);
    public void addCoursP(String intitule, String cours);

}

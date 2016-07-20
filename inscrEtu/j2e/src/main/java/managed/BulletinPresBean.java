package managed;


import entities.Levels;
import entities.Piste;
import interfaces.MakeBulletin;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;


@ManagedBean
public class BulletinPresBean {

    @EJB
    private MakeBulletin makeBulletin;

    public String getTempHaut() {
        return String.valueOf(makeBulletin.updateTemperature("haut").getTemperature());
    }

    public String getTempBas() {
        return String.valueOf(makeBulletin.updateTemperature("bas").getTemperature());
    }

    public String getWindHaut() {
        return String.valueOf(makeBulletin.updateWind("haut").getWind());
    }

    public String getWindBas() {
        return String.valueOf(makeBulletin.updateWind("bas").getWind());
    }

    public String getSnowHaut() {
        return String.valueOf(makeBulletin.updateSnow("haut").getSnow());
    }

    public String getSnowBas() {
        return String.valueOf(makeBulletin.updateSnow("bas").getSnow());
    }

}

/*package entities;


import javax.ejb.Singleton;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

@Entity
public class Bulletin implements Serializable{

    @OneToMany (cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private ArrayList<Piste> pistes;

    @OneToOne(cascade = {CascadeType.PERSIST})
    private Temperature tempHaut;

    @OneToOne(cascade = {CascadeType.PERSIST})
    private Temperature tempBas;

    @OneToOne (cascade = {CascadeType.PERSIST})
    private Wind windHaut;

    @OneToOne (cascade = {CascadeType.PERSIST})
    private Wind windBas;

    @OneToOne (cascade = {CascadeType.PERSIST})
    private Snow snowHaut;

    @OneToOne (cascade = {CascadeType.PERSIST})
    private Snow snowBas;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Bulletin() {}
    public Bulletin(ArrayList<Piste> pistes, Temperature tempHaut, Temperature tempBas,
                    Wind windHaut, Wind windBas,
                    Snow snowHaut, Snow snowBas) {
        this.pistes = pistes;
        this.tempHaut = tempHaut;
        this.tempBas = tempBas;
        this.windHaut = windHaut;
        this.windBas = windBas;
        this.snowHaut = snowHaut;
        this.snowBas = snowBas;
    }

    public ArrayList<Piste> getPistes() { return pistes; }

    public Temperature getTempHaut() {
        return tempHaut;
    }

    public Temperature getTempBas() {
        return tempBas;
    }

    public Wind getWindHaut() {
        return windHaut;
    }

    public Wind getWindBas() {
        return windBas;
    }

    public Snow getSnowHaut() {
        return snowHaut;
    }

    public Snow getSnowBas() {
        return snowBas;
    }

    public int getId() { return id; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bulletin)) return false;

        Bulletin bulletin = (Bulletin) o;

        if (this.getPistes().equals(bulletin.getPistes()) && this.getTempHaut() == bulletin.getTempHaut()
                && this.getWindHaut() == bulletin.getWindHaut() && this.getSnowHaut() == bulletin.getSnowHaut()
                && this.getTempBas() == bulletin.getTempBas()
                && this.getWindBas() == bulletin.getWindBas() && this.getSnowBas() == bulletin.getSnowBas()
                && this.getId() == bulletin.getId()) return true;
        return false;
    }
}
*/
package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class Parcours implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String intitule;

    @NotNull
    private ArrayList<Cours> cours;

    public Parcours() {}
    public Parcours(String intitule, ArrayList<Cours> cours) {
        this.intitule = intitule;
        this.cours=cours;
    }

    public int getId() { return id; }
    public String getIntitule() { return intitule; }
    public ArrayList<Cours> getCours() { return cours; }
}

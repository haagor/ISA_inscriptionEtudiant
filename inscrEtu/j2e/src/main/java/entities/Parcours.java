package entities;

import javax.persistence.*;
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

    @OneToMany (cascade = {CascadeType.PERSIST})
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

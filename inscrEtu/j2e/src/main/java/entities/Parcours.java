package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Parcours implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String intitule;

    @NotNull
    private ArrayList<String> cours = new ArrayList<String>();

    public Parcours() {}
    public Parcours(String intitule, ArrayList<String> cours) {
        this.intitule = intitule;
        this.cours = cours;
    }

    public int getId() { return id; }
    public String getIntitule() { return intitule; }
    public ArrayList<String> getCours() { return cours; }

    public void addCours(String c) { cours.add(c); }

}

package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class Cours implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String intitule;

    @NotNull
    private ArrayList<Integer> periode;

    @NotNull
    private ArrayList<ArrayList<Integer>> emplacement;

    @NotNull
    private ArrayList<Cours> prerequis;

    @NotNull
    private ArrayList<Cours> corequis;

    public Cours() {}
    public Cours(String intitule, ArrayList<Integer> periode, ArrayList<ArrayList<Integer>> emplacement,
                 ArrayList<Cours> prerequis, ArrayList<Cours> corequis) {
        this.intitule = intitule;
        this.periode = periode;
        this.emplacement = emplacement;
        this.prerequis = prerequis;
        this.corequis = corequis;
    }

    public int getId() { return id; }
    public String getIntitule() { return intitule; }
    public ArrayList<Integer> getPeriode() { return periode; }
    public ArrayList<ArrayList<Integer>> getEmplacement() { return emplacement; }
    public ArrayList<Cours> getPrerequis() { return prerequis; }
    public ArrayList<Cours> getCorequis() { return corequis; }
}

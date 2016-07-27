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
    private ArrayList<Cours> cours = new ArrayList<Cours>();

    public Parcours() {
    }

    public Parcours(String intitule, ArrayList<Cours> cours) {
        this.intitule = intitule;
        this.cours = cours;
    }

    public int getId() {
        return id;
    }

    public String getIntitule() {
        return intitule;
    }

    public ArrayList<Cours> getCours() {
        return cours;
    }

    public void addCours(Cours c) {
        cours.add(c);
    }

    public void removeCours(Cours c) {
        cours.remove(c);
    }

    public void findCours(String c) {
        for (int i = 0; i < cours.size(); i++) {
            if (cours.get(i).equals(c)) {

            }
        }
    }

    public boolean prerequisOK(Cours c) {
        String prerequis = c.getPrerequis();
        if (!prerequis.equals("")) {
            if (prerequis.contains("-")) {
                for (String id : prerequis.split("-")) {
                    if (!containsIDCours(id, cours)) {
                        System.out.println(id + " n'a pas tout ses prérequis");
                        return false;
                    }
                }
                return true;
            } else {
                if (!containsIDCours(prerequis, cours)) {
                    System.out.println(id + " n'a pas tout ses prérequis");
                    return false;
                }
                return true;
            }
        } else {
            return true;
        }
    }

    public boolean containsIDCours(String idCours, ArrayList<Cours> list_cours) {
        for (int i = 0; i < list_cours.size(); i++) {
            if (list_cours.get(i).getId().equals(idCours)) {
                return true;
            }
        }
        return false;
    }

}

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

    private String intitule;

    protected ArrayList<Cours> cours = new ArrayList<Cours>(); // new pour client

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
                    if (!containsIDCours(id)) {
                        System.out.println(id + " n'a pas tout ses prérequis");
                        return false;
                    }
                }
                return true;
            } else {
                if (!containsIDCours(prerequis)) {
                    System.out.println(c.getId() + " n'a pas tout ses prérequis");
                    return false;
                }
                return true;
            }
        } else {
            return true;
        }
    }

    //check final
    public boolean corequisOK() {
        for (Cours c : cours) {
            if (!oneCorequisOK(c)) {
                return false;
            };
        }
        return true;
    }

    public boolean oneCorequisOK(Cours c) {
        String corequis = c.getCorequis();
        if (!corequis.equals("")) {
            if (corequis.contains("-")) {
                for (String id : corequis.split("-")) {
                    if (!containsIDCours(id)) {
                        return false;
                    }
                }
            } else {
                if (!containsIDCours(corequis)) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean containsIDCours(String idCours) {
        for (int i = 0; i < cours.size(); i++) {
            if (cours.get(i).getId().equals(idCours)) {
                return true;
            }
        }
        return false;
    }

    public int countECTS() {
        int acc = 0;
        for (Cours c : cours) {
            if (c.getPeriode() == 3) {
                acc += 4;
            } else {
                acc += 2;
            }
        }
        return acc;
    }

    public int countPeriode(int periode) {
        int res = 0;
        for (Cours c : cours) {
            if (c.getPeriode() == periode || c.getPeriode() == 3) {
                res += 2;
            }
        }
        return res;
    }

}

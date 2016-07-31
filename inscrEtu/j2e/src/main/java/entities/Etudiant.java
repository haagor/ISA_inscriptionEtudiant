package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Etudiant implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String nom;

    @NotNull
    private String prenom;

    @NotNull
    private String numeroEtu;

    @OneToOne (cascade = {CascadeType.PERSIST})
    private ParcoursEtu parcoursEtu = null;

    public Etudiant() {}
    public Etudiant(String nom, String prenom, String numeroEtu) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroEtu = numeroEtu;
        this.parcoursEtu = null;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getNumeroEtu() { return numeroEtu; }
    public ParcoursEtu getParcoursEtu() { return parcoursEtu; }

    public void setParcoursEtu(ParcoursEtu parcoursEtu) {
        this.parcoursEtu = parcoursEtu;
    }

    public String affichePeriode(int periode) {
        String res = "";
        if (parcoursEtu == null) {
            return "/";
        }
        for (Cours c : parcoursEtu.getCours()) {
            if (c.getPeriode() == periode || c.getPeriode() == 3) {
                res += c.getIntitule() + "\n";
            }
        }
        return res;
    }
}

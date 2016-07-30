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

    @OneToOne (cascade = {CascadeType.ALL})
    private Parcours parcours;

    public Etudiant() {}
    public Etudiant(String nom, String prenom, String numeroEtu, Parcours parcours) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroEtu = numeroEtu;
        this.parcours = parcours;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getNumeroEtu() { return numeroEtu; }
    public Parcours getParcours() { return parcours; }
}

package entities;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class ParcoursEtu extends Parcours {

    private String numeroEtu;

    public ParcoursEtu() {}
        public ParcoursEtu(String intitule, ArrayList<Cours> cours, String numeroEtu) {
            super(intitule, cours);
            this.numeroEtu = numeroEtu;
        }
}

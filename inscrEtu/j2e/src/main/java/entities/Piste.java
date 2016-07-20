package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.awt.geom.Area;
import java.io.Serializable;

@Entity
public class Piste implements Serializable {

    @NotNull
    private String name;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Levels level;

    @Enumerated(EnumType.STRING)
    @NotNull
    private AreaEnum zone;

    @NotNull
    private boolean open;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Piste() {}
    public Piste(String name, Levels level, AreaEnum zone, boolean open) {
        this.name = name;
        this.level = level;
        this.zone = zone;
        this.open = open;
    }

    public String getName() { return name; }
    public Levels getLevel() { return level; }
    public AreaEnum getZone() { return zone; }
    public boolean getOpen() { return open; }
    public int getId() { return id; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Piste)) return false;
        Piste piste = (Piste) o;

        if (this.getName() == piste.getName() && this.getLevel() == piste.getLevel()
                && this.getZone() == piste.getZone() & this.getOpen() == piste.getOpen()
                && this.getId() == piste.getId()) return true;
        return false;
    }


    // **********************  Attention couche présentation *************************
    public String getImgOpen() {
        String res;
        if (this.open) {
            res = "img/button-green.png";
        } else {
            res = "img/button-red.png";
        }
        return res;
    }
}
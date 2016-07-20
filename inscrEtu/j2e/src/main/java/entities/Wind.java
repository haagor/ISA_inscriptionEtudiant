package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalTime;

@Entity
public class Wind implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private long time;

    @NotNull
    private String pos;

    @NotNull
    private int wind;

    public Wind() {}
    public Wind(long time, String pos, int wind) {
        this.time = time;
        this.pos = pos;
        this.wind = wind;
    }

    public long getTime() { return time; }
    public String getPos() { return pos; }
    public int getWind() { return wind; }
    public int getId() { return id; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wind)) return false;

        Wind wind = (Wind) o;

        if (this.getWind() == wind.getWind() && this.getTime() == wind.getTime()
                && this.getPos() == wind.getPos()) return true;
        return false;
    }
}

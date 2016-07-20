package entities;


import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Embeddable
public class Meteo {

    @NotNull
    private long time;

    @NotNull
    private String pos;

    public Meteo() { }
    public Meteo(long time, String pos) {
        this.time = time;
        this.pos = pos;
    }

    public long getTime() { return time; }
    public String getPos() { return pos; }
    public void setPos(String pos) { this.pos = pos; }
    public void setTime(long time) { this.time = time; }
}

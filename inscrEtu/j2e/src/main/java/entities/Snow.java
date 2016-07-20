package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalTime;

@Entity
public class Snow implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	private long time;

	@NotNull
	private String pos;

	@NotNull
	private int snow; // C°

	public Snow() {}
	public Snow(long time, String pos, int snow) {
		this.time = time;
		this.pos = pos;
		this.snow = snow;
	}


	public long getTime() { return time; }
	public String getPos() { return pos; }
	public int getSnow() { return snow; }
	public int getId() { return id; }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Snow)) return false;

		Snow snow = (Snow) o;

		if (this.getSnow() == snow.getSnow() && this.getTime() == snow.getTime()
				&& this.getPos() == snow.getPos()) return true;
		return false;
	}

}

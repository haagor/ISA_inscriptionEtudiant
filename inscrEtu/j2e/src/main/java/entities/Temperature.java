package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Temperature implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	private long time;

	@NotNull
	private String pos;

	@NotNull
	private float temperature; // C°

	public Temperature() {}
	public Temperature(long time, String pos, float temperature) {
		this.time = time;
		this.pos = pos;
		this.temperature = temperature;
	}


	public long getTime() { return time; }
	public String getPos() { return pos; }
	public float getTemperature() { return temperature; }
	public int getId() { return id; }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Temperature)) return false;

		Temperature temperature = (Temperature) o;

		if (this.getTemperature() == temperature.getTemperature() && this.getTime() == temperature.getTime()
				&& this.getPos() == temperature.getPos()) return true;
		return false;
	}

}

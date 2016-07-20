package managed;

import utils.Database;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import java.io.Serializable;

@ManagedBean
public class StatisticsBean implements Serializable {

	@EJB private Database memory;

	public int getProcessed() {
		return memory.howManyTemps();
	}

}

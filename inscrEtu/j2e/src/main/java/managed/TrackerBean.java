package managed;

import interfaces.Tracker;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class TrackerBean {

	@EJB private Tracker tracker;

	@ManagedProperty("#{param.pisteId}")  // Will be automatically injected from the GET parameter
	private String pisteId;
	public String getPisteId() { return pisteId; }
	public void setPisteId(String pisteId) { this.pisteId = pisteId; }

	public String getStatus() {
		if(pisteId == null) { return "No pisteId given!"; }
		try {
			if(tracker.status(pisteId)) {
				return "La piste " + pisteId + " est ouverte";
			} else {
                return "La piste " + pisteId + " est fermée";
            }
		} catch (Exception uiod) {
			return "Unknown piste [" + pisteId + "]";
		}
	}

}

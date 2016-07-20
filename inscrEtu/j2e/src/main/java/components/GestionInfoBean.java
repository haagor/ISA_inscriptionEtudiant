package components;


import entities.Temperature;
import interfaces.Afficher;
import interfaces.Collect;
import interfaces.MakeBulletin;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.Instant;
import java.util.List;

@Stateless
public class GestionInfoBean implements Afficher, MakeBulletin {

    @EJB
    private Collect collect;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public String afficherTemperature(String pos) {
        Temperature t = collect.collectTemperature(pos);
        Instant instant = Instant.ofEpochSecond(t.getTime());
        String res = "\nil faisait " + t.getTemperature() + "°C à " + instant + " en " + t.getPos() + " de la station\n" ;
        return res;
    }

    public Temperature findLastTemperature(String pos) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Temperature> criteria = builder.createQuery(Temperature.class);
        Root<Temperature> root = criteria.from(Temperature.class);
        criteria.select(root).where(builder.equal(root.get("pos"), pos));
        TypedQuery<Temperature> query = entityManager.createQuery(criteria);
        try {
            return lastTemperature(query.getResultList());
        } catch (NoResultException nre) {
            return null;
        }
    }

    public Temperature lastTemperature(List<Temperature> t) {
        long n = 0;
        Temperature res = null;
        for (Temperature tmp : t) {
            if (tmp.getTime() > n) {
                n = tmp.getTime();
                res = tmp;
            }
        }
        return res;
    }

    public Temperature updateTemperature(String pos) {
        Temperature lastT = findLastTemperature(pos);
        Temperature res = lastT;
        long currentTime = Instant.now().getEpochSecond();
        if ((currentTime - lastT.getTime()) > 10) { // Si le dernier releve date de +10sec (en vrai plutot 30min)
            res = collect.collectTemperature(pos);
        }
        return res;
    }

}
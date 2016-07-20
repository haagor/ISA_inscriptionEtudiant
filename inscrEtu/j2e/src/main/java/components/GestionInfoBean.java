package components;


import entities.*;
import interfaces.Afficher;
import interfaces.Collect;
import interfaces.MakeBulletin;
import interfaces.Tracker;

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
public class GestionInfoBean implements Afficher, Tracker, MakeBulletin {

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

    @Override
    public String afficherWind(String pos) {
        Wind w = collect.collectWind(pos);
        Instant instant = Instant.ofEpochSecond(w.getTime());
        String res = "\nil y avait " + w.getWind() + "km/h de vent à " + instant + " en " + w.getPos() + " de la station\n" ;
        return res;
    }

    @Override
    public String afficherSnow(String pos) {
        Snow s = collect.collectSnow(pos);
        Instant instant = Instant.ofEpochSecond(s.getTime());
        String res = "\nil y avait " + s.getSnow() + "cm de neige " + instant + " en " + s.getPos() + " de la station\n" ;
        return res;
    }


    @Override
    public boolean status(String PisteId) {
        Piste piste = entityManager.find(Piste.class, Integer.parseInt(PisteId));
        if (piste == null)
            System.out.print("Error");
        return piste.getOpen();
    }

    public List<Piste> findPisteByLevel(Levels lvl) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Piste> criteria = builder.createQuery(Piste.class);
        Root<Piste> root = criteria.from(Piste.class);
        criteria.select(root).where(builder.equal(root.get("level"), lvl));
        TypedQuery<Piste> query = entityManager.createQuery(criteria);
        try {
            return query.getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public Piste findPisteByName(String name) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Piste> criteria = builder.createQuery(Piste.class);
        Root<Piste> root = criteria.from(Piste.class);
        criteria.select(root).where(builder.equal(root.get("name"), name));
        TypedQuery<Piste> query = entityManager.createQuery(criteria);
        try {
            return query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
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

    public Wind findLastWind(String pos) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Wind> criteria = builder.createQuery(Wind.class);
        Root<Wind> root = criteria.from(Wind.class);
        criteria.select(root).where(builder.equal(root.get("pos"), pos));
        TypedQuery<Wind> query = entityManager.createQuery(criteria);
        try {
            return lastWind(query.getResultList());
        } catch (NoResultException nre) {
            return null;
        }
    }

    public Wind lastWind(List<Wind> w) {
        long n = 0;
        Wind res = null;
        for (Wind wind : w) {
            if (wind.getTime() > n) {
                n = wind.getTime();
                res = wind;
            }
        }
        return res;
    }

    public Wind updateWind(String pos) {
        Wind lastW = findLastWind(pos);
        Wind res = lastW;
        long currentTime = Instant.now().getEpochSecond();
        if ((currentTime - lastW.getTime()) > 10) { // Si le dernier releve date de +10sec (en vrai plutot 30min)
            res = collect.collectWind(pos);
        }
        return res;
    }

    public Snow findLastSnow(String pos) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Snow> criteria = builder.createQuery(Snow.class);
        Root<Snow> root = criteria.from(Snow.class);
        criteria.select(root).where(builder.equal(root.get("pos"), pos));
        TypedQuery<Snow> query = entityManager.createQuery(criteria);
        try {
            return lastSnow(query.getResultList());
        } catch (NoResultException nre) {
            return null;
        }
    }

    public Snow lastSnow(List<Snow> s) {
        long n = 0;
        Snow res = null;
        for (Snow snow : s) {
            if (snow.getTime() > n) {
                n = snow.getTime();
                res = snow;
            }
        }
        return res;
    }

    public Snow updateSnow(String pos) {
        Snow lastS = findLastSnow(pos);
        Snow res = lastS;
        long currentTime = Instant.now().getEpochSecond();
        if ((currentTime - lastS.getTime()) > 10) { // Si le dernier releve date de +10sec (en vrai plutot 30min)
            res = collect.collectSnow(pos);
        }
        return res;
    }

}
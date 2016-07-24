package components;

import entities.Parcours;
import interfaces.Search;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class SearchBean implements Search {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Parcours findParcoursByIntitule(String intitule) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Parcours> criteria = builder.createQuery(Parcours.class);
        Root<Parcours> root = criteria.from(Parcours.class);
        criteria.select(root).where(builder.equal(root.get("intitule"), intitule));
        TypedQuery<Parcours> query = entityManager.createQuery(criteria);
        try {
            return query.getResultList().get(0);
        } catch (NoResultException nre) {
            return null;
        }
    }
}

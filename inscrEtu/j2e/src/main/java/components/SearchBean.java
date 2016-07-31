package components;

import entities.Cours;
import entities.Etudiant;
import entities.Parcours;
import interfaces.Search;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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
        if (query.getResultList().isEmpty()) {
            return null;
        } else {
            return query.getResultList().get(0);
        }
    }

    @Override
    public Cours findCoursById(String id) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cours> criteria = builder.createQuery(Cours.class);
        Root<Cours> root = criteria.from(Cours.class);
        criteria.select(root).where(builder.equal(root.get("id"), id));
        TypedQuery<Cours> query = entityManager.createQuery(criteria);
        if (query.getResultList().isEmpty()) {
            return null;
        } else {
            return query.getResultList().get(0);
        }
    }

    @Override
    public Etudiant findEtudiantByNumEtu(String numeroEtu) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Etudiant> criteria = builder.createQuery(Etudiant.class);
        Root<Etudiant> root = criteria.from(Etudiant.class);
        criteria.select(root).where(builder.equal(root.get("numeroEtu"), numeroEtu));
        TypedQuery<Etudiant> query = entityManager.createQuery(criteria);
        if (query.getResultList().isEmpty()) {
            return null;
        } else {
            return query.getResultList().get(0);
        }
    }

}

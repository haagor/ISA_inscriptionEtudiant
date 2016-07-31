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
import java.util.List;

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

    @Override
    public String afficheEtudiantsInParcours(String parcours) {
        return this.EtudiantsByParcours(this.findAllEtudiants(), parcours);
    }

    @Override
    public List<Etudiant> findAllEtudiants() {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Etudiant> criteria = builder.createQuery(Etudiant.class);
        Root<Etudiant> root = criteria.from(Etudiant.class);
        CriteriaQuery<Etudiant> all = criteria.select(root);
        TypedQuery<Etudiant> query = entityManager.createQuery(all);
        if (query.getResultList().isEmpty()) {
            return null;
        } else {
            return query.getResultList();
        }
    }

    @Override
    public String EtudiantsByParcours(List<Etudiant> l, String intitule) {
        String semiRes = "";
        String desequilibre = "";
        for (Etudiant etudiant : l) {
            if (etudiant.getParcoursEtu() == null) {
                continue;
            }
            if (etudiant.getParcoursEtu().getIntitule() != intitule) {
                continue;
            } else {
                int p1 = etudiant.getParcoursEtu().countPeriode(1);
                int p2 = etudiant.getParcoursEtu().countPeriode(2);
                if (p1 != p2) {
                    desequilibre += etudiant.getNumeroEtu() + "     :       " + p1 + "/" + p2 + "\n";
                } else {
                    semiRes += etudiant.getNumeroEtu() + "\n";
                }
            }
        }
        String intro = "*** etudiants du parcours " + intitule + " ***";
        String res = intro +  semiRes + "\n------------ etudiant desequilibre ------------\n\n" + desequilibre;
        return res;
    }

    @Override
    public String afficheEtudiantPeriode(String numeroEtu) {
        Etudiant e = this.findEtudiantByNumEtu(numeroEtu);
        String p1 = e.affichePeriode(1);
        String p2 = e.affichePeriode(2);
        String res = "*** etudiant " + e.getNom() + " " + e.getPrenom() + " (" + e.getParcoursEtu().getIntitule() + ")" +
                " ***\n" + "- Periode n°1\n" + p1 + "- Periode n°2\n" + p2;
        return res;
    }

}

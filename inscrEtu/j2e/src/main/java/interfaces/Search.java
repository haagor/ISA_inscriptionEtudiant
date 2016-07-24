package interfaces;

import entities.Parcours;

import javax.ejb.Local;


@Local
public interface Search {

    public Parcours findParcoursByIntitule(String intitule);
}

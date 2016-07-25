package entities;

public enum Cours {

    EP5I9161("EP5I9161", "Algorithmic approach to distributed computing", "1", "lundi", "matin", "", "" );

    private String id;
    private String intitule;
    private String periode;
    private String emplacementJour;
    private String emplacementHeure;
    private String prerequis;
    private String corequis;

    Cours(String id, String intitule, String periode, String emplacementJour, String emplacementHeure, String prerequis, String corequis) {
        this.id = id;
        this.intitule = intitule;
        this.periode = periode;
        this.emplacementJour = emplacementJour;
        this.emplacementHeure = emplacementHeure;
        this.prerequis = prerequis;
        this.corequis = corequis;
    }

    public String getId() { return id; }
    public String getIntitule() { return intitule; }
    public String getPeriode() { return periode; }
    public String getEmplacementJour() { return emplacementJour; }
    public String getEmplacementHeure() { return emplacementHeure; }
    public String getPrerequis() { return prerequis; }
    public String getCorequis() { return corequis; }
}

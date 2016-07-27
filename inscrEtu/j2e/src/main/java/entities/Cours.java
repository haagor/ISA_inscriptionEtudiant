package entities;

public enum Cours {

    EP5I9161("EP5I9161", "Algorithmic approach to distributed computing", 1, "lundi", "matin", "", "" ),
    EP5I9112("EP5I9112", "Conception et évaluation des IHM", 3, "lundi", "matin", "", "" ),
    EP5EU301("EP5EU301", "Compression", 1, "lundi", "aprem", "", ""),
    EP5I9270("EP5I9270", "Web de données", 1, "mardi", "matin", "", ""),
    EP5I9264("EP5I9264", "Sécurité des applications web", 1, "jeudi", "matin", "", ""),
    EP5I9212("EP5I9212", "Web sémantique", 2, "mardi", "aprem", "EP5I9270", ""),
    EP5I9193("EP5I9193", "Technologies pour les données massives", 2, "lundi", "matin", "", ""),
    EP5I9262("EP5I9262", "Programmable web - server-side", 2, "lundi", "aprem", "", "EP5I9261"),
    EP5I9261("EP5I9261", "Programmable web - client-side", 2, "jeudi", "matin", "", "EP5I9262");

    private String id;
    private String intitule;
    private int periode;
    private String emplacementJour;
    private String emplacementHeure;
    private String prerequis;
    private String corequis;

    Cours(String id, String intitule, int periode, String emplacementJour, String emplacementHeure, String prerequis, String corequis) {
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
    public int getPeriode() { return periode; }
    public String getEmplacementJour() { return emplacementJour; }
    public String getEmplacementHeure() { return emplacementHeure; }
    public String getPrerequis() { return prerequis; }
    public String getCorequis() { return corequis; }
}

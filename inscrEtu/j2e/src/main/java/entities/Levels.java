package entities;

public enum Levels {

    VERT("vert", "facile"),
    BLEU("bleu", "moyenne"),
    ROUGE("rouge", "difficile"),
    NOIR("noir", "très difficile"),
    JAUNE("jaune", "balisé non damée");

    private String value;
    private String com;

    public String getCom() { return com; }
    public String getValue() { return value; }

    Levels(String value, String com) {
        this.value = value;
        this.com = com;
    }
}
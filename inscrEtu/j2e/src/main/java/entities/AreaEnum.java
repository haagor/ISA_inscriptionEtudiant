package entities;


public enum AreaEnum {

    SNOW_PARK("Snow park"),
    BEGINNER("Beginner"),
    PRO("Pro");

    private String name;

    public String getName() { return name; }

    AreaEnum(String name) { this.name = name; }
}
package ch.zli.m223.ksh19a.mj.CRM.model;

import java.util.List;

public interface Klasse {
    public Long getID();

    public String getName();

    public Klassenlehrperson getLehrperson();

    public List<Schueler> getSchueler();

    public Integer getAnzahlSchueler();

    void addSchuelerZurKlasse(SchuelerImpl schueler);
}

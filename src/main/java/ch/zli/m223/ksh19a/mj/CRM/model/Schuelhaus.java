package ch.zli.m223.ksh19a.mj.CRM.model;

import java.util.List;

public interface Schuelhaus {

    public Long getID();

    public String getName();

    public Integer getKlassenAnzahl();

    public List<Klasse> getKlassen();

    void addKlasseZumSchulhaus(KlasseImpl klasse);
}

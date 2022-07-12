package ch.zli.m223.ksh19a.mj.CRM.model;

import java.util.Date;

public interface Schueler {
    public Long getID();

    public String getVorname();

    public String getNachname();
    public Date getStartSchulzeit();
    public Date getEndeSchulzeit();
}

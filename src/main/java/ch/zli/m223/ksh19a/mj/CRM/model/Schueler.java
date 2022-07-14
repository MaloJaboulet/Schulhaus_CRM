package ch.zli.m223.ksh19a.mj.CRM.model;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

public interface Schueler extends UserDetails {
    public Long getID();

    public String getVorname();

    public String getNachname();
    public Date getStartSchulzeit();
    public Date getEndeSchulzeit();
}

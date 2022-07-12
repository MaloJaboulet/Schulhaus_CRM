package ch.zli.m223.ksh19a.mj.CRM.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity(name = "Schueler")
public class SchuelerImpl implements Schueler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vorname;
    private String nachname;
    private Date startSchulzeit;
    private Date endeSchulzeit;

    @ManyToOne
    private KlasseImpl klasse;

    protected SchuelerImpl() { /* for JPA only*/}

    public SchuelerImpl(String vorname, String nachname, KlasseImpl klasse) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.klasse = klasse;
        this.startSchulzeit = new Date(System.currentTimeMillis());

        Calendar c = Calendar.getInstance();
        c.setTime(startSchulzeit);
        c.add(Calendar.YEAR, 3);
        this.endeSchulzeit = c.getTime();
    }

    @Override
    public Long getID() {
        return id;
    }

    @Override
    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    @Override
    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    @Override
    public Date getStartSchulzeit() {
        return startSchulzeit;
    }

    public void setStartSchulzeit(Date startSchulzeit) {
        this.startSchulzeit = startSchulzeit;
    }

    @Override
    public Date getEndeSchulzeit() {
        return endeSchulzeit;
    }

    public void setEndeSchulzeit(Date endeSchulzeit) {
        this.endeSchulzeit = endeSchulzeit;
    }

    public KlasseImpl getKlasse() {
        return klasse;
    }

    public void setKlasse(KlasseImpl klasse) {
        this.klasse = klasse;
    }
}

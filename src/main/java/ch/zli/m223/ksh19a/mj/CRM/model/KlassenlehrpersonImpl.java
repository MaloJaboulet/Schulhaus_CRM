package ch.zli.m223.ksh19a.mj.CRM.model;

import javax.persistence.*;


@Entity(name = "Klassenlehrperson")
public class KlassenlehrpersonImpl implements Klassenlehrperson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vorname;
    private String nachname;
    private Integer alter;

    @OneToOne
    private KlasseImpl klasse;

    public KlassenlehrpersonImpl() {
    }

    public KlassenlehrpersonImpl(String vorname, String nachname, Integer alter, KlasseImpl klasse) {
        this();
        this.vorname = vorname;
        this.nachname = nachname;
        this.alter = alter;
        this.klasse = klasse;
    }

    @Override
    public Long getID() {
        return null;
    }

    @Override
    public String getVorname() {
        return vorname;
    }

    @Override
    public String getNachname() {
        return nachname;
    }

    @Override
    public Integer getAlter() {
        return alter;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setAlter(Integer alter) {
        this.alter = alter;
    }

    @Override
    public Klasse getKlasse() {
        return klasse;
    }

    public void setKlasse(Klasse klasse) {
        this.klasse = (KlasseImpl) klasse;
    }
}

package ch.zli.m223.ksh19a.mj.CRM.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Klasse")
public class KlasseImpl implements Klasse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "klasse")
    private List<SchuelerImpl> schuelers;

    @OneToOne
    private KlassenlehrpersonImpl klassenlehrperson;

    @ManyToOne
    private SchulhausImpl schulhaus;


    protected KlasseImpl() {
        /* for JPA only*/
        schuelers = new ArrayList<>();
    }

    public KlasseImpl(String name, SchulhausImpl schulhaus) {
        this();
        this.name = name;
        schuelers = new ArrayList<>();
        this.schulhaus = schulhaus;
    }


    @Override
    public Long getID() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Klassenlehrperson getLehrperson() {
        return klassenlehrperson;
    }


    @Override
    public List<Schueler> getSchueler() {
        return new ArrayList<>(schuelers);
    }

    @Override
    public Integer getAnzahlSchueler() {
        return schuelers.size();
    }

    @Override
    public void setKlassenlehrperson(Klassenlehrperson klassenlehrperson) {
        this.klassenlehrperson = (KlassenlehrpersonImpl) klassenlehrperson;
    }

    @Override
    public void addSchuelerZurKlasse(String vorname, String nachname, String password) {
        SchuelerImpl schueler = new SchuelerImpl(vorname, nachname,this, password);
        schuelers.add(schueler);
    }

    @Override
    public String getSchulhausname() {
        return schulhaus.getName();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SchuelerImpl> getSchuelers() {
        return schuelers;
    }

    public void setSchuelers(List<SchuelerImpl> schuelers) {
        this.schuelers = schuelers;
    }

    public KlassenlehrpersonImpl getKlassenlehrperson() {
        return klassenlehrperson;
    }

    public void setKlassenlehrperson(KlassenlehrpersonImpl klassenlehrperson) {
        this.klassenlehrperson = klassenlehrperson;
    }

    public SchulhausImpl getSchulhaus() {
        return schulhaus;
    }

    public void setSchulhaus(SchulhausImpl schulhaus) {
        this.schulhaus = schulhaus;
    }


}

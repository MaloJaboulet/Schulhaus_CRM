package ch.zli.m223.ksh19a.mj.CRM.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Schulhaus")
public class SchulhausImpl implements Schuelhaus{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "schulhaus")
    private List<KlasseImpl> klassen;

    public SchulhausImpl() {
        this.klassen = new ArrayList<>();
    }

    public SchulhausImpl(String name) {
        this.name = name;
        this.klassen = new ArrayList<>();
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
    public Integer getKlassenAnzahl() {
        return klassen.size();
    }

    @Override
    public List<Klasse> getKlassen() {
        return new ArrayList<>(klassen);
    }

    @Override
    public void addKlasseZumSchulhaus(KlasseImpl klasse) {
        klassen.add(klasse);
    }
}

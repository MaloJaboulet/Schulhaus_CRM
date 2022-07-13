package ch.zli.m223.ksh19a.mj.CRM.controller.DTO;

import ch.zli.m223.ksh19a.mj.CRM.model.Klasse;
import ch.zli.m223.ksh19a.mj.CRM.model.Schulhaus;

import java.util.ArrayList;
import java.util.List;

public class SchulhausDTO {

    public Long id;
    public String schulhausName;
    public List<KlasseDTO> klassen;


    public SchulhausDTO(Schulhaus schulhaus) {
        id = schulhaus.getID();
        schulhausName = schulhaus.getName();
        klassen = new ArrayList<>();
        for (Klasse klasse : schulhaus.getKlassen()) {
            klassen.add(new KlasseDTO(klasse));
        }
    }
}


package ch.zli.m223.ksh19a.mj.CRM.controller.DTO;


import ch.zli.m223.ksh19a.mj.CRM.model.Klasse;
import ch.zli.m223.ksh19a.mj.CRM.model.Schueler;

import java.util.ArrayList;
import java.util.List;

public class KlasseDTO {

    public Long id;
    public String name;
    public String schulhausName;
    public List<SchuelerDTO> schuelers;


    public KlasseDTO(Klasse klasse) {
        id = klasse.getID();
        name = klasse.getName();
        schuelers = new ArrayList<>();
        schulhausName = klasse.getSchulhausname();
        for (Schueler schueler : klasse.getSchueler()) {
            schuelers.add(new SchuelerDTO(schueler));
        }
    }
}

package ch.zli.m223.ksh19a.mj.CRM.controller;

import ch.zli.m223.ksh19a.mj.CRM.model.Schueler;

public class SchuelerDTO {
    public String vorname;
    public String nachname;

    public SchuelerDTO(Schueler schueler) {
        this.vorname = schueler.getVorname();
        this.nachname = schueler.getNachname();
    }


}

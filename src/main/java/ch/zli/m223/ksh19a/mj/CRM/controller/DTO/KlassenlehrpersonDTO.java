package ch.zli.m223.ksh19a.mj.CRM.controller.DTO;

import ch.zli.m223.ksh19a.mj.CRM.model.Klassenlehrperson;


public class KlassenlehrpersonDTO {

    public String vorname;
    public String nachname;
    public Integer alter;
    public String klassenname;

    public KlassenlehrpersonDTO(Klassenlehrperson klassenlehrperson) {
        this.vorname = klassenlehrperson.getVorname();
        this.nachname = klassenlehrperson.getNachname();
        this.alter = klassenlehrperson.getAlter();
        this.klassenname = klassenlehrperson.getKlasse().getName();
    }
}

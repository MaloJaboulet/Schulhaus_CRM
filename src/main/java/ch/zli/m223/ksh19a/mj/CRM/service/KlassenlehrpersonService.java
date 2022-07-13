package ch.zli.m223.ksh19a.mj.CRM.service;


import ch.zli.m223.ksh19a.mj.CRM.model.Klasse;
import ch.zli.m223.ksh19a.mj.CRM.model.Klassenlehrperson;

public interface KlassenlehrpersonService {

    Klassenlehrperson getKlassenlehrperson(Long id);

    Klassenlehrperson insertKlassenlehrperson(String vorname, String nachname, Integer alter, String klasse);

    Long deleteKlassenlehrperson(String vorname, String nachname);
}

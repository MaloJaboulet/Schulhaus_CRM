package ch.zli.m223.ksh19a.mj.CRM.service;

import ch.zli.m223.ksh19a.mj.CRM.model.Klasse;
import ch.zli.m223.ksh19a.mj.CRM.model.Schueler;


import java.util.Date;
import java.util.List;

public interface SchuelerService {

    List<Schueler> getAllSchueler();

    Schueler getSchueler(Long id);

    Schueler insertSchueler(String vorname, String nachname, Date startSchulzeit, Date endeSchulzeit, Klasse klasse);

    Long deleteSchueler(String vorname,String nachname);
}

package ch.zli.m223.ksh19a.mj.CRM.service;

import ch.zli.m223.ksh19a.mj.CRM.model.*;

import java.util.List;

public interface KlassenService {
    List<Klasse> getAllKlassen();

    Klasse getKlasse(Long id);

    Klasse insertKlasse(String name, Schuelhaus schulhaus);

    Long deleteKlasse(String name);

}

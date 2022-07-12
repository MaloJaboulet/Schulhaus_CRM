package ch.zli.m223.ksh19a.mj.CRM.service;

import ch.zli.m223.ksh19a.mj.CRM.model.Klasse;
import ch.zli.m223.ksh19a.mj.CRM.model.Schuelhaus;

import java.util.Date;
import java.util.List;

public interface SchulhausService {


    Schuelhaus getSchulhaus(Long id);

    Schuelhaus insertSchulhaus(String name);

    Long deleteSchulhaus(String name);
}

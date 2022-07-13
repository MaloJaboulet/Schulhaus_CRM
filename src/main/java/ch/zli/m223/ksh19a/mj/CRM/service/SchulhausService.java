package ch.zli.m223.ksh19a.mj.CRM.service;

import ch.zli.m223.ksh19a.mj.CRM.model.Schulhaus;

public interface SchulhausService {


    Schulhaus getSchulhaus(Long id);

    Schulhaus insertSchulhaus(String name);

    Long deleteSchulhaus(String name);


}

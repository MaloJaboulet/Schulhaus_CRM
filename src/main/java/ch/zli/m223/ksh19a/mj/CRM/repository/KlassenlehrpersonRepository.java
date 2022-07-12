package ch.zli.m223.ksh19a.mj.CRM.repository;

import ch.zli.m223.ksh19a.mj.CRM.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KlassenlehrpersonRepository extends JpaRepository<KlassenlehrpersonImpl, Long> {

    default Klassenlehrperson insert(String vorname, String nachname, Integer alter, Klasse klasse) {
        KlasseImpl klasseImp = (KlasseImpl) klasse;

        KlassenlehrpersonImpl klassenlehrperson = new KlassenlehrpersonImpl(vorname,nachname,alter,klasseImp);
        klasseImp.setKlassenlehrperson(klassenlehrperson);
        return save(klassenlehrperson);
    }

    Optional<KlassenlehrpersonImpl> findByVornameAndNachname(String vorname, String nachname);

    Long deleteByVornameAndNachname(String vorname, String nachname);
}

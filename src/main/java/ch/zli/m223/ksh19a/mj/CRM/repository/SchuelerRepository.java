package ch.zli.m223.ksh19a.mj.CRM.repository;


import ch.zli.m223.ksh19a.mj.CRM.model.Klasse;
import ch.zli.m223.ksh19a.mj.CRM.model.KlasseImpl;
import ch.zli.m223.ksh19a.mj.CRM.model.Schueler;
import ch.zli.m223.ksh19a.mj.CRM.model.SchuelerImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface SchuelerRepository extends JpaRepository<SchuelerImpl, Long> {

    default Schueler insert(String vorname, String nachname, Klasse klasse, String password) {
        KlasseImpl klassImpl = (KlasseImpl) klasse;
        //Create new Role
        SchuelerImpl schueler = new SchuelerImpl(vorname,nachname, klassImpl, password);
        //Save Role to DB
        SchuelerImpl schuelerImpl = save(schueler);
        // Update users role list
        klassImpl.addSchuelerZurKlasse(vorname, nachname, password);

        return schuelerImpl;
    }

    Optional<SchuelerImpl> findSchuelerByVornameAndNachname(String vorname, String nachname);

    Long deleteByVornameAndNachname(String vorname, String nachname);



    Optional<SchuelerImpl> findSchuelerByEmail(String email);
}
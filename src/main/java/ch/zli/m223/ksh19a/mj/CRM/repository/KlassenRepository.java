package ch.zli.m223.ksh19a.mj.CRM.repository;

import ch.zli.m223.ksh19a.mj.CRM.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KlassenRepository extends JpaRepository<KlasseImpl, Long> {


    default Klasse insert(String klassenName, Schuelhaus schuelhaus) {
        SchulhausImpl schulhausImpl = (SchulhausImpl) schuelhaus;

        KlasseImpl klasse = new KlasseImpl(klassenName,schulhausImpl);
        return save(klasse);
    }

    Optional<KlasseImpl> findKlasseByName(String name);


    Long deleteByName(String name);
}

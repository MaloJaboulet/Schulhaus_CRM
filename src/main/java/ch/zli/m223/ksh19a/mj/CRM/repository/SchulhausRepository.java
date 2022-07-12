package ch.zli.m223.ksh19a.mj.CRM.repository;

import ch.zli.m223.ksh19a.mj.CRM.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SchulhausRepository extends JpaRepository<SchulhausImpl, Long> {

    default Schuelhaus insert(String name) {
        SchulhausImpl schuelhaus = new SchulhausImpl(name);
        return save(schuelhaus);
    }

    Optional<SchulhausImpl> findSchulhausByName(String name);

    Long deleteByName(String name);
}

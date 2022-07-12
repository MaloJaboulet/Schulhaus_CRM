package ch.zli.m223.ksh19a.mj.CRM.service;

import ch.zli.m223.ksh19a.mj.CRM.exception.InvalidArgumentException;
import ch.zli.m223.ksh19a.mj.CRM.exception.AlreadyExistsException;
import ch.zli.m223.ksh19a.mj.CRM.exception.NotFoundException;
import ch.zli.m223.ksh19a.mj.CRM.model.Klasse;
import ch.zli.m223.ksh19a.mj.CRM.model.Klassenlehrperson;
import ch.zli.m223.ksh19a.mj.CRM.model.Schueler;
import ch.zli.m223.ksh19a.mj.CRM.model.Schuelhaus;
import ch.zli.m223.ksh19a.mj.CRM.repository.KlassenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class KlassenServiceImpl implements KlassenService {

    @Autowired
    private KlassenRepository klassenRepository;

    @Override
    public List<Klasse> getAllKlassen() {
        return new ArrayList<>(klassenRepository.findAll());
    }

    @Override
    public Klasse getKlasse(Long id) {
        return klassenRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Es gibt keine Klasse mit dieser ID.");
        });
    }

    @Override
    public Klasse insertKlasse(String name, Schuelhaus schulhaus) {
        if (name == null || schulhaus == null) {
            throw new InvalidArgumentException("Ein Parameter war null.");
        }
        if (klassenRepository.findKlasseByName(name).isPresent()) {
            throw new AlreadyExistsException("Eine Klasse mit diesem Namen gibt es schon.");
        }

        return klassenRepository.insert(name, schulhaus);
    }

    @Override
    @Transactional
    public Long deleteKlasse(String name) {
        if (name == null) {
            throw new InvalidArgumentException("Der Name darf nicht null sein.");
        }
        if (klassenRepository.findKlasseByName(name).isPresent()) {
            return klassenRepository.deleteByName(name);
        }
        return -1L;
    }


}

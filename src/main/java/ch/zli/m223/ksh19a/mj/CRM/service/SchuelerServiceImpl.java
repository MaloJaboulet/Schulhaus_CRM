package ch.zli.m223.ksh19a.mj.CRM.service;

import ch.zli.m223.ksh19a.mj.CRM.exception.InvalidArgumentException;
import ch.zli.m223.ksh19a.mj.CRM.exception.AlreadyExistsException;
import ch.zli.m223.ksh19a.mj.CRM.exception.NotFoundException;
import ch.zli.m223.ksh19a.mj.CRM.model.Klasse;
import ch.zli.m223.ksh19a.mj.CRM.model.Schueler;
import ch.zli.m223.ksh19a.mj.CRM.repository.KlassenRepository;
import ch.zli.m223.ksh19a.mj.CRM.repository.SchuelerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class SchuelerServiceImpl implements SchuelerService {

    @Autowired
    private SchuelerRepository schuelerRepository;

    @Autowired
    private KlassenRepository klassenRepository;

    @Override
    public List<Schueler> getAllSchueler() {
        return new ArrayList<>(schuelerRepository.findAll());
    }

    @Override
    public Schueler getSchueler(Long id) {
        return schuelerRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Es gibt keinen Schüler mit dieser ID.");
        });
    }

    @Override
    public Schueler insertSchueler(String vorname, String nachname, String klassenName, String password) {
        if (vorname == null || nachname == null || klassenName == null) {
            throw new InvalidArgumentException("Ein Parameter war null");
        }
        if (schuelerRepository.findSchuelerByVornameAndNachname(vorname, nachname).isPresent()) {
            throw new AlreadyExistsException("Der Schüler mit diesem Namen gibt es schon.");
        }
        if(!klassenRepository.findKlasseByName(klassenName).isPresent()){
            throw new NotFoundException("Die Klasse wurde nicht gefunden.");
        }
        Klasse klasse = klassenRepository.findKlasseByName(klassenName).get();

        return schuelerRepository.insert(vorname, nachname, klasse, password);
    }

    @Override
    @Transactional
    public Long deleteSchueler(String vorname, String nachname) {
        if (vorname == null || nachname == null) {
            throw new InvalidArgumentException("Ein Parameter war null");
        }
        if (schuelerRepository.findSchuelerByVornameAndNachname(vorname,nachname).isPresent()) {
            return schuelerRepository.deleteByVornameAndNachname(vorname,nachname);
        }
        return -1L;
    }

    @Override
    public Schueler changeSchueler(Long id, String vorname, String nachname, String klassenName, String password) {
        if (id == null || vorname == null || nachname == null || klassenName == null) {
            throw new InvalidArgumentException("Ein Parameter war null");
        }
        if (schuelerRepository.findById(id).isPresent()) {
            throw new AlreadyExistsException("Der Schüler mit dieser ID gibt es schon.");
        }
        if(!klassenRepository.findKlasseByName(klassenName).isPresent()){
            throw new NotFoundException("Die Klasse wurde nicht gefunden.");
        }
        Klasse klasse = klassenRepository.findKlasseByName(klassenName).get();

        schuelerRepository.deleteById(id);

        return schuelerRepository.insert(vorname, nachname, klasse, password);
    }


}

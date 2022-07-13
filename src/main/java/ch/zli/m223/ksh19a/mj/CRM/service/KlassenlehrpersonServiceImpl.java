package ch.zli.m223.ksh19a.mj.CRM.service;

import ch.zli.m223.ksh19a.mj.CRM.exception.InvalidArgumentException;
import ch.zli.m223.ksh19a.mj.CRM.exception.AlreadyExistsException;
import ch.zli.m223.ksh19a.mj.CRM.exception.NotFoundException;
import ch.zli.m223.ksh19a.mj.CRM.model.Klasse;
import ch.zli.m223.ksh19a.mj.CRM.model.Klassenlehrperson;

import ch.zli.m223.ksh19a.mj.CRM.repository.KlassenRepository;
import ch.zli.m223.ksh19a.mj.CRM.repository.KlassenlehrpersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class KlassenlehrpersonServiceImpl implements KlassenlehrpersonService {

    @Autowired
    private KlassenlehrpersonRepository klassenlehrpersonRepository;
    @Autowired
    private KlassenRepository klassenRepository;


    @Override
    public Klassenlehrperson getKlassenlehrperson(Long id) {
        return klassenlehrpersonRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("There was no user with the id given.");
        });
    }

    @Override
    public Klassenlehrperson insertKlassenlehrperson(String vorname, String nachname, Integer alter, String klassenName) {
        if (vorname == null || nachname == null || alter == null || klassenName == null) {
            throw new InvalidArgumentException("Ein Parameter war null");
        }
        if (klassenlehrpersonRepository.findByVornameAndNachname(vorname,nachname).isPresent()) {
            throw new AlreadyExistsException("Lehrperson mit diesem Namen gibt es schon.");
        }

        if(!klassenRepository.findKlasseByName(klassenName).isPresent()){
            throw new NotFoundException("Die Klasse wurde nicht gefunden.");
        }
        Klasse klasse = klassenRepository.findKlasseByName(klassenName).get();

        return klassenlehrpersonRepository.insert(vorname, nachname, alter, klasse);
    }

    @Override
    @Transactional
    public Long deleteKlassenlehrperson(String vorname, String nachname) {
        if (vorname == null || nachname == null) {
            throw new InvalidArgumentException("Name must no be null");
        }
        if (klassenlehrpersonRepository.findByVornameAndNachname(vorname, nachname).isPresent()) {
            return klassenlehrpersonRepository.deleteByVornameAndNachname(vorname,nachname);
        }
        return -1L;
    }


}

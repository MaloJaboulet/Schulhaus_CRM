package ch.zli.m223.ksh19a.mj.CRM.service;

import ch.zli.m223.ksh19a.mj.CRM.exception.InvalidArgumentException;
import ch.zli.m223.ksh19a.mj.CRM.exception.NotFoundException;
import ch.zli.m223.ksh19a.mj.CRM.exception.AlreadyExistsException;
import ch.zli.m223.ksh19a.mj.CRM.model.Schulhaus;
import ch.zli.m223.ksh19a.mj.CRM.repository.SchulhausRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class SchulhausServiceImpl implements SchulhausService {

    @Autowired
    private SchulhausRepository schulhausRepository;

    @Override
    public Schulhaus getSchulhaus(Long id) {
        return schulhausRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Es git kein Schulhaus mit dieser ID.");
        });
    }

    @Override
    public Schulhaus insertSchulhaus(String name) {
        if (name == null) {
            throw new InvalidArgumentException("Name darf nicht null sein.");
        }
        if (schulhausRepository.findSchulhausByName(name).isPresent()) {
            throw new AlreadyExistsException("Schlhaus mit " + name + " gibt es schon.");
        }

        return schulhausRepository.insert(name);
    }



    @Override
    @Transactional
    public Long deleteSchulhaus(String name) {
        if (name == null) {
            throw new InvalidArgumentException("Name darf nicht null sein.");
        }
        if (schulhausRepository.findSchulhausByName(name).isPresent()) {
            return schulhausRepository.deleteByName(name);
        }
        return -1L;
    }


}

package ch.zli.m223.ksh19a.mj.CRM.init;

import ch.zli.m223.ksh19a.mj.CRM.model.Klasse;
import ch.zli.m223.ksh19a.mj.CRM.model.Klassenlehrperson;
import ch.zli.m223.ksh19a.mj.CRM.model.Schulhaus;
import ch.zli.m223.ksh19a.mj.CRM.repository.KlassenlehrpersonRepository;
import ch.zli.m223.ksh19a.mj.CRM.repository.SchuelerRepository;
import ch.zli.m223.ksh19a.mj.CRM.repository.KlassenRepository;
import ch.zli.m223.ksh19a.mj.CRM.repository.SchulhausRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class ServerInitializer implements ApplicationRunner {

    @Autowired
    private KlassenRepository klassenRepository;
    @Autowired
    private SchuelerRepository schuelerRepository;

    @Autowired
    private SchulhausRepository schulhausRepository;

    @Autowired
    private KlassenlehrpersonRepository klassenlehrpersonRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        Schulhaus schulhaus = schulhausRepository.insert("KSH");

        Klasse klasse = klassenRepository.insert("I3a",schulhaus);

        Klassenlehrperson klassenlehrperson = klassenlehrpersonRepository.insert("Hans","Peter",35,klasse);

        klasse.setKlassenlehrperson(klassenlehrperson);

        schuelerRepository.insert("Aartin", "Düppi",klasse, "123");
        schuelerRepository.insert("Arbias", "Imeri",klasse, "123");
        schuelerRepository.insert("Luigi", "Spina",klasse, "123");
        schuelerRepository.insert("Malo", "Jaboulet",klasse, "123");
        schuelerRepository.insert("Yannis", "Lee",klasse, "123");

    }
}

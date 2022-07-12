package ch.zli.m223.ksh19a.mj.CRM.init;

import ch.zli.m223.ksh19a.mj.CRM.model.Klasse;
import ch.zli.m223.ksh19a.mj.CRM.model.Klassenlehrperson;
import ch.zli.m223.ksh19a.mj.CRM.model.Schueler;
import ch.zli.m223.ksh19a.mj.CRM.model.Schuelhaus;
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
        Schuelhaus schulhaus = schulhausRepository.insert("KSH");

        Klasse klasse = klassenRepository.insert("I3a",schulhaus);

        Klassenlehrperson klassenlehrperson = klassenlehrpersonRepository.insert("Hans","Peter",35,klasse);

        schuelerRepository.insert("Martin", "Düppi",klasse);
        schuelerRepository.insert("Arbias", "Imeri",klasse);
        schuelerRepository.insert("Luigi", "Spina",klasse);
        schuelerRepository.insert("Malo", "Jaboulet",klasse);
        schuelerRepository.insert("Yannis", "Lee",klasse);

    }
}

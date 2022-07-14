package ch.zli.m223.ksh19a.mj.CRM.controller;

import java.util.List;
import java.util.stream.Collectors;

import ch.zli.m223.ksh19a.mj.CRM.controller.DTO.KlasseDTO;
import ch.zli.m223.ksh19a.mj.CRM.controller.DTO.Input.KlassenInputDTO;
import ch.zli.m223.ksh19a.mj.CRM.controller.DTO.SchuelerDTO;
import ch.zli.m223.ksh19a.mj.CRM.controller.DTO.Input.SchuelerInputDTO;
import ch.zli.m223.ksh19a.mj.CRM.model.Klasse;
import ch.zli.m223.ksh19a.mj.CRM.service.KlassenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class KlassenRestController {
    @Autowired
    private KlassenService klassenService;

    @GetMapping("/klassen")
    public List<KlasseDTO> getAllKlassen() {
        return klassenService.getAllKlassen().stream()
                .map(klasse -> new KlasseDTO(klasse))
                .collect(Collectors.toList());
    }

    @GetMapping("/klassen/{id}")
    public KlasseDTO getKlasse(@PathVariable("id") Long id) {
        return new KlasseDTO(klassenService.getKlasse(id));
    }

    @PostMapping("/klassen")
    public KlasseDTO insertKlasse(@RequestBody KlassenInputDTO klassenData) {
        return new KlasseDTO(klassenService.insertKlasse(klassenData.name, klassenData.schulhaus));
    }

   @DeleteMapping("/klassen/{name}")
    public Long deleteKlasse(@PathVariable("name") String name) {
        return klassenService.deleteKlasse(name);
    }


   @GetMapping("/klassen/{id}/schueler")
    public List<SchuelerDTO> getSchuelerFromKlasse(@PathVariable("id") Long id) {
        Klasse klasse = klassenService.getKlasse(id);
        return klasse.getSchueler().stream()
                .map(schueler -> new SchuelerDTO(schueler))
                .collect(Collectors.toList());
    }

    @PostMapping("/klassen/{id}")
    public KlasseDTO insertSchueler(@PathVariable("id") Long id, @RequestBody SchuelerInputDTO schuelerData){
        Klasse klasse = klassenService.getKlasse(id);
        klasse.addSchuelerZurKlasse(schuelerData.vorname,schuelerData.nachname, schuelerData.password);
        return new KlasseDTO(klasse);
    }
}

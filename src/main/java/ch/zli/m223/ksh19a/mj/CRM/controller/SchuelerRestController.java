package ch.zli.m223.ksh19a.mj.CRM.controller;

import ch.zli.m223.ksh19a.mj.CRM.controller.DTO.KlasseDTO;
import ch.zli.m223.ksh19a.mj.CRM.controller.DTO.KlassenInputDTO;
import ch.zli.m223.ksh19a.mj.CRM.controller.DTO.SchuelerDTO;
import ch.zli.m223.ksh19a.mj.CRM.controller.DTO.SchuelerInputDTO;
import ch.zli.m223.ksh19a.mj.CRM.model.Klasse;
import ch.zli.m223.ksh19a.mj.CRM.service.SchuelerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class SchuelerRestController {

    @Autowired
    private SchuelerService schuelerService;

    @GetMapping("/schueler")
    public List<SchuelerDTO> getAllSchueler() {
        return schuelerService.getAllSchueler().stream()
                .map(schueler -> new SchuelerDTO(schueler))
                .collect(Collectors.toList());
    }

    @GetMapping("/schueler/{id}")
    public SchuelerDTO getSchueler(@PathVariable("id") Long id) {
        return new SchuelerDTO(schuelerService.getSchueler(id));
    }

    @PostMapping("/schueler")
    public SchuelerDTO insertSchueler(@RequestBody SchuelerInputDTO schuelerData) {
        return new SchuelerDTO(schuelerService.insertSchueler(schuelerData.vorname, schuelerData.nachname, schuelerData.klasse));
    }

    @DeleteMapping("/schueler/{vorname}/{nachname}")
    public Long deleteSchueler(@PathVariable("vorname") String vorname,@PathVariable("nachname") String nachname) {
        return schuelerService.deleteSchueler(vorname,nachname);
    }
}

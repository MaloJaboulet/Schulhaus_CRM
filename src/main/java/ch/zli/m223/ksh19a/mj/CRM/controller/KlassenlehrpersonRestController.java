package ch.zli.m223.ksh19a.mj.CRM.controller;

import ch.zli.m223.ksh19a.mj.CRM.controller.DTO.Input.KlassenlehrpersonInputDTO;
import ch.zli.m223.ksh19a.mj.CRM.controller.DTO.KlassenlehrpersonDTO;
import ch.zli.m223.ksh19a.mj.CRM.service.KlassenlehrpersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class KlassenlehrpersonRestController {

    @Autowired
    private KlassenlehrpersonService klassenlehrpersonService;

    @GetMapping("/klassenlehrperson/{id}")
    public KlassenlehrpersonDTO getKlassenlehrperson(@PathVariable("id") Long id) {
        return new KlassenlehrpersonDTO(klassenlehrpersonService.getKlassenlehrperson(id));
    }

    @PostMapping("/klassenlehrperson")
    public KlassenlehrpersonDTO insertKlassenlehrperson(@RequestBody KlassenlehrpersonInputDTO klassenlehrpersonInputDTO) {
        return new KlassenlehrpersonDTO(klassenlehrpersonService
                .insertKlassenlehrperson(klassenlehrpersonInputDTO.vorname,
                        klassenlehrpersonInputDTO.nachname,
                        klassenlehrpersonInputDTO.alter,
                        klassenlehrpersonInputDTO.klasse));
    }

    @DeleteMapping("/klassenlehrperson/{vorname}/{nachname}")
    public Long deleteKlassenlehrperson(@PathVariable("vorname") String vorname, @PathVariable("nachname") String nachname) {
        return klassenlehrpersonService.deleteKlassenlehrperson(vorname,nachname);
    }

}

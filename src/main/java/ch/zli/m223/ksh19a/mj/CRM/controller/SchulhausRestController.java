package ch.zli.m223.ksh19a.mj.CRM.controller;

import ch.zli.m223.ksh19a.mj.CRM.controller.DTO.Input.SchulhausInputDTO;
import ch.zli.m223.ksh19a.mj.CRM.controller.DTO.SchulhausDTO;
import ch.zli.m223.ksh19a.mj.CRM.service.SchulhausService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class SchulhausRestController {

    @Autowired
    private SchulhausService schulhausService;


    @GetMapping("/schulhaus/{id}")
    public SchulhausDTO getSchulhaus(@PathVariable("id") Long id) {
        return new SchulhausDTO(schulhausService.getSchulhaus(id));
    }

    @PostMapping("/schulhaus")
    public SchulhausDTO insertSchule(@RequestBody SchulhausInputDTO schulhausInputDTO) {
        return new SchulhausDTO(schulhausService.insertSchulhaus(schulhausInputDTO.name));
    }

    @DeleteMapping("/schulhaus/{name}")
    public Long deleteSchule(@PathVariable("name") String name) {
        return schulhausService.deleteSchulhaus(name);
    }
}

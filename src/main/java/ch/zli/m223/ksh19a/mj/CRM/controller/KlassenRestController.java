package ch.zli.m223.ksh19a.mj.CRM.controller;

import java.util.List;
import java.util.stream.Collectors;

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

   /* @GetMapping("/users/{id}")
    public UserDTO getUser(@PathVariable("id") Long id) {
        return new UserDTO(klassenService.getUser(id));
    }

    @PostMapping("/users")
    public UserDTO insertUser(@RequestBody UserInputDTO userData) {
        return new UserDTO(klassenService.insertUser(userData.name));
    }

    @DeleteMapping("/users/{name}")
    public Long deleteUser(@PathVariable("name") String name) {
        return klassenService.deleteUser(name);
    }


    @GetMapping("/users/{id}/roles")
    public List<RoleDTO> getRolesFromUser(@PathVariable("id") Long id) {
        Klasse klasse = klassenService.getUser(id);
        return klasse.getRoles().stream()
                .map(role -> new RoleDTO(role))
                .collect(Collectors.toList());
    }
*/

}

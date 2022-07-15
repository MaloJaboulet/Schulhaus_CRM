package ch.zli.m223.ksh19a.mj.CRM.controller;

import ch.zli.m223.ksh19a.mj.CRM.model.Klasse;
import ch.zli.m223.ksh19a.mj.CRM.model.Schueler;
import ch.zli.m223.ksh19a.mj.CRM.service.KlassenService;
import ch.zli.m223.ksh19a.mj.CRM.service.SchuelerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SchuelerWebController {

    @Autowired
    private SchuelerService schuelerService;
    @Autowired
    private KlassenService klassenService;

    @GetMapping("/schueler")
    String getSchuelerList(Model model) {
        List<Schueler> schulerList = schuelerService.getAllSchueler();
        model.addAttribute("schuelerList", schulerList);

        return "schueler";
    }

    @GetMapping("/schuelerEdit")
    String getUserList(Model model) {
        List<Schueler> schulerList = schuelerService.getAllSchueler();
        //model.addAttribute("schuelerList", schulerList);

        return "schuelerEdit";
    }

    @PostMapping("/schueler")
    public String insertSchueler(Model model,
                                 @RequestParam("vorname") String vorname,
                                 @RequestParam("nachname") String nachname,
                                 @RequestParam("klasse") String klassenName,
                                 @RequestParam("password") String password) {

        if (klassenService.getAllKlassen().stream()
                .anyMatch((Klasse klasse) -> {
                    return klasse.getName().equals(klassenName);
                })) {
            Schueler schueler = schuelerService.insertSchueler(vorname, nachname, klassenName, password);
        }

        model.addAttribute("schuelerList", schuelerService.getAllSchueler());
        return "redirect:/schueler";
    }

    @GetMapping("/schuelerDelete/{vorname}/{nachname}")
    public String deleteSchueler(Model model,
                                 @PathVariable("vorname") String vorname, @PathVariable("nachname") String nachname) {
        schuelerService.deleteSchueler(vorname, nachname);
        model.addAttribute("schuelerList", schuelerService.getAllSchueler());
        return "redirect:/schueler";
    }


    @GetMapping("/admin")
    String getToAdminPage() {
        return "admin_page";
    }

   /* @GetMapping("/schueler")
    String getToUserPage() {
        return "schueler_page";
    }*/


    @GetMapping("/login")
    String getToLoginPage() {
        return "login_page";
    }

}

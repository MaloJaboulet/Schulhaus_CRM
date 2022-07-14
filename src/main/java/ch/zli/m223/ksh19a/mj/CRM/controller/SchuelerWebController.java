package ch.zli.m223.ksh19a.mj.CRM.controller;

import ch.zli.m223.ksh19a.mj.CRM.controller.DTO.SchuelerDTO;
import ch.zli.m223.ksh19a.mj.CRM.model.Schueler;
import ch.zli.m223.ksh19a.mj.CRM.service.KlassenService;
import ch.zli.m223.ksh19a.mj.CRM.service.SchuelerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SchuelerWebController {

    @Autowired
    private SchuelerService schuelerService;

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
                                 @RequestParam("klasse") String klasse,
                                 @RequestParam("password") String password) {
        Schueler schueler = schuelerService.insertSchueler(vorname, nachname, klasse, password);
       model.addAttribute("schuelerList", schuelerService.getAllSchueler());
       return "schueler";
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

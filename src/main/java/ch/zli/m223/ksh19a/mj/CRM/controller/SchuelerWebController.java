package ch.zli.m223.ksh19a.mj.CRM.controller;

import ch.zli.m223.ksh19a.mj.CRM.service.SchuelerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SchuelerWebController {

    @Autowired
    private SchuelerService schuelerService;

    /*@GetMapping("/userlist")
    String getUserList(Model model) {
        List<Klasse> userList = klassenService.getAllUsers();
        model.addAttribute("users", userList);

        return "userList";
    }*/

    @GetMapping("/admin")
    String getToAdminPage() {
        return "admin_page";
    }

    @GetMapping("/schueler")
    String getToUserPage() {
        return "schueler_page";
    }


    @GetMapping("/login")
    String getToLoginPage() {
        return "login_page";
    }

}

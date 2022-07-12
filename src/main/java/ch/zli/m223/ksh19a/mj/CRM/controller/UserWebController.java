package ch.zli.m223.ksh19a.mj.CRM.controller;

import ch.zli.m223.ksh19a.mj.CRM.model.Klasse;
import ch.zli.m223.ksh19a.mj.CRM.service.KlassenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserWebController {

    @Autowired
    private KlassenService klassenService;

    /*@GetMapping("/userlist")
    String getUserList(Model model) {
        List<Klasse> userList = klassenService.getAllUsers();
        model.addAttribute("users", userList);

        return "userList";
    }*/

}

package cm.belrose.springboottests.controllers;

import cm.belrose.springboottests.entities.Employe;
import cm.belrose.springboottests.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeController {

    @Autowired
    private EmployeService employeService;

    @GetMapping("/employes")
    public List<Employe> getAllEmployees() {
        return employeService.findAllEmploye();
    }
}

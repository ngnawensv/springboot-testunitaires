package cm.belrose.springboottests.services;

import cm.belrose.springboottests.entities.Employe;

import java.util.List;

public interface EmployeService {
    Employe findByFirstName(String username);

    List<Employe> findAllEmploye();
}

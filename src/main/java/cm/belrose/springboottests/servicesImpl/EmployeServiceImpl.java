package cm.belrose.springboottests.servicesImpl;

import cm.belrose.springboottests.dao.EmployeDao;
import cm.belrose.springboottests.entities.Employe;
import cm.belrose.springboottests.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeServiceImpl implements EmployeService {
    @Autowired
    private EmployeDao employeDao;

    public EmployeServiceImpl() {
    }

    @Override
    public Employe findByFirstName(String username) {
        return employeDao.findByFirstName(username);
    }

    @Override
    public List<Employe> findAllEmploye() {
        return employeDao.findAll();
    }
}

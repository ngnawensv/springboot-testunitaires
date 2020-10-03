package cm.belrose.springboottests.dao;

import cm.belrose.springboottests.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeDao extends JpaRepository<Employe,Long> {
    Employe findByFirstName(String username);
}

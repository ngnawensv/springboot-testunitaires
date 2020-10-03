package cm.belrose.springboottests.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import cm.belrose.springboottests.entities.Employe;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Ngnawen Samuel
 * @RunWith(SpringRunner.class): this annotation help us to links the Spring implementation of JUnit
 * @DataJpaTest: this annotation permit us  to test the Spring beans, which which communicates relational databases
 * @AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE): This annotation help us to do the test on registred
 * database instead of in-memory database
 */

@RunWith(SpringRunner.class)
@DataJpaTest
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class EmployeDaoTest {

    @Autowired
    private EmployeDao employeDao;

    @Test
    public void testSaveEmploye() {
        Employe employeNew = new Employe("admin", "admin", "admin@gmail.com");
        employeDao.save(employeNew);
        Employe employeDB = employeDao.findByFirstName("admin");
        assertNotNull(employeNew);
        assertEquals(employeDB.getFirstName(), employeNew.getFirstName());
        assertEquals(employeDB.getLastName(), employeNew.getLastName());
    }

    @Test
    public void testGetEmploye() {
        Employe employeNew = new Employe("admin", "admin", "admin@gmail.com");
        employeDao.save(employeNew);
        Employe employeDB = employeDao.findByFirstName("admin");
        assertNotNull(employeNew);
        assertEquals(employeDB.getFirstName(), employeNew.getFirstName());
        assertEquals(employeDB.getLastName(), employeNew.getLastName());
    }

    @Test
    public void testFindAllEmploye() {
        Employe employeNew = new Employe("admin", "admin", "admin@gmail.com");
        employeDao.save(employeNew);
        assertNotNull(employeDao.findAll());
    }

    @Test
    public void testDeleteEmploye(){
        Employe employeNew = new Employe("admin", "admin", "admin@gmail.com");
        employeDao.save(employeNew);
        employeDao.delete(employeNew);
    }


}

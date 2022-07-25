package cm.belrose.springboottests.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import cm.belrose.springboottests.entities.Employe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Ngnawen Samuel
 * @RunWith(SpringRunner.class): this annotation provides a bridge between Spring Boot test features and JUnit
 *
 * @DataJpaTest: this annotation provides some standard setup needed for testing the persistence layer:
 * -configuring H2, an in-memory database
 * -setting Hibernate, Spring Data, and the DataSource
 * -performing an @EntityScan
 * -turning on SQL logging

 * @AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE): This annotation help us to do the test on registred
 * database instead of in-memory database
 */

@RunWith(SpringRunner.class)
@DataJpaTest
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class EmployeDaoTest {

    private static final Logger log= LoggerFactory.getLogger(EmployeDaoTest.class);
    /*
    To carry out DB operations, we need some records already in our database. To setup this data, we can use TestEntityManager.
    The Spring Boot TestEntityManager is an alternative to the standard JPA EntityManager that provides methods commonly used when writing tests
    */
    @Autowired
    private TestEntityManager entityManager; // help us to insert an Employe in the DB and reading it via the find by name

    @Autowired
    private EmployeDao employeDao;

    // given
    Employe employeGive = new Employe("alex");
    Employe employeNew = new Employe("admin", "admin", "admin@gmail.com");

    @Before
    public void setup(){
        entityManager.persist(employeGive);//on sauvegarde l'objet user au début de chaque test
        entityManager.flush();
    }

    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        //Employe alex = new Employe("alex");
        //entityManager.persist(alex);
        //entityManager.flush();
        // when
        Employe employeFound = employeDao.findByFirstName(employeGive.getFirstName());
        // then
        assertEquals(employeGive.getFirstName(),employeFound.getFirstName());
        log.info("success Test");
    }

    @Test
    public void testSaveEmploye() {
        employeDao.save(employeNew);
        Employe employeDB = employeDao.findByFirstName("admin");
        //J'attends que employeNew soit non null
        assertNotNull(employeNew);
        //J'attends que employeDB.getFirstName() soit egal à employeNew.getFirstName() ou bien
        //J'exige que employeDB.getFirstName() retuourne  employeNew.getFirstName()
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

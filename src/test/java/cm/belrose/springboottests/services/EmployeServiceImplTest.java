package cm.belrose.springboottests.services;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import cm.belrose.springboottests.dao.EmployeDao;
import cm.belrose.springboottests.entities.Employe;

import cm.belrose.springboottests.servicesImpl.EmployeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class EmployeServiceImplTest {

    /**
     * with this method, we create an instance of Service class and available as a @Bean
     */
    @TestConfiguration
    static class EmployeServiceImplContextConfiguration{
        @Bean
        public EmployeService employeService(){
            return new EmployeServiceImpl();
        }
    }

    /**
     * Inject the bean create above in test class (EmployeServiceImplTest)
     */
    @Autowired
    private EmployeService employeService;
    /**
     * @MockBean : Help us to create the mock (factice objet) pour contourner l'appel reel de EmployeDao
     */
    @MockBean
    private EmployeDao employeDao;

    @Before
    public void setUp() {
        Employe alex = new Employe("alex");
        Mockito.when(employeDao.findByFirstName(alex.getFirstName())).thenReturn(alex);
    }

    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        String name = "alex";
        Employe found = employeService.findByFirstName(name);

        assertEquals(found.getFirstName(),name);
    }
}

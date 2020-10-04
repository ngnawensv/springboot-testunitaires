package cm.belrose.springboottests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.io.IOException;
import java.util.List;

import cm.belrose.springboottests.controllers.EmployeController;
import cm.belrose.springboottests.dao.EmployeDao;
import cm.belrose.springboottests.entities.Employe;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;



@RunWith(SpringRunner.class)
//@SpringBootTes create the ApplicationContext that will be utilized in our tests
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,classes = {SpringbootTestsApplication.class, EmployeController.class})
@AutoConfigureMockMvc
//@TestPropertySource helps us to configure the locations of properties files specific to our tests
@TestPropertySource(locations = "classpath:application-test.properties")
public class SpringbootTestsApplicationTests {
    /*@Test
    public void contextLoads() {
    }

    @Test
    public void givenEmployes_whenGetEmployes_thenStatus200() throws Exception {

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private EmployeDao repository;

        createTestEmployee("bob");

        mockMvc.perform(get("/api/employes")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", is("bob")));
    }

    private void createTestEmployee(String name) {
        Employe emp = new Employe(name);
        repository.save(emp);
    }*/
}

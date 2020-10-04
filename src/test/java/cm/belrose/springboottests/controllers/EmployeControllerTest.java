package cm.belrose.springboottests.controllers;

import cm.belrose.springboottests.entities.Employe;
import cm.belrose.springboottests.services.EmployeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
//pour les méthodes HTTP
//import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//pour JSON
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//pour HTTP status
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = EmployeController.class) //auto-configures MockMvc
public class EmployeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmployeService employeService;

    @Test
    public void givenEmployees_whenGetEmployees_thenReturnJsonArray() throws Exception {

        Employe alex = new Employe("alex");

        List<Employe> allEmployes = Arrays.asList(alex);

        given(employeService.findAllEmploye()).willReturn(allEmployes);

        mockMvc.perform(get("/api/employes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].firstName", is(alex.getFirstName())));
    }
}

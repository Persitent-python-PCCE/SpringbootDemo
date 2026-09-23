package com.revature.demoapp;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCreateEmployee() throws Exception{
        String employeeJson = """
            {
                  "name":"arul",
                    "email":"guru@qwe.com",
                    "role":"HR",
                    "dept":{
                        "id":1
                    }
            }
            """;

        mockMvc.perform(
                post("/employees").contentType(MediaType.APPLICATION_JSON).content(employeeJson)
        ).andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("arul"))
                .andExpect(jsonPath("$.role").value("HR"));

    }

   @Test
    void testGetAllEmployees() throws Exception{
        mockMvc.perform(
                get("/employees")
        ).andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
   }

}

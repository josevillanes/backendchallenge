package com.entelgy.backendchallenge.controller;

import com.entelgy.backendchallenge.service.RefactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@EnableFeignClients
class RefactControllerTest {

    public MockMvc mockMvc;

    @Autowired
    public RefactController refactController;

    @Autowired
    public RefactService refactService;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(refactController).build();
    }

    @Test
    void testRefactor() throws Exception {

        mockMvc.perform(post("/posts")).
                andExpect(status().isOk()).
                andExpect(content().contentType("application/json")).

                //Se verifica el nro de items del resultado
                andExpect(jsonPath("$", hasSize(500))).

                //Se verifica que existan los atritubos considerados en la reconstrucción
                andExpect(jsonPath("$[0].postId").exists()).
                andExpect(jsonPath("$[0].id").exists()).
                andExpect(jsonPath("$[0].email").exists()).

                //Se verifica que no existan los atritubos iniciales reconstruidos
                andExpect(jsonPath("$[0].name").doesNotExist()).
                andExpect(jsonPath("$[0].body").doesNotExist()).

                //Se verifica los valores del 1er item del resultado
                andExpect(jsonPath("$[0].postId", is(1))).
                andExpect(jsonPath("$[0].id", is(1))).
                andExpect(jsonPath("$[0].email", is("Eliseo@gardner.biz")));

    }


}
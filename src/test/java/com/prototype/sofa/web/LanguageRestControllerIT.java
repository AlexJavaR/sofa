package com.prototype.sofa.web;

import com.prototype.sofa.model.Language;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.annotation.PostConstruct;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by AlexMeleh on 13.08.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LanguageRestControllerIT {
    private TestRestTemplate testRestTemplate = new TestRestTemplate();

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @PostConstruct
    private void postConstruct() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }


    @Test
    public void getAll() throws Exception {
//        ResponseEntity<List<Language>> listResponseEntity = testRestTemplate.exchange("http://localhost:8082/language/all", HttpMethod.GET, null,
//                new ParameterizedTypeReference<List<Language>>() {
//                });
//        List<Language> languagesList = listResponseEntity.getBody();
        mockMvc.perform(get("http://localhost:8082/language/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
        //List<Language> languagesList = languageRestController.getAll();
        //when(languageService.findAll()).thenReturn(languagesList);
        //verify(languageService).findAll();
    }
}
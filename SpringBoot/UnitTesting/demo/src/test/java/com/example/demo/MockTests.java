package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.controllers.PetController;
import com.example.demo.models.Pet;
import com.example.demo.repositories.PetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
@SpringBootTest(webEnvironment = WebEnvironment.MOCK,
                classes = DemoApplication.class)
public class MockTests {
    
    @MockBean
    PetRepository repository;

    @InjectMocks
    @Autowired
    PetController controller;

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void mockRepositoryTest() throws Exception{
        log.info("Testing mock repository insert...");

        Pet pet = new Pet();
        pet.setAge(5);
        pet.setColor("Black");
        pet.setName("OGA");
        pet.setSpecies("Bird");
        pet.setTag("1234");

        given(repository.save(any())).willReturn(pet);
        String body = mapper.writeValueAsString(pet);

        String result = mvc.perform(post("/pets").contentType("application/json").content(body))
                           .andExpect(status().isOk())
                           .andExpect(content().contentTypeCompatibleWith("application/json"))
                           .andDo(print())
                           .andExpect(jsonPath("$.name", is("OGA")))
                           .andReturn().getResponse().getContentAsString();
        
        Mockito.verify(repository).save(any());
    }

    @Test
    public void mockRepositoryFindByIdTest() throws Exception{
        log.info("Testing mock repository find by id...");

        Pet pet = new Pet();
        pet.setAge(5);
        pet.setColor("Black");
        pet.setName("OGA");
        pet.setSpecies("Bird");
        pet.setTag("1234");

        given(repository.findById(1L)).willReturn(Optional.of(pet));

        String body = mapper.writeValueAsString(pet);

        String result = mvc.perform(get("/pets/1").contentType("application/json").content(""))
                        .andExpect(status().isOk())
                        .andExpect(content().contentTypeCompatibleWith("application/json"))
                        .andDo(print())
                        .andExpect(jsonPath("$.name", is("OGA")))
                .andReturn().getResponse().getContentAsString();
         
        Mockito.verify(repository).findById(any());
    }
}

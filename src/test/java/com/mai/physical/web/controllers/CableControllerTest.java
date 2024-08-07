package com.mai.physical.web.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mai.physical.model.CableDto;
import com.mai.physical.services.CableService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CableController.class)
@AutoConfigureRestDocs
@ExtendWith(RestDocumentationExtension.class)
class CableControllerTest
{

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    CableService cableService;

    CableDto validCableDto;

    @BeforeEach
    public void setUp() throws Exception
    {
        validCableDto = CableDto.builder()
                .status("ACTIVE")
                .name("Cable1")
                .type("PAIR").build();
    }

    @Test
    void getCableById()
    {
    }

    @Test
    void getCables() throws JsonProcessingException
    {
        System.out.println(objectMapper.writeValueAsString(validCableDto));

    }

    @Test
    void testGetCableById()
    {
    }
}
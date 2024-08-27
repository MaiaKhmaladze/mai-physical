package com.mai.physical.web.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mai.physical.domain.CableConstants;
import com.mai.physical.domain.PairConstants;
import com.mai.physical.model.PairBindingDto;
import com.mai.physical.model.PairDto;
import com.mai.physical.services.PairService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PairController.class)
@AutoConfigureRestDocs
@ExtendWith(RestDocumentationExtension.class)
class PairControllerTest
{

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    PairService pairService;

    PairDto validPairDto;

    @BeforeEach
    public void setUp() throws Exception
    {
        PairBindingDto validCableBinding = PairBindingDto.builder()
                .bindingName(PairConstants.BINDING_PAIR_TO_CABLE)
                .targetId(1L)
                .targetType(CableConstants.CABLE_OBJECT_NAME).build();
        validPairDto = PairDto.builder()
                .status("ACTIVE")
                .name("Pair1")
                .color("RED")
                .type("PAIR").build();
    }

    @Test
    void getPairById()
    {
    }

    @Test
    void getPairs() throws JsonProcessingException
    {
        System.out.println(objectMapper.writeValueAsString(validPairDto));

    }

    @Test
    void testGetPairById()
    {
    }
}
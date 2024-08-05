package com.mai.physical.web.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mai.physical.model.SiteDto;
import com.mai.physical.services.SiteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
@WebMvcTest(SiteController.class)
@AutoConfigureRestDocs
@ExtendWith(RestDocumentationExtension.class)
class SiteControllerTest
{

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    SiteService siteService;

    SiteDto validSiteDto;

    @BeforeEach
    public void setUp() throws Exception
    {
        validSiteDto = SiteDto.builder().status("ACTIVE").name("SITE1").type("BTS").build();
    }

    @Test
    void getSiteById()
    {
    }

    @Test
    void getSites() throws JsonProcessingException
    {
        System.out.println(objectMapper.writeValueAsString(validSiteDto));

    }

    @Test
    void testGetSiteById()
    {
    }
}
package com.mai.physical.web.controllers;

import com.mai.physical.model.SitePagedList;
import com.mai.physical.services.SiteService;
import com.mai.physical.model.SiteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/site")
public class SiteController
{
    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

    @Autowired
    SiteService siteService;

    @GetMapping("/{siteId}")
    SiteDto getSiteById(@PathVariable("siteId") Long id){

        return siteService.getSiteById(id);
    }

    @GetMapping(produces = { "application/json" })
    ResponseEntity<SitePagedList> getSites(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                           @RequestParam(value = "pageSize", required = false) Integer pageSize)
    {
        if (pageNumber == null || pageNumber < 0){
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        SitePagedList siteList = siteService.findSites(null, PageRequest.of(pageNumber, pageSize));

        return new ResponseEntity<>(siteList, HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity createSite(@RequestBody @Validated SiteDto siteDto){

        return new ResponseEntity<>(siteService.createSite(siteDto), HttpStatus.CREATED);
    }

    @PutMapping("{siteId}")
    ResponseEntity updateSiteById(@PathVariable("siteId") Long siteId, @RequestBody @Validated SiteDto siteDto){
        return new ResponseEntity<>(siteService.updateSite(siteId, siteDto), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{siteId}")
    void deleteSite(@PathVariable("siteId") Long siteId){

        siteService.deleteSite(siteId);
    }
}

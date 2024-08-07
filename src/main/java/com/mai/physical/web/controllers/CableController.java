package com.mai.physical.web.controllers;

import com.mai.physical.model.CableDto;
import com.mai.physical.model.CablePagedList;
import com.mai.physical.services.CableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cable")
public class CableController
{
    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

    @Autowired
    CableService cableService;

    @GetMapping("/{cableId}")
    CableDto getCableById(@PathVariable("cableId") Long id){

        return cableService.getCableById(id);
    }

    @GetMapping(produces = { "application/json" })
    ResponseEntity<CablePagedList> getCables(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                           @RequestParam(value = "pageSize", required = false) Integer pageSize)
    {
        if (pageNumber == null || pageNumber < 0){
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        CablePagedList cableList = cableService.findCables(null, PageRequest.of(pageNumber, pageSize));

        return new ResponseEntity<>(cableList, HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity createCable(@RequestBody @Validated CableDto cableDto){

        return new ResponseEntity<>(cableService.createCable(cableDto), HttpStatus.CREATED);
    }

    @PutMapping("{cableId}")
    ResponseEntity updateCableById(@PathVariable("cableId") Long cableId, @RequestBody @Validated CableDto cableDto){
        return new ResponseEntity<>(cableService.updateCable(cableId, cableDto), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{cableId}")
    void deleteCable(@PathVariable("cableId") Long cableId){

        cableService.deleteCable(cableId);
    }
}

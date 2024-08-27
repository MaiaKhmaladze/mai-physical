package com.mai.physical.web.controllers;

import com.mai.physical.model.PairDto;
import com.mai.physical.model.PairPagedList;
import com.mai.physical.services.PairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pair")
public class PairController
{
    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

    @Autowired
    PairService pairService;

    @GetMapping("/{pairId}")
    PairDto getPairById(@PathVariable("pairId") Long id){

        return pairService.getPairById(id);
    }

    @GetMapping(produces = { "application/json" })
    ResponseEntity<PairPagedList> getPairs(@RequestParam(value = "pageNumber", required = false) Integer pageNumber,
                                           @RequestParam(value = "pageSize", required = false) Integer pageSize)
    {
        if (pageNumber == null || pageNumber < 0){
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        PairPagedList pairList = pairService.findPairs(null, PageRequest.of(pageNumber, pageSize));

        return new ResponseEntity<>(pairList, HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity createPair(@RequestBody @Validated PairDto pairDto){

        return new ResponseEntity<>(pairService.createPair(pairDto), HttpStatus.CREATED);
    }

    @PutMapping("{pairId}")
    ResponseEntity updatePairById(@PathVariable("pairId") Long pairId, @RequestBody @Validated PairDto pairDto){
        return new ResponseEntity<>(pairService.updatePair(pairId, pairDto), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{pairId}")
    void deletePair(@PathVariable("pairId") Long pairId){

        pairService.deletePair(pairId);
    }
}

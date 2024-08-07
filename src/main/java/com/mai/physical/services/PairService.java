package com.mai.physical.services;

import com.mai.physical.model.PairDto;
import com.mai.physical.model.PairPagedList;
import com.mai.sdk.QueryParam;
import org.springframework.data.domain.PageRequest;

import java.util.Set;

public interface PairService
{
    PairDto getPairById(Long id);
    PairPagedList findPairs( QueryParam[] params, PageRequest pageRequest);

    PairPagedList findPairsByIds( Set<Long> ids);

    PairDto createPair(PairDto pairDto);

    PairDto updatePair(Long id, PairDto pairDto);

    void deletePair(Long id);
}

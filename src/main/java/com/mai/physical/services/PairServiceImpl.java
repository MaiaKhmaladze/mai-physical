package com.mai.physical.services;

import com.mai.physical.domain.Pair;
import com.mai.physical.events.PairBindingEvent;
import com.mai.physical.model.PairBindingDto;
import com.mai.physical.model.PairDto;
import com.mai.physical.model.PairPagedList;
import com.mai.physical.repositories.PairRepository;
import com.mai.physical.web.mappers.PairMapper;
import com.mai.sdk.QueryParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional(readOnly = false)
@RequiredArgsConstructor
public class PairServiceImpl implements PairService
{
    private final PairRepository pairRepository;
    private final PairMapper pairMapper;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Override
    public PairDto getPairById( Long id )
    {
        PairDto pairDto = pairMapper.pairToPairDto(
                pairRepository.findById(id).orElseThrow(NotFoundException::new));

        return pairDto;
    }

    @Override
    public PairPagedList findPairs( QueryParam[] params, PageRequest pageRequest)
    {
        PairPagedList pairPagedList;
        Page<Pair> pairPage;

        pairPage = pairRepository.findAll(pageRequest);
        pairPagedList = new PairPagedList(pairPage
                .getContent()
                .stream()
                .map(pairMapper::pairToPairDto)
                .collect(Collectors.toList()),
                PageRequest
                        .of(pairPage.getPageable().getPageNumber(),
                                pairPage.getPageable().getPageSize()),
                pairPage.getTotalElements());

        return pairPagedList;
    }

    @Override
    public PairPagedList findPairsByCableId( Long cableId, PageRequest pageRequest)
    {
        PairPagedList pairPagedList;
        Page<Pair> pairPage;

        /*pairPage =  pairRepository.findAllByCable_TargetId(cableId, pageRequest);

        pairPagedList = new PairPagedList(pairPage
                .getContent()
                .stream()
                .map(pairMapper::pairToPairDto)
                .collect(Collectors.toList()),
                PageRequest
                        .of(pairPage.getPageable().getPageNumber(),
                                pairPage.getPageable().getPageSize()),
                pairPage.getTotalElements());

        return pairPagedList;*/
return null;
    }

    @Override
    public PairDto createPair( PairDto pairDto )
    {
        Pair pair = pairMapper.pairDtoToPair(pairDto);
        PairDto persistedPair = pairMapper.pairToPairDto(pairRepository.save(pair));
        Long persistedPairId = persistedPair.getId();
        pairDto.getCables().forEach(c -> c.setOwnerId(persistedPairId));
        eventPublisher.publishEvent(new PairBindingEvent(this, pairDto.getCables()));
        return persistedPair;
    }

    @Override
    public PairDto updatePair( Long id,  PairDto pairDto )
    {
        Pair pair = pairRepository.findById(id).orElseThrow(NotFoundException::new);
        pair.setName(pairDto.getName());
        pair.setStatus(pairDto.getStatus());
        pair.setType(pairDto.getType());

        return pairMapper.pairToPairDto(pairRepository.save(pair));
    }

    @Override
    public void deletePair( Long id )
    {
        Pair pair = pairRepository.findById(id).orElseThrow(NotFoundException::new);
        pairRepository.deleteById(id);
    }
}

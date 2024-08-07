package com.mai.physical.services;

import com.mai.physical.domain.Pair;
import com.mai.physical.model.PairDto;
import com.mai.physical.model.PairPagedList;
import com.mai.physical.repositories.PairRepository;
import com.mai.physical.web.mappers.PairMapper;
import com.mai.sdk.QueryParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PairServiceImpl implements PairService
{
    private final PairRepository pairRepository;
    private final PairMapper pairMapper;

    private final PairService pairService;

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
    @Query(value = "SELECT p FROM Pair p JOIN p.cables.targetId=:cableId and p.cables.ownerId=p.id")
    public List findPairsByCableId( Long cableId);
    {
        Pair pair = Pair.builder().build();
        Pair pair = pairRepository.findAll()ById(id).orElseThrow(NotFoundException::new);
        pair.setName(pairDto.getName());
        pair.setStatus(pairDto.getStatus());
        pair.setType(pairDto.getType());

        return pairMapper.pairToPairDto(pairRepository.save(pair));
    }

    @Override
    public PairDto createPair( PairDto pairDto )
    {
        return pairMapper.pairToPairDto(pairRepository.save(pairMapper.pairDtoToPair(pairDto)));
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

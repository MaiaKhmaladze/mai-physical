package com.mai.physical.services;

import com.mai.physical.domain.Cable;
import com.mai.physical.domain.CableBinding;
import com.mai.physical.model.CableDto;
import com.mai.physical.model.CablePagedList;
import com.mai.physical.model.PairPagedList;
import com.mai.physical.repositories.CableRepository;
import com.mai.physical.web.mappers.CableMapper;
import com.mai.physical.web.mappers.PairMapper;
import com.mai.sdk.QueryParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CableServiceImpl implements CableService
{
    private final CableRepository cableRepository;
    private final CableMapper cableMapper;

    private final PairService pairService;

    @Override
    public CableDto getCableById( Long id )
    {
        Cable cable = cableRepository.findById(id).orElseThrow(NotFoundException::new);
        CableDto cableDto = cableMapper.cableToCableDto(cable);


        Set<Long> pairIds = cable.getCableToPair().stream().forEach(p -> p.getTargetId()).collect(Collectors.toSet());
        PairPagedList list = pairService.findPairsByIds(pairIds);
        cableDto.getCableToASite();
        return cableDto;
    }

    @Override
    public CablePagedList findCables( QueryParam[] params, PageRequest pageRequest)
    {
        CablePagedList cablePagedList;
        Page<Cable> cablePage;

        cablePage = cableRepository.findAll(pageRequest);
        cablePagedList = new CablePagedList(cablePage
                .getContent()
                .stream()
                .map(cableMapper::cableToCableDto)
                .collect(Collectors.toList()),
                PageRequest
                        .of(cablePage.getPageable().getPageNumber(),
                                cablePage.getPageable().getPageSize()),
                cablePage.getTotalElements());

        return cablePagedList;
    }

    @Override
    public CableDto createCable( CableDto cableDto )
    {
        return cableMapper.cableToCableDto(cableRepository.save(cableMapper.cableDtoToCable(cableDto)));
    }

    @Override
    public CableDto updateCable( Long id,  CableDto cableDto )
    {
        Cable cable = cableRepository.findById(id).orElseThrow(NotFoundException::new);
        cable.setName(cableDto.getName());
        cable.setStatus(cableDto.getStatus());
        cable.setType(cableDto.getType());

        return cableMapper.cableToCableDto(cableRepository.save(cable));
    }

    @Override
    public void deleteCable( Long id )
    {
        Cable cable = cableRepository.findById(id).orElseThrow(NotFoundException::new);
        cableRepository.deleteById(id);
    }
}

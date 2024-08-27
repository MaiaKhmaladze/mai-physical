package com.mai.physical.services;


import com.mai.physical.domain.PairBinding;
import com.mai.physical.model.PairBindingDto;
import com.mai.physical.model.PairBindingPagedList;
import com.mai.physical.repositories.PairBindingRepository;
import com.mai.physical.web.mappers.PairBindingMapper;
import com.mai.sdk.QueryParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PairBindingServiceImpl implements PairBindingService
{
    private final PairBindingRepository pairBindingRepository;
    private final PairBindingMapper pairBindingMapper;

    @Override
    public PairBindingDto getBindingById(Long id )
    {
        PairBinding binding = pairBindingRepository.findById(id).orElseThrow(NotFoundException::new);
        PairBindingDto pairBindingDto = pairBindingMapper.bindingToBindingDto(binding);
;
        return pairBindingDto;
    }

    @Override
    public PairBindingPagedList findBindings(QueryParam[] params, PageRequest pageRequest)
    {
        PairBindingPagedList pairBindingPagedList;
        Page<PairBinding> bindingPage;

        bindingPage = pairBindingRepository.findAll(pageRequest);
        pairBindingPagedList = new PairBindingPagedList(bindingPage
                .getContent()
                .stream()
                .map(pairBindingMapper::bindingToBindingDto)
                .collect(Collectors.toList()),
                PageRequest
                        .of(bindingPage.getPageable().getPageNumber(),
                                bindingPage.getPageable().getPageSize()),
                bindingPage.getTotalElements());

        return pairBindingPagedList;
    }

    @Override
    public PairBindingDto createBinding(PairBindingDto pairBindingDto)
    {
        return pairBindingMapper.bindingToBindingDto(pairBindingRepository.save(pairBindingMapper.bindingDtoToBinding(pairBindingDto)));
    }

    @Override
    public PairBindingDto updateBinding(Long id, PairBindingDto pairBindingDto)
    {
        PairBinding binding = pairBindingRepository.findById(id).orElseThrow(NotFoundException::new);
        //only sequence order can be changed
        binding.setSequenceOrder(pairBindingDto.getSequenceOrder());

        return pairBindingMapper.bindingToBindingDto(pairBindingRepository.save(binding));
    }

    @Override
    public void deleteBinding( Long id )
    {
        PairBinding binding = pairBindingRepository.findById(id).orElseThrow(NotFoundException::new);
        pairBindingRepository.deleteById(id);
    }
}

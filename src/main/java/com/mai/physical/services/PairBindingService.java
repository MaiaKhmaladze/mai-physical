package com.mai.physical.services;

import com.mai.physical.model.PairBindingDto;
import com.mai.physical.model.PairBindingPagedList;
import com.mai.sdk.QueryParam;
import org.springframework.data.domain.PageRequest;

public interface PairBindingService
{

    PairBindingDto getBindingById(Long id);
    PairBindingPagedList findBindings(QueryParam[] params, PageRequest pageRequest);

    PairBindingDto createBinding(PairBindingDto bindingDto);

    PairBindingDto updateBinding(Long id, PairBindingDto pairBindingDto);

    void deleteBinding(Long id);
}

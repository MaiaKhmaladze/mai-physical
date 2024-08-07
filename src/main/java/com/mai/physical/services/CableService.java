package com.mai.physical.services;

import com.mai.physical.model.CableDto;
import com.mai.physical.model.CablePagedList;
import com.mai.sdk.QueryParam;
import org.springframework.data.domain.PageRequest;

public interface CableService
{
    CableDto getCableById(Long id);
    CablePagedList findCables( QueryParam[] params, PageRequest pageRequest);

    CableDto createCable(CableDto cableDto);

    CableDto updateCable(Long id, CableDto cableDto);

    void deleteCable(Long id);
}

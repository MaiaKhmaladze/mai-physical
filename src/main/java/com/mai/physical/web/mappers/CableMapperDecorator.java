package com.mai.physical.web.mappers;

import com.mai.physical.domain.Cable;
import com.mai.physical.model.CableDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CableMapperDecorator implements CableMapper {

    private CableMapper mapper;

    @Autowired
    public void setMapper(CableMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public CableDto cableToCableDto( Cable cable) {
        CableDto dto = mapper.cableToCableDto(cable);
        dto.setId(cable.getObjectId());
        return dto;
    }

    @Override
    public Cable cableDtoToCable( CableDto cableDto) {
        return mapper.cableDtoToCable(cableDto);
    }
}

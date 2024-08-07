package com.mai.physical.web.mappers;

import com.mai.physical.domain.Cable;
import com.mai.physical.model.CableDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper (uses = {DateMapper.class})
@DecoratedWith(CableMapperDecorator.class)
public interface CableMapper
{

    CableDto cableToCableDto( Cable cable );

    Cable cableDtoToCable( CableDto dto );
}

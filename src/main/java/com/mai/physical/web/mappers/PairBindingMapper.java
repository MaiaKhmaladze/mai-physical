package com.mai.physical.web.mappers;

import com.mai.physical.domain.PairBinding;
import com.mai.physical.model.PairBindingDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper (uses = {DateMapper.class})
@DecoratedWith(PairBindingMapperDecorator.class)
public interface PairBindingMapper
{

    PairBindingDto bindingToBindingDto(PairBinding binding );

    PairBinding bindingDtoToBinding( PairBindingDto dto );
}

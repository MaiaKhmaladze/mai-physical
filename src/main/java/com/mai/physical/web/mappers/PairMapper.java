package com.mai.physical.web.mappers;

import com.mai.physical.domain.Pair;
import com.mai.physical.model.PairDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper (uses = {DateMapper.class}, componentModel = "spring")
@DecoratedWith(PairMapperDecorator.class)
public interface PairMapper
{
    PairDto pairToPairDto( Pair pair );

    Pair pairDtoToPair( PairDto dto );
}

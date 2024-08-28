package com.mai.physical.web.mappers;

import com.mai.physical.domain.Pair;
import com.mai.physical.model.PairDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Optional;

public abstract class PairMapperDecorator implements PairMapper {

    private PairMapper mapper;

    @Autowired
    public void setMapper(PairMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public PairDto pairToPairDto( Pair pair) {
        PairDto dto = mapper.pairToPairDto(pair);
        Long pairId = pair.getObjectId();
        dto.setId(pair.getObjectId());
        return dto;
    }

   /* @Override
    public PairDto pairDtoToPair( PairDto pairDto) {
        Pair pair = mapper.pairDtoToPair(pairDto);
        pair.
        dto.setId(pair.getObjectId());
        return dto;
    }*/

}

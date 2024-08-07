package com.mai.physical.web.mappers;

import com.mai.physical.domain.Pair;
import com.mai.physical.model.PairDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class PairMapperDecorator implements PairMapper {

    private PairMapper mapper;

    @Autowired
    public void setMapper(PairMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public PairDto pairToPairDto( Pair pair) {
        PairDto dto = mapper.pairToPairDto(pair);
        dto.setId(pair.getObjectId());
        return dto;
    }

    @Override
    public Pair pairDtoToPair( PairDto pairDto) {
        return mapper.pairDtoToPair(pairDto);
    }
}

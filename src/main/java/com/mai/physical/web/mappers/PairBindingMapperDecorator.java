package com.mai.physical.web.mappers;

import com.mai.physical.domain.PairBinding;
import com.mai.physical.model.PairBindingDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class PairBindingMapperDecorator implements PairBindingMapper {

    private PairBindingMapper mapper;

    @Autowired
    public void setMapper(PairBindingMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public PairBindingDto bindingToBindingDto(PairBinding binding) {
        PairBindingDto dto = mapper.bindingToBindingDto(binding);
        return dto;
    }

    @Override
    public PairBinding bindingDtoToBinding(PairBindingDto pairBindingDto) {
        return mapper.bindingDtoToBinding(pairBindingDto);
    }
}

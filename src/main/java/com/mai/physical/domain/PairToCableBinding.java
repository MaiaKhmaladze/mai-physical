package com.mai.physical.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
public class PairToCableBinding extends PairBinding
{

    public String getBindingName(){
        return PairConstants.BINDING_PAIR_TO_CABLE;
    }
}

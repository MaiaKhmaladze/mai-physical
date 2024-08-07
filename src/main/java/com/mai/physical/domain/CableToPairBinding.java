package com.mai.physical.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
public class CableToPairBinding extends CableBinding
{

    public String getBindingName(){
        return "CableToPair";
    }
}

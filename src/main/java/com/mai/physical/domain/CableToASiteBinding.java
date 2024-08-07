package com.mai.physical.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
public class CableToASiteBinding extends CableBinding
{

    public String getBindingName(){
        return "CableToASite";
    }
}

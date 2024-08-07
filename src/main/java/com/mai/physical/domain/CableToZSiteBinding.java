package com.mai.physical.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
public class CableToZSiteBinding extends CableBinding
{

    public String getBindingName(){
        return "CableToZSite";
    }

}

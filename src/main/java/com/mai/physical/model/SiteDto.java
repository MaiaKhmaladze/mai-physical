package com.mai.physical.model;

import com.mai.physical.domain.CableToASiteBinding;
import com.mai.physical.domain.CableToPairBinding;
import com.mai.physical.domain.CableToZSiteBinding;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SiteDto
{
    static final long serialVersionUID = 0;

    @Null
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private String status;

    @NotNull
    private String type;

    private Set<CableToPairBinding> cableToPair;

    private CableToZSiteBinding cableToZSite;

    private CableToASiteBinding cableToASite;
}

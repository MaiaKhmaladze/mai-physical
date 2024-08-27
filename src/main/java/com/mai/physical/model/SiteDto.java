package com.mai.physical.model;

import com.mai.physical.domain.CableBinding;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private Set<CableBinding> cableToPair;

    private Set<CableBinding> cableToZSite;

    private Set<CableBinding> cableToASite;
}

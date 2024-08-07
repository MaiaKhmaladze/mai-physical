package com.mai.physical.model;

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
public class CableDto extends BaseDto
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

    private Long numberOfPairs;

    private Long numberOfPairsInUse;

    private String aSideTermState;

    private String zSideTermState;

    private SiteDto cableToZSite;

    private SiteDto cableToASite;

    private Set<PairDto> pairs;
}

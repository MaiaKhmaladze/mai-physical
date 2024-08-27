package com.mai.physical.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PairBindingDto {
    private Long ownerId;

    private Long targetId;

    private String ownerType;

    private String targetType;

    private String bindingName;

    private Long sequenceOrder;
}

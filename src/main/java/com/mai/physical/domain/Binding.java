package com.mai.physical.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class Binding
{
    @Column(name="OWNER_ID", columnDefinition = "int8")
    private Long ownerId;

    @Column(name="TARGET_ID", columnDefinition = "int8")
    private Long targetId;

    @Column(name="OWNER_TYPE", columnDefinition = "varchar")
    private String ownerType;

    @Column(name="TARGET_TYPE", columnDefinition = "varchar")
    private String targetType;

    @Column(name="BINDING_NAME", columnDefinition = "varchar")
    private String bindingName;

    @Column(name="SEQUENCE_ORDER", columnDefinition = "int4")
    private Long sequenceOrder;
}

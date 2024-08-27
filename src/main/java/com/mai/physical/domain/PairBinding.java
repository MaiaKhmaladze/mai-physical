package com.mai.physical.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "OCI_PAIR_B")
public class PairBinding
{
    private static final String TABLE_NAME = "OCI_PAIR_B";

    @Id
    @Column(name="ID")
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            type = SequenceStyleGenerator.class,
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "oci_pair_b_id"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "4"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name="OWNER_ID", columnDefinition = "int8", nullable=false)
    private Pair pair;

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

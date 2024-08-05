package com.mai.physical.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "OCI_PAIR")
public class Pair
{
    @Id
    @Column(name="PAIR_STRAND_INST_ID")
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            type = SequenceStyleGenerator.class,
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "oci_pair_id"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "4"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    private Long objectId;

    @Column(name="NAME", columnDefinition = "varchar")
    private String name;

    @Column(name="STATUS", columnDefinition = "varchar")
    private String status;

    @Column(name="TYPE", columnDefinition = "varchar")
    private String type;

    @Column(name="ACTIVE_CONSUMING_TRAIL", columnDefinition = "varchar")
    private String activeConsumingTrail;

    @Column(name="ACTIVE_CONSUMING_TRAIL_ID", columnDefinition = "int8")
    private Long activeConsumingTrailId;

    @Column(name="NUMBER_OF_PAIRS", columnDefinition = "int4")
    private Long numberOfPairs;

    @Column(name="NUMBER_OF_PAIRS_IN_USE", columnDefinition = "int4")
    private Long numberOfPairsInUse;

    @Column(name="ASIDE_TERM_STATE", columnDefinition = "varchar")
    private String aSideTermState;

    @Column(name="ZSIDE_TERM_STATE", columnDefinition = "varchar")
    private String zSideTermState;

    @Column(name="CREATED_BY", columnDefinition = "varchar")
    private String createdBy;

    @Column(name="LOCKED_BY", columnDefinition = "varchar")
    private String lockedBy;

    @Column(name="LAST_MODIFIED_BY", columnDefinition = "varchar")
    private String modifiedBy;

    @CreationTimestamp
    @Column(name="CREATED_ON", updatable = false)
    private Timestamp createdOn;

    @Column(name="LOCKED_ON")
    private Timestamp lockedOn;

    @Column(name="LAST_MODIFIED_ON")
    @UpdateTimestamp
    private Timestamp modifiedOn;

    @Version
    @Column(name="VERSION", columnDefinition = "int8")
    private Long version;
}




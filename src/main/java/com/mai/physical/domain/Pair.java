package com.mai.physical.domain;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.*;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
//@Builder
@Entity
@Data
@Table(name = "OCI_PAIR")
public class Pair
{
    @Id
    @Column(name="PAIR_INST_ID")
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

    @Column(name="NAME", columnDefinition = "varchar", unique = true)
    private String name;

    @Column(name="STATUS", columnDefinition = "varchar")
    private String status;

    @Column(name="TYPE", columnDefinition = "varchar")
    private String type;

    @Column(name="COLOR", columnDefinition = "varchar")
    private String color;

    @Column(name="ACTIVE_CONSUMING_TRAIL", columnDefinition = "varchar")
    private String activeConsumingTrail;

    @Column(name="ACTIVE_CONSUMING_TRAIL_ID", columnDefinition = "int8")
    private Long activeConsumingTrailId;

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

    /*@ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<PairBinding> cables = new ArrayList<>();
*/
}




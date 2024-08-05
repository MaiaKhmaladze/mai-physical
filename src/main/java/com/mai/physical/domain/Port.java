package com.mai.physical.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "OCI_PORT")
public class Port
{
    @Id
    @Column(name="PORT_INST_ID")
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            type = SequenceStyleGenerator.class,
            parameters = {
                    @Parameter(name = "sequence_name", value = "oci_equip_id"),
                    @Parameter(name = "initial_value", value = "4"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private Long objectId;

    @Column(name="NAME", columnDefinition = "varchar")
    private String name;

    @Column(name="STATUS", columnDefinition = "varchar")
    private String status;

    @Column(name="CONNECTOR_TYPE", columnDefinition = "varchar")
    private String connectorType;

    @Column(name="ACTIVE_CONSUMING_TRAIL", columnDefinition = "varchar")
    private String activeConsumingTrail;

    @Column(name="ACTIVE_CONSUMING_TRAIL_ID", columnDefinition = "int8")
    private Long activeConsumingTrailId;

    @Column(name="VENDOR", columnDefinition = "varchar")
    private String vendor;

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




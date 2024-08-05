package com.mai.physical.domain;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@DynamicUpdate
@Table(name = "OCI_SITE", uniqueConstraints = { @UniqueConstraint(columnNames = { "name", "version" }) })

public class Site
{
    @Id
    @Column(name="SITE_INST_ID")
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            type = SequenceStyleGenerator.class,
            parameters = {
                    @Parameter(name = "sequence_name", value = "oci_site_id"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private Long objectId;

    @Column(name="NAME", columnDefinition = "varchar", unique=true)
    private String name;

    @Column(name="STATUS", columnDefinition = "varchar")
    private String status;

    @Column(name="TYPE", columnDefinition = "varchar")
    private String type;

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



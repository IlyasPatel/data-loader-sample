package com.efinancialcareers.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Calendar;

@Entity(name = "JobAllocation")
@Table(name = "JobAllocation")
public class JobAllocation implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "JobAllocationId")
    private Long jobAllocationId;

    @Column(name = "Version")
    private Long version;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "StartDt")
    private Calendar startDt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ExpirationDt")
    private Calendar expirationDt;

    @OneToOne
    @JoinColumn(name = "jobId")
    private Job job;

    @OneToOne
    @JoinColumn(name = "InventoryAllocationIdFk")
    private InventoryAllocation inventoryAllocation;
}

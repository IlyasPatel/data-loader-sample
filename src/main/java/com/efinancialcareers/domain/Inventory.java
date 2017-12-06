package com.efinancialcareers.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Calendar;

@Entity(name = "Inventory")
@Table(name = "Inventory")
public class Inventory implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "InventoryId")
    private Long id;

    @Column(name = "Version")
    private Long version;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "ContractId")
    private Contract contract;

    @Column(name = "LocationId")
    private Long locationId;

    @JoinColumn(name = "InventorySubTypeId")
    private Long inventorySubTypeId;

    @Column(name = "Amount")
    private Integer amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "StartDt")
    private Calendar startDt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ExpirationDt")
    private Calendar expirationDt;

    @Column(name = "StatusId")
    private Integer status;
}

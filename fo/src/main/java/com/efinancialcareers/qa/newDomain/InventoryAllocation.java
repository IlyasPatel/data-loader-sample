package com.efinancialcareers.qa.newDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "InventoryAllocation")
@Table(name = "InventoryAllocation")
public class InventoryAllocation implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "InventoryAllocationId")
    private Long id;

    @Column(name = "Version")
    private Long version;

    @ManyToOne
    @JoinColumn(name = "InventoryId")
    private Inventory inventory;

    @ManyToOne
    @JoinColumn(name = "TeamId")
    private Team team;

    @Column(name = "TotalAmount")
    private Integer totalAmount;

    @Column(name = "StatusId")
    private Integer status;
}

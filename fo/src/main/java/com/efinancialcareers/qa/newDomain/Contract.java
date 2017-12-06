package com.efinancialcareers.qa.newDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "Contract")
@Table(name = "Contract")
public class Contract implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ContractId")
    private Long contractId;

    @Column(name = "Version")
    private Long version;

    @Column(name = "ContractRefNum")
    private String contractRefNum;

    @OneToOne
    @JoinColumn(name = "CompanyId")
    private Company company;

}

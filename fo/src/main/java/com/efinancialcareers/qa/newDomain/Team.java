package com.efinancialcareers.qa.newDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "Team")
@Table(name = "Team")
public class Team implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "TeamId")
    private Long id;

    @Column(name = "Version")
    private Long version;

    @Column(name = "Name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "CompanyId")
    private Company company;

    @Column(name = "StatusId")
    private Integer status;
}

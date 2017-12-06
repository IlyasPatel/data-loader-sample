package com.efinancialcareers.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "JobDescription")
@Table(name = "JobDescription")
public class JobDescription implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "JobDescriptionId")
    private Long id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Description")
    private String description;

    @Column(name = "Summary")
    private String summary;

    @Column(name = "SalaryDescription")
    private String salaryDescription;

    @Column(name = "PermitRequirements")
    private String permitRequirements;

    @Column(name = "LanguageCode")
    private String languageCode;

    @Column(name = "DefaultDescription")
    private boolean defaultDescription;

    @OneToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
    @JoinColumn(name = "jobId")
    private Job job;

}

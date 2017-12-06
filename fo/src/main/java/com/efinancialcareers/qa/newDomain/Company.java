package com.efinancialcareers.qa.newDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "Company")
@Table(name = "Company")
public class Company implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "CompanyId")
    private Long companyId;

    @Column(name = "Version")
    private Long version;

    @Column(name = "Name")
    private String name;

    @Column(name = "SiebelReferenceNumber")
    private String siebelReferenceNumber;

    @Column(name = "Url")
    private String url;

    @Column(name = "IsOfccpCompliant")
    private boolean ofccpCompliant;

    @Column(name = "IsSocialCvSearchEnabled")
    private boolean socialCvSearchEnabled;

    @Column(name = "IsSocialCvSearchShowPhotoEnabled")
    private boolean socialCvSearchShowPhotoEnabled;

    @Column(name = "AllowExternalAppsWithoutLogin")
    private boolean allowExternalAppsWithoutLogin;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "CompanyTypeId")
    private int type;
}

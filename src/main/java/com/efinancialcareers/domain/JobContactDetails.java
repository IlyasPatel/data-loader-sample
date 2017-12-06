package com.efinancialcareers.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "JobContactDetails")
@Table(name = "JobContactDetails")
public class JobContactDetails implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "JobIdPK")
    private Long jobIdPk;

    @Column(name = "ContactFirstName")
    private String contactFirstName;

    @Column(name = "ContactLastName")
    private String contactLastName;

    @Column(name = "ContactEmail")
    private String contactEmail;

    @Column(name = "ContactPhone")
    private String contactPhone;

    @Column(name = "ContactFax")
    private String contactFax;

    @Column(name = "ContactCompanyName")
    private String contactCompanyName;

    @Column(name = "ContactAddress1")
    private String contactAddress1;

    @Column(name = "ContactAddress2")
    private String contactAddress2;

    @Column(name = "ContactAddress3")
    private String contactAddress3;

    @Column(name = "ContactCity")
    private String contactCity;

    @Column(name = "ContactRegion")
    private String contactRegion;

    @Column(name = "ContactPostCode")
    private String contactPostCode;

    @Column(name = "ContactCountry")
    private String contactCountry;

    @Column(name = "ContactURL")
    private String contactURL;

    @Column(name = "ContactBrandName")
    private String contactBrandName;

    @Column(name = "DisplayContactFirstName")
    private Boolean displayContactFirstName;

    @Column(name = "DisplayContactLastName")
    private Boolean displayContactLastName;

    @Column(name = "DisplayContactEmail")
    private Boolean displayContactEmail;

    @Column(name = "DisplayContactPhone")
    private Boolean displayContactPhone;

    @Column(name = "DisplayContactFax")
    private Boolean displayContactFax;

    @Column(name = "DisplayContactCompanyName")
    private Boolean displayContactCompanyName;

    @Column(name = "DisplayContactAddress1")
    private Boolean displayContactAddress1;

    @Column(name = "DisplayContactAddress2")
    private Boolean displayContactAddress2;

    @Column(name = "DisplayContactAddress3")
    private Boolean displayContactAddress3;

    @Column(name = "DisplayContactCity")
    private Boolean displayContactCity;

    @Column(name = "DisplayContactRegion")
    private Boolean displayContactRegion;

    @Column(name = "DisplayContactPostCode")
    private Boolean displayContactPostCode;

    @Column(name = "DisplayContactCountry")
    private Boolean displayContactCountry;

    @Column(name = "DisplayContactURL")
    private Boolean displayContactURL;

    @Column(name = "DisplayContactBrandImage")
    private Boolean displayContactBrandImage;

    @Column(name = "HideContactDetails")
    private Boolean hideContactDetails;

    @Column(name = "DisplayContactBrandName")
    private Boolean displayContactBrandName;

    @Column(name = "DisplayEALicenceNumber")
    private Boolean displayEALicenceNumber;

    @Column(name = "DisplayRegistrationNumber")
    private Boolean displayRegistrationNumber;

}

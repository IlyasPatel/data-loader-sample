package com.efinancialcareers.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

    @OneToOne
    @JoinColumn(name = "ParentId")
    private Company parentCompany;


    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSiebelReferenceNumber() {
        return siebelReferenceNumber;
    }

    public void setSiebelReferenceNumber(String siebelReferenceNumber) {
        this.siebelReferenceNumber = siebelReferenceNumber;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isOfccpCompliant() {
        return ofccpCompliant;
    }

    public void setOfccpCompliant(boolean ofccpCompliant) {
        this.ofccpCompliant = ofccpCompliant;
    }

    public boolean isSocialCvSearchEnabled() {
        return socialCvSearchEnabled;
    }

    public void setSocialCvSearchEnabled(boolean socialCvSearchEnabled) {
        this.socialCvSearchEnabled = socialCvSearchEnabled;
    }

    public boolean isSocialCvSearchShowPhotoEnabled() {
        return socialCvSearchShowPhotoEnabled;
    }

    public void setSocialCvSearchShowPhotoEnabled(boolean socialCvSearchShowPhotoEnabled) {
        this.socialCvSearchShowPhotoEnabled = socialCvSearchShowPhotoEnabled;
    }

    public boolean isAllowExternalAppsWithoutLogin() {
        return allowExternalAppsWithoutLogin;
    }

    public void setAllowExternalAppsWithoutLogin(boolean allowExternalAppsWithoutLogin) {
        this.allowExternalAppsWithoutLogin = allowExternalAppsWithoutLogin;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Company getParentCompany() {
        return parentCompany;
    }

    public void setParentCompany(Company parentCompany) {
        this.parentCompany = parentCompany;
    }
}
package com.efinancialcareers.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Calendar;

@Entity(name = "Job")
@Table(name = "Job")
public class Job implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "JobId")
    private Long jobId;

    @Column(name = "Version")
    private Long version;

    @Column(name = "LocationId")
    private Long locationId;

    @JoinColumn(name = "CompanyId")
    private Long companyId;

    @JoinColumn(name = "BrandId")
    private Long brandId;

    @JoinColumn(name = "ProjectId")
    private Long projectId;

    @JoinColumn(name = "UsrId")
    private Long usrId;

    @JoinColumn(name = "subSector1Id")
    private Long subSector1Id;

    @JoinColumn(name = "subSector2Id")
    private Long subSector2Id;

    @JoinColumn(name = "subSector3Id")
    private Long subSector3Id;

    @Column(name = "YearsExperience")
    private Integer yearsExperience;

    @Column(name = "JobReference")
    private String jobReference;

    @Column(name = "SalaryCurrency")
    private Integer salaryCurrency;

    @Column(name = "salaryBand")
    private Integer salaryBand;

    @Column(name = "PositionType")
    private Integer positionType;

    @Column(name = "EmploymentType")
    private Integer employmentType;

    @Column(name = "applicationMethod")
    private Integer applicationMethod;

    @Column(name = "JobProvider")
    private Integer jobProviderId;

    @Column(name = "ExternalApplicationURL")
    private String externalApplicationURL;

    @Column(name = "AutoReply")
    private Boolean autoReply;

    @Column(name = "ScreenQuestionary")
    private Boolean screenQuestionary;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RefreshDt")
    private Calendar refreshDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ModifiedDt")
    private Calendar modifiedDate;

    @Column(name = "ISOCityCode")
    private String isoCityCode;

    @Column(name = "ISOCountryCode")
    private String isoCountryCode;

    @Column(name = "ZIP")
    private String zip;

    @JoinColumn(name = "ScreenQuestionnaireId")
    private Long screenQuestionnaireId;

    @JoinColumn(name = "DeletedByUsrId")
    private Long deletedByUsrId;

    @JoinColumn(name = "JobTemplateId")
    private Long jobTemplateId;

    @Column(name = "JobFeedProviderId")
    private Long jobFeedProviderId;

    @JoinColumn(name = "JobFeedTrustedAccountId")
    private Long jobFeedTrustedAccountId;

    @JoinColumn(name = "JobFeedProviderAccountId")
    private Long jobFeedProviderAccountId;

    @Column(name = "JobFeedTrustedAccountApiKey")
    private String jobFeedTrustedAccountApiKey;

    @Column(name = "JobFeedProviderAccountApiKey")
    private String jobFeedProviderAccountApiKey;

}

package com.efinancialcareers.qa.newDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Brand")
public class Brand implements Serializable {

    private int BrandId;
    private int Version;
    private String Name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getBrandId() {
        return BrandId;
    }

    public void setBrandId(int brandId) {
        this.BrandId = brandId;
    }

    @Column(name = "Version", nullable = false)
    public int getVersion() {
        return Version;
    }

    public void setVersion(int version) {
        Version = version;
    }

    @Column(name = "Name", nullable = false)
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
}

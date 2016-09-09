package dpu.beans.admin;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "companymaster")
public class CompanyBean implements Serializable {

    @Id
    @Column(name = "company_id")
    @GeneratedValue
    private int companyId;

    @Column(name = "name")
    private String companyName;

    @Column(name = "address")
    private String address;

    @Column(name = "unit_no")
    private String unitNo;

    @Column(name = "city")
    private String city;

    @Column(name = "province_state")
    private String provinceState;

    @Column(name = "zip")
    private String zip;

    @Column(name = "email")
    private String email;

    @Column(name = "website")
    private String website;

    @Column(name = "contact")
    private String contact;

    @Column(name = "position")
    private String position;

    @Column(name = "phone")
    private String phone;

    @Column(name = "ext")
    private String ext;

    @Column(name = "fax")
    private String fax;

    @Column(name = "company_prefix")
    private String prefix;

    @Column(name = "tollfree")
    private String tollfree;

    @Column(name = "cellular")
    private String cellular;

    @Column(name = "pager")
    private String pager;

    @Column(name = "customer_notes")
    private String notes;

    @Column(name = "after_hours")
    private String afterHours;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "companyBean")
    private Set<BillingLocationBean> billingLocations = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "companyBean")
    private Set<AdditionalContactBean> additionalContacts = new HashSet<>();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.beans.admin;

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

/**
 *
 * @author Gagandeep
 */
@Getter
@Setter
@Entity
@Table(name = "custombrokermaster")
public class CustomBrokerBean {

    @Id
    @Column(name = "custom_broker_id")
    @GeneratedValue
    private int customBrokerId;

    @Column(name = "custom_broker")
    private String customBroker;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "ext")
    private String ext;

    @Column(name = "fax_no")
    private String faxNo;

    @Column(name = "status")
    private int status;

    @Column(name = "email")
    private String email;

    @Column(name = "website")
    private String website;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customBrokerBean")
    private Set<BorderAgentBean> borderAgentBean = new HashSet();
}

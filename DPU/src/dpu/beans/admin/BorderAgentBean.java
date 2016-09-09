/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.beans.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "border_agent")
public class BorderAgentBean {

    @Id
    @Column(name = "border_agent_id")
    @GeneratedValue
    private int borderAgentId;

    @Column(name = "code")
    private String code;

    @Column(name = "border_agent")
    private String borderAgent;

    @Column(name = "border_crossing")
    private String borderCrossing;

    @Column(name = "phone")
    private String phone;

    @Column(name = "ext")
    private String ext;

    @Column(name = "fax")
    private String fax;

    @Column(name = "status")
    private int status;

    @Column(name = "email")
    private String email;

    @Column(name = "open_from")
    private String openFrom;

    @Column(name = "open_to")
    private String openTo;

    @Column(name = "after_hour")
    private String afterHour;

    @Column(name = "is24Hr")
    private int is24Hr;

    @Column(name = "comments")
    private String comments;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "custom_broker_id")
    private CustomBrokerBean customBrokerBean;
}

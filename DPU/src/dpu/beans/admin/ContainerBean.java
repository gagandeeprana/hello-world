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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author gagandeep.rana
 */
@Getter
@Setter
@Entity
@Table(name = "containermaster")
public class ContainerBean {

    @Id
    @Column(name = "container_id")
    @GeneratedValue
    private int containerId;

    @Column(name = "unit_no")
    private String unitNo;

    @Column(name = "type")
    private String type;

    @OneToOne(mappedBy = "containerBean", fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private TerminalBean terminalBean;
    
    @Column(name = "status")
    private int status;
    
    @OneToOne(mappedBy = "containerBean", fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private CategoryBean categoryBean;
    
    @Column(name = "owner")
    private String owner;
    
    @Column(name = "location")
    private String location;

}

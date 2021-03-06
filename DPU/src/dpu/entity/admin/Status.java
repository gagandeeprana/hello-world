/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.entity.admin;

import dpu.beans.admin.CategoryBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
 

/**
 *
 * @author Durga
 */
@Getter
@Setter
@Entity
@Table(name= "status")
public class Status {
    
    @Id
    @Column(name= "statusId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long statusId;
    
    @Column(name= "statusValue")
    private String statusValue;
    
    //@OneToOne(fetch = FetchType.LAZY)
   // @PrimaryKeyJoinColumn
   // private Driver driver;
    
}

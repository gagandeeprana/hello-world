/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.entity.admin;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author lakhvir
 */
@Getter
@Setter
@Entity
@Table(name="state")
public class State implements Serializable{
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="state_id")
    private Long stateId;
    
     @Column(name="state_code")
    private String stateCode;
    
    @Column(name="state_name")
    private String stateName;
     
}

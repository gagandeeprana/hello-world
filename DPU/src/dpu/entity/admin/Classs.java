/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.entity.admin;

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
 * @author Durga
 */
@Getter
@Setter
@Entity
@Table(name= "class")
public class Classs {
    
     
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "classId")
    private Long classId;
    
    @Column(name = "classvalue")
    private String classValue;
    
    
}

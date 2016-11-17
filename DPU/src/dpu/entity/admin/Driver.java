/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.entity.admin;

/**
 *
 * @author Durga
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 
import dpu.beans.admin.ContainerBean;
import dpu.beans.admin.TypeBean;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
 
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author gagandeep.rana
 */
@Getter
@Setter
@Entity
@Table(name="driver")
public class Driver implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="driver_id")
    private int driverId;
    
     
    
    @Column(unique = true , name="driver_code")
    private String driverCode;
    
    @Column(name="first_name")
    private String firstName;
     
    @Column(name="last_name") 
    private String lastName;
    
    @Column(name="address")
    private String address;
    
    @Column(name="unit")
    private String unit;
    
    @Column(name="city")
    private String city;
    
    @Column(name="pvs")
    private String pvs;
    
    @Column(name="postal_code")
    private String postalCode;
    
    @Column(name="e_mail")
    private String email;
    
    @Column(name="home")
    private String home;
    
    @Column(name="fax_no")
    private String faxNo;
    
    
    @Column(name="cellular")
    private String cellular;
    
    @Column(name="pager")
    private String pager;
    
    @Column(name="division")
    private String division;
    
    @Column(name="terminal")
    private String terminalId;
    
    @Column(name="category")
    private String catogoryId;
    
    @Column(name="role")
    private String roleId;

    @Column(name="status")
    private String statusId;
    
    @Column(name="classId")
    private String classId;

    @Column(name = "created_by")
    private String createdBy;

     
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

     

   // @OneToOne(fetch = FetchType.LAZY, mappedBy = "driver")
    //private Status status;
    

}

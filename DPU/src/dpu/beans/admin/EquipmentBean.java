package dpu.beans.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "equipmentmaster")
@Entity
public class EquipmentBean {

    @Id
    @Column(name = "equipment_id")
    @GeneratedValue
    private int equipmentId;

    @Column(name = "equipment_name")
    private String equipmentName;

    @Column(name = "description")
    private String description;

}

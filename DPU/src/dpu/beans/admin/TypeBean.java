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
 * @author gagandeep.rana
 */
@Entity
@Table(name = "typemaster")
@Getter
@Setter
public class TypeBean {

    @Id
    @Column(name = "type_id")
    @GeneratedValue
    private int typeId;

    @Column(name = "type_name")
    private String typeName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "typeBean")
    private Set<CategoryBean> categories = new HashSet<>();
}

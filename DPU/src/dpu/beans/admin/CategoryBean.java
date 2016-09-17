package dpu.beans.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name = "categorymaster")
public class CategoryBean {

    @Id
    @Column(name = "category_id")
    @GeneratedValue
    private int categoryId;

    @Column(name = "name")
    private String categoryName;

    @Column(name = "status")
    private int status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private TypeBean typeBean;
    
    @OneToOne(fetch = FetchType.LAZY,mappedBy = "categoryBean")
    private ContainerBean containerBean;
}

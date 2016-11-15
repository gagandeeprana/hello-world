package dpu.beans.admin;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private TypeBean typeBean;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "categoryBean")
    private ContainerBean containerBean;
}

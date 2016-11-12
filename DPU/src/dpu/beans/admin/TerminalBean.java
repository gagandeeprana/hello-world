package dpu.beans.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "terminalmaster")
public class TerminalBean {

    @Id
    @Column(name = "terminal_id")
    @GeneratedValue
    private int terminalId;

    @Column(name = "terminal_name")
    private String terminalName;

     @Column(name = "facility")
    private String facility;
    
    @Column(name = "location")
    private String location;
    
    @OneToOne(fetch = FetchType.LAZY,mappedBy = "terminalBean")
    private ContainerBean containerBean;
}

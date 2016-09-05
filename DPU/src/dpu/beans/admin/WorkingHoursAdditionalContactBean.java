package dpu.beans.admin;

import java.beans.ConstructorProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Gagandeep
 */
@Getter
@Setter
@AllArgsConstructor
public class WorkingHoursAdditionalContactBean {

    private int workingId;
    private String workingDay;
    private String open1;
    private String close1;
    private String open2;
    private String close2;
    private int is24Hrs;
    private int additionalContactId;
}

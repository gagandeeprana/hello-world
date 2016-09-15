package dpu.dao.admin;

import dpu.beans.admin.ContainerBean;
import java.util.List;

/**
 *
 * @author gagandeep.rana
 */
public interface ContainerDAO {

    List<ContainerBean> getAllContainers(String containerName);

    ContainerBean getContainerInfoById(int id);

    int addContainer(ContainerBean obj);

    String updateContainer(ContainerBean obj);

    String deleteContainer(int containerId);
}

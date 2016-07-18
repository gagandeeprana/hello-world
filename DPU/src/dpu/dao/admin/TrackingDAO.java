package dpu.dao.admin;

import dpu.beans.admin.TrackingBean;
import java.util.List;

public interface TrackingDAO {

    List<TrackingBean> getAllTrackings(String name);

    String addTracking(TrackingBean obj);

    String updateTracking(TrackingBean obj);

    String deleteTracking(int trackingId);

}

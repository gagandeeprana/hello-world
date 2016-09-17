package dpu.dao.admin;

import dpu.beans.admin.PaymentTermsBean;
import java.util.List;

/**
 *
 * @author gagandeep.rana
 */
public interface PaymentTermsDAO {

    List<PaymentTermsBean> getAllPaymentTerms(String paymentTermName);

    PaymentTermsBean getPaymentTermInfoById(int id);

    int addPaymentTerm(PaymentTermsBean obj);

    String updatePaymentTerm(PaymentTermsBean obj);

    String deletePaymentTerm(int paymentTermId);
}

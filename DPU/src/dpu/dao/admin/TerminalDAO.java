package dpu.dao.admin;

import dpu.beans.admin.TerminalBean;
import java.util.List;

public interface TerminalDAO {

    List<TerminalBean> getAllTerminals(String name);

    TerminalBean getTerminalInfoById(int id);

    int addTerminal(TerminalBean obj);

    String updateTerminal(TerminalBean obj);

    String deleteTerminal(int terminalId);

    
}

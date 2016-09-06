/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.ui.common.helper;

import dpu.reports.common.JasperReportGenerator;
import dpu.ui.common.TestClassPanel;
import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import properties.ReadFromPropertiesFile;

/**
 *
 * @author gagandeep.rana
 */
@Component
class ShowWaitAction extends AbstractAction {

    protected static final long SLEEP_TIME = 2 * 1000;
    String fileName = "";

    @Autowired
    public ShowWaitAction(@Value("#{' '}") String name, @Value("#{'filename'}") String fileName) {
        super(name);
        this.fileName = fileName;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        try {
            SwingWorker<Void, Void> mySwingWorker = new SwingWorker<Void, Void>() {

                @Override
                protected Void doInBackground() throws Exception {
                    // mimic some long-running process here...
                    Thread.sleep(SLEEP_TIME);
                    return null;
                }
            };

            Window win = SwingUtilities.getWindowAncestor((AbstractButton) evt.getSource());
            final JDialog dialog = new JDialog(win, "", Dialog.ModalityType.APPLICATION_MODAL);
            dialog.setUndecorated(true);

            mySwingWorker.addPropertyChangeListener(new PropertyChangeListener() {

                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    if (evt.getPropertyName().equals("state")) {
                        if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
                            JasperReportGenerator.generateReport("CustomerReport.jrxml");
                            dialog.dispose();
                        }
                    }
                }
            });
            mySwingWorker.execute();
//        JProgressBar progressBar = new JProgressBar();
//        progressBar.setIndeterminate(true);
            JPanel panel = new JPanel(new BorderLayout());
//        panel.add(progressBar, BorderLayout.CENTER);
//        panel.add(new JLabel("Please wait......."), BorderLayout.PAGE_START);
            JLabel jLabel = new JLabel(new ImageIcon(ReadFromPropertiesFile.imagePath + "Wait.gif"));
            panel.add(jLabel);
            dialog.add(panel);
            TestClassPanel testClassPanel = new TestClassPanel();
            testClassPanel.setEnabled(false);
            dialog.pack();
            dialog.setLocationRelativeTo(win);
            dialog.setVisible(true);
        } catch (Exception e) {
            System.out.println("ShowWaitAction : actionPerformed(): " + e);
        }

    }
}

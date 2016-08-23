/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.ui.helper.common;

import dpu.beans.admin.WorkingHoursAdditionalContactBean;
import dpu.ui.common.AdditionalContactWorkingHours;
import static dpu.ui.common.AdditionalContactWorkingHours.txtSunOpen1;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import properties.TimeConstants;

/**
 *
 * @author gagandeep.rana
 */
public class AdditionalContactWorkingHoursUIHelper {

    public static MaskFormatter mask = null;
    public static List<WorkingHoursAdditionalContactBean> lstWorkingHours = new ArrayList();

    public AdditionalContactWorkingHoursUIHelper() {
        try {
            mask = new MaskFormatter("##:##");
            mask.setPlaceholderCharacter('_');
        } catch (Exception e) {
            System.out.println("AdditionalContactWorkingHoursUIHelper() : " + e);
        }
    }

    public void disable(boolean val) {
        AdditionalContactWorkingHours.txtSunOpen1.setEditable(val);
        AdditionalContactWorkingHours.txtMonOpen1.setEditable(val);
        AdditionalContactWorkingHours.txtTueOpen1.setEditable(val);
        AdditionalContactWorkingHours.txtWedOpen1.setEditable(val);
        AdditionalContactWorkingHours.txtThurOpen1.setEditable(val);
        AdditionalContactWorkingHours.txtFriOpen1.setEditable(val);
        AdditionalContactWorkingHours.txtSatOpen1.setEditable(val);
        AdditionalContactWorkingHours.txtSunOpen2.setEditable(val);
        AdditionalContactWorkingHours.txtMonOpen2.setEditable(val);
        AdditionalContactWorkingHours.txtTueOpen2.setEditable(val);
        AdditionalContactWorkingHours.txtWedOpen2.setEditable(val);
        AdditionalContactWorkingHours.txtThurOpen2.setEditable(val);
        AdditionalContactWorkingHours.txtFriOpen2.setEditable(val);
        AdditionalContactWorkingHours.txtSatOpen2.setEditable(val);
        AdditionalContactWorkingHours.txtSunClose1.setEditable(val);
        AdditionalContactWorkingHours.txtMonClose1.setEditable(val);
        AdditionalContactWorkingHours.txtTueClose1.setEditable(val);
        AdditionalContactWorkingHours.txtWedClose1.setEditable(val);
        AdditionalContactWorkingHours.txtThurClose1.setEditable(val);
        AdditionalContactWorkingHours.txtFriClose1.setEditable(val);
        AdditionalContactWorkingHours.txtSatClose1.setEditable(val);
        AdditionalContactWorkingHours.txtSunClose2.setEditable(val);
        AdditionalContactWorkingHours.txtMonClose2.setEditable(val);
        AdditionalContactWorkingHours.txtTueClose2.setEditable(val);
        AdditionalContactWorkingHours.txtWedClose2.setEditable(val);
        AdditionalContactWorkingHours.txtThurClose2.setEditable(val);
        AdditionalContactWorkingHours.txtFriClose2.setEditable(val);
        AdditionalContactWorkingHours.txtSatClose2.setEditable(val);
    }

    public void setText() {
        AdditionalContactWorkingHours.txtSunOpen1.setText(TimeConstants.open1);
        AdditionalContactWorkingHours.txtMonOpen1.setText(TimeConstants.open1);
        AdditionalContactWorkingHours.txtTueOpen1.setText(TimeConstants.open1);
        AdditionalContactWorkingHours.txtWedOpen1.setText(TimeConstants.open1);
        AdditionalContactWorkingHours.txtThurOpen1.setText(TimeConstants.open1);
        AdditionalContactWorkingHours.txtFriOpen1.setText(TimeConstants.open1);
        AdditionalContactWorkingHours.txtSatOpen1.setText(TimeConstants.open1);
        AdditionalContactWorkingHours.txtSunOpen2.setText(TimeConstants.open2);
        AdditionalContactWorkingHours.txtMonOpen2.setText(TimeConstants.open2);
        AdditionalContactWorkingHours.txtTueOpen2.setText(TimeConstants.open2);
        AdditionalContactWorkingHours.txtWedOpen2.setText(TimeConstants.open2);
        AdditionalContactWorkingHours.txtThurOpen2.setText(TimeConstants.open2);
        AdditionalContactWorkingHours.txtFriOpen2.setText(TimeConstants.open2);
        AdditionalContactWorkingHours.txtSatOpen2.setText(TimeConstants.open2);
        AdditionalContactWorkingHours.txtSunClose1.setText(TimeConstants.close1);
        AdditionalContactWorkingHours.txtMonClose1.setText(TimeConstants.close1);
        AdditionalContactWorkingHours.txtTueClose1.setText(TimeConstants.close1);
        AdditionalContactWorkingHours.txtWedClose1.setText(TimeConstants.close1);
        AdditionalContactWorkingHours.txtThurClose1.setText(TimeConstants.close1);
        AdditionalContactWorkingHours.txtFriClose1.setText(TimeConstants.close1);
        AdditionalContactWorkingHours.txtSatClose1.setText(TimeConstants.close1);
        AdditionalContactWorkingHours.txtSunClose2.setText(TimeConstants.close2);
        AdditionalContactWorkingHours.txtMonClose2.setText(TimeConstants.close2);
        AdditionalContactWorkingHours.txtTueClose2.setText(TimeConstants.close2);
        AdditionalContactWorkingHours.txtWedClose2.setText(TimeConstants.close2);
        AdditionalContactWorkingHours.txtThurClose2.setText(TimeConstants.close2);
        AdditionalContactWorkingHours.txtFriClose2.setText(TimeConstants.close2);
        AdditionalContactWorkingHours.txtSatClose2.setText(TimeConstants.close2);
    }

    public void setChecked(boolean val) {
        AdditionalContactWorkingHours.chkSun.setSelected(val);
        AdditionalContactWorkingHours.chkMon.setSelected(val);
        AdditionalContactWorkingHours.chkTue.setSelected(val);
        AdditionalContactWorkingHours.chkWed.setSelected(val);
        AdditionalContactWorkingHours.chkThur.setSelected(val);
        AdditionalContactWorkingHours.chkFri.setSelected(val);
        AdditionalContactWorkingHours.chkSat.setSelected(val);
    }

    public void setOpenMaskFormatter() {
        txtSunOpen1.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {

                return mask;
            }
        });
        AdditionalContactWorkingHours.txtMonOpen1.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {

                return mask;
            }
        });
        AdditionalContactWorkingHours.txtTueOpen1.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {

                return mask;
            }
        });
        AdditionalContactWorkingHours.txtWedOpen1.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {

                return mask;
            }
        });
        AdditionalContactWorkingHours.txtThurOpen1.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {
                return mask;
            }
        });
        AdditionalContactWorkingHours.txtFriOpen1.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {
                return mask;
            }
        });
        AdditionalContactWorkingHours.txtSatOpen1.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {
                return mask;
            }
        });
        AdditionalContactWorkingHours.txtSameOpen1.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {
                return mask;
            }
        });
        AdditionalContactWorkingHours.txtSunOpen2.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {

                return mask;
            }
        });
        AdditionalContactWorkingHours.txtMonOpen2.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {

                return mask;
            }
        });
        AdditionalContactWorkingHours.txtTueOpen2.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {

                return mask;
            }
        });
        AdditionalContactWorkingHours.txtWedOpen2.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {

                return mask;
            }
        });
        AdditionalContactWorkingHours.txtThurOpen2.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {
                return mask;
            }
        });
        AdditionalContactWorkingHours.txtFriOpen2.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {
                return mask;
            }
        });
        AdditionalContactWorkingHours.txtSatOpen2.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {
                return mask;
            }
        });
        AdditionalContactWorkingHours.txtSameOpen2.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {
                return mask;
            }
        });
    }

    public void setCloseMaskFormatter() {
        AdditionalContactWorkingHours.txtSunClose1.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {

                return mask;
            }
        });
        AdditionalContactWorkingHours.txtMonClose1.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {

                return mask;
            }
        });
        AdditionalContactWorkingHours.txtTueClose1.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {

                return mask;
            }
        });
        AdditionalContactWorkingHours.txtWedClose1.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {

                return mask;
            }
        });
        AdditionalContactWorkingHours.txtThurClose1.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {
                return mask;
            }
        });
        AdditionalContactWorkingHours.txtFriClose1.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {
                return mask;
            }
        });
        AdditionalContactWorkingHours.txtSatClose1.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {
                return mask;
            }
        });
        AdditionalContactWorkingHours.txtSameClose1.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {
                return mask;
            }
        });
        AdditionalContactWorkingHours.txtSunClose2.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {

                return mask;
            }
        });
        AdditionalContactWorkingHours.txtMonClose2.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {

                return mask;
            }
        });
        AdditionalContactWorkingHours.txtTueClose2.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {

                return mask;
            }
        });
        AdditionalContactWorkingHours.txtWedClose2.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {

                return mask;
            }
        });
        AdditionalContactWorkingHours.txtThurClose2.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {
                return mask;
            }
        });
        AdditionalContactWorkingHours.txtFriClose2.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {
                return mask;
            }
        });
        AdditionalContactWorkingHours.txtSatClose2.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {
                return mask;
            }
        });
        AdditionalContactWorkingHours.txtSameClose2.setFormatterFactory(new JFormattedTextField.AbstractFormatterFactory() {
            @Override
            public JFormattedTextField.AbstractFormatter getFormatter(JFormattedTextField tf) {
                return mask;
            }
        });
    }

    public void setOpen1Text(String str) {
        AdditionalContactWorkingHours.txtSunOpen1.setText(str);
        AdditionalContactWorkingHours.txtMonOpen1.setText(str);
        AdditionalContactWorkingHours.txtTueOpen1.setText(str);
        AdditionalContactWorkingHours.txtWedOpen1.setText(str);
        AdditionalContactWorkingHours.txtThurOpen1.setText(str);
        AdditionalContactWorkingHours.txtFriOpen1.setText(str);
        AdditionalContactWorkingHours.txtSatOpen1.setText(str);
    }

    public void setOpen2Text(String str) {
        AdditionalContactWorkingHours.txtSunOpen2.setText(str);
        AdditionalContactWorkingHours.txtMonOpen2.setText(str);
        AdditionalContactWorkingHours.txtTueOpen2.setText(str);
        AdditionalContactWorkingHours.txtWedOpen2.setText(str);
        AdditionalContactWorkingHours.txtThurOpen2.setText(str);
        AdditionalContactWorkingHours.txtFriOpen2.setText(str);
        AdditionalContactWorkingHours.txtSatOpen2.setText(str);
    }

    public void setClose1Text(String str) {
        AdditionalContactWorkingHours.txtSunClose1.setText(str);
        AdditionalContactWorkingHours.txtMonClose1.setText(str);
        AdditionalContactWorkingHours.txtTueClose1.setText(str);
        AdditionalContactWorkingHours.txtWedClose1.setText(str);
        AdditionalContactWorkingHours.txtThurClose1.setText(str);
        AdditionalContactWorkingHours.txtFriClose1.setText(str);
        AdditionalContactWorkingHours.txtSatClose1.setText(str);
    }

    public void setClose2Text(String str) {
        AdditionalContactWorkingHours.txtSunClose2.setText(str);
        AdditionalContactWorkingHours.txtMonClose2.setText(str);
        AdditionalContactWorkingHours.txtTueClose2.setText(str);
        AdditionalContactWorkingHours.txtWedClose2.setText(str);
        AdditionalContactWorkingHours.txtThurClose2.setText(str);
        AdditionalContactWorkingHours.txtFriClose2.setText(str);
        AdditionalContactWorkingHours.txtSatClose2.setText(str);
    }

    public void saveToList() {
        if (AdditionalContactWorkingHours.chkSun.isSelected()) {
            String workingDay = "Sun";
            String open1 = AdditionalContactWorkingHours.txtSunOpen1.getText();
            String close1 = AdditionalContactWorkingHours.txtSunClose1.getText();
            String open2 = AdditionalContactWorkingHours.txtSunOpen2.getText();
            String close2 = AdditionalContactWorkingHours.txtSunClose2.getText();
            int is24Hr = 0;
            if (open1.equals(TimeConstants.open1) && open2.equals(TimeConstants.open2) && close1.equals(TimeConstants.close1) && close2.equals(TimeConstants.close2)) {
                is24Hr = 1;
            }
            lstWorkingHours.add(new WorkingHoursAdditionalContactBean(workingDay, open1, close1, open2, close2, is24Hr));
        }
        if (AdditionalContactWorkingHours.chkMon.isSelected()) {
            String workingDay = "Mon";
            String open1 = AdditionalContactWorkingHours.txtMonOpen1.getText();
            String close1 = AdditionalContactWorkingHours.txtMonClose1.getText();
            String open2 = AdditionalContactWorkingHours.txtMonOpen2.getText();
            String close2 = AdditionalContactWorkingHours.txtMonClose2.getText();
            int is24Hr = 0;
            if (open1.equals(TimeConstants.open1) && open2.equals(TimeConstants.open2) && close1.equals(TimeConstants.close1) && close2.equals(TimeConstants.close2)) {
                is24Hr = 1;
            }
            lstWorkingHours.add(new WorkingHoursAdditionalContactBean(workingDay, open1, close1, open2, close2, is24Hr));
        }
        if (AdditionalContactWorkingHours.chkTue.isSelected()) {
            String workingDay = "Tue";
            String open1 = AdditionalContactWorkingHours.txtTueOpen1.getText();
            String close1 = AdditionalContactWorkingHours.txtTueClose1.getText();
            String open2 = AdditionalContactWorkingHours.txtTueOpen2.getText();
            String close2 = AdditionalContactWorkingHours.txtTueClose2.getText();
            int is24Hr = 0;
            if (open1.equals(TimeConstants.open1) && open2.equals(TimeConstants.open2) && close1.equals(TimeConstants.close1) && close2.equals(TimeConstants.close2)) {
                is24Hr = 1;
            }
            lstWorkingHours.add(new WorkingHoursAdditionalContactBean(workingDay, open1, close1, open2, close2, is24Hr));
        }
        if (AdditionalContactWorkingHours.chkWed.isSelected()) {
            String workingDay = "Wed";
            String open1 = AdditionalContactWorkingHours.txtWedOpen1.getText();
            String close1 = AdditionalContactWorkingHours.txtWedClose1.getText();
            String open2 = AdditionalContactWorkingHours.txtWedOpen2.getText();
            String close2 = AdditionalContactWorkingHours.txtWedClose2.getText();
            int is24Hr = 0;
            if (open1.equals(TimeConstants.open1) && open2.equals(TimeConstants.open2) && close1.equals(TimeConstants.close1) && close2.equals(TimeConstants.close2)) {
                is24Hr = 1;
            }
            lstWorkingHours.add(new WorkingHoursAdditionalContactBean(workingDay, open1, close1, open2, close2, is24Hr));
        }
        if (AdditionalContactWorkingHours.chkThur.isSelected()) {
            String workingDay = "Thur";
            String open1 = AdditionalContactWorkingHours.txtThurOpen1.getText();
            String close1 = AdditionalContactWorkingHours.txtThurClose1.getText();
            String open2 = AdditionalContactWorkingHours.txtThurOpen2.getText();
            String close2 = AdditionalContactWorkingHours.txtThurClose2.getText();
            int is24Hr = 0;
            if (open1.equals(TimeConstants.open1) && open2.equals(TimeConstants.open2) && close1.equals(TimeConstants.close1) && close2.equals(TimeConstants.close2)) {
                is24Hr = 1;
            }
            lstWorkingHours.add(new WorkingHoursAdditionalContactBean(workingDay, open1, close1, open2, close2, is24Hr));
        }
        if (AdditionalContactWorkingHours.chkFri.isSelected()) {
            String workingDay = "Fri";
            String open1 = AdditionalContactWorkingHours.txtFriOpen1.getText();
            String close1 = AdditionalContactWorkingHours.txtFriClose1.getText();
            String open2 = AdditionalContactWorkingHours.txtFriOpen2.getText();
            String close2 = AdditionalContactWorkingHours.txtFriClose2.getText();
            int is24Hr = 0;
            if (open1.equals(TimeConstants.open1) && open2.equals(TimeConstants.open2) && close1.equals(TimeConstants.close1) && close2.equals(TimeConstants.close2)) {
                is24Hr = 1;
            }
            lstWorkingHours.add(new WorkingHoursAdditionalContactBean(workingDay, open1, close1, open2, close2, is24Hr));
        }
        if (AdditionalContactWorkingHours.chkSat.isSelected()) {
            String workingDay = "Sat";
            String open1 = AdditionalContactWorkingHours.txtSatOpen1.getText();
            String close1 = AdditionalContactWorkingHours.txtSatClose1.getText();
            String open2 = AdditionalContactWorkingHours.txtSatOpen2.getText();
            String close2 = AdditionalContactWorkingHours.txtSatClose2.getText();
            int is24Hr = 0;
            if (open1.equals(TimeConstants.open1) && open2.equals(TimeConstants.open2) && close1.equals(TimeConstants.close1) && close2.equals(TimeConstants.close2)) {
                is24Hr = 1;
            }
            lstWorkingHours.add(new WorkingHoursAdditionalContactBean(workingDay, open1, close1, open2, close2, is24Hr));
        }
    }
}

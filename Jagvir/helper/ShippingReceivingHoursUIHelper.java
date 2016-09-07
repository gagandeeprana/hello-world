/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.ui.helper.common;

import dpu.beans.admin.WorkingHoursAdditionalContactBean;
import dpu.beans.admin.WorkingHoursAdditionalShipperBean;
import dpu.ui.common.AdditionalContactWorkingHours;
import dpu.ui.shipper.ShippingReceivingHours;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import properties.TimeConstants;

/**
 *
 * @author jagvir
 */
public class ShippingReceivingHoursUIHelper {

    public static Map<Integer, List<WorkingHoursAdditionalShipperBean>> mapWorkingHours = new HashMap<>();
    public static List<WorkingHoursAdditionalShipperBean> listOfReceivingHours = null;
    public static List<WorkingHoursAdditionalShipperBean> listOfShippingHours = null;

    public void showReceivingData(List<WorkingHoursAdditionalShipperBean> listOfReceivingHours) {
        if (listOfReceivingHours != null) {
            for (WorkingHoursAdditionalShipperBean work : listOfReceivingHours) {
                if (work.getWorkingDay().equals("Sun")) {
                    ShippingReceivingHours.chkSun.setSelected(true);
                    ShippingReceivingHours.txtSunOpen1.setText(work.getOpen1());
                    ShippingReceivingHours.txtSunClose1.setText(work.getClose1());
                    ShippingReceivingHours.txtSunOpen2.setText(work.getOpen2());
                    ShippingReceivingHours.txtSunClose2.setText(work.getClose2());
                }
                if (work.getWorkingDay().equals("Mon")) {
                    ShippingReceivingHours.chkMon.setSelected(true);
                    ShippingReceivingHours.txtMonOpen1.setText(work.getOpen1());
                    ShippingReceivingHours.txtMonClose1.setText(work.getClose1());
                    ShippingReceivingHours.txtMonOpen2.setText(work.getOpen2());
                    ShippingReceivingHours.txtMonClose2.setText(work.getClose2());
                }
                if (work.getWorkingDay().equals("Tue")) {
                    ShippingReceivingHours.chkTue.setSelected(true);
                    ShippingReceivingHours.txtTueOpen1.setText(work.getOpen1());
                    ShippingReceivingHours.txtTueClose1.setText(work.getClose1());
                    ShippingReceivingHours.txtTueOpen2.setText(work.getOpen2());
                    ShippingReceivingHours.txtTueClose2.setText(work.getClose2());
                }
                if (work.getWorkingDay().equals("Wed")) {
                    ShippingReceivingHours.chkWed.setSelected(true);
                    ShippingReceivingHours.txtWedOpen1.setText(work.getOpen1());
                    ShippingReceivingHours.txtWedClose1.setText(work.getClose1());
                    ShippingReceivingHours.txtWedOpen2.setText(work.getOpen2());
                    ShippingReceivingHours.txtWedClose2.setText(work.getClose2());
                }
                if (work.getWorkingDay().equals("Thu")) {
                    ShippingReceivingHours.chkThu.setSelected(true);
                    ShippingReceivingHours.txtThuOpen1.setText(work.getOpen1());
                    ShippingReceivingHours.txtThuClose1.setText(work.getClose1());
                    ShippingReceivingHours.txtThuOpen2.setText(work.getOpen2());
                    ShippingReceivingHours.txtThuClose2.setText(work.getClose2());
                }
                if (work.getWorkingDay().equals("Fri")) {
                    ShippingReceivingHours.chkFri.setSelected(true);
                    ShippingReceivingHours.txtFriOpen1.setText(work.getOpen1());
                    ShippingReceivingHours.txtFriClose1.setText(work.getClose1());
                    ShippingReceivingHours.txtFriOpen2.setText(work.getOpen2());
                    ShippingReceivingHours.txtFriClose2.setText(work.getClose2());
                }
                if (work.getWorkingDay().equals("Sat")) {
                    ShippingReceivingHours.chkSat.setSelected(true);
                    ShippingReceivingHours.txtSatOpen1.setText(work.getOpen1());
                    ShippingReceivingHours.txtSatClose1.setText(work.getClose1());
                    ShippingReceivingHours.txtSatOpen2.setText(work.getOpen2());
                    ShippingReceivingHours.txtSatClose2.setText(work.getClose2());
                }
            }
        }
    }

    public void showShippingData(List<WorkingHoursAdditionalShipperBean> listOfShippingHours) {
        if (listOfShippingHours != null) {
            for (WorkingHoursAdditionalShipperBean work : listOfShippingHours) {
                if (work.getWorkingDay().equals("Sun")) {
                    ShippingReceivingHours.chkSSun.setSelected(true);
                    ShippingReceivingHours.txtSSunOpen1.setText(work.getOpen1());
                    ShippingReceivingHours.txtSSunClose1.setText(work.getClose1());
                    ShippingReceivingHours.txtSSunOpen2.setText(work.getOpen2());
                    ShippingReceivingHours.txtSSunClose2.setText(work.getClose2());
                }
                if (work.getWorkingDay().equals("Mon")) {
                    ShippingReceivingHours.chkSMon.setSelected(true);
                    ShippingReceivingHours.txtSMonOpen1.setText(work.getOpen1());
                    ShippingReceivingHours.txtSMonClose1.setText(work.getClose1());
                    ShippingReceivingHours.txtSMonOpen2.setText(work.getOpen2());
                    ShippingReceivingHours.txtSMonClose2.setText(work.getClose2());
                }
                if (work.getWorkingDay().equals("Tue")) {
                    ShippingReceivingHours.chkSTue.setSelected(true);
                    ShippingReceivingHours.txtSTueOpen1.setText(work.getOpen1());
                    ShippingReceivingHours.txtSTueClose1.setText(work.getClose1());
                    ShippingReceivingHours.txtSTueOpen2.setText(work.getOpen2());
                    ShippingReceivingHours.txtSTueClose2.setText(work.getClose2());
                }
                if (work.getWorkingDay().equals("Wed")) {
                    ShippingReceivingHours.chkSWed.setSelected(true);
                    ShippingReceivingHours.txtSWedOpen1.setText(work.getOpen1());
                    ShippingReceivingHours.txtSWedClose1.setText(work.getClose1());
                    ShippingReceivingHours.txtSWedOpen2.setText(work.getOpen2());
                    ShippingReceivingHours.txtSWedClose2.setText(work.getClose2());
                }
                if (work.getWorkingDay().equals("Thu")) {
                    ShippingReceivingHours.chkSThu.setSelected(true);
                    ShippingReceivingHours.txtSThuOpen1.setText(work.getOpen1());
                    ShippingReceivingHours.txtSThuClose1.setText(work.getClose1());
                    ShippingReceivingHours.txtSThuOpen2.setText(work.getOpen2());
                    ShippingReceivingHours.txtSThuClose2.setText(work.getClose2());
                }
                if (work.getWorkingDay().equals("Fri")) {
                    ShippingReceivingHours.chkSFri.setSelected(true);
                    ShippingReceivingHours.txtSFriOpen1.setText(work.getOpen1());
                    ShippingReceivingHours.txtSFrClose1.setText(work.getClose1());
                    ShippingReceivingHours.txtSFriOpen2.setText(work.getOpen2());
                    ShippingReceivingHours.txtSFrClose2.setText(work.getClose2());
                }
                if (work.getWorkingDay().equals("Sat")) {
                    ShippingReceivingHours.chkSSat.setSelected(true);
                    ShippingReceivingHours.txtSSatOpen1.setText(work.getOpen1());
                    ShippingReceivingHours.txtSSatClose1.setText(work.getClose1());
                    ShippingReceivingHours.txtSSatOpen2.setText(work.getOpen2());
                    ShippingReceivingHours.txtSSatClose2.setText(work.getClose2());
                }
            }
        }
    }

    private void disableFieled(boolean v) {
        ShippingReceivingHours.txtSunOpen1.setEnabled(v);
        ShippingReceivingHours.txtSunOpen2.setEnabled(v);
        ShippingReceivingHours.txtSunClose1.setEnabled(v);
        ShippingReceivingHours.txtSunClose2.setEnabled(v);
        ShippingReceivingHours.txtMonOpen1.setEnabled(v);
        ShippingReceivingHours.txtMonOpen2.setEnabled(v);
        ShippingReceivingHours.txtMonClose1.setEnabled(v);
        ShippingReceivingHours.txtMonClose2.setEnabled(v);
        ShippingReceivingHours.txtTueOpen1.setEnabled(v);
        ShippingReceivingHours.txtTueOpen2.setEnabled(v);
        ShippingReceivingHours.txtTueClose1.setEnabled(v);
        ShippingReceivingHours.txtTueClose2.setEnabled(v);
        ShippingReceivingHours.txtWedOpen1.setEnabled(v);
        ShippingReceivingHours.txtWedOpen2.setEnabled(v);
        ShippingReceivingHours.txtWedClose1.setEnabled(v);
        ShippingReceivingHours.txtWedClose2.setEnabled(v);
        ShippingReceivingHours.txtThuOpen1.setEnabled(v);
        ShippingReceivingHours.txtThuOpen2.setEnabled(v);
        ShippingReceivingHours.txtThuClose1.setEnabled(v);
        ShippingReceivingHours.txtThuClose2.setEnabled(v);
        ShippingReceivingHours.txtFriOpen1.setEnabled(v);
        ShippingReceivingHours.txtFriOpen2.setEnabled(v);
        ShippingReceivingHours.txtFriClose1.setEnabled(v);
        ShippingReceivingHours.txtFriClose2.setEnabled(v);
        ShippingReceivingHours.txtSatOpen1.setEnabled(v);
        ShippingReceivingHours.txtSatOpen2.setEnabled(v);
        ShippingReceivingHours.txtSatClose1.setEnabled(v);
        ShippingReceivingHours.txtSatClose2.setEnabled(v);
    }

    public void setText() {
        ShippingReceivingHours.txtSunOpen1.setText(TimeConstants.open1);
        ShippingReceivingHours.txtMonOpen1.setText(TimeConstants.open1);
        ShippingReceivingHours.txtTueOpen1.setText(TimeConstants.open1);
        ShippingReceivingHours.txtWedOpen1.setText(TimeConstants.open1);
        ShippingReceivingHours.txtThuOpen1.setText(TimeConstants.open1);
        ShippingReceivingHours.txtFriOpen1.setText(TimeConstants.open1);
        ShippingReceivingHours.txtSatOpen1.setText(TimeConstants.open1);

        ShippingReceivingHours.txtSunOpen2.setText(TimeConstants.open2);
        ShippingReceivingHours.txtMonOpen2.setText(TimeConstants.open2);
        ShippingReceivingHours.txtTueOpen2.setText(TimeConstants.open2);
        ShippingReceivingHours.txtWedOpen2.setText(TimeConstants.open2);
        ShippingReceivingHours.txtThuOpen2.setText(TimeConstants.open2);
        ShippingReceivingHours.txtFriOpen2.setText(TimeConstants.open2);
        ShippingReceivingHours.txtSatOpen2.setText(TimeConstants.open2);

        ShippingReceivingHours.txtSunClose1.setText(TimeConstants.close1);
        ShippingReceivingHours.txtMonClose1.setText(TimeConstants.close1);
        ShippingReceivingHours.txtTueClose1.setText(TimeConstants.close1);
        ShippingReceivingHours.txtWedClose1.setText(TimeConstants.close1);
        ShippingReceivingHours.txtThuClose1.setText(TimeConstants.close1);
        ShippingReceivingHours.txtFriClose1.setText(TimeConstants.close1);
        ShippingReceivingHours.txtSatClose1.setText(TimeConstants.close1);

        ShippingReceivingHours.txtSunClose2.setText(TimeConstants.close2);
        ShippingReceivingHours.txtMonClose2.setText(TimeConstants.close2);
        ShippingReceivingHours.txtTueClose2.setText(TimeConstants.close2);
        ShippingReceivingHours.txtWedClose2.setText(TimeConstants.close2);
        ShippingReceivingHours.txtThuClose2.setText(TimeConstants.close2);
        ShippingReceivingHours.txtFriClose2.setText(TimeConstants.close2);
        ShippingReceivingHours.txtSatClose2.setText(TimeConstants.close2);

    }

    public void setChecked(boolean val) {
        ShippingReceivingHours.chkSun.setSelected(val);
        ShippingReceivingHours.chkMon.setSelected(val);
        ShippingReceivingHours.chkTue.setSelected(val);
        ShippingReceivingHours.chkWed.setSelected(val);
        ShippingReceivingHours.chkThu.setSelected(val);
        ShippingReceivingHours.chkFri.setSelected(val);
        ShippingReceivingHours.chkSat.setSelected(val);
    }

    public void setOpen1Text(String str) {
        ShippingReceivingHours.txtSunOpen1.setText(str);
        ShippingReceivingHours.txtMonOpen1.setText(str);
        ShippingReceivingHours.txtTueOpen1.setText(str);
        ShippingReceivingHours.txtWedOpen1.setText(str);
        ShippingReceivingHours.txtThuOpen1.setText(str);
        ShippingReceivingHours.txtFriOpen1.setText(str);
        ShippingReceivingHours.txtSatOpen1.setText(str);
    }

    public void setOpen2Text(String str) {
        ShippingReceivingHours.txtSunOpen2.setText(str);
        ShippingReceivingHours.txtMonOpen2.setText(str);
        ShippingReceivingHours.txtTueOpen2.setText(str);
        ShippingReceivingHours.txtWedOpen2.setText(str);
        ShippingReceivingHours.txtThuOpen2.setText(str);
        ShippingReceivingHours.txtFriOpen2.setText(str);
        ShippingReceivingHours.txtSatOpen2.setText(str);
    }

    public void setClose1Text(String str) {
        ShippingReceivingHours.txtSunClose1.setText(str);
        ShippingReceivingHours.txtMonClose1.setText(str);
        ShippingReceivingHours.txtTueClose1.setText(str);
        ShippingReceivingHours.txtWedClose1.setText(str);
        ShippingReceivingHours.txtThuClose1.setText(str);
        ShippingReceivingHours.txtFriClose1.setText(str);
        ShippingReceivingHours.txtSatClose1.setText(str);
    }

    public void setClose2Text(String str) {
        ShippingReceivingHours.txtSunClose2.setText(str);
        ShippingReceivingHours.txtMonClose2.setText(str);
        ShippingReceivingHours.txtTueClose2.setText(str);
        ShippingReceivingHours.txtWedClose2.setText(str);
        ShippingReceivingHours.txtThuClose2.setText(str);
        ShippingReceivingHours.txtFriClose2.setText(str);
        ShippingReceivingHours.txtSatClose2.setText(str);
    }

    public void saveShipperReceivingHours() {
        listOfReceivingHours = new ArrayList<>();
        if (ShippingReceivingHours.chkSun.isSelected()) {
            String workingDay = "Sun";

            String open1 = ShippingReceivingHours.txtSunOpen1.getText();
            String close1 = ShippingReceivingHours.txtSunClose1.getText();
            String open2 = ShippingReceivingHours.txtSunOpen2.getText();
            String close2 = ShippingReceivingHours.txtSunClose2.getText();
            int is24Hr = 0;
            if (open1.equals(TimeConstants.open1) && open2.equals(TimeConstants.open2) && close1.equals(TimeConstants.close1) && close2.equals(TimeConstants.close2)) {
                is24Hr = 1;
            }
            WorkingHoursAdditionalShipperBean work = new WorkingHoursAdditionalShipperBean(workingDay, open1, close1, open2, close2, is24Hr, "receiving");
            listOfReceivingHours.add(work);
        }
        if (ShippingReceivingHours.chkMon.isSelected()) {
            String workingDay = "Mon";

            String open1 = ShippingReceivingHours.txtMonOpen1.getText();
            String close1 = ShippingReceivingHours.txtMonClose1.getText();
            String open2 = ShippingReceivingHours.txtMonOpen2.getText();
            String close2 = ShippingReceivingHours.txtMonClose2.getText();
            int is24Hr = 0;
            if (open1.equals(TimeConstants.open1) && open2.equals(TimeConstants.open2) && close1.equals(TimeConstants.close1) && close2.equals(TimeConstants.close2)) {
                is24Hr = 1;
            }
            WorkingHoursAdditionalShipperBean work = new WorkingHoursAdditionalShipperBean(workingDay, open1, close1, open2, close2, is24Hr, "receiving");
            listOfReceivingHours.add(work);
        }
        if (ShippingReceivingHours.chkTue.isSelected()) {
            String workingDay = "Tue";

            String open1 = ShippingReceivingHours.txtTueOpen1.getText();
            String close1 = ShippingReceivingHours.txtTueClose1.getText();
            String open2 = ShippingReceivingHours.txtTueOpen2.getText();
            String close2 = ShippingReceivingHours.txtTueClose2.getText();
            int is24Hr = 0;
            if (open1.equals(TimeConstants.open1) && open2.equals(TimeConstants.open2) && close1.equals(TimeConstants.close1) && close2.equals(TimeConstants.close2)) {
                is24Hr = 1;
            }
            WorkingHoursAdditionalShipperBean work = new WorkingHoursAdditionalShipperBean(workingDay, open1, close1, open2, close2, is24Hr, "receiving");
            listOfReceivingHours.add(work);
        }
        if (ShippingReceivingHours.chkWed.isSelected()) {
            String workingDay = "Wed";

            String open1 = ShippingReceivingHours.txtWedOpen1.getText();
            String close1 = ShippingReceivingHours.txtWedClose1.getText();
            String open2 = ShippingReceivingHours.txtWedOpen2.getText();
            String close2 = ShippingReceivingHours.txtWedClose2.getText();
            int is24Hr = 0;
            if (open1.equals(TimeConstants.open1) && open2.equals(TimeConstants.open2) && close1.equals(TimeConstants.close1) && close2.equals(TimeConstants.close2)) {
                is24Hr = 1;
            }
            WorkingHoursAdditionalShipperBean work = new WorkingHoursAdditionalShipperBean(workingDay, open1, close1, open2, close2, is24Hr, "receiving");
            listOfReceivingHours.add(work);
        }
        if (ShippingReceivingHours.chkThu.isSelected()) {
            String workingDay = "Thu";

            String open1 = ShippingReceivingHours.txtThuOpen1.getText();
            String close1 = ShippingReceivingHours.txtThuClose1.getText();
            String open2 = ShippingReceivingHours.txtThuOpen2.getText();
            String close2 = ShippingReceivingHours.txtThuClose2.getText();
            int is24Hr = 0;
            if (open1.equals(TimeConstants.open1) && open2.equals(TimeConstants.open2) && close1.equals(TimeConstants.close1) && close2.equals(TimeConstants.close2)) {
                is24Hr = 1;
            }
            WorkingHoursAdditionalShipperBean work = new WorkingHoursAdditionalShipperBean(workingDay, open1, close1, open2, close2, is24Hr, "receiving");
            listOfReceivingHours.add(work);
        }
        if (ShippingReceivingHours.chkFri.isSelected()) {
            String workingDay = "Fri";

            String open1 = ShippingReceivingHours.txtFriOpen1.getText();
            String close1 = ShippingReceivingHours.txtFriClose1.getText();
            String open2 = ShippingReceivingHours.txtFriOpen2.getText();
            String close2 = ShippingReceivingHours.txtFriClose2.getText();
            int is24Hr = 0;
            if (open1.equals(TimeConstants.open1) && open2.equals(TimeConstants.open2) && close1.equals(TimeConstants.close1) && close2.equals(TimeConstants.close2)) {
                is24Hr = 1;
            }
            WorkingHoursAdditionalShipperBean work = new WorkingHoursAdditionalShipperBean(workingDay, open1, close1, open2, close2, is24Hr, "receiving");
            listOfReceivingHours.add(work);
        }
        if (ShippingReceivingHours.chkSat.isSelected()) {
            String workingDay = "Sat";

            String open1 = ShippingReceivingHours.txtSatOpen1.getText();
            String close1 = ShippingReceivingHours.txtSatClose1.getText();
            String open2 = ShippingReceivingHours.txtSatOpen2.getText();
            String close2 = ShippingReceivingHours.txtSatClose2.getText();
            int is24Hr = 0;
            if (open1.equals(TimeConstants.open1) && open2.equals(TimeConstants.open2) && close1.equals(TimeConstants.close1) && close2.equals(TimeConstants.close2)) {
                is24Hr = 1;
            }
            WorkingHoursAdditionalShipperBean work = new WorkingHoursAdditionalShipperBean(workingDay, open1, close1, open2, close2, is24Hr, "receiving");
            listOfReceivingHours.add(work);
        }
    }

    public void saveShipperShippingHours() {
        listOfShippingHours = new ArrayList<>();
        if (ShippingReceivingHours.chkSSun.isSelected()) {
            String workingDay = "Sun";

            String open1 = ShippingReceivingHours.txtSSunOpen1.getText();
            String close1 = ShippingReceivingHours.txtSSunClose1.getText();
            String open2 = ShippingReceivingHours.txtSSunOpen2.getText();
            String close2 = ShippingReceivingHours.txtSSunClose2.getText();
            int is24Hr = 0;
            if (open1.equals(TimeConstants.open1) && open2.equals(TimeConstants.open2) && close1.equals(TimeConstants.close1) && close2.equals(TimeConstants.close2)) {
                is24Hr = 1;
            }
            WorkingHoursAdditionalShipperBean work = new WorkingHoursAdditionalShipperBean(workingDay, open1, close1, open2, close2, is24Hr, "shipping");
            listOfShippingHours.add(work);
        }
        if (ShippingReceivingHours.chkSMon.isSelected()) {
            String workingDay = "Mon";

            String open1 = ShippingReceivingHours.txtSMonOpen1.getText();
            String close1 = ShippingReceivingHours.txtSMonClose1.getText();
            String open2 = ShippingReceivingHours.txtSMonOpen2.getText();
            String close2 = ShippingReceivingHours.txtSMonClose2.getText();
            int is24Hr = 0;
            if (open1.equals(TimeConstants.open1) && open2.equals(TimeConstants.open2) && close1.equals(TimeConstants.close1) && close2.equals(TimeConstants.close2)) {
                is24Hr = 1;
            }
            WorkingHoursAdditionalShipperBean work = new WorkingHoursAdditionalShipperBean(workingDay, open1, close1, open2, close2, is24Hr, "shipping");
            listOfShippingHours.add(work);
        }
        if (ShippingReceivingHours.chkSTue.isSelected()) {
            String workingDay = "Tue";

            String open1 = ShippingReceivingHours.txtSTueOpen1.getText();
            String close1 = ShippingReceivingHours.txtSTueClose1.getText();
            String open2 = ShippingReceivingHours.txtSTueOpen2.getText();
            String close2 = ShippingReceivingHours.txtSTueClose2.getText();
            int is24Hr = 0;
            if (open1.equals(TimeConstants.open1) && open2.equals(TimeConstants.open2) && close1.equals(TimeConstants.close1) && close2.equals(TimeConstants.close2)) {
                is24Hr = 1;
            }
            WorkingHoursAdditionalShipperBean work = new WorkingHoursAdditionalShipperBean(workingDay, open1, close1, open2, close2, is24Hr, "shipping");
            listOfShippingHours.add(work);
        }
        if (ShippingReceivingHours.chkSWed.isSelected()) {
            String workingDay = "Wed";

            String open1 = ShippingReceivingHours.txtSWedOpen1.getText();
            String close1 = ShippingReceivingHours.txtSWedClose1.getText();
            String open2 = ShippingReceivingHours.txtSWedOpen2.getText();
            String close2 = ShippingReceivingHours.txtSWedClose2.getText();
            int is24Hr = 0;
            if (open1.equals(TimeConstants.open1) && open2.equals(TimeConstants.open2) && close1.equals(TimeConstants.close1) && close2.equals(TimeConstants.close2)) {
                is24Hr = 1;
            }
            WorkingHoursAdditionalShipperBean work = new WorkingHoursAdditionalShipperBean(workingDay, open1, close1, open2, close2, is24Hr, "shipping");
            listOfShippingHours.add(work);
        }
        if (ShippingReceivingHours.chkSThu.isSelected()) {
            String workingDay = "Thu";

            String open1 = ShippingReceivingHours.txtSThuOpen1.getText();
            String close1 = ShippingReceivingHours.txtSThuClose1.getText();
            String open2 = ShippingReceivingHours.txtSThuOpen2.getText();
            String close2 = ShippingReceivingHours.txtSThuClose2.getText();
            int is24Hr = 0;
            if (open1.equals(TimeConstants.open1) && open2.equals(TimeConstants.open2) && close1.equals(TimeConstants.close1) && close2.equals(TimeConstants.close2)) {
                is24Hr = 1;
            }
            WorkingHoursAdditionalShipperBean work = new WorkingHoursAdditionalShipperBean(workingDay, open1, close1, open2, close2, is24Hr, "shipping");
            listOfShippingHours.add(work);
        }
        if (ShippingReceivingHours.chkSFri.isSelected()) {
            String workingDay = "Fri";

            String open1 = ShippingReceivingHours.txtSFriOpen1.getText();
            String close1 = ShippingReceivingHours.txtSFrClose1.getText();
            String open2 = ShippingReceivingHours.txtSFriOpen2.getText();
            String close2 = ShippingReceivingHours.txtSFrClose2.getText();
            int is24Hr = 0;
            if (open1.equals(TimeConstants.open1) && open2.equals(TimeConstants.open2) && close1.equals(TimeConstants.close1) && close2.equals(TimeConstants.close2)) {
                is24Hr = 1;
            }
            WorkingHoursAdditionalShipperBean work = new WorkingHoursAdditionalShipperBean(workingDay, open1, close1, open2, close2, is24Hr, "shipping");
            listOfShippingHours.add(work);
        }
        if (ShippingReceivingHours.chkSSat.isSelected()) {
            String workingDay = "Sat";

            String open1 = ShippingReceivingHours.txtSSatOpen1.getText();
            String close1 = ShippingReceivingHours.txtSSatClose1.getText();
            String open2 = ShippingReceivingHours.txtSSatOpen2.getText();
            String close2 = ShippingReceivingHours.txtSSatClose2.getText();
            int is24Hr = 0;
            if (open1.equals(TimeConstants.open1) && open2.equals(TimeConstants.open2) && close1.equals(TimeConstants.close1) && close2.equals(TimeConstants.close2)) {
                is24Hr = 1;
            }
            WorkingHoursAdditionalShipperBean work = new WorkingHoursAdditionalShipperBean(workingDay, open1, close1, open2, close2, is24Hr, "shipping");
            listOfShippingHours.add(work);
        }
    }

    public void copyReceivinngToShipping() {
        ShippingReceivingHours.txtSSunOpen1.setText(ShippingReceivingHours.txtSunOpen1.getText());
        ShippingReceivingHours.txtSMonOpen1.setText(ShippingReceivingHours.txtMonOpen1.getText());
        ShippingReceivingHours.txtSTueOpen1.setText(ShippingReceivingHours.txtTueOpen1.getText());
        ShippingReceivingHours.txtSWedOpen1.setText(ShippingReceivingHours.txtWedOpen1.getText());
        ShippingReceivingHours.txtSThuOpen1.setText(ShippingReceivingHours.txtThuOpen1.getText());
        ShippingReceivingHours.txtSFriOpen1.setText(ShippingReceivingHours.txtFriOpen1.getText());
        ShippingReceivingHours.txtSSatOpen1.setText(ShippingReceivingHours.txtSatOpen1.getText());

        ShippingReceivingHours.txtSSunOpen2.setText(ShippingReceivingHours.txtSunOpen2.getText());
        ShippingReceivingHours.txtSMonOpen2.setText(ShippingReceivingHours.txtMonOpen2.getText());
        ShippingReceivingHours.txtSTueOpen2.setText(ShippingReceivingHours.txtTueOpen2.getText());
        ShippingReceivingHours.txtSWedOpen2.setText(ShippingReceivingHours.txtWedOpen2.getText());
        ShippingReceivingHours.txtSThuOpen2.setText(ShippingReceivingHours.txtThuOpen2.getText());
        ShippingReceivingHours.txtSFriOpen2.setText(ShippingReceivingHours.txtFriOpen2.getText());
        ShippingReceivingHours.txtSSatOpen2.setText(ShippingReceivingHours.txtSatOpen2.getText());

        ShippingReceivingHours.txtSSunClose1.setText(ShippingReceivingHours.txtSunClose1.getText());
        ShippingReceivingHours.txtSMonClose1.setText(ShippingReceivingHours.txtMonClose1.getText());
        ShippingReceivingHours.txtSTueClose1.setText(ShippingReceivingHours.txtTueClose1.getText());
        ShippingReceivingHours.txtSWedClose1.setText(ShippingReceivingHours.txtWedClose1.getText());
        ShippingReceivingHours.txtSThuClose1.setText(ShippingReceivingHours.txtThuClose1.getText());
        ShippingReceivingHours.txtSFrClose1.setText(ShippingReceivingHours.txtFriClose1.getText());
        ShippingReceivingHours.txtSSatClose1.setText(ShippingReceivingHours.txtSatClose1.getText());

        ShippingReceivingHours.txtSSunClose2.setText(ShippingReceivingHours.txtSunClose2.getText());
        ShippingReceivingHours.txtSMonClose2.setText(ShippingReceivingHours.txtMonClose2.getText());
        ShippingReceivingHours.txtSTueClose2.setText(ShippingReceivingHours.txtTueClose2.getText());
        ShippingReceivingHours.txtSWedClose2.setText(ShippingReceivingHours.txtWedClose2.getText());
        ShippingReceivingHours.txtSThuClose2.setText(ShippingReceivingHours.txtThuClose2.getText());
        ShippingReceivingHours.txtSFrClose2.setText(ShippingReceivingHours.txtFriClose2.getText());
        ShippingReceivingHours.txtSSatClose2.setText(ShippingReceivingHours.txtSatClose2.getText());

        ShippingReceivingHours.txtSSameClose1.setText(ShippingReceivingHours.txtSameClose1.getText());
        ShippingReceivingHours.txtSSameClose2.setText(ShippingReceivingHours.txtSameClose2.getText());
        ShippingReceivingHours.txtSSameOpen1.setText(ShippingReceivingHours.txtSameOpen1.getText());
        ShippingReceivingHours.txtSSameOpen2.setText(ShippingReceivingHours.txtSameOpen2.getText());

    }

    public void copyCheckBox() {
        if (ShippingReceivingHours.chkSun.isSelected()) {
            ShippingReceivingHours.chkSSun.setSelected(true);
        }
        if (ShippingReceivingHours.chkMon.isSelected()) {
            ShippingReceivingHours.chkSMon.setSelected(true);
        }
        if (ShippingReceivingHours.chkTue.isSelected()) {
            ShippingReceivingHours.chkSTue.setSelected(true);
        }
        if (ShippingReceivingHours.chkWed.isSelected()) {
            ShippingReceivingHours.chkSWed.setSelected(true);
        }
        if (ShippingReceivingHours.chkThu.isSelected()) {
            ShippingReceivingHours.chkSThu.setSelected(true);
        }
        if (ShippingReceivingHours.chkFri.isSelected()) {
            ShippingReceivingHours.chkSFri.setSelected(true);
        }
        if (ShippingReceivingHours.chkSat.isSelected()) {
            ShippingReceivingHours.chkSSat.setSelected(true);
        }
        if (ShippingReceivingHours.chkSame.isSelected()) {
            ShippingReceivingHours.chkSSame1.setSelected(true);
        }
    }

    public void unCheck() {
        ShippingReceivingHours.chkSSun.setSelected(false);
        ShippingReceivingHours.chkSMon.setSelected(false);
        ShippingReceivingHours.chkSTue.setSelected(false);
        ShippingReceivingHours.chkSWed.setSelected(false);
        ShippingReceivingHours.chkSThu.setSelected(false);
        ShippingReceivingHours.chkSFri.setSelected(false);
        ShippingReceivingHours.chkSSat.setSelected(false);
        ShippingReceivingHours.chkSSame1.setSelected(false);

    }

    public void clearShippingFieleds() {
        ShippingReceivingHours.txtSSunOpen1.setText("");
        ShippingReceivingHours.txtSMonOpen1.setText("");
        ShippingReceivingHours.txtSTueOpen1.setText("");
        ShippingReceivingHours.txtSWedOpen1.setText("");
        ShippingReceivingHours.txtSThuOpen1.setText("");
        ShippingReceivingHours.txtSFriOpen1.setText("");
        ShippingReceivingHours.txtSSatOpen1.setText("");

        ShippingReceivingHours.txtSSunOpen2.setText("");
        ShippingReceivingHours.txtSMonOpen2.setText("");
        ShippingReceivingHours.txtSTueOpen2.setText("");
        ShippingReceivingHours.txtSWedOpen2.setText("");
        ShippingReceivingHours.txtSThuOpen2.setText("");
        ShippingReceivingHours.txtSFriOpen2.setText("");
        ShippingReceivingHours.txtSSatOpen2.setText("");

        ShippingReceivingHours.txtSSunClose1.setText("");
        ShippingReceivingHours.txtSMonClose1.setText("");
        ShippingReceivingHours.txtSTueClose1.setText("");
        ShippingReceivingHours.txtSWedClose1.setText("");
        ShippingReceivingHours.txtSThuClose1.setText("");
        ShippingReceivingHours.txtSFrClose1.setText("");
        ShippingReceivingHours.txtSSatClose1.setText("");

        ShippingReceivingHours.txtSSunClose2.setText("");
        ShippingReceivingHours.txtSMonClose2.setText("");
        ShippingReceivingHours.txtSTueClose2.setText("");
        ShippingReceivingHours.txtSWedClose2.setText("");
        ShippingReceivingHours.txtSThuClose2.setText("");
        ShippingReceivingHours.txtSFrClose2.setText("");
        ShippingReceivingHours.txtSSatClose2.setText("");

        ShippingReceivingHours.txtSSameClose1.setText("");
        ShippingReceivingHours.txtSSameClose2.setText("");
        ShippingReceivingHours.txtSSameOpen1.setText("");
        ShippingReceivingHours.txtSSameOpen2.setText("");
    }

}

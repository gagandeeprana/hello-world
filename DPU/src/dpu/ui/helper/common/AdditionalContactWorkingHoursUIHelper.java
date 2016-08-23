/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.ui.helper.common;

import dpu.ui.common.AdditionalContactWorkingHours;
import static dpu.ui.common.AdditionalContactWorkingHours.txtSunOpen1;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import properties.TimeConstants;

/**
 *
 * @author gagandeep.rana
 */
public class AdditionalContactWorkingHoursUIHelper {

    public static MaskFormatter mask = null;

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
}

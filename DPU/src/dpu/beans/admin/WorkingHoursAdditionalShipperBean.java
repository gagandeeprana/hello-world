/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.beans.admin;

/**
 *
 * @author jagvir
 */
public class WorkingHoursAdditionalShipperBean {

    private int workingId;
    private String workingDay;
    private int is24Hrs;
    private int additionalShipperId;
    private String open1;
    private String close1;
    private String open2;
    private String close2;
    private String type;

    public WorkingHoursAdditionalShipperBean() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public WorkingHoursAdditionalShipperBean(String workingDay, String open1, String close1, String open2, String close2, int is24Hrs, String type) {
        this.workingDay = workingDay;
        this.is24Hrs = is24Hrs;
        this.open1 = open1;
        this.close1 = close1;
        this.open2 = open2;
        this.close2 = close2;
        this.type = type;
    }

    public int getWorkingId() {
        return workingId;
    }

    public void setWorkingId(int workingId) {
        this.workingId = workingId;
    }

    public String getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(String workingDay) {
        this.workingDay = workingDay;
    }

    public int getIs24Hrs() {
        return is24Hrs;
    }

    public void setIs24Hrs(int is24Hrs) {
        this.is24Hrs = is24Hrs;
    }

    public int getAdditionalShipperId() {
        return additionalShipperId;
    }

    public void setAdditionalShipperId(int additionalShipperId) {
        this.additionalShipperId = additionalShipperId;
    }

    public String getOpen1() {
        return open1;
    }

    public void setOpen1(String open1) {
        this.open1 = open1;
    }

    public String getClose1() {
        return close1;
    }

    public void setClose1(String close1) {
        this.close1 = close1;
    }

    public String getOpen2() {
        return open2;
    }

    public void setOpen2(String open2) {
        this.open2 = open2;
    }

    public String getClose2() {
        return close2;
    }

    public void setClose2(String close2) {
        this.close2 = close2;
    }

}

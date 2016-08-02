package dpu.beans.admin;

public class PowerUnitBean {

    private int unitNo;
    private String status;
    private String powerUnitClass;
    private int ownerId;
    private String VIN;
    private String make;
    private String model;
    private int year;
    private String plateNo;
    private String jurisdiction;
    private int tareWeight;
    private String rgw;
    private int trackingId;
    private String currentOdometer;
    private String equipmentType;
    private int terminalId;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPowerUnitClass() {
        return powerUnitClass;
    }

    public void setPowerUnitClass(String powerUnitClass) {
        this.powerUnitClass = powerUnitClass;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(int unitNo) {
        this.unitNo = unitNo;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public int getTareWeight() {
        return tareWeight;
    }

    public void setTareWeight(int tareWeight) {
        this.tareWeight = tareWeight;
    }

    public String getRgw() {
        return rgw;
    }

    public void setRgw(String rgw) {
        this.rgw = rgw;
    }

    public int getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(int trackingId) {
        this.trackingId = trackingId;
    }

    public String getCurrentOdometer() {
        return currentOdometer;
    }

    public void setCurrentOdometer(String currentOdometer) {
        this.currentOdometer = currentOdometer;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public int getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(int terminalId) {
        this.terminalId = terminalId;
    }

}

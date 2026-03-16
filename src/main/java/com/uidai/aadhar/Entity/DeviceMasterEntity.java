package com.uidai.aadhar.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import lombok.Data;

//@Data
@Entity
@Table(name = "uidai_device_master")
public class DeviceMasterEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "device_serial_no", length = 100)
    private String serialNo;

    @Column(name = "device_mac_address", length = 100)
    private String macAddress;
    
    @Column(name = "device_make", length = 100)
    private String deviceMake;
    
    @Column(name = "device_model", length = 100)
    private String deviceModel;
    
    @Column(name = "device_si_name", length = 100)
    private String deviceSiName;
    
    @Column(name = "district_name", length = 100)
    private String districtName;
    
    @Column(name = "vkid", length = 100)
    private String vkid;
    
    @Column(name = "machine_id", length = 100)
    private String machineId;
    
    @Column(name = "station_id", length = 100)
    private String stationId;
    
    @Column(name = "registration_date")
    private LocalDate registrationDate;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @Column(name = "is_active")
    private Integer isActive;
    
    @Column(name = "operator_mapped")
    private String operatoMapped;

	public DeviceMasterEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public String getDeviceMake() {
		return deviceMake;
	}

	public void setDeviceMake(String deviceMake) {
		this.deviceMake = deviceMake;
	}

	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	public String getDeviceSiName() {
		return deviceSiName;
	}

	public void setDeviceSiName(String deviceSiName) {
		this.deviceSiName = deviceSiName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getVkid() {
		return vkid;
	}

	public void setVkid(String vkid) {
		this.vkid = vkid;
	}

	public String getMachineId() {
		return machineId;
	}

	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public String getOperatoMapped() {
		return operatoMapped;
	}

	public void setOperatoMapped(String operatoMapped) {
		this.operatoMapped = operatoMapped;
	}

	@Override
	public String toString() {
		return "DeviceMasterEntity [id=" + id + ", serialNo=" + serialNo + ", macAddress=" + macAddress
				+ ", deviceMake=" + deviceMake + ", deviceModel=" + deviceModel + ", deviceSiName=" + deviceSiName
				+ ", districtName=" + districtName + ", vkid=" + vkid + ", machineId=" + machineId + ", stationId="
				+ stationId + ", registrationDate=" + registrationDate + ", updatedAt=" + updatedAt + ", isActive="
				+ isActive + ", operatoMapped=" + operatoMapped + "]";
	}

	public DeviceMasterEntity(Long id, String serialNo, String macAddress, String deviceMake, String deviceModel,
			String deviceSiName, String districtName, String vkid, String machineId, String stationId,
			LocalDate registrationDate, LocalDateTime updatedAt, Integer isActive, String operatoMapped) {
		super();
		this.id = id;
		this.serialNo = serialNo;
		this.macAddress = macAddress;
		this.deviceMake = deviceMake;
		this.deviceModel = deviceModel;
		this.deviceSiName = deviceSiName;
		this.districtName = districtName;
		this.vkid = vkid;
		this.machineId = machineId;
		this.stationId = stationId;
		this.registrationDate = registrationDate;
		this.updatedAt = updatedAt;
		this.isActive = isActive;
		this.operatoMapped = operatoMapped;
	}
    
}

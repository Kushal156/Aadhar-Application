package com.uidai.aadhar.DTO;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class ClientEODRequest {

	private Integer machineNo;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate date;
	
	public Integer getMachineNo() {
		return machineNo;
	}
	public void setMachineNo(Integer machineNo) {
		this.machineNo = machineNo;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "ClientEODRequest [machineNo=" + machineNo + ", date=" + date + "]";
	}
	
	
}

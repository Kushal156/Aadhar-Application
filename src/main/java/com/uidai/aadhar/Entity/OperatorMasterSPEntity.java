package com.uidai.aadhar.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;
import lombok.ToString;

@Entity
public class OperatorMasterSPEntity {

	@Id
	@Column(name = "OperatorID")
	private String operatorId;
	
	@Column(name = "Message")
	private String message;
	
	@Column(name = "Status")
	private Integer status;

	public OperatorMasterSPEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OperatorMasterSPEntity(String operatorId, String message, Integer status) {
		super();
		this.operatorId = operatorId;
		this.message = message;
		this.status = status;
	}

	@Override
	public String toString() {
		return "OperatorMasterSPEntity [operatorId=" + operatorId + ", message=" + message + ", status=" + status + "]";
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
}
package com.uidai.aadhar.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
//@Data
public class DashBoardEntity {

	@Id
	@Column(name = "entity_type")
	private String entityType;
	
	@Column(name = "active_count")
	private Integer activeCount;
	
	@Column(name = "inactive_count")
	private Integer inactiveCount;
	
	@Column(name = "total_count")
	private Integer totalCount;

	@Override
	public String toString() {
		return "DashBoardEntity [entityType=" + entityType + ", activeCount=" + activeCount + ", inactiveCount="
				+ inactiveCount + ", totalCount=" + totalCount + "]";
	}

	public DashBoardEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DashBoardEntity(String entityType, Integer activeCount, Integer inactiveCount, Integer totalCount) {
		super();
		this.entityType = entityType;
		this.activeCount = activeCount;
		this.inactiveCount = inactiveCount;
		this.totalCount = totalCount;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public Integer getActiveCount() {
		return activeCount;
	}

	public void setActiveCount(Integer activeCount) {
		this.activeCount = activeCount;
	}

	public Integer getInactiveCount() {
		return inactiveCount;
	}

	public void setInactiveCount(Integer inactiveCount) {
		this.inactiveCount = inactiveCount;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
	
	
}

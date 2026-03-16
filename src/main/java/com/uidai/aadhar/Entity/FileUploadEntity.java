package com.uidai.aadhar.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "uidai_eod_file_upload")
public class FileUploadEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "uidai_id", nullable = false, length = 50)
	private String uidaiID;

	@Column(name = "device_mac_address", nullable = false, length = 50)
	private String macID;

	@Column(name = "file_path", nullable = false, length = 150)
	private String filePath;
	
	@Column(name = "file_name")
	private String fileName;

	@Column(name = "upload_date")
    private LocalDate uploadDate;
	
	@Column(name = "createdAt")
    private LocalDateTime createdAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUidaiID() {
		return uidaiID;
	}

	public void setUidaiID(String uidaiID) {
		this.uidaiID = uidaiID;
	}

	public String getMacID() {
		return macID;
	}

	public void setMacID(String macID) {
		this.macID = macID;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public LocalDate getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(LocalDate uploadDate) {
		this.uploadDate = uploadDate;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "FileUploadEntity [id=" + id + ", uidaiID=" + uidaiID + ", macID=" + macID + ", filePath=" + filePath
				+ ", fileName=" + fileName + ", uploadDate=" + uploadDate + ", createdAt=" + createdAt + "]";
	}

	public FileUploadEntity(Integer id, String uidaiID, String macID, String filePath, String fileName,
			LocalDate uploadDate, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.uidaiID = uidaiID;
		this.macID = macID;
		this.filePath = filePath;
		this.fileName = fileName;
		this.uploadDate = uploadDate;
		this.createdAt = createdAt;
	}

	public FileUploadEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
}

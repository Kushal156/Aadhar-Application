package com.uidai.aadhar.DTO;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadRequestDTO {

	private String uidaiID;
	private String macID;
	private MultipartFile file;

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

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "FileUploadRequestDTO [uidaiID=" + uidaiID + ", macID=" + macID + ", file=" + file + "]";
	}

	public FileUploadRequestDTO(String uidaiID, String macID, MultipartFile file) {
		super();
		this.uidaiID = uidaiID;
		this.macID = macID;
		this.file = file;
	}

	public FileUploadRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}

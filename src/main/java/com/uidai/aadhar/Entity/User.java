package com.uidai.aadhar.Entity;

import java.time.LocalDateTime;

import javax.persistence.Column;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(schema = "[UIDAI]", name = "[login_master]")
//@Data
//@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, name = "agency_code")
    //private String username;
    private String agencyCode;
    private String password;
    private String role; // ADMIN, OPERATOR
    private Boolean active = true;
    private String email;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "user_created_datetime", 
            nullable = false, 
            updatable = false, 
            insertable = false)
    private LocalDateTime userCreatedDateTime;

    @Column(name = "password_updated_datetime")
    private LocalDateTime passwordUpdatedDateTime;

	@Override
	public String toString() {
		return "User [id=" + id + ", agencyCode=" + agencyCode + ", password=" + password + ", role=" + role
				+ ", active=" + active + ", name=" + name + ", userCreatedDateTime=" + userCreatedDateTime
				+ ", passwordUpdatedDateTime=" + passwordUpdatedDateTime + "]";
	}

	public User(Long id, String agencyCode, String password, String role, Boolean active,
			LocalDateTime userCreatedDateTime, LocalDateTime passwordUpdatedDateTime, String name, String email) {
		super();
		this.id = id;
		this.agencyCode = agencyCode;
		this.password = password;
		this.role = role;
		this.active = active;
		this.userCreatedDateTime = userCreatedDateTime;
		this.passwordUpdatedDateTime = passwordUpdatedDateTime;
		this.name = name;
		this.email = email;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAgencyCode() {
		return agencyCode;
	}

	public void setAgencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public LocalDateTime getUserCreatedDateTime() {
		return userCreatedDateTime;
	}

	public void setUserCreatedDateTime(LocalDateTime userCreatedDateTime) {
		this.userCreatedDateTime = userCreatedDateTime;
	}

	public LocalDateTime getPasswordUpdatedDateTime() {
		return passwordUpdatedDateTime;
	}

	public void setPasswordUpdatedDateTime(LocalDateTime passwordUpdatedDateTime) {
		this.passwordUpdatedDateTime = passwordUpdatedDateTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}


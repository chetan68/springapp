package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name="UserRoles")
public class UserRoles {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int role_id;
	
	private String authority;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="RegisterId")
	private Register reg;
	
	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public Register getReg() {
		return reg;
	}

	public void setReg(Register reg) {
		this.reg = reg;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}


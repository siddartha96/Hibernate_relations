package com.jsp.manytomany.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class CustomerDto  implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int c_id;
	private String c_name;
	private int c_accNo;
	private String c_accType;
	
	@ManyToMany(mappedBy = "custlist")
	private List<BankDto> banklist = new ArrayList<BankDto>();
	
	public List<BankDto> getBanklist() {
		return banklist;
	}

	public void setBanklist(List<BankDto> banklist) {
		this.banklist = banklist;
	}
	
	public CustomerDto() {
		
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public int getC_accNo() {
		return c_accNo;
	}

	public void setC_accNo(int c_accNo) {
		this.c_accNo = c_accNo;
	}

	public String getC_accType() {
		return c_accType;
	}

	public void setC_accType(String c_accType) {
		this.c_accType = c_accType;
	}

	
	
	
	

}

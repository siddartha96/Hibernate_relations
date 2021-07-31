package com.jsp.manytomany.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Bank")
public class BankDto  implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int b_id;
	private String b_name;
	private String b_branch;
	private String b_IFSC;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="bank_cust",joinColumns =@JoinColumn(name="b_id"), inverseJoinColumns = @JoinColumn(name = "c_id"))
	private List<CustomerDto>  custlist = new ArrayList<CustomerDto>();
	
	
	public List<CustomerDto> getCustlist() {
		return custlist;
	}

	public void setCustlist(List<CustomerDto> custlist) {
		this.custlist = custlist;
	}

	public BankDto() {
		
	}

	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getB_branch() {
		return b_branch;
	}

	public void setB_branch(String b_branch) {
		this.b_branch = b_branch;
	}

	public String getB_IFSC() {
		return b_IFSC;
	}

	public void setB_IFSC(String b_IFSC) {
		this.b_IFSC = b_IFSC;
	}
	
}

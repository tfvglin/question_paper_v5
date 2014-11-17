package edu.xidian.research.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SelMulOption {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer soID;

	private Character item;
	private String sqoption;
	private Integer optiontype;
	private Integer sqnum;
	public Integer getSoID() {
		return soID;
	}
	public void setSoID(Integer soID) {
		this.soID = soID;
	}
	public Character getItem() {
		return item;
	}
	public void setItem(Character item) {
		this.item = item;
	}
	public String getSqoption() {
		return sqoption;
	}
	public void setSqoption(String sqoption) {
		this.sqoption = sqoption;
	}
	public Integer getOptiontype() {
		return optiontype;
	}
	public void setOptiontype(Integer optiontype) {
		this.optiontype = optiontype;
	}
	public Integer getSqnum() {
		return sqnum;
	}
	public void setSqnum(Integer sqnum) {
		this.sqnum = sqnum;
	}
	
}

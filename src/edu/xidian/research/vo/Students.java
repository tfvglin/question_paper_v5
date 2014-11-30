package edu.xidian.research.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Students {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	private String stuname;
	private String stunum;
	private String cardid;
	private String studepartment;
	
	//@GeneratedValue(generator="sid")
	//@GenericGenerator(name="sid",strategy="assigned")
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getStunum() {
		return stunum;
	}
	public void setStunum(String stunum) {
		this.stunum = stunum;
	}
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getStudepartment() {
		return studepartment;
	}
	public void setStudepartment(String studepartment) {
		this.studepartment = studepartment;
	}
	

}

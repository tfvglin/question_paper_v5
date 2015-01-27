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
	private String sex;
	private String hukou;
	private String province;
	private String stumarjor;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHukou() {
		return hukou;
	}
	public void setHukou(String hukou) {
		this.hukou = hukou;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getStumarjor() {
		return stumarjor;
	}
	public void setStumarjor(String stumarjor) {
		this.stumarjor = stumarjor;
	}
	
	
}

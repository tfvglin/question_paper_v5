package edu.xidian.research.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class TextAnswer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer tID;
	private Integer pnum;
	private Integer qnum;
	private String tans;
	public Integer gettID() {
		return tID;
	}
	public void settID(Integer tID) {
		this.tID = tID;
	}
	public Integer getPnum() {
		return pnum;
	}
	public void setPnum(Integer pnum) {
		this.pnum = pnum;
	}
	public Integer getQnum() {
		return qnum;
	}
	public void setQnum(Integer qnum) {
		this.qnum = qnum;
	}
	public String getTans() {
		return tans;
	}
	public void setTans(String tans) {
		this.tans = tans;
	}
	

}

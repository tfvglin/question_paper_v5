package edu.xidian.research.vo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sqID;
	private String sque;
	private Integer sqtype;
	private Integer sqnum;
//	@OneToMany(mappedBy="selquestion")
//	private List<SelOption> solist;

	public Integer getSqID() {
		return sqID;
	}

	public void setSqID(Integer sqID) {
		this.sqID = sqID;
	}

	public String getSque() {
		return sque;
	}

	public void setSque(String sque) {
		this.sque = sque;
	}

	public Integer getSqtype() {
		return sqtype;
	}

	public void setSqtype(Integer sqtype) {
		this.sqtype = sqtype;
	}

	public Integer getSqnum() {
		return sqnum;
	}

	public void setSqnum(Integer sqnum) {
		this.sqnum = sqnum;
	}


	
	

}

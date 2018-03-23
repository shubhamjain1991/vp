package com.vp.enity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MessageCode implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mc_id")
	private Integer mcId;
	
	@Column(name="mc_title")
	private String mcTitle;
	
	@Column(name="mc_desc")
	private String mcDesc;

	public MessageCode(){
		super();
	}

	public Integer getMcId() {
		return mcId;
	}

	public void setMcId(Integer mcId) {
		this.mcId = mcId;
	}

	public String getMcTitle() {
		return mcTitle;
	}

	public void setMcTitle(String mcTitle) {
		this.mcTitle = mcTitle;
	}

	public String getMcDesc() {
		return mcDesc;
	}

	public void setMcDesc(String mcDesc) {
		this.mcDesc = mcDesc;
	}
}

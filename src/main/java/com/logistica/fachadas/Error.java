package com.logistica.fachadas;

import java.io.Serializable;

public class Error implements Serializable {

	private static final long serialVersionUID = -5667239534084555506L;
	
	private int code;
	private String display;

	public Error(int code, String display) {
		super();
		this.code = code;
		this.display = display;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

}

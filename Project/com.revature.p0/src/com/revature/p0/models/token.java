package com.revature.p0.models;

import java.time.Instant;

public class token {
	
	private String status;
	private int employee_id;
	private Instant timestamp;
	
	public token() {
		
	}
	public token(String status) {
		
		this.status = status;
		
	}
	public token(String status, int employee_id) {
		
		this(status);
		this.employee_id = employee_id;		
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public Instant getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "token [status=" + status + ", employee_id=" + employee_id + ", timestamp=" + timestamp + "]";
	}
	
}

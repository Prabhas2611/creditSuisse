package com.credit.suisse.creditSuisse.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class LogData {

	private String id;
	private String state;
	private String type;
	private String host;
	private Long timestamp;

	public LogData(String id, String state, String type, String host, Long timestamp) {
		this.id = id;
		this.state = state;
		this.type = type;
		this.host = host;
		this.timestamp = timestamp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

}

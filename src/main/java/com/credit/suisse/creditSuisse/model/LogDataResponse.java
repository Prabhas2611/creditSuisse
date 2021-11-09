package com.credit.suisse.creditSuisse.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class LogDataResponse {

	private Integer id;
	private String eventId;
	private Double eventDuration;
	private String type;
	private String host;
	private Boolean alert;

	public LogDataResponse(Integer id, String eventId, Double eventDuration, String type, String host, Boolean alert) {
		this.id = id;
		this.eventId = eventId;
		this.eventDuration = eventDuration;
		this.type = type;
		this.host = host;
		this.alert = alert;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public Double getEventDuration() {
		return eventDuration;
	}

	public void setEventDuration(Double eventDuration) {
		this.eventDuration = eventDuration;
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

	public Boolean getAlert() {
		return alert;
	}

	public void setAlert(Boolean alert) {
		this.alert = alert;
	}

}

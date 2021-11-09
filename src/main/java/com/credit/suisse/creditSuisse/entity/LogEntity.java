package com.credit.suisse.creditSuisse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Log_Table")
public class LogEntity {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "Event_ID")
	private String eventId;

	@Column(name = "Event_Duration")
	private Double eventDuration;

	@Column(name = "Type")
	private String type;

	@Column(name = "Host")
	private String host;

	@Column(name = "Alert")
	private Boolean alert;

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

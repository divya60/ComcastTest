package com.user.services;

import java.util.Calendar;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class PartnerDetails {

	private String partner_id;
	private int duration;
	private String ad_content;
	private Calendar date;
	private String message;

	@JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
	public int getDuration() {
		return duration;
	}

	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	public String getPartner_id() {
		return partner_id;
	}

	public void setPartner_id(String partner_id) {
		this.partner_id = partner_id;
	}

	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	public String getAd_content() {
		return ad_content;
	}

	public void setAd_content(String ad_content) {
		this.ad_content = ad_content;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@JsonIgnore
	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "PartnerDetails [partner_id=" + partner_id + ", duration="
				+ duration + ", ad_content=" + ad_content + ", message="
				+ message + "]";
	}

}

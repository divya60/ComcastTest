package com.user.services;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class CampaignPartner {
	private static Map<String, PartnerDetails> pdetails = new HashMap<String, PartnerDetails>();

	public void addPartner(PartnerDetails partnerDetails) {
		partnerDetails.setDate(Calendar.getInstance());
		pdetails.put(partnerDetails.getPartner_id(), partnerDetails);

	}

	public PartnerDetails getPartner(String id) {
		return pdetails.get(id);
	}

}

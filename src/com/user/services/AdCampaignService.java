package com.user.services;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ad")
public class AdCampaignService {

	CampaignPartner cPartner = new CampaignPartner();

	@GET
	@Path("/get/{partnerId}")
	@Produces(MediaType.APPLICATION_JSON)
	public PartnerDetails getPartner(@PathParam("partnerId") String partnerId) {
		try {
			PartnerDetails partner = cPartner.getPartner(partnerId);
			Calendar current = Calendar.getInstance();
			Calendar partnerTime = partner.getDate();
			partnerTime.add(Calendar.SECOND, partner.getDuration());
			if (current.compareTo(partnerTime) < 0) {
				System.out.println("If condition");
				return partner;
			}
			PartnerDetails errorMsg = new PartnerDetails();
			errorMsg.setMessage("The Ad is no long valid for :" + partnerId);
			return errorMsg;

		} catch (Exception e) {
			PartnerDetails errorMsg = new PartnerDetails();
			errorMsg.setMessage("Exception occured for" + partnerId);
			return errorMsg;

		}

	}

	@POST
	@Path("/post")
	@Consumes("application/json")
	public String createPaprtner(PartnerDetails pdr) {
		try {
			cPartner.addPartner(pdr);
		} catch (Exception e) {
			return "Error occured when creating partner";
		}

		return "success";

	}

}

package com.FCI.SWE.Controller;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


@Path("/")
@Produces("text/html")
public class MessageController {
	/**
	 * Action function to response to 
	 * send message to friends 
	 * user from datastore
	 * 
	 * @param sender
	 *            provided user name
	 * @param reciver
	 *            provided user will recive message
	 *  @param text
	 *            user message          
	 * @return page
	 */
	@POST
	@Path("/sendMessgae")
	@Produces("text/html")
	public String sendFriendRequest(@FormParam("sender") String sender,
			@FormParam("receiver") String receiver,@FormParam("text") String text) {
 
		String serviceUrl = "http://localhost:8888/rest/sending";
		String urlParameters = "sender=" + sender + "&receiver=" +receiver + "&text=" +text;
		String retJson = Connection.connect( serviceUrl, urlParameters, "POST",
				"application/x-www-form-urlencoded;charset=UTF-8");
		try {
 
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj; 
			if (object.get("Status").equals("OK"))
				return "Message Sent Successfully";
			else  
				return "User not found";
 
 
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
 
	}

	
}

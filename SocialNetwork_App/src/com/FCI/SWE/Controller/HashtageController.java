package com.FCI.SWE.Controller;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.FCI.SWE.Models.User;

@Path("/")
@Produces("text/html")
public class HashtageController {
	
	
	/**
	 * this is to take ur selected hashtag
	 * and get it from database
	 * @return 
	 */
	
	@POST
	@Path("/GetHashtag")
	public String getHashtag() {
		
		String serviceUrl = "http://localhost:8888/rest/CreatePostService";
		String urlParameters = "user_ID=" + User.getCurrentActiveUser().getId();
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST",
				"application/x-www-form-urlencoded;charset=UTF-8");
		JSONParser parser = new JSONParser();
		Object obj;
 		try {
			obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;
			if (object.get("Status").equals("OK"))
				return "Hashtage ";

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	

}

package com.FCI.SWE.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.mvc.Viewable;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.FCI.SWE.Models.User;
import com.google.appengine.labs.repackaged.org.json.JSONException;

@Path("/")
@Produces("text/html")
public class PageController {
	
	
	/**
	 * take the current active user and turn it to a new page
	 * @return jsp page
	 */
	@GET	
	@Path("/CreatePage")
	public Response CreatePage() {
		//System.out.println("username "+username);

		return Response.ok(new Viewable("/jsp/CreatePage") ).build();
	}
	
	/**
	 * this will turn u to the new jsp to enter the page name
	 * @return Jsp page
	 */
	@GET	
	@Path("/CreatePages")
	public Response CreatePages() {
		//System.out.println("username "+username);

		return Response.ok(new Viewable("/jsp/CreatePages") ).build();
	}
	
	/**
	 * this is when someone like a page 
	 * @return a jsp page that u have already liked the page 
	 */
	@GET
	@Path("/likepage")
	public Response likepage() {
		//System.out.println("username "+username);

		return Response.ok(new Viewable("/jsp/likepage") ).build();
	}
	
	/**
	 * 
	 * @param PageName
	 * @return
	 * @throws org.json.simple.parser.ParseException
	 * @throws JSONException
	 * @throws ParseException
	 */
	@POST
	@Path("/Likepage")
	@Produces(MediaType.TEXT_PLAIN)
	public String Like(@FormParam("PageName") String PageName
			) throws org.json.simple.parser.ParseException, JSONException, ParseException {

		String serviceUrl = "http://localhost:8888//rest/Liked";
		String urlParameters = "PageName=" + PageName +"&UserName=" + User.getCurrentActiveUser().getName() 
				;
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST",
				"application/x-www-form-urlencoded;charset=UTF-8");
		JSONParser parser = new JSONParser();
		Object obj;
		// System.out.println(retJson);
		obj = parser.parse(retJson);
		JSONObject object = (JSONObject) obj;
		Map<String, String> map = new HashMap<String, String>();
		if (object.get("Status").equals("OK")){
			
			return "Liked";
	
		}
		return "Failed";
		
	}
	
	/**
	 * @param PageName 
	 * @return Status created if the page created
	 *  	   Status Failed  if can't create the page 
	 * @throws org.json.simple.parser.ParseException
	 * @throws JSONException
	 * @throws ParseException
	 */
	@POST
	@Path("/CreatePages")
	@Produces(MediaType.TEXT_PLAIN)
	public String response(@FormParam("PageName") String PageName
			) throws org.json.simple.parser.ParseException, JSONException, ParseException {

		String serviceUrl = "http://localhost:8888//rest/CreateSuccesfully";
		String urlParameters = "&PageName=" + PageName +"&UserName=" + User.getCurrentActiveUser().getName();
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST",
				"application/x-www-form-urlencoded;charset=UTF-8");
		JSONParser parser = new JSONParser();
		Object obj;
		// System.out.println(retJson);
		obj = parser.parse(retJson);
		JSONObject object = (JSONObject) obj;
		Map<String, String> map = new HashMap<String, String>();
		if (object.get("Status").equals("OK")){
			
			return "Created";
	
		}
		return "Failed";
		
	}
	
	/**
	 * here we create the page post 
	 * @param PageName
	 * @param YourPost
	 * @return  String to check if the 
	 *  the post created or not
	 * @throws org.json.simple.parser.ParseException
	 * @throws JSONException
	 * @throws ParseException
	 */
	@POST
	@Path("/Write")
	@Produces(MediaType.TEXT_PLAIN)
	public String post(@FormParam("PageName") String PageName,
			@FormParam("YourPost") String YourPost
			) throws org.json.simple.parser.ParseException, JSONException, ParseException {

		String serviceUrl = "http://localhost:8888//rest/PostSuccesfully";
		String urlParameters = "&PageName=" + PageName +"&YourPost=" + YourPost 
				;
		String retJson = Connection.connect(serviceUrl, urlParameters, "POST",
				"application/x-www-form-urlencoded;charset=UTF-8");
		JSONParser parser = new JSONParser();
		Object obj;
		// System.out.println(retJson);
		obj = parser.parse(retJson);
		JSONObject object = (JSONObject) obj;
		Map<String, String> map = new HashMap<String, String>();
		if (object.get("Status").equals("OK")){			
			return "The post Created to the page";
	
		}
		return "Failed";
		
	}

}

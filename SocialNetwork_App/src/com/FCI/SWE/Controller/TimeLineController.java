package com.FCI.SWE.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.mvc.Viewable;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.FCI.SWE.Models.User;
import com.FCI.SWE.ServicesModels.PostEntity;
import com.FCI.SWE.ServicesModels.UserEntity;
import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
@Path("/")
@Produces("text/html")
public class TimeLineController {
	

	/*
	 * @param sender send message
	 * @param reciver who recive message 
	 * @param text message containt
	 * 
	 */

	@POST
	@Path("//showTimeLine")
	public String showtimeline(@FormParam("user_ID") int ID){
		JSONObject object = new JSONObject();
		Map<String,ArrayList>map=new HashMap<String,ArrayList>();
		ArrayList<UserEntity> Post = PostEntity.listOfPosts(ID);
		JSONArray arr=new JSONArray();
		
		for(UserEntity users:Post){
			object.put("post",Post.get(ID));
			
			arr.put(object);
		}
	  return arr.toString();

	}
	
	/**
	 * Action function to response to login request. This function will act as a
	 * controller part, it will calls login service to check user data and get
	 * user from datastore
	 * 
	 * @param 
	 *            take user name and return whos send to him friend request 
	 * @return  page view his pending friends
	 */
	@POST
	@Path("/TimeLine")
	@Produces("text/html")
	public Response timeLine() throws JSONException {
		String retJson = Connection.connect(
				"http://localhost:8888/rest/showTimeLine"
				//"http://localhost:8888/rest/LoginService"
				, "",
				"POST", "application/x-www-form-urlencoded;charset=UTF-8");
		JSONParser parser = new JSONParser();
		Object obj;
		HashMap<String,ArrayList<User>>listof=new HashMap<String,ArrayList<User>>();
		ArrayList<User>Posts=new ArrayList<User>();
		try {
			JSONArray arr=(JSONArray) parser.parse(retJson);
			obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;
			
		for(int i=0;i<arr.length();i++){
			
			object=(JSONObject) arr.get(i);
			Posts.add(User.parsInfo(object.toJSONString()));
		
		}
		listof.put("Posts",Posts);
			
			
			return Response.ok(new Viewable("/jsp/TimeLine", listof)).build();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}

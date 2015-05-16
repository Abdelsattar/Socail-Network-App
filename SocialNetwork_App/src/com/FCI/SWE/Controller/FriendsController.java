package com.FCI.SWE.Controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.mvc.Viewable;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.FCI.SWE.Models.User;
import com.FCI.SWE.ServicesModels.MessagEntity;
import com.FCI.SWE.ServicesModels.UserEntity;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class FriendsController {

	/*
	 * @param fname Friend name 
	 * @param uname User name
	 * his function to accept friend request take it param from controller 
	 */
	@POST
	@Path("/addfriend")
	public String Accept( @FormParam("friendName") String fname , @FormParam("userName") String uname){
		JSONObject object=new JSONObject();
		UserEntity user=new UserEntity();
		user.get(fname);
		if(user==null){
			object.put("Status", "Request declined");
		}
		else
		{
			object.put("Status", "Accpted ");
		//	UserEntity.addFriend(uname, fname);
		}
		return object.toString();
		
	}
	
	/**
	 * here show friends of u 
	 * @return
	 */
	@POST
	@Path("/showFriends")
	@Produces("text/html")
	public Response show() {
		String retJson = Connection.connect(
				"http://localhost:8888/rest/showfriends"
				//"http://localhost:8888/rest/LoginService"
				, "",
				"POST", "application/x-www-form-urlencoded;charset=UTF-8");
		JSONParser parser = new JSONParser();
		Object obj;
		HashMap<String,ArrayList<User>>listof=new HashMap<String,ArrayList<User>>();
		ArrayList<User>users=new ArrayList<User>();
		try {
			JSONArray arr=(JSONArray) parser.parse(retJson);
			obj = parser.parse(retJson);
			JSONObject object = (JSONObject) obj;
			
		for(int i=0;i<arr.size();i++){
			
			object=(JSONObject) arr.get(i);
			users.add(User.parsInfo(object.toJSONString()));
		
		}
		listof.put("usersList",users);
			
			
			return Response.ok(new Viewable("/jsp/UrRe", listof)).build();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		/*
		 * UserEntity user = new UserEntity(uname, email, pass);
		 * user.saveUser(); return uname;
		 */
		return null;

	}
	
	/**
	 * Action function to render Signup page, this function will be executed
	 * using url like this /rest/signup
	 * 
	 * @return sign up page
	 */
	@POST
	@Path("/doSearch")
	public Response search(@FormParam("userName") String uname , @FormParam("friendName") String fname){
		System.out.println(uname);
		// lma badoos 3 l button li f l form li hya mawgoda f home.jsp haygi hna 
		//ba3d kda haya5od l path da "http://localhost:8888/rest/search" w yro7 ynf7
		//f l user service 
		String serviceUrl = "http://localhost:8888/rest/search";
		String urlParameters = "userName=" + uname + "&friendName=" + fname ;
		 Connection.connect(serviceUrl, urlParameters, "POST",
				"application/x-www-form-urlencoded;charset=UTF-8");
		
		return Response.ok(new Viewable("/jsp/search_result")).build();
	}
	
}

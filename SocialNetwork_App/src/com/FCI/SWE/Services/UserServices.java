package com.FCI.SWE.Services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

import com.FCI.SWE.ServicesModels.MessagEntity;
import com.FCI.SWE.ServicesModels.UserEntity;
import com.google.appengine.labs.repackaged.org.json.JSONArray;

/**
 * This class contains REST services, also contains action function for web
 * application
 * 
 * @author Mohammed Abd EL-Sattar
 * @version 1.0.1
 * @since 2014-03-09
 *
 */
@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class UserServices {

		/**
	 * Registration Rest service, this service will be called to make
	 * registration. This function will store user data in data store
	 * 
	 * @param uname
	 *            provided user name
	 * @param email
	 *            provided user email
	 * @param pass
	 *            provided password
	 * @return Status json
	 */
	@POST
	@Path("/RegistrationService")
	public String registrationService(@FormParam("uname") String uname,
			@FormParam("email") String email, @FormParam("password") String pass) {
		UserEntity user = new UserEntity(uname, email, pass);
		user.saveUser();
		JSONObject object = new JSONObject();
		object.put("Status", "OK");
		return object.toString();
	}
	@POST
	@Path("/showfriends")
	public String shower(){
		JSONObject object = new JSONObject();
		Map<String,ArrayList>map=new HashMap<String,ArrayList>();
		ArrayList<UserEntity> user = UserEntity.listOfFriend();
		JSONArray arr=new JSONArray();
		
		for(UserEntity users:user){
			object.put("FNAME",users.getName());
			
			arr.put(object);
		}
		
		
		
	  return arr.toString();

	}
	/**
	 * Login Rest Service, this service will be called to make login process
	 * also will check user data and returns new user from datastore
	 * @param uname provided user name
	 * @param pass provided user password
	 * @return user in json format
	 */
	@POST
	@Path("/LoginService")
	public String loginService(@FormParam("uname") String uname,
			@FormParam("password") String pass) {
		System.out.println(uname+" "+pass);
		JSONObject object = new JSONObject();
		UserEntity user = UserEntity.getUser(uname, pass);
		if (user == null) {
			object.put("Status", "Failed");

		} else {
			object.put("Status", "OK");
			object.put("name", user.getName());
			object.put("email", user.getEmail());
			object.put("password", user.getPass());
			object.put("id", user.getId());
		}
		return object.toString();

	}
	/*
	 * this for send friend request
	 * and return userName if exist or null if not exist
	 * jason format =D
	 * */

	@POST
	@Path("/search") //hya de li hynfzha mn l usercontrol
	public String Search( @FormParam("friendName") String fname , @FormParam("userName") String uname){
		
		JSONObject object=new JSONObject();
		UserEntity user=new UserEntity();
		user.get(fname);
		if(user==null)
		{
			object.put("Status", "user not exist");
		}
		else
		{
			object.put("status", "user exist");
			UserEntity.sendfriendrequest(uname, fname);
		}
		return object.toString();
		
	}
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
	/*
	 * @param sender send message
	 * @param reciver who recive message 
	 * @param text message containt
	 * 
	 */
	@POST
	@Path("/sending")
	public String sendMessageService(@FormParam("sender") String sender,
			@FormParam("receiver") String receiver,@FormParam("text") String text) {
		JSONObject object = new JSONObject();
 
		/*to check the reciver is exist */
		UserEntity user = UserEntity.getUserByMail(receiver); 
		if(user == null ){
			object.put("Status", "Not Found");  
			return object.toString();
		}	 
		else{ 
			    MessagEntity msg = new MessagEntity(sender,receiver,text);
				object.put("Status", "OK");  
				msg.saveMsg();
		}
 
		return object.toString();
	}

}
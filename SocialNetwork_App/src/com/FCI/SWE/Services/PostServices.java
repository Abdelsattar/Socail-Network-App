package com.FCI.SWE.Services;

import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

import com.FCI.SWE.ServicesModels.PostEntity;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class PostServices {

	@POST
	@Path("/CreatePostService")
	public String createPost(@FormParam("user_ID") String userId,
			@FormParam("post") String post,
			@FormParam("privacy") String privacy,
			@FormParam("Feelings") String feelings) {
		String words[] = post.split(" ");
		String word="";
		ArrayList <String> hashTags = new ArrayList<String>();
		
		for(int i=0; i <words.length ; i++){
			word=words[i];
			if(word.charAt(i)=='#'){ 
				hashTags.add(words[i]);
			}
		}
		System.out.println();
		PostEntity postEntity = new PostEntity();
		postEntity.setFeeling(feelings);
		postEntity.setPost(post);
		postEntity.setUser_ID(Long.parseLong(userId));
		postEntity.setPrivacy(privacy);
		JSONObject json = new JSONObject();
		
		if(postEntity.savePost())
			json.put("Status", "Posted");
		else
			json.put("Status", "Failed");
		return json.toJSONString();
	}

}

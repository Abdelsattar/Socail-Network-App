package com.FCI.SWE.ServicesModels;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Transaction;

public class PostEntity {
	private String name;
	private static long user_ID;
	private String post;
	private String privacy;
	private String Feeling;
	
	public String getName(){
		return name;
	}
	
	public long getUser_ID(){
		return user_ID;
	}
	
	public String getPost(){
		return post;
	}
	
	public String getPrivacy(){
		return privacy;
	}
	
	public String getFeeling(){
		return Feeling;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setUser_ID(long user_ID){
		this.user_ID = user_ID;
	}
	
	public void setPost(String post){
		this.post = post;
	}
	
	public void setPrivacy(String privacy){
		this.privacy = privacy;
	}
	
	public void setFeeling(String Feeling){
		this.Feeling=Feeling;
	}
	
	public Boolean savePost() {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("Posts");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());

		Entity post = new Entity("posts", list.size() + 3);

		post.setProperty("name", this.name);
		post.setProperty("user_ID", this.user_ID);
		post.setProperty("post", this.post);
		post.setProperty("privacy", this.privacy);
		post.setProperty("Feeling", this.Feeling);
		
		if(datastore.put(post).isComplete())
			return true;
		else return false;

	}
	
	
	public static String get(String name) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("post");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		for (Entity entity : pq.asIterable()) {
			if (entity.getProperty("user_ID").toString().equals(user_ID)) {
				String returnedUser = new String(entity.getProperty("user_ID")
						.toString());
				return returnedUser;
			}
		}

		return null;
	}
	
	
	public static Boolean postView(String name, String post) {

		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Transaction txn = datastore.beginTransaction();
		Query gaeQuery = new Query("post");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());
		System.out.println("Size = " + list.size());

		try {
			Entity employee = new Entity("requests", list.size() + 3);

			employee.setProperty("name", name);
			employee.setProperty("post", post);

			employee.setProperty("Post", "true");

			System.out.println(datastore.put(employee).isComplete());
			txn.commit();
		} finally {
			if (txn.isActive()) {
				txn.rollback();
			}
		}
		return true;

	}

	
	

	public static ArrayList<PostEntity> listOfPost() {

		ArrayList<PostEntity> list = new ArrayList<PostEntity>();
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Transaction txn = datastore.beginTransaction();
		Query gaeQuery = new Query("post");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		for (Entity entity : pq.asIterable()) {
			if (entity.getProperty("post").toString().equals("post")
					&& entity.getProperty("post").toString()
							.equals("true")) {
				
				PostEntity user=new PostEntity();
				list.add(user);
			}
		}
		return list;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
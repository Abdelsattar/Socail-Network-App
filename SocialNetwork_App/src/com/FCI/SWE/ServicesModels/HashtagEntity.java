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

public class HashtagEntity {
	private static long Post_ID;
	private static String Hashtag;
	private static int Occerance;
	private static long Hashtag_ID;
	
	public String getHashtag(){
		return Hashtag;
	}
	
	public long getPost_ID(){
		return Post_ID;
	}
	
	public int getOccerance(){
		return Occerance;
	}
	
	public void setHashtag(String Hashtag){
		this.Hashtag = Hashtag;
	}
	
	public void setOccerance(int Occerance){
		this.Occerance = Occerance;
	}
	
	public Boolean saveHashtag() {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("Hashtag");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());

		Entity Hashtag = new Entity("Hashtag", list.size() + 3);

		Hashtag.setProperty("Hashtag", this.Hashtag);
		Hashtag.setProperty("Post_ID",this.Post_ID);
		Hashtag.setProperty("Occerance",1);
		
		boolean check = UpdateHashtag();
		if(!check){
			if(datastore.put(Hashtag).isComplete())
				return true;
			else return false;
		}
		return true;

	}
	
	
	public static String get(String name) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("Hashtag");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		for (Entity entity : pq.asIterable()) {
			if (entity.getProperty("Post_ID").toString().equals(Post_ID)) {
				String returnedUser = new String(entity.getProperty("Post_ID")
						.toString());
				return returnedUser;
			}
		}

		return null;
	}
	
	
	public static Boolean HashtagView(String Hashtag, long Post_ID) {
		
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Transaction txn = datastore.beginTransaction();
		Query gaeQuery = new Query("Hashtag");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		List<Entity> list = pq.asList(FetchOptions.Builder.withDefaults());
		System.out.println("Size = " + list.size());

		try {
			Entity employee = new Entity("Hashtag", list.size() + 4);

			employee.setProperty("Post_ID", Post_ID);
			employee.setProperty("Hashtag", Hashtag);
			employee.setProperty("Occerance", Occerance);

			employee.setProperty("Hashtag", "true");

			System.out.println(datastore.put(employee).isComplete());
			txn.commit();
		} finally {
			if (txn.isActive()) {
				txn.rollback();
			}
		}
		return true;

	}	

	public static ArrayList<HashtagEntity> listOfHashtag() {

		ArrayList<HashtagEntity> list = new ArrayList<HashtagEntity>();
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Transaction txn = datastore.beginTransaction();
		Query gaeQuery = new Query("Hashtag");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		for (Entity entity : pq.asIterable()) {
			if (entity.getProperty("Hashtag").toString().equals("Hashtag")
					&& entity.getProperty("Hashtag").toString()
							.equals("true")) {
				
				HashtagEntity user=new HashtagEntity();
				list.add(user);
			}
		}
		return list;
	}

	
	
	public boolean UpdateHashtag(){
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Query gaeQuery = new Query("Hashtag");
		PreparedQuery pq = datastore.prepare(gaeQuery);
		
		for (Entity entity : pq.asIterable()) {
			if (entity.getProperty("Hashtag_ID").toString().equals(Hashtag_ID)) {
				long ID = (long)entity.getProperty("Occerance");
				 ID++;
				 entity.setProperty("Occerance",ID);
				 // here we want to update the Occerance by a quewry
				 /*
				 if(datastore.put(Hashtag).isComplete())
						return true;
					else return false;
					*/
			}
		}

		return false;
	}
	
	
	
	
	
	
	
	
	
}
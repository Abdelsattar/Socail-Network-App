package com.FCI.SWE.ServicesModelsTests;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.FCI.SWE.ServicesModels.ConnectHashtagAndPost;

public class ConnectHashtagAndPostTest {
	ConnectHashtagAndPost connect = new ConnectHashtagAndPost();
	
  @Test
  public void get() {
    //throw new RuntimeException("Test not implemented");
  }


  @Test
  public void setConnect_ID() {
	  connect.setConnect_ID(20);
	  long bakID = getConnect_ID();
	  Assert.assertEquals(20, bakID);
	  
  }

  @Test
  public void setHashtag_ID() {
	  connect.setHashtag_ID(15);
	  long bakID = getHashtag_ID();
	  Assert.assertEquals(15, bakID);
  }

  @Test
  public void setPost_ID() {
	  connect.setPost_ID(10);
	  long bakID = getPost_ID();
	  Assert.assertEquals(10, bakID);
   // throw new RuntimeException("Test not implemented");
  }
  
  
  @Test
  public void listOfPost() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void postView() {
	  boolean check = connect.postView(0, 12);
	  Assert.assertEquals(true, check);
  }
  

  @Test
  public void saveAll() {
	  boolean check = connect.postView(0, 12);
	  Assert.assertEquals(true, check);
  }
  
  @Test
  public long getConnect_ID() {
	  return connect.getConnect_ID();
  }

  @Test
  public long getHashtag_ID() {
	  return connect.getHashtag_ID();
	 }

  @Test
  public long getPost_ID() {
	  return connect.getPost_ID();
  }
  
}

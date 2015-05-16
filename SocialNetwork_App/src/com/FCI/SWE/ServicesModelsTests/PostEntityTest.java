package com.FCI.SWE.ServicesModelsTests;


import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import com.FCI.SWE.ServicesModels.PostEntity;
import com.FCI.SWE.ServicesModels.UserEntity;

public class PostEntityTest {
	
	//private static final String Assert = null;
	public	ArrayList<UserEntity> Arr;
	public	ArrayList<UserEntity> Res;
	PostEntity PE= new PostEntity();
	
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }

  @Test
  public void get() {
	  String result = PE.get("Mai");
	  Assert.assertEquals(true, result);

    throw new RuntimeException("Test not implemented");
  }

  
  @Test
  public void savePost() {
	  PE.setFeeling("LOL");
	  PE.setPost("Here the first Post" );
	  PE.setPost_ID(28);
	  PE.setPrivacy("Private");
	  PE.setUser_ID(500);
	  boolean res= PE.savePost();
	  Assert.assertEquals(true, res);
  }

  @Test
  public void getFeeling() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getPost() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getPost_ID() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getPrivacy() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getUser_ID() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void listOfPosts() {
		 Res= PE.listOfPosts(28);
		 Assert.assertEquals(Arr, Res);

    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void postView() {
		 boolean result = PostEntity.postView("Mai", "Mmmmm");
		 Assert.assertEquals(true, result);
    //throw new RuntimeException("Test not implemented");
  }  
  /*
  @Test
  public void setFeeling() {
	  //Assert.assertEquals(PE.setFeeling(Feeling));

    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void setPost() {
	  //Assert.assertEquals(PE.setPost(post));

    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void setPost_ID() {
	  //Assert.assertEquals(PE.setPost_ID(Post_ID));

 throw new RuntimeException("Test not implemented");
  }

  @Test
  public void setPrivacy() {
	  //Assert.assertEquals(PE.setPrivacy(privacy));

   throw new RuntimeException("Test not implemented");
  }

  @Test
  public void setUser_ID() {
	  //Assert.assertEquals(PE.setUser_ID(user_ID));

    throw new RuntimeException("Test not implemented");
  }
  */
}

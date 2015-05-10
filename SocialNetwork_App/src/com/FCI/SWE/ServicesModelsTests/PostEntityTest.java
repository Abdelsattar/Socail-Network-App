package com.FCI.SWE.ServicesModels;

import junit.framework.Assert;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import com.FCI.SWE.ServicesModels.PostEntity;

public class PostEntityTest {
	//private static final String Assert = null;
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
		 boolean result = PE.listOfPosts("18");
		 Assert.assertEquals(true, result);

    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void postView() {
		 boolean result = PE.postView("Mai", "Mmmmm");
		 Assert.assertEquals(true, result);

    //throw new RuntimeException("Test not implemented");
  }

  @Test(expectedExceptions=ArithmeticException.class)
  public void savePost() {
    throw new RuntimeException("Test not implemented");
  }

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
}

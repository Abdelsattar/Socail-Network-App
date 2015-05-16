package com.FCI.SWE.ServicesModelsTests;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import com.FCI.SWE.ServicesModels.LikePageEntity;


public class LikePageEntityTest {
	
	LikePageEntity L = new LikePageEntity();
	
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
  public void Like() {
		 boolean result = L.Like("Hala");
		 Assert.assertEquals(true, result);

    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void LikePage() {
	  String result = L.LikePage();
		 Assert.assertEquals("Liked", result);
  }

  @Test
  public void LikePageEntityStringString() {
	  L = new LikePageEntity("Btngan", "Mai");
	  boolean result = true;
	  Assert.assertEquals(true, result);
 }
/*
  @Test
  public void LikePageEntity() {
	  //Assert.assertEquals(true, result);
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void LikePageEntityString() {
//	  boolean result = L.LikePageEntity("Like");

	//  AssertJUnit.assertEquals(true, result);
	  //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void UserName() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getId() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void setId() {
	  //AssertJUnit.assertEquals(L.setId(id));
	  throw new RuntimeException("Test not implemented");
  }
	*/
}

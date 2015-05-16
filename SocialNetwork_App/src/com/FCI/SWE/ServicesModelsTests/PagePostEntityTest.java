package com.FCI.SWE.ServicesModelsTests;

import com.FCI.SWE.ServicesModels.PagePostEntity;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class PagePostEntityTest {
	
	PagePostEntity PP= new PagePostEntity();
	
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
  public void WritePost() {
	  PP.id = 300;
	  PP.PageName = "Barca";
	  PP.Postpage = "this will post to the page";
	  boolean res= PP.WritePost();
	  Assert.assertEquals(true, res);
	  }

}

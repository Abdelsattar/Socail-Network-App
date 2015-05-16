package com.FCI.SWE.ServicesModelsTests;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import com.FCI.SWE.ServicesModels.LikePageEntity;

import com.FCI.SWE.ServicesModels.PageEntity;

@Test
public class PageEntityTest {
	
	PageEntity P= new PageEntity();
	
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
  public void CreatePage() {
	  P.PageName = "Barca";
	  P.UserName = "Mido";
	  boolean res=  P.CreatePage();
	  Assert.assertEquals(true, res);
	  
  }
}

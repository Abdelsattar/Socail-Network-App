package com.FCI.SWE.ServicesModelsTests;
import junit.framework.Assert;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import com.FCI.SWE.ServicesModels.PageEntity;

public class PagePostEntityTest {
	PageEntity PP;
	
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
  /*

  @Test
  public void PagePostEntityStringString() {
	  Assert.assertEquals(PP.PagePostEntity(PageName, Postpage));

    //throw new RuntimeException("Test not implemented");
  }

  @Test(expectedExceptions=ArithmeticException.class)
  public void PagePostEntity() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void PagePostEntityString() {
	  Assert.assertEquals(PP.PagePostEntity(Postpage));

    //throw new RuntimeException("Test not implemented");
  }

  @Test(expectedExceptions=ArithmeticException.class)
  public void WritePost() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getId() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getPage() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getPagePost() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void setId() {
	  Assert.assertEquals(PP.setId(id));

    //throw new RuntimeException("Test not implemented");
  }*/
}

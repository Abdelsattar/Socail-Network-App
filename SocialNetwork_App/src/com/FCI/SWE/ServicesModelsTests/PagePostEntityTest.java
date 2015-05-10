package com.FCI.SWE.ServicesModels;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class PagePostEntityTest {
	private static final String Assert = null;
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
  public void PagePostEntityStringString() {
		 boolean result = PP.PagePostEntity("yadiElNela", "PostGamil");

	  Assert.assertEquals(true, result);

    //throw new RuntimeException("Test not implemented");
  }

  @Test(expectedExceptions=ArithmeticException.class)
  public void PagePostEntity() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void PagePostEntityString() {
		 boolean result = PP.PagePostEntity("PostGamil");

	  Assert.assertEquals(true, result);

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
	  //Assert.assertEquals(PP.setId(id));

    throw new RuntimeException("Test not implemented");
  }
}

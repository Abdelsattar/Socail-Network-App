package com.FCI.SWE.ServicesModels;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import com.google.appengine.api.search.query.QueryParser.term_return;

public class MessagEntityTest {
	private static final String Assert = null;
	MessagEntity M= new MessagEntity();
	
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
  public void MessagEntity() {
		 boolean result = M.MessagEntity("Mai", "Bor3i", "Blabla");

	  Assert.assertEquals(true, result);
    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getID() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getReceiver() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getSender() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getText() {
    throw new RuntimeException("Test not implemented");
  }

  @Test(expectedExceptions=ArithmeticException.class)
  public void saveMsg() {
    //throw new RuntimeException("Test not implemented");
  }

  @Test
  public void setId() {
	  //Assert.assertEquals(M.setId(id));
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void setReceiver() {
	  //Assert.assertEquals(M.setText(receiver));
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void setSender() {
	  //Assert.assertEquals(M.setText(sender));
	  throw new RuntimeException("Test not implemented");
  }

  @Test
  public void setText() {
	 // Assert.assertEquals(M.setText(text));
	  throw new RuntimeException("Test not implemented");
  }
}

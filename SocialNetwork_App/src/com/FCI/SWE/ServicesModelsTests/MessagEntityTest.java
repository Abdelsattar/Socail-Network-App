package com.FCI.SWE.ServicesModelsTests;

import com.FCI.SWE.ServicesModels.MessagEntity;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class MessagEntityTest {
	
  MessagEntity M =new MessagEntity("Mai", "Bor3i", "Blabla");
	
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
  
  @Test(expectedExceptions=ArithmeticException.class)
  public void saveMsg() {
    //throw new RuntimeException("Test not implemented");
  }
  
  
/*
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
*/
 
/*
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
*/
	}

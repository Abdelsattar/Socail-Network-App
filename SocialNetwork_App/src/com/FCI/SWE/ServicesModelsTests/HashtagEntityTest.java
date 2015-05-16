package com.FCI.SWE.ServicesModelsTests;

import java.util.ArrayList;





import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.FCI.SWE.ServicesModels.HashtagEntity;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class HashtagEntityTest {


	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
	HashtagEntity Hash =new HashtagEntity();
	@BeforeClass
	  public void setUp() {
	    helper.setUp();
	  }
	
	@AfterClass  
	public void tearDown() {
	    helper.tearDown();
	  }
	

  @Test
  public void HashtagView() {
	  
	 boolean result = Hash.HashtagView("#lol", 0);
	  Assert.assertEquals(true, result);
	  
   // throw new RuntimeException("Test not implemented");
  }
  

  @Test
  public void saveHashtag() {
	  boolean lol =Hash.saveHashtag("#LOL");
	  Assert.assertEquals(true, lol);
	  //throw new RuntimeException("Test not implemented");
  }



  @Test
  public void UpdateHashtag() {
	  long lol =Hash.UpdateHashtag("12");
	  Assert.assertEquals(3, lol);
  }
  
  /*
  @Test
  public void listOfHashtag() {
    throw new RuntimeException("Test not implemented");
  }
*/

  @DataProvider(name = "Hashtags")
	public static Object[] getUserStringTest() {
		Object[] x = { "#LOL","#lol","#gd3","#yarb"};
		return x;
	}

  @Test(dataProvider = "Users")
  public void trendHashtags(ArrayList arr) {
	  ArrayList<String> backArray = new ArrayList<>();
	  Assert.assertEquals(arr, backArray);
  }
  
  @Test 
  public void fail(){
	  int i= 5+9;
	  Assert.assertEquals(12 ,i);
  }
  @Test
  public void success(){
	  int i= 5+9;
	  Assert.assertEquals(14 ,i);
  }
}

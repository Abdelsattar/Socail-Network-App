package com.FCI.SWE.ServicesModelsTests;



import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import com.FCI.SWE.ServicesModels.UserEntity;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class UserEntityTest {
	
	private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
	UserEntity user =new UserEntity();
	
	
	
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
  	@BeforeClass
  	public void setUp() {
	  helper.setUp();
  	}

  	@AfterClass  
  	public void tearDown() {
  		helper.tearDown();
  	}


  	@Test
    public void UserEntityStringStringString() {
	  throw new RuntimeException("Test not implemented");
  	}

  @Test
  	public void getUserByMail() {
	  throw new RuntimeException("Test not implemented");
  	}

  
     @Test
  	public void listOfFriend() {

    	 throw new RuntimeException("Test not implemented");
     }
  
  

   @Test
    public void saveUser() {
	  boolean out =  user.saveUser();
		Assert.assertEquals(true,out);
	
  }

	/*** test send friend request  *************/
	@DataProvider(name = "Users")
	public static Object[][] getUserStringTest() {
		Object[][] x = { { false, "ahmed", "Ali" }, { false, "ibrahim", "Ali" }, { true, "abdo", "Mai"} };
		return x;
	}

	@Test(dataProvider = "Users")
	public void sendfriendrequest(boolean result, String uName, String fName) {
		boolean out =  user.sendfriendrequest(uName, fName);
		Assert.assertEquals(result,out);

		// throw new RuntimeException("Test not implemented");
	}

  @Test
  	public void setId() {
	  long ID = 9512;
	  user.setId(ID);
	  Assert.assertEquals(ID, user.getId());
    //throw new RuntimeException("Test not implemented");
  }
}

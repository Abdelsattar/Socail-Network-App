package com.FCI.SWE.ServicesModelsTests;

import javax.swing.GroupLayout.Group;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.FCI.SWE.ServicesModels.GroupEntity;

public class GroupEntityTest {
	GroupEntity group = new GroupEntity();

	
 @Test(dependsOnGroups = { "setter.*"})
  public void saveGroup() {
	  boolean result = group.saveGroup();
	  Assert.assertEquals(true, result);
  }

  @Test
  public String getDesc() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public String  getName() {
	 return group.getName();
   }

  @Test
  public long getOwnerId() {
	  return group.getOwnerId();
  }

  @Test
  public String  getPrivacy() {
	  return group.getPrivacy();
  }


  
  @Test(groups = { "setter" })
  public void setDescription() {
	  String desc = " the Group is for FCI Student Only";
	  group.setDescription(desc);
	  Assert.assertEquals(desc,getDesc());
  }

  @Test(groups = { "setter" })
  public void setName() {
	  String Name = "FCI ECOM";
	  group.setName(Name);
	  Assert.assertEquals(Name,getName());
  }

  @Test(groups = { "setter" })
  public void setOwnerId() {
	  long ID = 9512;
	  group.setOwnerId(ID);
	  Assert.assertEquals(ID,getOwnerId());
  }

  @Test(groups = { "setter" })
  public void setPrivacy() {
	  String Privcy = "Private";
	  group.setName(Privcy);
	  Assert.assertEquals(Privcy,getPrivacy());
  }
  
}

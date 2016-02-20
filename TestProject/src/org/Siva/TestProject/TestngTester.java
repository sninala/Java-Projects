package org.Siva.TestProject;

import org.testng.annotations.Test;

import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.*;

import org.Siva.TestProject.TestDataManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestngTester {
	private TestDataManager testdtMgr = new TestDataManager();
	@Test //default enable=true
	public void test1() {
		List<String> testData = null;
		try {
			testData = this.testdtMgr.getTestDataForTestCase("TC_001");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(testData);
		AssertJUnit.assertEquals(true, true);
	}

	@Test(enabled = true)
	public void test2() {
		List<String> testData = null;
		try {
			testData = this.testdtMgr.getTestDataForTestCase("TC_002");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(testData);
		AssertJUnit.assertEquals(true, true);
	}

	@Test(enabled = false)
	public void test3() {
		AssertJUnit.assertEquals(true, true);
	}
	
	@Test(description="selenium test", enabled=true)
	  public void OpenSite() {
		  WebDriver driver = new FirefoxDriver();
		  driver.get("https://www.google.co.in/");
		  System.out.println(driver.getCurrentUrl());
		  driver.close();
	  }

}


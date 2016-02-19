package org.Siva.TestProject;
import java.io.IOException;

import org.Siva.TestProject.TestDataManager;

public class TestDataTester {
	public static void main(String[] args) throws IOException{
		TestDataManager testData = new TestDataManager();
		System.out.println(testData.getTestDataForTestCase("TC_001"));
	}
}

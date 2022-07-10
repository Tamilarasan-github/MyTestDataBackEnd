package testScripts;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class T002_TestNG_Run
{

	public static void main(String[] args)
	{
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		Class cls=T001_Google.class;
		testng.setTestClasses(new Class[] { T001_Google.class, T003_Google.class });
		testng.setThreadCount(5);
		testng.addListener(tla);
		testng.run();


	}

}

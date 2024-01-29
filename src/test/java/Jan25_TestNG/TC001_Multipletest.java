package Jan25_TestNG;

import org.testng.annotations.Test;

public class TC001_Multipletest
{
	// to assign priority to the test
  @Test(groups = {"sanity"},priority=2)
  public void Test1() {
	  System.out.println("This is test1");
 }
  
  @Test(groups = {"sanity"},priority=1)//sanity is the sanity testing we used
  public void Test2() {
	  System.out.println("This is test2");
  }
  
  
  @Test(groups = {"sanity"},priority=3)
  public void Test3() {
	  System.out.println("This is test3");
  }
}

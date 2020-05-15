package base;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTestSuite{
 
  @BeforeClass
  public void beforeClass() {
	  System.out.println("\n BaseTestSuite -> BeforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("\n BaseTestSuite -> afterClass");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("\n BaseTestSuite -> beforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("\n BaseTestSuite -> afterSuite");
  }

}

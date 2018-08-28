//import junitparallel.TestClassA;
//import junitparallel.TestClassB;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ChromeTest.class, ChromeTest.class })
public class TestSuiteSimple2 {

}

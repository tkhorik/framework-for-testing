package junitparallel;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestClassA.class, TestClassB.class })
public class TestSuiteSimple {

}

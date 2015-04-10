package by.balan;

import by.balan.test.TestClass;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import java.sql.SQLException;

/**
 * Created by Ultrabook on 08.04.2015.
 */
public class Run {
    public static void main (String args[]) throws SQLException {
        TestRunner runner = new TestRunner();
        TestSuite suite = new TestSuite();
        suite.addTest(new TestClass("testOpenSession"));
        suite.addTest(new TestClass("testInsertToShip"));
        suite.addTest(new TestClass("testReadToShip"));
        suite.addTest(new TestClass("testInsertEqualsRead"));
        suite.addTest(new TestClass("testReadAll"));
        runner.doRun(suite);
    }

}

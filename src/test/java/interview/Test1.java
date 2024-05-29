package interview;

import org.testng.annotations.Test;
import utils.TableHelper;
import utils.TestCase;
import pageObject.W3schools;
import utils.JSONDataReader;

import java.util.List;

public class Test1 extends Base{

    protected static TableHelper helper = new TableHelper();

    @Test(description = "test different scenarios from json file on html table")
    public static void tc1() throws Exception {
        driver.get("http://www.w3schools.com/html/html_tables.asp");
        W3schools w3schools = new W3schools(driver);
        List<TestCase> testCases = JSONDataReader.getTestCasesFromJsonFile();

        for (TestCase testCase : testCases) {
            boolean result = helper.verifyTableCellText(w3schools.table, testCase.searchColumn, testCase.searchText, testCase.returnColumnText, testCase.expectedText);
            if (result) {
                System.out.println("Test passed: Actual text '" + helper.getTableCellTextByXpath(w3schools.table, testCase.searchColumn, testCase.searchText, testCase.returnColumnText) + "' matches expected text '" + testCase.expectedText + "'.");
            } else {
                throw new Exception("Test failed: Actual text '" + helper.getTableCellTextByXpath(w3schools.table, testCase.searchColumn, testCase.searchText, testCase.returnColumnText) + "' does not match expected text '" + testCase.expectedText + "'.");
            }
        }
   }
}

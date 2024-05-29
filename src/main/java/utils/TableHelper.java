package utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TableHelper {

    public String getTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText) {
        // Get all rows in the table
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        // Skip the header row (first row with <th>)
        for (int i = 1; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            // Get all cells in the row
            List<WebElement> cells = row.findElements(By.tagName("td"));

            // Check if the current row has enough cells to access the searchColumn and returnColumnText
            if (cells.size() > searchColumn && cells.size() > returnColumnText) {
                // Check if the search text matches the text in the specified search column
                if (cells.get(searchColumn).getText().equals(searchText)) {
                    // Return the text in the specified return column
                    return cells.get(returnColumnText).getText();
                }
            }
        }

        // Return null if the search text is not found
        return null;
    }

    public boolean verifyTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText, String expectedText) {
        try {
            String actualText = getTableCellText(table, searchColumn, searchText, returnColumnText);
            return actualText.equals(expectedText);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getTableCellTextByXpath(WebElement table, int searchColumn, String searchText, int returnColumnText) {
        // Construct the XPath expression
        String xpath = String.format(".//tr[td[%d]='%s']/td[%d]", searchColumn + 1, searchText, returnColumnText + 1);

        // Locate the cell using XPath
        WebElement cell = table.findElement(By.xpath(xpath));

        // Return the text of the found cell
        return cell.getText();
    }

    public static List<TestCase> extractTestCases(JsonArray jsonArray) {
        List<TestCase> testCases = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
            int searchColumn = jsonObject.get("searchColumn").getAsInt();
            String searchText = jsonObject.get("searchText").getAsString();
            int returnColumnText = jsonObject.get("returnColumnText").getAsInt();
            String expectedText = jsonObject.get("expectedText").getAsString();
            testCases.add(new TestCase(searchColumn, searchText, returnColumnText, expectedText));
        }
        return testCases;
    }
}

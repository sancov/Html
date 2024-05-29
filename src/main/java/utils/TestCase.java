package utils;

public class TestCase {
    public int    searchColumn;
    public String searchText;
    public int    returnColumnText;
    public String expectedText;

    public TestCase(int searchColumn, String searchText, int returnColumnText, String expectedText) {
        this.searchColumn     = searchColumn;
        this.searchText       = searchText;
        this.returnColumnText = returnColumnText;
        this.expectedText     = expectedText;
    }
}


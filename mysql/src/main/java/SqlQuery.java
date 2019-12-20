import dnl.utils.text.table.TextTable;
import framework.utiles.Printer;
import mysqlquery.DateFromQuery;
import mysqlquery.NumberTestsInBrowser;
import mysqlquery.TimeSpendOnTest;
import mysqlquery.UniqueTestOnProject;

import java.sql.SQLException;

public class SqlQuery {

    public static void main(String[] args) throws SQLException {
        TextTable timeSpendOnTestTable = sqlQueryTimeSpendOnTest();
        TextTable numberOfUniqueTestOnProject = sqlQueryNumberOfUniqueTests();
        TextTable allTestsAfterTheDate = sqlQueryAllTestAfterDate("2015-11-07");
        TextTable numberOfBrowsersTable = sqlQueryNumberOfBrowsers(new String[]{"firefox", "chrome"});
        Printer.printInFileTableWithName("Point 1: Minimal work time of tests", timeSpendOnTestTable);
        Printer.printInFileTableWithName("Point 2: Number of unique test on the project", numberOfUniqueTestOnProject);
        Printer.printInFileTableWithName("Point 3: All tests for every project after the date", allTestsAfterTheDate);
        Printer.printInFileTableWithName("Point 4: number tests in browser", numberOfBrowsersTable);
    }

    private static TextTable sqlQueryTimeSpendOnTest() throws SQLException {
        return new TimeSpendOnTest().getResultOfQuery().getTextTable();
    }

    private static TextTable sqlQueryNumberOfUniqueTests() throws SQLException {
        return new UniqueTestOnProject().getResultOfQuery().getTextTable();
    }

    private static TextTable sqlQueryAllTestAfterDate(String date) throws SQLException {
        return new DateFromQuery(date).getResultOfQuery().getTextTable();

    }

    private static TextTable sqlQueryNumberOfBrowsers(String[] browsers) throws SQLException {
        return new NumberTestsInBrowser(browsers).getResultOfQuery().getTextTable();
    }
}

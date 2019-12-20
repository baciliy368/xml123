import framework.utiles.Printer;
import mysqlquery.DateFromQuery;
import mysqlquery.NumberTestsInBrowser;
import mysqlquery.TimeSpendOnTest;
import mysqlquery.UniqueTestOnProject;

import java.sql.SQLException;

public class SqlQuery {

    public static void main(String[] args) throws SQLException {
        sqlQueryTimeSpendOnTest();
        sqlQueryNumberOfBrowsers();
        sqlQueryAllTestAfterDate("2015-11-07");
        sqlQueryNumberOfUniqueTests();
    }

    private static void sqlQueryTimeSpendOnTest() throws SQLException {
        Printer.printInFileTableWithName("Point 1: Minimal work time of tests",
                new TimeSpendOnTest().getResultOfQuery().getTextTable());
    }

    private static void sqlQueryNumberOfUniqueTests() throws SQLException {
        Printer.printInFileTableWithName("Point 2: Number of unique test on the project",
                new UniqueTestOnProject().getResultOfQuery().getTextTable());
    }

    private static void sqlQueryAllTestAfterDate(String date) throws SQLException {
        Printer.printInFileTableWithName(String.format("Point 3: All tests for every project after %s", date),
                new DateFromQuery(date).getResultOfQuery().getTextTable());
    }

    private static void sqlQueryNumberOfBrowsers() throws SQLException {
        Printer.printInFileTableWithName("Point 4: number tests in browser",
                new NumberTestsInBrowser(new String[]{"firefox", "chrome"}).getResultOfQuery().getTextTable());
    }
}

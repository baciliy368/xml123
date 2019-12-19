import mysqlquery.BrowserQuery;
import mysqlquery.DateFromQuery;
import mysqlquery.TimeSpendOnTest;
import mysqlquery.UniqueTestOnProject;
import java.sql.SQLException;

public class SqlQuery {

    private static void sqlQueryNumberOfBrowsers() throws SQLException {
        new BrowserQuery().printAnswerInLog();
    }

    private static void sqlQueryAllTestAfterDate() throws SQLException {
        new DateFromQuery().printAnswerInLog();
    }

    private static void sqlQueryTimeSpendOnTest() throws SQLException {
        new TimeSpendOnTest().printAnswerInLog();
    }

    private static void sqlQueryNumberOfUniqueTests() throws SQLException {
        new UniqueTestOnProject().printAnswerInLog();
    }

    public static void main(String[] args) throws SQLException {
        sqlQueryNumberOfBrowsers();
        sqlQueryAllTestAfterDate();
        sqlQueryTimeSpendOnTest();
        sqlQueryNumberOfUniqueTests();
    }
}

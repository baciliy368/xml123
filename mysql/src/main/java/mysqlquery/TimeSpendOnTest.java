package mysqlquery;

import framework.baseelements.BaseQuery;

public class TimeSpendOnTest extends BaseQuery {
    private static final String query = "SELECT id.name, test.name, test.end_time-test.start_time   "
            + "FROM test INNER JOIN project AS id ON test.project_id = id.id WHERE end_time > 2015-11-07 ORDER BY id.name ASC, test.name;";
    private static final String[] header = new String[]{"project", "test", "time_was_spend"};

    public TimeSpendOnTest() {
        super(query, header);
    }
}

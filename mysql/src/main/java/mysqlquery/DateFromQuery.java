package mysqlquery;

import framework.baseelements.BaseQuery;

public class DateFromQuery extends BaseQuery {
    private static final String query = "SELECT id.name, test.name, test.end_time "
            + "FROM test INNER JOIN project AS id ON test.project_id = id.id "
            + "WHERE end_time > 2015-11-07 ORDER BY id.name ASC, test.name ASC;";
    private static final String[] header = new String[]{"project", "test", "date"};

    public DateFromQuery() {
        super(query, header);
    }
}

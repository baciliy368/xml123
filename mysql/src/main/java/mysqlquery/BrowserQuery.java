package mysqlquery;

import framework.baseelements.BaseQuery;

public class BrowserQuery extends BaseQuery {
    private static final String query = "SELECT COUNT(browser) FROM test WHERE browser = 'firefox' "
            + "UNION SELECT COUNT(browser) FROM test WHERE browser = 'chrome'";
    private static final String[] header = new String[]{"number"};

    public BrowserQuery() {
        super(query, header);
    }
}

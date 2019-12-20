package mysqlquery;

import framework.baseelements.BaseQuery;

public class DateFromQuery extends BaseQuery {
    private static final String name = "DATE_SCRIPT";
    private static final String[] header = new String[]{"project", "test", "date"};

    public DateFromQuery(String dateParam) {
        super(getQuery(dateParam), header);
    }

    private static String getQuery(String dateParam) {
        return  String.format(getSqlScriptByNameToString(name), dateParam);
    }

}

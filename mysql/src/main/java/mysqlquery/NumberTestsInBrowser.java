package mysqlquery;

import framework.baseelements.BaseQuery;

public class NumberTestsInBrowser extends BaseQuery {
    private static final String name = "BROWSER_SCRIPT";
    private static final String[] header = new String[]{"number"};

    public NumberTestsInBrowser(String[] browserNames) {
        super(getQuery(browserNames), header);
    }

    private static String getQuery(String[] browsers) {
        String pattern = getSqlScriptByNameToString(name);
        String result = String.format(pattern, browsers[0]);
        if (browsers.length > 1) {
            for (int browserIndex = 1; browserIndex < browsers.length; browserIndex++) {
                result = String.format("%s UNION %s", result, String.format(pattern, browsers[browserIndex]));
            }
            result = result + ";";
        }
        return result;
    }
}

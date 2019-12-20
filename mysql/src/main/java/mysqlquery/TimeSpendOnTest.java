package mysqlquery;

import framework.baseelements.BaseQuery;

public class TimeSpendOnTest extends BaseQuery {
    private static final String nameOfTestInPropertiesFile = "TIME_SPEND_ON_TEST_SCRIPT";
    private static final String[] header = new String[]{"project", "test", "time_was_spend"};

    public TimeSpendOnTest() {
        super(getSqlScriptByNameToString(nameOfTestInPropertiesFile), header);
    }
}

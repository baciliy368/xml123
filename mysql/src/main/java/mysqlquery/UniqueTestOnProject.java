package mysqlquery;

import framework.baseelements.BaseQuery;

public class UniqueTestOnProject extends BaseQuery {
    private static final String nameOfTestInPropertiesFile = "UNIQUE_TESTS_ON_PROJECT";
    private static final String[] header = new String[]{"project", "number"};

    public UniqueTestOnProject() {
        super(getSqlScriptByNameToString(nameOfTestInPropertiesFile), header);
    }
}


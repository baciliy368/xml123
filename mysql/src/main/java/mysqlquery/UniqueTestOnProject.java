package mysqlquery;

import framework.baseelements.BaseQuery;

public class UniqueTestOnProject extends BaseQuery {
    private static final String query = "SELECT id.name, COUNT(DISTINCT test.name) FROM test INNER JOIN project "
            + "AS id ON test.project_id = id.id GROUP BY name";
    private static final String[] header = new String[]{"project", "number"};

    public UniqueTestOnProject() {
        super(query, header);
    }
}

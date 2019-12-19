package framework.baseelements;

import framework.sqlconnection.DataBaseConnection;
import framework.utiles.TableOutPut;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseQuery {
    private String[] header;
    private ResultSet answer;

    public BaseQuery(String query, String[] header) {
        answer = DataBaseConnection.getAnswer(query);
        this.header = header;
    }

    public void printAnswerInLog() throws SQLException {
        assert answer != null;
        int numberOfRowsOfQuery = getNumberOfRowsOfQuery(answer);
        answer.first();
        Object[][] rows = new Object[numberOfRowsOfQuery][header.length];
        for (int indexOfRow = 0; indexOfRow < numberOfRowsOfQuery; indexOfRow++) {
            for (int indexOfColumn = 0; indexOfColumn < header.length; indexOfColumn++) {
                rows[indexOfRow][indexOfColumn] = answer.getObject(indexOfColumn + 1);
            }
            answer.next();
        }
        TableOutPut.printInLog(header, rows);
    }

    private int getNumberOfRowsOfQuery(ResultSet answer) throws SQLException {
        answer.last();
        return answer.getRow();
    }
}

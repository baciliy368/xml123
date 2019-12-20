package framework.baseelements;

import exceptions.NoSqlScriptFile;
import framework.sqlconnection.DataBaseConnection;
import framework.utiles.PropertiesReader;
import models.Row;
import models.Table;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.Collectors;

public abstract class BaseQuery {
    private String[] header;
    private String query;

    public BaseQuery(String query, String[] header) {
        this.header = header;
        this.query = query;
    }

    public Table getResultOfQuery() throws SQLException {
        ResultSet answer = DataBaseConnection.getAnswer(query);
        assert answer != null;
        Row[] arrRows = new Row[getNumberOfRowsOfQuery(answer)];
        answer.first();
        for (int indexOfRow = 0; indexOfRow < arrRows.length; indexOfRow++) {
            Row row = new Row(header.length);
            for (int indexOfColumn = 0; indexOfColumn < header.length; indexOfColumn++) {
                row.addToRow(answer.getObject(indexOfColumn + 1));
            }
            arrRows[indexOfRow] = row;
            answer.next();
        }
        return new Table(header, arrRows);
    }

    protected static String getSqlScriptByNameToString(String name)   {
        try {

            return new BufferedReader(new FileReader(new File(PropertiesReader
                    .getValue(name))))
                    .lines().collect(Collectors.joining());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new NoSqlScriptFile();
        }
    }

    private int getNumberOfRowsOfQuery(ResultSet answer) throws SQLException {
        answer.last();
        return answer.getRow();
    }
}

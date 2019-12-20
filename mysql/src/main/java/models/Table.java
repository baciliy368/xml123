package models;

import dnl.utils.text.table.TextTable;

public class Table {
    private String[] header;
    private Row[] rows;

    public Table(String[] header, Row[] rows) {
        this.header = header;
        this.rows = rows;
    }

    public TextTable getTextTable() {
        TextTable textTable = new TextTable(header, getRowsArrToObjectArr());
        textTable.setAddRowNumbering(false);
        return textTable;
    }

    private Object[][] getRowsArrToObjectArr() {
        Object[][] result = new Object[rows.length][];
        for (int indexOfRow = 0; indexOfRow < rows.length; indexOfRow++) {
            result[indexOfRow] = rows[indexOfRow].getDataOfRow();
        }
        return result;
    }
}

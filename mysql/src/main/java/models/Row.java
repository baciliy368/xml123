package models;

public class Row {
    private Object[] dataOfRow;
    int position = 0;

    public Object[] getDataOfRow() {
        return dataOfRow;
    }

    public Row(int numberOfCells) {
        dataOfRow = new Object[numberOfCells];
    }

    public void addToRow(Object value) {
        dataOfRow[position] = value;
        position++;
    }
}

package framework.utiles;

import dnl.utils.text.table.TextTable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class TableOutPut   {
    public static void printInLog(String [] header, Object[][] rows) {
        TextTable textTable = new TextTable(header, rows);
        textTable.setAddRowNumbering(false);
        try {
            textTable.printTable(new PrintStream(new FileOutputStream("logger.txt", true)), 0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

package framework.utiles;

import dnl.utils.text.table.TextTable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Printer {
    private static PrintStream printStream;

    public static void printInFileTableWithName(String name, TextTable table) {
        try {
            printStream = new PrintStream(new FileOutputStream("resultOfQuery.txt", true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        printInFile(name);
        printInFile(table);
    }

    private static void printInFile(String text) {
        printStream.println(text);
    }

    private static void printInFile(TextTable table) {
        table.printTable(printStream, 0);
    }



}

package exceptions;

public class NoSqlScriptFile extends Error {

    public NoSqlScriptFile() {
        super("SQL Script is not exist in");
    }
}

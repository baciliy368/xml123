package exceptions;

public class NoAnswerFromSqlServer extends Error {
    public NoAnswerFromSqlServer() {
        super("No answer from sql server");
    }
}

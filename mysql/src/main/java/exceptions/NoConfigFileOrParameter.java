package exceptions;

public class NoConfigFileOrParameter extends Error {
    public NoConfigFileOrParameter() {
        super("There are problems in configuration");
    }
}

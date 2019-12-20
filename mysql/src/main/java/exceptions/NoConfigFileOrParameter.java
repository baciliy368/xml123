package exceptions;

public class NoConfigFileOrParameter extends Error {
    public NoConfigFileOrParameter() {
        super("There are no config file in directory");
    }
}

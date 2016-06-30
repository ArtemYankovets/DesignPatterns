package ua.com.juja.patterns.command.sample.sqlcmd.command;

/**
 * Created by oleksandr.baglai on 30.09.2015.
 */
public abstract class Processor implements Command {

    @Override
    public String description() {
        return null;
    }

    @Override
    public String format() {
        return null;
    }
}

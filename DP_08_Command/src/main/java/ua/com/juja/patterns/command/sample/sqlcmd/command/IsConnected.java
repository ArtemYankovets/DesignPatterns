package ua.com.juja.patterns.command.sample.sqlcmd.command;

import ua.com.juja.patterns.command.sample.sqlcmd.DatabaseManager;
import ua.com.juja.patterns.command.sample.sqlcmd.View;

/**
 * Created by oleksandr.baglai on 28.08.2015.
 */
public class IsConnected extends Processor {

    private DatabaseManager manager;
    private View view;

    public IsConnected(DatabaseManager manager, View view) {
        this.manager = manager;
        this.view = view;
    }

    @Override
    public boolean canProcess(String command) {
        return !manager.isConnected();
    }

    @Override
    public void process(String command) {
        view.write(String.format("Ты не можешь пользоваться командой '%s' пока " +
                "не подключишься с помощью комманды " +
                "connect|databaseName|userName|password", command));
    }
}

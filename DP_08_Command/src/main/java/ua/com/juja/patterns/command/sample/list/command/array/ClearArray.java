package ua.com.juja.patterns.command.sample.list.command.array;

import ua.com.juja.patterns.command.sample.list.ArrayReceiver;
import ua.com.juja.patterns.command.sample.list.Command;

/**
 * Created by artem.yankovets on 30.06.2016.
 */
public class ClearArray implements Command {
    private ArrayReceiver receiver;

    public ClearArray(final ArrayReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public Object execute(final Object... args) {
        if (args.length != 0) {
            throw new IllegalArgumentException(
                "Неверный формат вызова команды, ожидается вызов без параметров");
        }

        for (int i = 0; i < receiver.size(); i++) {
            receiver.set(i, null);
        }

        return receiver;
    }
}

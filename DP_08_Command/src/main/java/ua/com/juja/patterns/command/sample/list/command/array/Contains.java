package ua.com.juja.patterns.command.sample.list.command.array;

import ua.com.juja.patterns.command.sample.list.ArrayReceiver;
import ua.com.juja.patterns.command.sample.list.Command;

/**
 * Created by artem.yankovets on 30.06.2016.
 */
public class Contains implements Command {

    private ArrayReceiver receiver;

    public Contains(final ArrayReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public Object execute(final Object... args) {
        if ((args.length != 1) || !(args[0] instanceof String)) {
            throw new IllegalArgumentException(
                "Неверный формат вызова команды, ожидается 1 параметр [String]");
        }

        String item = (String) args[0];
        for (int i = 0; i < receiver.size(); i++) {
            if (item.equals(receiver.get(i))) {
                return true;
            }
        }

        return false;
    }
}

package ua.com.juja.patterns.command.sample.list.command.array;

import ua.com.juja.patterns.command.sample.list.ArrayReceiver;
import ua.com.juja.patterns.command.sample.list.Command;

/**
 * Created by artem.yankovets on 30.06.2016.
 */
public class Set implements Command {

    private ArrayReceiver receiver;

    public Set(ArrayReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute(Object... args) {

        if (args.length != 2 || !(args[0] instanceof Integer) || !(args[1] instanceof String)) {
            throw new IllegalArgumentException(
                    "Неверный формат вызова команды, ожидается 1 параметр [Integer]");
        }

        Integer index = (Integer)args[0];
        String data = (String) args[1];

        String old = receiver.get(index);
        receiver.set(index, data);

        return old;
    }
}

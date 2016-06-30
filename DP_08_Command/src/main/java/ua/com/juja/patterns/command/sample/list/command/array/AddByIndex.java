package ua.com.juja.patterns.command.sample.list.command.array;

import ua.com.juja.patterns.command.sample.list.ArrayReceiver;
import ua.com.juja.patterns.command.sample.list.Command;

/**
 * Created by artem.yankovets on 30.06.2016.
 */
public class AddByIndex implements Command {

    private ArrayReceiver receiver;

    public AddByIndex(ArrayReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public Integer execute(Object... args) {
        if (args.length != 2 || !(args[0] instanceof Integer) || !(args[1] instanceof String) ) {
            throw new IllegalArgumentException(
                    "Неверный формат вызова команды, ожидается 1 параметр [String]");
        }

        Integer index = (Integer) args[0];
        String value = (String)args[1];

        int newSize = receiver.size() + 1;
        receiver.copyOf(newSize);

        for (int i = newSize - 1; i > index ; i--) {
            String item = receiver.get(i-1);
            receiver.set(i, item);
        }
        receiver.set(index, value);

        return index;
    }
}


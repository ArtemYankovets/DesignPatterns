package ua.com.juja.patterns.command.sample.list.command.array;

import ua.com.juja.patterns.command.sample.list.ArrayReceiver;
import ua.com.juja.patterns.command.sample.list.Command;

/**
 * Created by artem.yankovets on 30.06.2016.
 */
public class IndexOf implements Command {

    private ArrayReceiver receiver;

    public IndexOf(ArrayReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public Integer execute(Object... args) {
        if (args.length != 1 || !(args[0] instanceof String)) {
            throw new IllegalArgumentException(
                    "Неверный формат вызова команды, ожидается 1 параметр [String]");
        }

        String value = (String) args[0];
        Integer index = -1;

        for (int i = 0; i < receiver.size(); i++) {
            if (value.equals(receiver.get(i))) {
                index = i;
                break;
            }
        }

        return index;
    }
}

package ua.com.juja.patterns.command.sample.list.command.array;

import ua.com.juja.patterns.command.sample.list.ArrayReceiver;
import ua.com.juja.patterns.command.sample.list.Command;

/**
 * Created by artem.yankovets on 30.06.2016.
 */
public class RemoveByObject implements Command {

    private ArrayReceiver receiver;

    public RemoveByObject(ArrayReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute(Object... args) {
        if (args.length != 1 || !(args[0] instanceof String)) {
            throw new IllegalArgumentException(
                    "Неверный формат вызова команды, ожидается 1 параметр [String]");
        }

        String old = (String) args[0];

        Integer index = -1;
        for (int i = 0; i < receiver.size(); i++) {
            if (old.equals(receiver.get(i))) {
                index = i;
                break;
            }
        }

        if (index == -1){
            throw new IllegalArgumentException(
                "Элемент не найден");
        } else {
            for (int i = index + 1; i < receiver.size(); i++) {
                receiver.set(i - 1, receiver.get(i));
            }
            receiver.copyOf(receiver.size() - 1);
        }

        return old;
    }
}

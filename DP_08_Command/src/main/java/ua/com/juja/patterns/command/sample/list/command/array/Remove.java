package ua.com.juja.patterns.command.sample.list.command.array;

import ua.com.juja.patterns.command.sample.list.ArrayReceiver;
import ua.com.juja.patterns.command.sample.list.Command;

/**
 * Created by oleksandr.baglai on 08.10.2015.
 * Edited by artem.yankovets on 30.06.2016.
 */
public class Remove implements Command {

    private ArrayReceiver receiver;

    public Remove(ArrayReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public Object execute(Object... args) {
        if (args.length != 1 || !(args[0] instanceof Integer) && !(args[0] instanceof String)) {
            throw new IllegalArgumentException(
                    "Неверный формат вызова команды, ожидается 1 параметр [Integer]");
        }

        String old = null;
        Integer index = -1;
        if (args[0] instanceof String) {
            old = (String) args[0];

            for (int i = 0; i < receiver.size(); i++) {
                if (old.equals(receiver.get(i))) {
                    index = i;
                    break;
                }
            }
            if (index == -1){
                throw new IllegalArgumentException(
                    "Элемент со значением " + old + " не найден");
            }
        }
        else {
            index = (Integer) args[0];
            old = receiver.get(index);
        }

        for (int i = index + 1; i < receiver.size(); i++) {
            receiver.set(i - 1, receiver.get(i));
        }
        receiver.copyOf(receiver.size() - 1);

        return (args[0] instanceof String) ? true : old;
    }
}

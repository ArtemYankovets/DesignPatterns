package ua.com.juja.patterns.command.sample.list;

import ua.com.juja.patterns.command.sample.list.command.array.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 08.10.2015.
 */
public class ArrayListTest extends ListTest{

    // наш приемник содержащий массив
    ArrayReceiver receiver = new ArrayReceiver();

    @Override
    protected Command getAddCommand() {
        return new Add(receiver);
    }

    @Override
    protected Command getToStringCommand() {
        return new ToString(receiver);
    }

    @Override
    protected Command getSizeCommand() {
        return new Size(receiver);
    }

    @Override
    protected Command getIsEmptyCommand() {
        return new IsEmpty(receiver);
    }

    @Override
    protected Command getGetCommand() {
        return new Get(receiver);
    }

    @Override
    protected Command getRemoveCommand() {
        return new Remove(receiver);
    }

    // тест (тот что template method) занаследуем от родителя
}

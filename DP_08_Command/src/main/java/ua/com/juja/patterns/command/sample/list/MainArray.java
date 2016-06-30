package ua.com.juja.patterns.command.sample.list;

import ua.com.juja.patterns.command.sample.list.command.array.*;

/**
 * Created by oleksandr.baglai on 08.10.2015.
 * Edited by artem.yankovets on 30.06.2016.
 */
public class MainArray {
    public static void main(String[] args) {
        // наш приемник содержащий массив
        ArrayReceiver array = new ArrayReceiver();

        // наши алгоритмы работы с приемником
        Command add = new Add(array);
        Command toString = new ToString(array);
        Command size = new Size(array);
        Command isEmpty = new IsEmpty(array);
        Command get = new Get(array);
        Command remove = new Remove(array);
        // My commands
        Command removeObject = new RemoveByObject(array);
        Command contains = new Contains(array);
        Command clear = new ClearArray(array);
        Command set = new Set(array);
        Command addByIndex = new AddByIndex(array);
        Command indexOf = new IndexOf(array);

        // наш выполнятор
        Invoker invoker = new Invoker();

        // и то, как мы им пользуемся
        invoker.setCommand(isEmpty).doit();
        invoker.setCommand(add).doit("one");
        invoker.setCommand(add).doit("two");
        invoker.setCommand(add).doit("three");
        invoker.setCommand(toString).doit();
        invoker.setCommand(size).doit();
        invoker.setCommand(isEmpty).doit();
        invoker.setCommand(get).doit(2);
        invoker.setCommand(remove).doit(0);
        invoker.setCommand(remove).doit(1);
        invoker.setCommand(toString).doit();
        // Вывод
        // IsEmpty[] = true
        // Add[one] = 0
        // Add[two] = 1
        // Add[three] = 2
        // ToString[] = [one, two, three]
        // Size[] = 3
        // IsEmpty[] = false
        // Get[2] = three
        // Remove[0] = one
        // Remove[1] = three
        // ToString[] = [two]

        // TODO домашка - реализовать все остальные команды List
        // Remove(Object o) Удаляющий первый найденный элемент, который и вернет
        invoker.setCommand(add).doit("four");
        invoker.setCommand(add).doit("five");
        invoker.setCommand(toString).doit();
        invoker.setCommand(remove).doit("four");
        invoker.setCommand(toString).doit();

        // Contains(Object o) проверяющий есть ли такой объект в нашем ArrayReceiver
        invoker.setCommand(contains).doit("two");

        // Iterator() возвращающий объект итератор, йаху!


        // Clear() очищающий весь массив
        invoker.setCommand(clear).doit();
        invoker.setCommand(toString).doit();

        // Set(Integer index, String o) изменяюзий элемент в заданной позиции (старый возвращаем)
        invoker.setCommand(set).doit(0, "six");
        invoker.setCommand(set).doit(1, "seven");
        invoker.setCommand(toString).doit();

        // Add(Integer index, String o) вставляющий элемент в заданную позицию
        invoker.setCommand(addByIndex).doit(1, "eight");
        invoker.setCommand(toString).doit();

        // IndexOf(Object o) должен вернуть индекс искомого элемента, или -1 если не найдено
        invoker.setCommand(indexOf).doit("eight");
        invoker.setCommand(indexOf).doit("ten");
    }
}

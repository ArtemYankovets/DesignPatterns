package ua.com.juja.patterns.command.sample.list;

/**
 * Created by oleksandr.baglai on 08.10.2015.
 */
// Любая команда будет реализовывать этот интерфейс
public interface Command {
    // что-то сделать с Receiver с заданными параметрами
    Object execute(Object... args);
}

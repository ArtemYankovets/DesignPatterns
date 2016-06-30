package ua.com.juja.patterns.command.classic;

/**
 * Created by oleksandr.baglai on 08.10.2015.
 */

// Главная абстракция, за которой мы прячем любой Receiver от Invoker
public interface Command {
    Object execute(Object input);
}

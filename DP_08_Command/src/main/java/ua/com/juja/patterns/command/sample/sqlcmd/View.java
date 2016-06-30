package ua.com.juja.patterns.command.sample.sqlcmd;

/**
 * Created by oleksandr.baglai on 25.08.2015.
 */
public interface View {

    void write(String message);

    String read();
}

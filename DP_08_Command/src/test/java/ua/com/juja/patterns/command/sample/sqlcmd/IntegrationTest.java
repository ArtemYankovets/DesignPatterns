package ua.com.juja.patterns.command.sample.sqlcmd;


import org.junit.Test;
import ua.com.juja.patterns.command.ConsoleMock;

import static org.junit.Assert.assertEquals;

/**
 * Created by oleksandr.baglai on 28.08.2015.
 */
public class IntegrationTest {

    private ConsoleMock console = new ConsoleMock();

    @Test
    public void testHelp() {
        // given
        console.addIn("help");
        console.addIn("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\n" +
                "-->\n" +
                "help\n" +
                "Существующие команды:\n" +
                "\tconnect|databaseName|userName|password\n" +
                "\t\tПодключение к базе данных, с которой будем работать\n" +
                "\thelp\n" +
                "\t\tВывод списка команд\n" +
                "\texit\n" +
                "\t\tВыход из программы\n" +
                "\ttables\n" +
                "\t\tВывод всех таблиц базы\n" +
                "\tclear|tableName\n" +
                "\t\tОчищение всей таблицы\n" +
                "\tremove|tableName|column|value\n" +
                "\t\tУдаление записей из таблицы по запросу\n" +
                "\tcreate|tableName|column1|value1|column2|value2|...|columnN|valueN\n" +
                "\t\tСозание записи в таблице\n" +
                "\tfind|tableName\n" +
                "\t\tПолучение содержимого таблицы\n" +
                "-->\n" +
                "exit\n" +
                "До скорой встречи!\n", console.getOut());
    }

    @Test
    public void testExit() {
        // given
        console.addIn("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\n" +
                "-->\n" +
                "exit\n" +
                "До скорой встречи!\n", console.getOut());
    }

    @Test
    public void testListWithoutConnect() {
        // given
        console.addIn("tables");
        console.addIn("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\n" +
                "-->\n" +
                "tables\n" +
                "Ты не можешь пользоваться командой 'tables' пока не подключишься с помощью комманды connect|databaseName|userName|password\n" +
                "-->\n" +
                "exit\n" +
                "До скорой встречи!\n", console.getOut());
    }

    @Test
    public void testFindWithoutConnect() {
        // given
        console.addIn("find|user");
        console.addIn("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\n" +
                "-->\n" +
                "find|user\n" +
                "Ты не можешь пользоваться командой 'find|user' пока не подключишься с помощью комманды connect|databaseName|userName|password\n" +
                "-->\n" +
                "exit\n" +
                "До скорой встречи!\n", console.getOut());
    }

    @Test
    public void testUnsupported() {
        // given
        console.addIn("unsupported");
        console.addIn("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\n" +
                "-->\n" +
                "unsupported\n" +
                "Ты не можешь пользоваться командой 'unsupported' пока не подключишься с помощью комманды connect|databaseName|userName|password\n" +
                "-->\n" +
                "exit\n" +
                "До скорой встречи!\n", console.getOut());
    }

    @Test
    public void testUnsupportedAfterConnect() {
        // given
        console.addIn("connect|sqlcmd|postgres|postgres");
        console.addIn("unsupported");
        console.addIn("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\n" +
                "-->\n" +
                "connect|sqlcmd|postgres|postgres\n" +
                "Успех!\n" +
                "-->\n" +
                "unsupported\n" +
                "Несуществующая команда: unsupported\n" +
                "-->\n" +
                "exit\n" +
                "До скорой встречи!\n", console.getOut());
    }

    @Test
    public void testTablesAfterConnect() {
        // given
        console.addIn("connect|sqlcmd|postgres|postgres");
        console.addIn("tables");
        console.addIn("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\n" +
                "-->\n" +
                "connect|sqlcmd|postgres|postgres\n" +
                "Успех!\n" +
                "-->\n" +
                "tables\n" +
                "[]\n" +
                "-->\n" +
                "exit\n" +
                "До скорой встречи!\n", console.getOut());
    }

    @Test
    public void testTablesWithData_caseEmptyTable() {
        // given
        console.addIn("connect|sqlcmd|postgres|postgres");
        console.addIn("find|user");
        console.addIn("tables");
        console.addIn("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\n" +
                "-->\n" +
                "connect|sqlcmd|postgres|postgres\n" +
                "Успех!\n" +
                "-->\n" +
                "find|user\n" +
                "--------------------\n" +
                "|\n" +
                "--------------------\n" +
                "--------------------\n" +
                "-->\n" +
                "tables\n" +
                "[user]\n" +
                "-->\n" +
                "exit\n" +
                "До скорой встречи!\n", console.getOut());
    }

    @Test
    public void testTablesWithData_caseNoEmptyData() {
        // given
        console.addIn("connect|sqlcmd|postgres|postgres");
        console.addIn("create|user|id|13|name|Stiven|password|pass");
        console.addIn("tables");
        console.addIn("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\n" +
                "-->\n" +
                "connect|sqlcmd|postgres|postgres\n" +
                "Успех!\n" +
                "-->\n" +
                "create|user|id|13|name|Stiven|password|pass\n" +
                "Запись {names:[id, name, password], values:[13, Stiven, pass]} была успешно создана в таблице 'user'.\n" +
                "-->\n" +
                "tables\n" +
                "[user]\n" +
                "-->\n" +
                "exit\n" +
                "До скорой встречи!\n", console.getOut());
    }

    @Test
    public void testFindAfterConnect() {
        // given
        console.addIn("connect|sqlcmd|postgres|postgres");
        console.addIn("clear|user");
        console.addIn("find|user");
        console.addIn("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\n" +
                "-->\n" +
                "connect|sqlcmd|postgres|postgres\n" +
                "Успех!\n" +
                "-->\n" +
                "clear|user\n" +
                "Таблица user была успешно очищена.\n" +
                "-->\n" +
                "find|user\n" +
                "--------------------\n" +
                "|\n" +
                "--------------------\n" +
                "--------------------\n" +
                "-->\n" +
                "exit\n" +
                "До скорой встречи!\n", console.getOut());
    }

    @Test
    public void testConnectAfterConnect() {
        // given
        console.addIn("connect|sqlcmd|postgres|postgres");
        console.addIn("tables");
        console.addIn("connect|test|postgres|postgres");
        console.addIn("tables");
        console.addIn("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\n" +
                "-->\n" +
                "connect|sqlcmd|postgres|postgres\n" +
                "Успех!\n" +
                "-->\n" +
                "tables\n" +
                "[]\n" +
                "-->\n" +
                "connect|test|postgres|postgres\n" +
                "Успех!\n" +
                "-->\n" +
                "tables\n" +
                "[]\n" +
                "-->\n" +
                "exit\n" +
                "До скорой встречи!\n", console.getOut());
    }

    @Test
    public void testConnectWithError() {
        // given
        console.addIn("connect|sqlcmd");
        console.addIn("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\n" +
                "-->\n" +
                "connect|sqlcmd\n" +
                "Неудача! по причине: Формат команды 'connect|databaseName|userName|password', а ты ввел 'connect|sqlcmd'\n" +
                "Повтори попытку.\n" +
                "-->\n" +
                "exit\n" +
                "До скорой встречи!\n", console.getOut());
    }

    @Test
    public void testFindAfterConnect_withData() {
        // given
        console.addIn("connect|sqlcmd|postgres|postgres");
        console.addIn("clear|user");
        console.addIn("create|user|id|13|name|Stiven|password|*****");
        console.addIn("create|user|id|14|name|Eva|password|+++++");
        console.addIn("find|user");
        console.addIn("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\n" +
                "-->\n" +
                "connect|sqlcmd|postgres|postgres\n" +
                "Успех!\n" +
                "-->\n" +
                "clear|user\n" +
                "Таблица user была успешно очищена.\n" +
                "-->\n" +
                "create|user|id|13|name|Stiven|password|*****\n" +
                "Запись {names:[id, name, password], values:[13, Stiven, *****]} была успешно создана в таблице 'user'.\n" +
                "-->\n" +
                "create|user|id|14|name|Eva|password|+++++\n" +
                "Запись {names:[id, name, password], values:[14, Eva, +++++]} была успешно создана в таблице 'user'.\n" +
                "-->\n" +
                "find|user\n" +
                "--------------------\n" +
                "|id|name|password|\n" +
                "--------------------\n" +
                "|13|Stiven|*****|\n" +
                "|14|Eva|+++++|\n" +
                "--------------------\n" +
                "-->\n" +
                "exit\n" +
                "До скорой встречи!\n", console.getOut());
    }

    @Test
    public void testClearWithError() {
        // given
        console.addIn("connect|sqlcmd|postgres|postgres");
        console.addIn("clear|sadfasd|fsf|fdsf");
        console.addIn("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\n" +
                "-->\n" +
                "connect|sqlcmd|postgres|postgres\n" +
                "Успех!\n" +
                "-->\n" +
                "clear|sadfasd|fsf|fdsf\n" +
                "Неудача! по причине: Формат команды 'clear|tableName', а ты ввел: 'clear|sadfasd|fsf|fdsf'\n" +
                "Повтори попытку.\n" +
                "-->\n" +
                "exit\n" +
                "До скорой встречи!\n", console.getOut());
    }

    @Test
    public void testCreateWithErrors() {
        // given
        console.addIn("connect|sqlcmd|postgres|postgres");
        console.addIn("create|user|error");
        console.addIn("exit");

        // when
        Main.main(new String[0]);

        // then
        assertEquals("Привет юзер!\n" +
                "Введи, пожалуйста имя базы данных, имя пользователя и пароль в формате: connect|database|userName|password\n" +
                "-->\n" +
                "connect|sqlcmd|postgres|postgres\n" +
                "Успех!\n" +
                "-->\n" +
                "create|user|error\n" +
                "Неудача! по причине: Должно быть четное количество параметров в формате 'create|tableName|column1|value1|column2|value2|...|columnN|valueN', а ты ввел: 'create|user|error'\n" +
                "Повтори попытку.\n" +
                "-->\n" +
                "exit\n" +
                "До скорой встречи!\n", console.getOut());
    }
}

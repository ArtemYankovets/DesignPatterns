package ua.com.juja.patterns.command.classic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by oleksandr.baglai on 08.10.2015.
 */
public class ConcreteCommandСTest {

    private Object processed;
    private Object returned;

    @Test
    public void shouldCallReceiver() {
        // given

        // создаем фейковый приемник-зонд, который сохраняет в поля то,
        // что ему передали
        ReceiverA receiver = new ReceiverA() {
            @Override
            public Object method1(Object input) {
                throw new IllegalStateException("Не должно было вызываться!");
            }

            @Override
            public Object method2(Object input) {
                processed = input;
                return returned;
            }
        };

        // наш подопытная команда
        Command command = new ConcreteCommandC(receiver);

        // вот что вернет приемник
        returned = "returned";

        // when
        // вызов тестового метода команды
        Object result = command.execute("data");

        // then
        // проверили что команда вернула то, что ей передал приемник
        assertEquals("returned", result);

        // + до приемника дошел сигнал из команды
        assertEquals("Changed in CommandC: data", processed);
    }

    @Test
    public void shouldCallReceiver_mockitoCase() {
        // given

        // создаем мок приемника
        ReceiverA receiver = mock(ReceiverA.class);

        // наш подопытная команда
        Command command = new ConcreteCommandC(receiver);

        // вот что вернет приемник
        when(receiver.method2(anyString())).thenReturn("returned");

        // when
        // вызов тестового метода команды
        Object result = command.execute("data");

        // then
        // проверили что команда вернула то, что ей передал приемник
        assertEquals("returned", result);

        // + до приемника дошел сигнал из команды
        verify(receiver).method2("Changed in CommandC: data");

        // и больше ничего с рисивером не делали
        verifyNoMoreInteractions(receiver);
    }
}

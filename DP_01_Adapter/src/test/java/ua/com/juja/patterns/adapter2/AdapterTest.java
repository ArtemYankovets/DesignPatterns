package ua.com.juja.patterns.adapter2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by indigo on 19.08.2015.
 */
public class AdapterTest {
    @Test
    public void test() {
        // given
        Target target = new Adapter();

        // when
        Object actual = target.request("data");

        // then
        assertEquals("Hello from Adaptee!", actual);
    }
}

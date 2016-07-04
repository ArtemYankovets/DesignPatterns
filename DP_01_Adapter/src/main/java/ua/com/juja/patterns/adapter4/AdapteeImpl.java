package ua.com.juja.patterns.adapter4;

/**
 * Created by oleksandr.baglai on 19.08.2015.
 */
public class AdapteeImpl implements Adaptee {

    public Object specificRequest(Object input) {
        System.out.println("Call Adaptee.specificRequest(" + input + ")");
        return "Hello from Adaptee!";
    }
}

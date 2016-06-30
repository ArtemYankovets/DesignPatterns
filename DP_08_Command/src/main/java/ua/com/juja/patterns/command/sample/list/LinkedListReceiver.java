package ua.com.juja.patterns.command.sample.list;

/**
 * Created by oleksandr.baglai on 08.10.2015.
 */
// наше хранилище, собственно массив
public class LinkedListReceiver {

    // вся суть нашего двусвязного списочка
    private Node first;
    private Node last;

    public static class Node {
        // я раскрыл это для комманд, но не для клиента!
        public Node next;
        public Node prev;
        public String value;
    }

    // а это разрешаем делать нашим клиентам
    // не много, но так ведь интереснее :)
    // то, что заметишь общее во всех командах - можешь выделить сюда

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public void setFirst(Node first) {
        this.first = first;
    }
}

package com.yankovets.hfdp.adapter.adapter2;

public class IteratorToEnumeration implements Enumaration {

    java.util.Iterator iterator;

    public IteratorToEnumeration(java.util.Iterator iterator) {
        this.iterator = iterator;
    }

    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    public Object nextElement() {
        return iterator.next();
    }
}

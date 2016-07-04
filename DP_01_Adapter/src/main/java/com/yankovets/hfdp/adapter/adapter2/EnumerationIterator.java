package com.yankovets.hfdp.adapter.adapter2;



public class EnumerationIterator implements Iterator {

    Enumaration enumaration;

    public EnumerationIterator(Enumaration  enumaration) {
        this.enumaration = enumaration;
    }

    public boolean hasNext() {
        return enumaration.hasMoreElements();
    }

    public Object next() {
        return enumaration.nextElement();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}

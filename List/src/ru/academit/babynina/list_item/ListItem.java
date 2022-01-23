package ru.academit.babynina.list_item;

public class ListItem<T> {
    private T data;
    private ListItem<T> next;

    public ListItem(T data) {
        this.data = data;
        this.next = null;
    }

    public ListItem(T data, ListItem<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ListItem<T> getNext() {
        return next;
    }

    public void setNext(ListItem<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "[Data:" + data + ", Next:" + getNext().getData() + "]";
    }
}
package ru.academit.babynina.list;

import ru.academit.babynina.list_item.ListItem;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList(ListItem<T> head) {
        this.head = head;
        this.count = getCount();
    }

    public ListItem<T> getHead() {
        return head;
    }

    public void setHead(ListItem<T> head) {
        this.head = head;
    }

    private void validateIndex(int index) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Index must be more than 0 and less than the count(" + count + "). Index = " + index + ".");
        }
    }

    private void validateCount() {
        if (count == 0) {
            throw new NullPointerException("List is empty.");
        }
    }

    private ListItem<T> getNode(int index) {
        validateIndex(index);
        ListItem<T> node = head;

        for (int i = 0; i < index; ++i) {
            node = node.getNext();
        }

        return node;
    }

    // получение размера списка
    public int getCount() {
        int count = 0;

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            count += 1;
        }

        return count;
    }

    // получение значение первого элемента
    public T get() {
        return head.getData();
    }

    // получение значения по указанному индексу
    public T get(int index) {
        validateIndex(index);

        return getNode(index).getData();
    }

    // изменение значения по указанному индексу, пусть выдает старое значение
    public T update(int index, T data) {
        validateIndex(index);
        T oldData = getNode(index).getData();
        getNode(index).setData(data);

        return oldData;
    }

    // удаление элемента по индексу, пусть выдает значение элемента
    public T remove(int index) {
        validateIndex(index);
        T data = getNode(index).getData();
        getNode(index - 1).setNext(getNode(index).getNext());
        --count;

        return data;
    }

    // вставка элемента в начало
    public void insert(T data) {
        setHead(new ListItem<>(data, head));
        ++count;
    }

    // вставка элемента по индексу
    public void insert(T data, int index) {
        validateIndex(index);

        if (index == 0) {
            insert(data);
            return;
        }

        getNode(index - 1).setNext(new ListItem<>(data, getNode(index)));
        ++count;
    }

    // удаление узла по значению, пусть выдает true, если элемент был удален
    public boolean removeData(T data) {
        validateCount();

        if (head.getData().equals(data)) {
            remove();
            --count;
            return true;
        }

        for (ListItem<T> p = head.getNext(), prev = head; p != null; prev = p, p = p.getNext()) {
            if (p.getData().equals(data)) {
                prev.setNext(p.getNext());
                --count;
                return true;
            }
        }

        return false;
    }

    // удаление первого элемента, пусть выдает значение элемента
    public T remove() {
        validateCount();
        T data = head.getData();
        setHead(head.getNext());
        --count;

        return data;
    }

    // разворот списка за линейное время
    public void reverse() {
        validateCount();

        if (count == 1) {
            return;
        }

        ListItem<T> current = head.getNext();
        head.setNext(null);

        for (; current != null; current = current.getNext()) {
            current.setNext(head);
            head = current;
        }
    }

    // копирование списка
    public SinglyLinkedList<T> copy() {
        validateCount();
        SinglyLinkedList<T> listCopy = new SinglyLinkedList<>(getHead());

        for (ListItem<T> current = head.getNext(), copy = getHead(); current != null; current = current.getNext(), copy = copy.getNext()) {
            copy.setNext(new ListItem<>(current.getData()));
        }

        listCopy.count = listCopy.getCount();

        return listCopy;
    }

    @Override
    public String toString() {
        validateCount();
        StringBuilder stringBuilder = new StringBuilder("[");

        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            stringBuilder.append(p.getData()).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()).append("]");

        return stringBuilder.toString();
    }
}
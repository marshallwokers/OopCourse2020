package ru.academit.babynina.list_main;

import ru.academit.babynina.list.SinglyLinkedList;
import ru.academit.babynina.list_item.ListItem;

public class ListMain {
    public static void main(String[] args) {
        ListItem<Integer> item1 = new ListItem<>(2);
        ListItem<Integer> item2 = new ListItem<>(1, item1);
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(item2);
        System.out.println("Список list — " + list);
        System.out.println("Получение размера списка — " + list.getCount());
        System.out.println("Получение значения первого элемента — " + list.get());
        System.out.println("Получение значения по указанному индексу — " + list.get(1));
        System.out.println("Изменение значения по указанному индексу. Выдает старое значение элемента — " + list.update(1, 3));
        System.out.println("Список list — " + list);
        System.out.println("Удаление элемента по индексу. Выдает значение элемента — " + list.remove(1));
        System.out.println("Список list — " + list);
        System.out.println("Вставка элемента в начало.");
        list.insert(0);
        System.out.println("Список list — " + list);
        System.out.println("Вставка элемента по индексу.");
        list.insert(2, 2);
        System.out.println("Список list — " + list);
        System.out.println("Удаление узла по значению. Выдает true, если элемент был удален.");
        list.removeData(0);
        System.out.println("Список list — " + list);
        System.out.println("Удаление первого элемента. Выдает значение элемента.");
        list.remove();
        System.out.println("Список list — " + list);
    }
}

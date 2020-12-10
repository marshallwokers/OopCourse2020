package ru.academit.babynina.shapes;

import java.util.Comparator;

public class SortByArea implements Comparator<Shapes> {
    @Override
    public int compare(Shapes shape1, Shapes shape2) {
        if (shape1.getArea() < shape2.getArea()) {
            return -1;
        }

        if (shape1.getArea() == shape2.getArea()) {
            return 0;
        }

        return 1;
    }
}
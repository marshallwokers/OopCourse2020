package ru.academit.babynina.shapes;

import java.util.Comparator;

public class SortByPerimeter implements Comparator<Shapes> {
    @Override
    public int compare(Shapes shape1, Shapes shape2) {
        if (shape1.getPerimeter() < shape2.getPerimeter()) {
            return -1;
        }

        if (shape1.getPerimeter() == shape2.getPerimeter()) {
            return 0;
        }

        return 1;
    }
}
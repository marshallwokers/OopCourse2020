package ru.academit.babynina.shape_main;

import ru.academit.babynina.shape.*;

import java.util.Arrays;

public class ShapeMain {
    private static Shape getMaxAreaShape(Shape[] shapes) {
        if (shapes.length == 0) {
            return null;
        }

        Arrays.sort(shapes, new AreaComparator());

        return shapes[shapes.length - 1];
    }

    private static Shape getSecondMaxPerimeterShape(Shape[] shapes) {
        if (shapes.length == 0) {
            return null;
        }

        if (shapes.length == 1) {
            return shapes[0];
        }

        Arrays.sort(shapes, new PerimeterComparator());

        return shapes[shapes.length - 2];
    }

    public static void main(String[] args) {
        Shape[] shapes = {
                new Square(5),
                new Triangle(-2, 2, 3, 2, -1, 0),
                new Rectangle(3, 7),
                new Circle(50),
                new Square(15),
                new Triangle(0, -1, 0, 5, 34, 0),
                new Rectangle(13, 17),
                new Circle(6)
        };

        if (getMaxAreaShape(shapes) == null || getSecondMaxPerimeterShape(shapes) == null) {
            System.out.println("Массив фигур пуст.");
        } else {
            System.out.println("Фигура с максимальной площадью - " + getMaxAreaShape(shapes));
            System.out.println();
            System.out.println("Фигура со вторым по величине периметром - " + getSecondMaxPerimeterShape(shapes));
        }
    }
}
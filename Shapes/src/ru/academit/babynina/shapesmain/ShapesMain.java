package ru.academit.babynina.shapesmain;

import ru.academit.babynina.shapes.*;

import java.util.Arrays;

public class ShapesMain {
    private static Shapes getMaxAreaShape(Shapes[] shapes) {
        Arrays.sort(shapes, new SortByArea());

        return shapes[shapes.length - 1];
    }

    private static Shapes getSecondMaxPerimeterShape(Shapes[] shapes) {
        Arrays.sort(shapes, new SortByPerimeter());

        return shapes[shapes.length - 2];
    }

    public static void main(String[] args) {
        Shapes[] shapes = {new Square(5), new Triangle(-2, 2, 3, 2, -1, 0), new Rectangle(3, 7), new Circle(50), new Square(15), new Triangle(0, -1, 0, 5, 34, 0), new Rectangle(13, 17), new Circle(6)};

        System.out.println("Фигура с максимальной площадью - " + getMaxAreaShape(shapes).toString());
        System.out.println("\n\nФигура со вторым по величине периметром - " + getSecondMaxPerimeterShape(shapes).toString());
    }
}
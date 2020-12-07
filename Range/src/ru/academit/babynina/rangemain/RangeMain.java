package ru.academit.babynina.rangemain;

import ru.academit.babynina.range.Range;

import java.util.Scanner;

public class RangeMain {
    private static String print(Range[] ranges) {
        if (ranges.length == 0) {
            return "пуст.";
        }

        if (ranges.length == 1) {
            return "равен:" + ranges[0].toString();
        }

        return "равен:" + ranges[0].toString() + " и" + ranges[1].toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите начальное число первого диапазона: ");
        double range1From = scanner.nextDouble();

        System.out.print("Введите конечное число первого диапазона: ");
        double range1To = scanner.nextDouble();

        System.out.print("Введите начальное число второго диапазона: ");
        double range2From = scanner.nextDouble();

        System.out.print("Введите конечное число второго диапазона: ");
        double range2To = scanner.nextDouble();

        Range range1 = new Range(range1From, range1To);
        Range range2 = new Range(range2From, range2To);

        Range intersection = range1.getIntersection(range2);

        if (intersection == null) {
            System.out.println("Интервалы не имеют пересечений.");
        } else {
            System.out.println("Интервал-пересечение двух интервалов равен:" + intersection.toString());

        }

        Range[] union = range1.getUnion(range2);
        System.out.println("Интервал-объединение двух интервалов " + print(union));

        Range[] difference = range1.getDifference(range2);
        System.out.println("Интервал-разность двух интервалов " + print(difference));
    }
}
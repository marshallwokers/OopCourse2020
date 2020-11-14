package ru.academit.babynina;

import java.util.Scanner;

public class ProgramForRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите начальное число первого диапазона: ");
        double firstRangeFrom = scanner.nextDouble();

        System.out.print("Введите конечное число первого диапазона: ");
        double firstRangeTo = scanner.nextDouble();

        System.out.print("Введите начальное число второго диапазона: ");
        double secondRangeFrom = scanner.nextDouble();

        System.out.print("Введите конечное число второго диапазона: ");
        double secondRangeTo = scanner.nextDouble();

        Range firstRange = new Range(firstRangeFrom, firstRangeTo);
        Range secondRange = new Range(secondRangeFrom, secondRangeTo);

        Range intersectionRangeResult = firstRange.getIntersection(secondRange);

        if (intersectionRangeResult == null) {
            System.out.println("Интервалы не имеют пересечений.");
        } else {
            System.out.println("Интервал-пересечение двух интервалов равен: от " + intersectionRangeResult.getFrom() + " до " + intersectionRangeResult.getTo());
        }

        Range[] unionRangeResult = firstRange.getUnion(secondRange);

        if (unionRangeResult.length == 1) {
            System.out.println("Интервал-объединение двух интервалов равен: от " + unionRangeResult[0].getFrom() + " до " + unionRangeResult[0].getTo());
        } else {
            System.out.println("Интервалы-объединение двух интервалов равен: от " + unionRangeResult[0].getFrom() + " до " + unionRangeResult[0].getTo() + " и от " + unionRangeResult[1].getFrom() + " до " + unionRangeResult[1].getTo());
        }

        Range[] differenceRangeResult = firstRange.getDifference(secondRange);

        if (differenceRangeResult == null) {
            System.out.println("Интервал-разность не найден, т.к. интервалы не имеют пересечений");
        } else if (differenceRangeResult.length == 1) {
            System.out.println("Интервал-разность двух интервалов равен: от " + differenceRangeResult[0].getFrom() + " до " + differenceRangeResult[0].getTo());
        } else {
            System.out.println("Интервалы-разность двух интервалов равен: от " + differenceRangeResult[0].getFrom() + " до " + differenceRangeResult[0].getTo() + " и от " + differenceRangeResult[1].getFrom() + " до " + differenceRangeResult[1].getTo());
        }
    }
}
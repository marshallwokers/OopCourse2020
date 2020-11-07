package ru.academit.babynina;

import java.util.Scanner;

public class ProgramForRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите начальное число диапазона: ");
        double from = scanner.nextDouble();

        System.out.print("Введите конечное число диапазона: ");
        double to = scanner.nextDouble();

        System.out.print("Введите число для проверки: ");
        double number = scanner.nextDouble();

        Range userRange = new Range(from, to);

        System.out.println("Длина диапазона равна: " + userRange.getLength());

        if (userRange.isInside(number)) {
            System.out.println("Введенное число принадлежит диапазону");
        } else {
            System.out.println("Введенное число не принадлежит диапазону");
        }
        userRange.setFrom(from + 1);
        userRange.setTo(to + 1);
        System.out.println("Диапазон, смещенный на единицу от " + userRange.getFrom() + " до " + userRange.getTo());
    }
}
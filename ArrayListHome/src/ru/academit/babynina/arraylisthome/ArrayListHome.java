package ru.academit.babynina.arraylisthome;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHome {
    public static ArrayList<String> getLinesFromFile(String fileName) {
        ArrayList<String> linesFromFile = new ArrayList<>(70);

        try (Scanner scanner = new Scanner(new FileInputStream(fileName))) {
            while (scanner.hasNextLine()) {
                linesFromFile.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return linesFromFile;
    }

    public static void main(String[] args) {
        //Прочитать в список все строки из файла
        System.out.println(getLinesFromFile("ArrayListHome/input.txt") + "\n");

        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 4, 5, 5, 6, 7, 8, 8, 9, 10));

        //Удалить из списка целых чисел все чётные
        if (numbersList.removeIf(i -> i % 2 == 0)) {
            System.out.println("Все чётные числа списка были удалены. Итоговый список: " + numbersList + "\n");
        } else {
            System.out.println("Чётные числа не были найдены. Список остался без изменений.\n");
        }

        //Создать новый список без повторений
        ArrayList<Integer> uniqueNumbersList = new ArrayList<>(numbersList.size());
        uniqueNumbersList.add(numbersList.get(0));

        for (Integer i : numbersList) {
            if (!uniqueNumbersList.contains(i)) {
                uniqueNumbersList.add(i);
            }
        }

        System.out.println("Список чисел без повторений: " + uniqueNumbersList);
    }
}
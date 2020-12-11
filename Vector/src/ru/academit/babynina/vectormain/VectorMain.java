package ru.academit.babynina.vectormain;

import ru.academit.babynina.vector.Vector;

public class VectorMain {
    public static void main(String[] args) {
        Vector vector1 = new Vector(5);
        Vector vector2 = new Vector(vector1.getSize(), new double[]{1.0, 2.0, 3.0});
        Vector vector3 = new Vector(vector2);
        Vector vector4 = new Vector(new double[]{6.0, 5.0, 4.0, 3.0, 2.0, 1.0});

        System.out.println("vector1 : " + vector1.toString());
        System.out.println("vector2 : " + vector1.toString());
        System.out.println("vector3 : " + vector1.toString());
        System.out.println("vector4 : " + vector1.toString() + "\n\n");
        System.out.println("vector2 после прибавления к нему vector4 равен : " + vector2.sum(vector4).toString());
        System.out.println("vector1 после вычитания из него vector2 равен : " + vector1.subtract(vector2).toString());
        System.out.println("vector2 после умножения на скаляр 3 равен : " + vector2.multiply(3).toString());
        System.out.println("Развернутый vector1 : " + vector1.inverse().toString());
        System.out.println("Длина vector3 равна: " + vector3.getLength());
        vector4.setVectorComponentByIndex(0, 10.0);
        System.out.println("Компонент vector4 по индексу 0 равен: " + vector4.getVectorComponentByIndex(0));
        System.out.println("Хэш-код vector4 равен: " + vector4.hashCode());
        Vector sumResultVector = Vector.getSumResultVector(vector1, vector2);
        System.out.println("Результирующий вектор сложения векторов vector1 и vector2 равен: " + sumResultVector.toString());

        if (sumResultVector.equals(vector1)) {
            System.out.println("Векторы sumResultVector и vector1 равны");
        } else {
            System.out.println("Векторы sumResultVector и vector1 не равны");
        }

        System.out.println("Результирующий вектор вычитания векторов sumResultVector и vector1 равен: " + Vector.getSubtractResultVector(sumResultVector, vector1).toString());
        System.out.println("Результирующий вектор скалярного произведения векторов sumResultVector и vector1 равен: " + Vector.getMultiplyResultVector(sumResultVector, vector3).toString());
    }
}
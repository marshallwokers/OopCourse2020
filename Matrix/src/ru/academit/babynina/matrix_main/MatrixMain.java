package ru.academit.babynina.matrix_main;

import ru.academit.babynina.matrix.Matrix;
import ru.academit.babynina.vector.Vector;

public class MatrixMain {
    public static void main(String[] args) {
        double[][] doublesArray = {{1, 2}, {3, 4, 5}, {6}, {7, 8}};
        double[][] doublesArray1 = {{3, -4, 5, 2}, {2, 1, -1, 4}, {5, 2, 2, 6}, {3, 4, 2, 3}};
        double[][] doublesArray2 = {{3}, {2}, {0}, {1}};
        double[][] doublesArray3 = {{-1, 0, 2}, {3, 1, -4}};
        double[][] doublesArray4 = {{-3, 7}, {4, 0}, {5, -2}};


        Vector vector1 = new Vector(new double[]{4.0});
        Vector vector2 = new Vector(new double[]{4.0, 4.0});
        Vector vector3 = new Vector(new double[]{4.0, 4.0, 4.0});
        Vector vector4 = new Vector(new double[]{4.0, 4.0, 4.0, 4.0});
        Vector vector5 = new Vector(new double[]{-1.0, 1.0, 0, 2.0});

        Vector[] vectorsArray = new Vector[]{vector1, vector2, vector3};

        Matrix matrix1 = new Matrix(2, 4);
        Matrix matrix2 = new Matrix(matrix1);
        Matrix matrix3 = new Matrix(doublesArray);
        Matrix matrix4 = new Matrix(vectorsArray);
        Matrix matrix5 = new Matrix(doublesArray1);
        Matrix matrix6 = new Matrix(doublesArray2);
        Matrix matrix12 = new Matrix(doublesArray3);
        Matrix matrix13 = new Matrix(doublesArray4);

        System.out.println("РЕЗУЛЬТАТЫ КОНСТРУКТОРОВ:");
        System.out.println("a) Первая матрица: " + matrix1);
        System.out.println("b) Вторая матрица (копия первой): " + matrix2);
        System.out.println("c) Третья матрица (из двумерного массива): " + matrix3);
        System.out.println("d) Четвертая матрица (из массива векторов): " + matrix4);

        System.out.println();
        System.out.println("РЕЗУЛЬТАТЫ МЕТОДОВ:");
        System.out.println("a) Размеры третьей матрицы: " + matrix3.getRowsAmount() + " x " + matrix3.getColumnsAmount());
        System.out.println("b) Строка по индексу 2 четвертой матрицы: " + matrix4.getRow(2));
        matrix2.setRow(0, vector4);
        System.out.println("b) Вторая матрица после задания вектора " + vector4 + " по индексу 0: " + matrix2);
        matrix2.transpose();
        System.out.println("с и d) Транспонированная матрица 2: " + matrix2);
        matrix3.scalarMultiply(2);
        System.out.println("e) Матрица3 умноженная на скаляр 2: " + matrix3);
        System.out.println("f) Детерминант матрицы 5: " + matrix5.getDeterminant());
        Matrix matrix7 = matrix6.vectorMultiply(vector5);
        System.out.println("h) Матрица 7 - результат умножения матрицы6 на вектор {-1, 1, 0, 2}: " + matrix7);
        Matrix matrix8 = matrix5.getSum(matrix7);
        System.out.println("i) Матрица 8 - результат сложения матриц 5 и 7: " + matrix8);
        Matrix matrix9 = matrix5.getSubtract(matrix7);
        System.out.println("i) Матрица 9 - результат вычитания матриц 5 и 7: " + matrix9);
        System.out.println();
        System.out.println("РЕЗУЛЬТАТЫ НЕСТАТИЧЕСКИХ МЕТОДОВ:");
        Matrix matrix10 = Matrix.getSum(matrix5, matrix7);
        System.out.println("a) Матрица 10 - результат сложения матриц 5 и 7: " + matrix10);
        Matrix matrix11 = Matrix.getSubtract(matrix5, matrix7);
        System.out.println("b) Матрица 11 - результат вычитания матриц 5 и 7: " + matrix11);
        Matrix matrix14 = Matrix.multiply(matrix12, matrix13);
        System.out.println("c) Матрица 14 - результат умножения матриц 12 и 13: " + matrix14);
    }
}

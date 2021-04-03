package ru.academit.babynina.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    //Конструкторы

    //размерность n, все компоненты равны 0
    public Vector(int vectorDimension) {
        if (vectorDimension <= 0) {
            throw new IllegalArgumentException("Vector length is " + vectorDimension + ". Must be more than 0");
        }

        components = new double[vectorDimension];
    }

    //конструктор копирования
    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    //заполнение вектора значениями из массива
    public Vector(double[] vectorComponents) {
        if (vectorComponents.length <= 0) {
            throw new IllegalArgumentException("Vector length is " + vectorComponents.length + ". Must be more than 0");
        }

        components = Arrays.copyOf(vectorComponents, vectorComponents.length);
    }

    //заполнение вектора значениями из массива. Если длина массива меньше n, то считать что в остальных компонентах 0
    public Vector(int vectorDimension, double[] vectorComponents) {
        this(vectorDimension);

        if (vectorComponents.length > vectorDimension) {
            throw new IllegalArgumentException("Vector dimension is " + vectorDimension + ". Array length is " +
                    vectorComponents.length + ". Vector dimension must be more than array length.");
        }

        components = Arrays.copyOf(vectorComponents, vectorDimension);
    }

    //Получить размерность вектора
    public int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ ");

        for (int i = 0; i < components.length; ++i) {
            stringBuilder.append(components[i]);

            if (i != components.length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(" }");

        return stringBuilder.toString();
    }

    //Прибавление к вектору другого вектора
    public Vector getSum(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; ++i) {
            components[i] += vector.components[i];
        }

        return this;
    }

    //Вычитание из вектора другого вектора
    public Vector getSubtract(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; ++i) {
            components[i] -= vector.components[i];
        }

        return this;
    }

    //Умножение вектора на скаляр
    public Vector multiply(double scalar) {
        for (int i = 0; i < components.length; ++i) {
            components[i] *= scalar;
        }

        return this;
    }

    //Разворот вектора (умножение всех компонент на -1)
    public Vector getInverseVector() {
        return multiply(-1);
    }

    //Получение длины вектора
    public double getLength() {
        double squaresOfComponentsSum = 0;

        for (double e : components) {
            squaresOfComponentsSum += e * e;
        }

        return Math.sqrt(squaresOfComponentsSum);
    }

    //Получение и установка компоненты вектора по индексу
    public double getComponent(int index) {
        return components[index];
    }

    public void setComponent(int index, double value) {
        components[index] = value;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        hash = (prime * hash) + components.length;
        hash = (prime * hash) + Arrays.hashCode(components);

        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Vector vector = (Vector) o;

        return components.length == vector.components.length && Arrays.equals(components, vector.components);
    }

    //Сложение двух векторов
    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector resultVector = new Vector(vector1);

        return resultVector.getSum(vector2);
    }

    //Вычитание векторов
    public static Vector getSubtract(Vector vector1, Vector vector2) {
        Vector resultVector = new Vector(vector1);

        return resultVector.getSubtract(vector2);
    }

    //Скалярное произведение векторов
    public static double getScalarProduct(Vector vector1, Vector vector2) {
        double scalarProduct = 0;

        for (int i = 0; i < Math.min(vector1.components.length, vector2.components.length); ++i) {
            scalarProduct += vector1.components[i] * vector2.components[i];
        }

        return scalarProduct;
    }
}
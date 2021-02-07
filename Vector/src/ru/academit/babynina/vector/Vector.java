package ru.academit.babynina.vector;

import java.util.Arrays;

public class Vector {
    private int n;
    private double[] components;

    //Конструкторы

    //размерность n, все компоненты равны 0
    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Vector length must be n > 0");
        }

        this.n = n;
        components = new double[n];
    }

    //конструктор копирования
    public Vector(Vector vector) {
        n = vector.n;
        components = vector.components;
    }

    //заполнение вектора значениями из массив
    public Vector(double[] vectorComponents) {
        n = vectorComponents.length;
        components = vectorComponents;
    }

    //заполнение вектора значениями из массива. Если длина массива меньше n, то считать что в остальных компонентах 0
    public Vector(int n, double[] vectorComponents) {
        this(n);
        System.arraycopy(vectorComponents, 0, components, 0, vectorComponents.length);

        if (vectorComponents.length < n) {
            for (int i = vectorComponents.length; i < n; ++i) {
                components[i] = 0;
            }
        }
    }

    //Получить размерность вектора
    public int getSize() {
        return n;
    }

    public void setSize(int n) {
        this.n = n;
    }

    public double[] getComponents() {
        return components;
    }

    public void setComponents(double[] components) {
        this.components = components;
        setSize(components.length);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ ");

        for (int i = 0; i < n; ++i) {
            stringBuilder.append(components[i]);

            if (i != n - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(" }");

        return stringBuilder.toString();
    }

    //Прибавление к вектору другого вектора
    public Vector sum(Vector vector) {
        Vector tempVector;

        if (n < vector.n) {
            tempVector = new Vector(vector.n, components);
            setComponents(tempVector.components);
        }

        if (n > vector.n) {
            tempVector = new Vector(n, vector.components);
            vector.setComponents(tempVector.components);
        }

        for (int i = 0; i < n; ++i) {
            components[i] += vector.components[i];
        }

        return this;
    }

    //Вычитание из вектора другого вектора
    public Vector subtract(Vector vector) {
        Vector tempVector;

        if (n < vector.n) {
            tempVector = new Vector(vector.n, components);
            setComponents(tempVector.components);
        }

        if (n > vector.n) {
            tempVector = new Vector(n, vector.components);
            vector.setComponents(tempVector.components);
        }

        for (int i = 0; i < n; ++i) {
            components[i] -= vector.components[i];
        }

        return this;
    }

    //Умножение вектора на скаляр
    public Vector multiply(int scalar) {
        for (int i = 0; i < n; ++i) {
            components[i] *= scalar;
        }

        return this;
    }

    //Разворот вектора (умножение всех компонент на -1)
    public Vector inverse() {
        for (int i = 0; i < n; ++i) {
            if (components[i] == 0) {
                continue;
            }
            components[i] *= -1;
        }

        return this;
    }

    //Получение длины вектора
    public double getLength() {
        double temp = 0;

        for (double e : components) {
            temp += Math.pow(e, 2);
        }

        return Math.sqrt(temp);
    }

    //Получение и установка компоненты вектора по индексу
    public double getVectorComponentByIndex(int index) {
        return components[index];
    }

    public void setVectorComponentByIndex(int index, double value) {
        components[index] = value;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = (prime * hash) + n;
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

        return n == vector.n && Arrays.equals(components, ((Vector) o).components);
    }

    //Сложение двух векторов
    public static Vector getSumResultVector(Vector vector1, Vector vector2) {
        Vector resultVector = new Vector(Math.max(vector1.n, vector2.n));
        int temp = Math.min(vector1.n, vector2.n);

        for (int i = 0; i < temp; ++i) {
            resultVector.components[i] = vector1.components[i] + vector2.components[i];
        }

        return resultVector;
    }

    //Вычитание векторов
    public static Vector getSubtractResultVector(Vector vector1, Vector vector2) {
        Vector resultVector = new Vector(Math.max(vector1.n, vector2.n));
        int temp = Math.min(vector1.n, vector2.n);

        for (int i = 0; i < temp; ++i) {
            resultVector.components[i] = vector1.components[i] - vector2.components[i];
        }

        return resultVector;
    }

    //Скалярное произведение векторов
    public static Vector getMultiplyResultVector(Vector vector1, Vector vector2) {
        Vector resultVector = new Vector(Math.max(vector1.n, vector2.n));
        int temp = Math.min(vector1.n, vector2.n);

        for (int i = 0; i < temp; ++i) {
            resultVector.components[i] = vector1.components[i] * vector2.components[i];
        }

        return resultVector;
    }
}
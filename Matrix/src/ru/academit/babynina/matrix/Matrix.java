package ru.academit.babynina.matrix;

import ru.academit.babynina.vector.Vector;

public class Matrix {
    private Vector[] rows;

//Конструкторы:

    //a. Matrix(n, m) – матрица нулей размера nxm
    public Matrix(int rows, int columns) {
        if (rows == 0 || columns == 0) {
            throw new IllegalArgumentException("Rows is " + rows + ". Columns is " + columns + ". Rows and columns must be more than 0.");
        }

        this.rows = new Vector[rows];

        for (int i = 0; i < rows; ++i) {
            this.rows[i] = new Vector(columns);
        }
    }

    //b. Matrix(Matrix) – конструктор копирования
    public Matrix(Matrix matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix is null. Matrix must be filled.");
        }

        rows = new Vector[matrix.getRowsAmount()];

        for (int i = 0; i < matrix.getRowsAmount(); ++i) {
            rows[i] = new Vector(matrix.rows[i]);
        }
    }

    //c. Matrix(double[][]) – из двумерного массива
    public Matrix(double[][] doubles) {
        if (doubles == null || doubles.length == 0) {
            throw new IllegalArgumentException("Array is null or his length is 0. Array must be filled.");
        }

        rows = new Vector[doubles.length];
        int maxArrayLength = 0;

        for (double[] e : doubles) {
            maxArrayLength = Math.max(maxArrayLength, e.length);
        }

        for (int i = 0; i < getRowsAmount(); ++i) {
            rows[i] = new Vector(maxArrayLength, doubles[i]);
        }
    }

    //d. Matrix(Vector[]) – из массива векторов-строк
    public Matrix(Vector[] vectors) {
        if (vectors == null || vectors.length == 0) {
            throw new IllegalArgumentException("Array is null or his length is 0. Array must be filled.");
        }

        rows = new Vector[vectors.length];
        int maxVectorsLength = 0;

        for (Vector e : vectors) {
            maxVectorsLength = Math.max(maxVectorsLength, e.getSize());
        }

        double[] vectorComponents = new double[maxVectorsLength];

        for (int i = 0; i < getRowsAmount(); ++i) {
            for (int j = 0; j < vectors[i].getSize(); ++j) {
                vectorComponents[j] = vectors[i].getComponent(j);
            }

            rows[i] = new Vector(vectorComponents);
        }
    }

// Методы:

    private void checkIndexCorrectness(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index must be a positive number.");
        }

        if (index >= getRowsAmount()) {
            throw new IndexOutOfBoundsException("Index must be less than rows matrix amount (" + getRowsAmount() + ").");
        }
    }

    //a. Получение размеров матрицы
    public int getRowsAmount() {
        return rows.length;
    }

    public int getColumnsAmount() {
        return rows[0].getSize();
    }

    //b. Получение и задание вектора-строки по индексу
    public Vector getRow(int index) {
        checkIndexCorrectness(index);

        return rows[index];
    }

    public void setRow(int index, Vector vector) {
        checkIndexCorrectness(index);

        if (vector.getSize() != rows[index].getSize()) {
            throw new IllegalArgumentException("Vector's length (" + vector.getSize() + ") must match the matrix column amount (" + rows[index].getSize() + ").");
        }

        rows[index] = new Vector(vector);
    }

    //c. Получение вектора-столбца по индексу
    public Vector getColumn(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index must be a positive number.");
        }

        if (index >= getColumnsAmount()) {
            throw new IndexOutOfBoundsException("Index must be less than columns matrix amount (" + getColumnsAmount() + ").");
        }

        Vector columnComponents = new Vector(getRowsAmount());

        for (int i = 0; i < getRowsAmount(); ++i) {
            columnComponents.setComponent(i, rows[i].getComponent(index));
        }

        return columnComponents;
    }

    //d. Транспонирование матрицы
    public void transpose() {
        Vector[] tempMatrix = new Vector[getColumnsAmount()];

        for (int i = 0; i < getColumnsAmount(); i++) {
            tempMatrix[i] = getColumn(i);
        }

        rows = tempMatrix;
    }

    //e. Умножение на скаляр
    public void scalarMultiply(double scalar) {
        for (Vector e : rows) {
            e.multiply(scalar);
        }
    }

    //f. Вычисление определителя матрицы (разложение по столбцам)
    public double getDeterminant() {
        if (getRowsAmount() != getColumnsAmount()) {
            throw new IllegalArgumentException("Only a square matrix have a determinant. Dimensions of this matrix " + getRowsAmount() + " x " + getColumnsAmount() + ".");
        }

        if (getRowsAmount() == 1) {
            return rows[0].getComponent(0);
        }

        if (getRowsAmount() == 2) {
            return rows[0].getComponent(0) * rows[1].getComponent(1) - rows[1].getComponent(0) * rows[0].getComponent(1);
        }

        double result = 0;

        for (int i = 0; i < getColumnsAmount(); i++) {
            double[][] temp = new double[getRowsAmount() - 1][getColumnsAmount() - 1];

            for (int j = 1; j < getRowsAmount(); j++) {
                int columnIndex = 0;

                for (int k = 0; k < getRowsAmount(); k++) {
                    if (k == i) {
                        continue;
                    }

                    temp[j - 1][columnIndex] = rows[j].getComponent(k);
                    columnIndex++;
                }
            }
            result += Math.pow(-1, i) * rows[0].getComponent(i) * new Matrix(temp).getDeterminant();
        }

        return result;
    }

    //g. toString определить так, чтобы результат получался в таком виде: { { 1, 2 }, { 2, 3 } }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");

        for (int i = 0; i < getRowsAmount(); ++i) {
            stringBuilder.append(rows[i]);

            if (i != getRowsAmount() - 1) {
                stringBuilder.append(", ");
            }
        }

        stringBuilder.append("}");

        return stringBuilder.toString();
    }

    //h. умножение матрицы на вектор
    public Matrix vectorMultiply(Vector vector) {
        if (getColumnsAmount() != 1) {
            throw new IllegalArgumentException("Matrix can only be a column vector. This matrix contains " + getColumnsAmount() + " columns.");
        }

        if (getRowsAmount() != vector.getSize()) {
            throw new IllegalArgumentException("Rows amount in the column vector have to match columns amount in the row vector. " +
                    "This matrix contains " + getRowsAmount() + " rows. This vector contains " + vector.getSize() + " columns.");
        }

        int resultMatrixSize = getRowsAmount();
        Matrix resultMatrix = new Matrix(resultMatrixSize, resultMatrixSize);

        for (int i = 0; i < resultMatrixSize; ++i) {
            for (int j = 0; j < resultMatrixSize; ++j) {
                resultMatrix.getRow(i).setComponent(j, rows[i].getComponent(0) * vector.getComponent(j));
            }
        }

        return resultMatrix;
    }

    private static void checkMatrixEquality(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsAmount() != matrix2.getColumnsAmount() || matrix1.getRowsAmount() != matrix2.getRowsAmount()) {
            throw new IllegalArgumentException("Matrix must be the same dimensions. Dimensions of those matrix " + matrix1.getRowsAmount()
                    + "x" + matrix1.getColumnsAmount() + " and " + matrix2.getRowsAmount() + "x" + matrix2.getColumnsAmount() + ".");
        }
    }

    //i. Сложение матриц
    public Matrix getSum(Matrix matrix) {
        checkMatrixEquality(this, matrix);

        for (int i = 0; i < getRowsAmount(); ++i) {
            for (int j = 0; j < getColumnsAmount(); ++j) {
                rows[i].setComponent(j, rows[i].getComponent(j) + matrix.getRow(i).getComponent(j));
            }
        }

        return this;
    }

    //j. Вычитание матриц
    public Matrix getSubtract(Matrix matrix) {
        checkMatrixEquality(this, matrix);

        for (int i = 0; i < getRowsAmount(); ++i) {
            for (int j = 0; j < getColumnsAmount(); ++j) {
                rows[i].setComponent(j, rows[i].getComponent(j) - matrix.getRow(i).getComponent(j));
            }
        }

        return this;
    }

//3. Статические методы:

    //a. Сложение матриц
    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        Matrix resultMatrix = new Matrix(matrix1);

        return resultMatrix.getSum(matrix2);
    }

    //b. Вычитание матриц
    public static Matrix getSubtract(Matrix matrix1, Matrix matrix2) {
        Matrix resultMatrix = new Matrix(matrix1);

        return resultMatrix.getSubtract(matrix2);
    }

    //c. Умножение матриц
    public static Matrix multiply(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getRowsAmount() != matrix2.getColumnsAmount()) {
            throw new IllegalArgumentException("Matrix 1 columns amount have to match matrix 2 rows amount. Matrix 1 columns amount is " + matrix1.getColumnsAmount()
                    + ". Matrix 2 rows amount is " + matrix2.getRowsAmount() + ".");
        }

        int resultMatrixSize = matrix1.getRowsAmount();
        Matrix resultMatrix = new Matrix(resultMatrixSize, resultMatrixSize);
        double element = 0;

        for (int i = 0; i < resultMatrixSize; ++i) {
            for (int j = 0; j < resultMatrixSize; ++j) {
                for (int k = 0; k < resultMatrixSize + 1; ++k) {
                    element += matrix1.getRow(i).getComponent(k) * matrix2.getRow(k).getComponent(j);
                }

                resultMatrix.getRow(i).setComponent(j, element);
                element = 0;
            }
        }

        return resultMatrix;
    }
}
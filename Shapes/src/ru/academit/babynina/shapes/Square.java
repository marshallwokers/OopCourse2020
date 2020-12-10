package ru.academit.babynina.shapes;

public class Square implements Shapes {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getWidth() {
        return sideLength;
    }

    @Override
    public double getHeight() {
        return sideLength;
    }

    @Override
    public double getArea() {
        return Math.pow(sideLength, 2);
    }

    @Override
    public double getPerimeter() {
        return sideLength * 4;
    }

    @Override
    public String toString() {
        return String.format("квадрат с длиной стороны %.2f.\nШирина равна %.2f.\nВысота равна %.2f.\nПлощадь равна %.2f.\nПериметр равен %.2f.\nХэш-код равен %d.", sideLength, getWidth(), getHeight(), getArea(), getPerimeter(), hashCode());
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = (prime * hash) + Double.hashCode(sideLength);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Square square = (Square) o;

        return sideLength == square.sideLength;
    }
}
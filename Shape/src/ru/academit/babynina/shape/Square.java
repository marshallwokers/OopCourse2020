package ru.academit.babynina.shape;

public class Square implements Shape {
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
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter() {
        return sideLength * 4;
    }

    @Override
    public String toString() {
        return String.format("[ Квадрат с длиной стороны %.2f. Площадь = %.2f. Периметр = %.2f. ]", sideLength, getArea(), getPerimeter());
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

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Square square = (Square) o;

        return sideLength == square.sideLength;
    }
}
package ru.academit.babynina.shapes;

public class Rectangle implements Shapes {
    private double firstSideLength;
    private double secondSideLength;

    public Rectangle(double firstSideLength, double secondSideLength) {
        this.firstSideLength = firstSideLength;
        this.secondSideLength = secondSideLength;
    }

    public double getFirstSideLength() {
        return firstSideLength;
    }

    public void setFirstSideLength(double firstSideLength) {
        this.firstSideLength = firstSideLength;
    }

    public double getSecondSideLength() {
        return secondSideLength;
    }

    public void setSecondSideLength(double secondSideLength) {
        this.secondSideLength = secondSideLength;
    }

    @Override
    public double getWidth() {
        return Math.max(firstSideLength, secondSideLength);
    }

    @Override
    public double getHeight() {
        return Math.min(firstSideLength, secondSideLength);
    }

    @Override
    public double getArea() {
        return firstSideLength * secondSideLength;
    }

    @Override
    public double getPerimeter() {
        return (firstSideLength + secondSideLength) * 2;
    }

    @Override
    public String toString() {
        return String.format("прямоуольник со сторонами %.2f и %.2f.\nШирина равна %.2f.\nВысота равна %.2f.\nПлощадь равна %.2f.\nПериметр равен %.2f.\nХэш-код равен %d.", firstSideLength, secondSideLength, getWidth(), getHeight(), getArea(), getPerimeter(), hashCode());
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = (prime * hash) + Double.hashCode(firstSideLength);
        hash = (prime * hash) + Double.hashCode(secondSideLength);
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

        Rectangle rectangle = (Rectangle) o;

        return firstSideLength == rectangle.firstSideLength && secondSideLength == rectangle.secondSideLength;
    }
}
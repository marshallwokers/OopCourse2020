package ru.academit.babynina.shapes;

public class Circle implements Shapes {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getWidth() {
        return 2 * radius;
    }

    @Override
    public double getHeight() {
        return 2 * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return String.format("круг с радиусом %.2f.\nШирина равна %.2f.\nВысота равна %.2f.\nПлощадь равна %.2f.\nПериметр равен %.2f.\nХэш-код равен %d.", radius, getWidth(), getHeight(), getArea(), getPerimeter(), hashCode());
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = (prime * hash) + Double.hashCode(radius);
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

        Circle circle = (Circle) o;

        return radius == circle.radius;
    }
}
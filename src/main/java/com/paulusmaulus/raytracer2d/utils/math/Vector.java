package com.paulusmaulus.raytracer2d.utils.math;

public class Vector {
    private double x;
    private double y;

    public Vector(double x, double y) {
        super();
        this.x = x;
        this.y = y;
    }

    public Vector(double val) {
        this(val, val);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Vector add(Vector other) {
        return new Vector(x + other.x, y + other.y);
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }

}

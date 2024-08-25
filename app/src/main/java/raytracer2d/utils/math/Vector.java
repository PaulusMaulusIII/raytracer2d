package raytracer2d.utils.math;

public class Vector {

    public double x, y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector rotate(double roll) {
        double cosRoll = Math.cos(roll);
        double sinRoll = Math.sin(roll);
        double rotatedX = x * cosRoll - y * sinRoll;
        double rotatedY = y * cosRoll + x * sinRoll;

        return new Vector(rotatedX, rotatedY);
    }

    public double distance(Vector other) {
        Vector difference = this.subtract(other);
        return (double) Math.sqrt(difference.x * difference.x + difference.y * difference.y);
    }

    public Vector add(Vector other) {
        return new Vector(x + other.x, y + other.y);
    }

    public Vector subtract(Vector other) {
        return new Vector(x - other.x, y - other.y);
    }

    public Vector scale(double scalar) {
        return new Vector(x * scalar, y * scalar);
    }

    public double magnitude() {
        return (double) Math.sqrt(x * x + y * y);
    }

    public double length() {
        return x + y;
    }

    public Vector normalize() {
        double magnitude = magnitude();
        return new Vector(x / magnitude, y / magnitude);
    }

    public double dot(Vector other) {
        return this.x * other.x + this.y * other.y;
    }

    public double[] toArray() {
        return new double[] {
                x, y
        };
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }

    public boolean isParallel(Vector other) {
        return Math.abs(this.dot(other) - 1) < 1e-6 || Math.abs(this.dot(other) + 1) < 1e-6;
    }

    public Vector invert() {
        return new Vector(-x, -y);
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
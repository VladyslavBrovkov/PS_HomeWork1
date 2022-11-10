package homework.first.Task3;

import java.util.Objects;

public class Cylinder implements Shape {
    private double high;
    private double radius;
    private double volume;

    private Cylinder(double high, double radius) {
        this.high = high;
        this.radius = radius;
        calculateCylinderVolume();
    }

    public static Cylinder createCylinder(double high, double radius) {
        if (high <= 0 || radius <= 0) {
            throw new IllegalArgumentException("High and radius must both be positive");
        }
        return new Cylinder(high, radius);
    }

    public double getHigh() {
        return high;
    }

    public double getRadius() {
        return radius;
    }

    public void setHigh(double high) {
        this.high = high;
        calculateCylinderVolume();
    }

    public void setRadius(double radius) {
        this.radius = radius;
        calculateCylinderVolume();
    }

    public double getVolume() {
        return volume;
    }

    private void calculateCylinderVolume() {
        volume = Math.PI * Math.pow(2, this.radius) * this.high;
    }

    @Override
    public double getShapeVolume() {
        return getVolume();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cylinder cylinder = (Cylinder) o;
        return Double.compare(cylinder.high, high) == 0 && Double.compare(cylinder.radius, radius) == 0 && Double.compare(cylinder.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(high, radius, volume);
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "high=" + high +
                ", radius=" + radius +
                ", volume=" + volume +
                '}';
    }
}

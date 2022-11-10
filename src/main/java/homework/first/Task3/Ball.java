package homework.first.Task3;

import java.util.Objects;

public class Ball implements Shape {
    private double radius;
    private double volume;

    private Ball(double radius) {
        this.radius = radius;
        calculateBallVolume();
    }

    public static Ball createBall(double radius){
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be a positive number");
        }
        return new Ball(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be a positive number");
        }
        this.radius = radius;
        calculateBallVolume();
    }

    public double getVolume() {
        return volume;
    }

    private void calculateBallVolume() {
        volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public double getShapeVolume() {
        return getVolume();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Double.compare(ball.radius, radius) == 0 && Double.compare(ball.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, volume);
    }

    @Override
    public String toString() {
        return "Ball{" +
                "radius=" + radius +
                ", volume=" + volume +
                '}';
    }

}

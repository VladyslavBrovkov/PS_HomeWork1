package homework.first.Task3;

import java.util.Objects;

public class Cube implements Shape {

    private double sideLength;

    private double volume;

    private Cube(double sideLength) {
        this.sideLength = sideLength;
        calculateCubeVolume();
    }

    public static Cube createCube(double sideLength){
        if (sideLength <= 0){
            throw new IllegalArgumentException("Cube sideLength must be positive");
        }
        return new Cube(sideLength);
    }

    public double getSideLength() {
        return sideLength;
    }


    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
        calculateCubeVolume();
    }

    public double getVolume() {
        return volume;
    }

    public void calculateCubeVolume() {
        volume = Math.pow(sideLength, 3);
    }

    @Override
    public double getShapeVolume() {
        return getVolume();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cube cube = (Cube) o;
        return Double.compare(cube.sideLength, sideLength) == 0 && Double.compare(cube.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideLength, volume);
    }

    @Override
    public String toString() {
        return "Cube{" +
                "sideLength=" + sideLength +
                ", volume=" + volume +
                '}';
    }
}

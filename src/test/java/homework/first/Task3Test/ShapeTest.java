package homework.first.Task3Test;

import homework.first.Task3.Ball;
import homework.first.Task3.Cube;
import homework.first.Task3.Cylinder;
import homework.first.Task3.Shape;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ShapeTest {
    /**
     * Check normal sorting of Shapes
     */
    @Test
    public void sortShapeByVolume() {
        List<Shape> shapeList = new ArrayList<>();
        Ball ball = Ball.createBall(5.0);
        Cylinder cylinder = Cylinder.createCylinder(5.0,6.0);
        Cube cube = Cube.createCube(7.0);
        shapeList.add(ball);
        shapeList.add(cylinder);
        shapeList.add(cube);

        List<Shape> expectedList = Shape.sortByVolume(shapeList);
        assertEquals(expectedList.get(0),cube);
        assertEquals(expectedList.get(1),ball);
        assertEquals(expectedList.get(2),cylinder);
    }


    /**
     * Check IllegalArgumentException message is thrown when a Ball with negative radius is created
     */
    @Test
    public void shouldThrowIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Ball.createBall(-5));
        assertEquals("Radius must be a positive number", exception.getMessage());
    }
}

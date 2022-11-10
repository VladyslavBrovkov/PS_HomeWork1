package homework.first.Task3;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ShapeUtil interface which provides two methods. One static method for sorting Shapes which implements
 * interface and one method for receiving volume
 */
public interface Shape {

    double getShapeVolume();

    static List<Shape> sortByVolume(List<Shape> shapeList) {
        return shapeList.stream()
                .sorted(Comparator.comparingDouble(Shape::getShapeVolume))
                .collect(Collectors.toList());
    }

}

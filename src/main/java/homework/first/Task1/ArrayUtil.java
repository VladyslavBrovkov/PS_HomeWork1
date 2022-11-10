package homework.first.Task1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * Utility class for filter and sort operations with Arrays using Stream API
 */
public class ArrayUtil {

    /**
     * filters Integer[] array where number >= 0 and makes reversed sorting
     * array must be not null and contains no null values
     *
     * @param array - input array of Integer type
     * @return Integer[]
     */
    public static Integer[] checkArray(Integer[] array) {
        if (array == null || Arrays.asList(array).contains(null)) {
            throw new NullPointerException("Cannot check array with null values");
        }
        return Arrays.stream(array)
                .filter(i -> i >= 0)
                .sorted(Comparator.reverseOrder())
                .toArray(Integer[]::new);
    }


    /**
     * filters primitive int[] array where number >= 0 and makes reversed sorting
     *
     * @param array - input array of int type
     * @return int[]
     */
    public static int[] checkArray(int[] array) {
        return IntStream.of(array)
                .boxed()
                .filter(i -> i >= 0)
                .sorted(Comparator.reverseOrder())
                .mapToInt(i -> i)
                .toArray();
    }


}

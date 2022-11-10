package homework.first.Task1Test;

import homework.first.Task1.ArrayUtil;
import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


/**
 * Unit tests for ArraysUtil class, Task1.
 */
public class ArrayUtilTest {
    /**
     * Check Integer[] array
     */
    @Test
    public void shouldCheckIntegerArray() {
        Integer[] inputArray = new Integer[]{1, 2, -4, -7, 0, 3, 4, 5,};
        Integer[] expectedArray = new Integer[]{5, 4, 3, 2, 1, 0};
        assertArrayEquals(expectedArray, ArrayUtil.checkArray(inputArray));
    }

    /**
     * Check primitive type int[] array
     */
    @Test
    public void shouldCheckIntArray() {
        int[] inputArray = new int[]{1, -3232, -4, -7, 0, 657, 98, 55,};
        int[] expectedArray = new int[]{657, 98, 55, 1, 0};
        assertArrayEquals(expectedArray, ArrayUtil.checkArray(inputArray));
    }

    /**
     * Check NullPointerException message is thrown when array has null
     */
    @Test
    public void shouldThrowNullPointerException() {
        Integer[] inputArray = new Integer[]{1, 2, -4, -7, 0, 3, 4, null, 76};
        NullPointerException exception = assertThrows(NullPointerException.class,
                ()-> ArrayUtil.checkArray(inputArray));
        assertEquals("Cannot check array with null values",exception.getMessage());
    }

}

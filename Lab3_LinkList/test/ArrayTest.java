import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTest {

    @Test
    void insert() {
        int[] actual = {5, 9, 14, 15};
        actual = Array.insert(actual, 6, 2);
        int[] expected = {5, 9, 6, 14, 15};

        assertArrayEquals(expected, actual);
    }

    @Test
    void reverse() {
        int[] expected = {1, 2, 3};
        Array.reverse(expected);
        int[] actual = {3, 2, 1};
        assertArrayEquals(expected, actual);


        int[] expected2 = {1, 2, 3, 4};
        Array.reverse(expected2);
        int[] actual2 = {4, 3, 2, 1};
        assertArrayEquals(expected2, actual2);

        int[] expected3 = {1};
        Array.reverse(expected3);
        int[] actual3 = {1};
        assertArrayEquals(expected3, actual3);





    }

    @Test
    void replicate() {
        int[] actual = {3, 2, 1};
        actual = Array.replicate(actual);
        int[] expected = {3, 3, 3, 2, 2, 1};
        assertArrayEquals(expected, actual);


        int[] actual2 = {4, 3, 2, 1};
        actual2 = Array.replicate(actual2);
        int[] expected2 = {4, 4, 4, 4, 3, 3, 3, 2, 2, 1};
        assertArrayEquals(expected2, actual2);

    }
}
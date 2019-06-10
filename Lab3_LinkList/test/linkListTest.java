import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class linkListTest {

    @Test
    void insert() {
        linkList actual = new linkList(2);
        actual.addFirst(6);
        actual.addFirst(5);
        actual.insert(10, 1);
        String expected = "5, 10, 6, 2";
        assertEquals(expected, actual.toString());
    }

    @Test
    void reverseByiter() {
        linkList actual = new linkList(2);
        actual.addFirst(6);
        actual.addFirst(5);
        actual.insert(10, 1);
        actual.reverseByiter();
        String expected = "2, 6, 10, 5";
        assertEquals(expected, actual.toString());
    }

    @Test
    void reverseByRecursive() {
        linkList actual = new linkList(2);
        actual.addFirst(6);
        actual.addFirst(5);
        actual.insert(10, 1);
        actual.reverseByRecursive();
        String expected = "2, 6, 10, 5";
        assertEquals(expected, actual.toString());
    }

}
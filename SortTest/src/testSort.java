import static org.junit.Assert.*;

public class testSort {
    public static void main(String[] args) {
        testSelectSort();
    }

    public static void testSelectSort(){
        String[] array = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg" , "have", "i"};
        Sort.selectSort(array);

        org.junit.Assert.assertArrayEquals(expected, array);

    }
}
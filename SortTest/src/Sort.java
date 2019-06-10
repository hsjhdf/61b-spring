public class Sort {
    public static void selectSort(String[] array) {
        /**three step 
         * 1. find the index of the smallest item
         * 2. swap it with the first index
         * 3. recursive solve the rest of part
         * 
         * make helper function 
        */
        selectSortHelp(array, 0);

    }
    public static void selectSortHelp(String[] array, int start) {
        if (start != array.length - 1) {
            int small = findSmallest(array, start);
            if (small != start) {
                swapArray(array, small, start);
            }
            selectSortHelp(array, start + 1);
        }
    }

    public static int findSmallest(String[] array, int start) {
        int index = start;
        for (int i = start + 1; i < array.length; i++) {
            if ((array[i].compareToIgnoreCase(array[index])) < 0) {
                index = i;
            } 
        }
        return index;
    }

    public static void swapArray(String[] array, int a, int b) {
        String temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
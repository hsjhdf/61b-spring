public class Array {
    public static int[] insert(int[] arr, int item, int position) {
        int[] temp = new int[arr.length + 1];
        System.arraycopy(arr, 0, temp,0, position);
        temp[position] = item;
        System.arraycopy(arr, position, temp, position + 1,temp.length - position - 1);
        return temp;
    }



    public static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }



    public static int[] replicate(int[] arr) {
        int sum = sumOfArray(arr);
        int[] temp = new int[sum];
        int index = 0;
        for (int i = 0; i < sum; i += arr[index++]) {
            for (int j = 0; j < arr[index]; j++) {
                temp[i + j] = arr[index];
            }
        }
        return temp;
    }


    private static int sumOfArray(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
}

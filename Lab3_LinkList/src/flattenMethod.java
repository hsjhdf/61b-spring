public class flattenMethod {
    public static int[] flatten(int[][] x) {
        int totalLength = 0;
        for (int i = 0; i < x.length; i++) {
            totalLength += x[i].length;
        }

        int[] a = new int[totalLength];
        int aIndex = 0;

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                a[aIndex++] = x[i][j];

            }
        }

        return a;

    }


    public static void main(String[] args) {
        int[][] x = {{1, 2, 3}, {}, {7, 8}};
        int[] b= flatten(x);

        for (int i = 0; i< b.length; i++) {
            System.out.print(b[i] + " ");
        }
    }


}

public class IntList {
    public int value;
    public IntList rest;

    public IntList(int value, IntList rest) {
        this.value = value;
        this.rest = rest;
    }

    public boolean equals(Object o)  {
        return true;
    }
    public static IntList list(int... args) {
        int length = args.length;

        if (length == 0) {
            return null;
        } else {
            IntList ptr = new IntList(args[0], null);
            IntList temp = ptr;
            for (int i = 1; i < length; i++) {
                temp.rest = new IntList(args[i], null);
                temp = temp.rest;
            }
            return ptr;

        }
    }

    public String toString() {
        if (rest == null) {
            return "null";
        } else {
            IntList ptr = rest;
            String result = "" + value;

            while(ptr != null) {
                result += " " + ptr.value;
                ptr = ptr.rest;
            }

            return result;
        }

    }

    public void skippify() {
        IntList p = this;
        int n = 1;
        while (p != null) {
            IntList next = p;

            for (int i = 0; i < n+1; i++) {
                if (next == null) {
                    break;
                }
                next = next.rest;
            }

            p.rest = next;
            p = next;
            n++;
        }
    }

    public static IntList ilsans(IntList x, int y) {
        if (x == null) {
            return x;
        }

        if (x.value == y) {
            return ilsans(x.rest, y);
        }

        return new IntList(x.value, ilsans(x.rest, y));
    }

    public static IntList dilsans(IntList x, int y) {
        if (x == null) {
            return null;
        }
        IntList ptr = x.rest;
        if (x.value == y) {
            return dilsans(x.rest, y);
        }

        return x;
    }
    public static void main(String[] args) {
        IntList A = IntList.list(1, 2, 7, 3, 4, 7, 5, 6, 7,  8, 9, 10);
        IntList B = IntList.list(9, 8, 7, 6, 5, 4, 3, 2, 1);
        IntList C = IntList.list(2, 2, 2, 2, 2);

//        A.skippify();
//        B.skippify();
        IntList test = IntList.ilsans(C, 2);

//        System.out.println(A);
//        System.out.println(B);
        System.out.println(test);



    }


}

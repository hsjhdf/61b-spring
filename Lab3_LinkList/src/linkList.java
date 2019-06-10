public class linkList {
    private class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;


    public linkList() {
        first = null;
    }
    public linkList(int item) {
        first = new IntNode(item, null);
    }

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }
    public void insert(int item, int position) {
        if (first == null || position == 0) {
            addFirst(item);
        } else {
            IntNode ptr = first;
            while(position != 1 && ptr.next != null) {
                position--;
                ptr = ptr.next;
            }
            ptr.next = new IntNode(item, ptr.next);

        }
    }

    public void reverseByiter(){
        if (first != null && first.next != null) {
            IntNode temp;
            IntNode before = first;
            IntNode ptr= first.next;
            while (ptr != null) {
               temp = ptr.next;
               ptr.next = before;
               before = ptr;
               ptr = temp;
            }
            first.next = null;
            first = before;

        }
    }

    public void reverseByRecursive() {
        if (first != null && first.next != null) {
            IntNode ptr = first;
            IntNode end;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            end = ptr;
            reverseByRecursiveHelper(first, end);
            first = end;
        }

    }
    private void reverseByRecursiveHelper(IntNode first, IntNode end) {
        if (first == end) {
            first.next = null;
        } else {
            IntNode ptr = first;
            while (ptr.next != end) {
                ptr = ptr.next;
            }
            end.next = ptr;
            ptr.next = null;
            reverseByRecursiveHelper(first, end.next);
        }
    }



    public String toString() {
        if (first == null) {
            return "null";
        } else {
            String result = "" + first.item;
            first = first.next;
            while(first != null) {
                result += ", ";
                result += first.item;
                first = first.next;
            }
            return result;
        }

    }

}

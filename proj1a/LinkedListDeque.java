public class LinkedListDeque<T> {

    private class IntNode {
        private T item;
        private IntNode next;
        private IntNode before;

        IntNode(T item, IntNode before, IntNode next) {
            this.item = item;
            this.next = next;
            this.before = before;
        }

        IntNode() {
            this.next = this;
            this.before = this;
        }
    }

    private IntNode sentinel;
    private int size;


    public LinkedListDeque() {
        sentinel = new IntNode();
        size = 0;
    }
    public LinkedListDeque(T item) {
        sentinel = new IntNode();
        IntNode temp = new IntNode(item, sentinel, sentinel);
        sentinel.next = temp;
        sentinel.before = temp;
        size = 1;
    }
    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new IntNode();

        for (int i = 0; i < other.size(); i++) {
            this.addLast((T) other.get(i));

        }
    }

    public void addFirst(T x) {
        IntNode temp = new IntNode(x, sentinel, sentinel.next);
        sentinel.next.before = temp;
        sentinel.next = temp;
        size++;
    }

    public void addLast(T x) {
        IntNode temp = new IntNode(x, sentinel.before, sentinel);
        sentinel.before.next = temp;
        sentinel.before = temp;
        size++;
    }

    public boolean isEmpty() {
        return sentinel.next == sentinel;
    }

    public int size() {
        return size;
    }

    public T removeFirst() {
        if (sentinel.next != sentinel) {
        IntNode temp = sentinel.next;
        sentinel.next.next.before = sentinel;
        sentinel.next = sentinel.next.next;
        temp.next = null;
        temp.before = null;
        size--;
        return temp.item;
        } else {
            return null;
        }
    }


    public T removeLast() {
        if (sentinel.next != sentinel) {
        IntNode temp = sentinel.before;
        sentinel.before.before.next = sentinel;
        sentinel.before = sentinel.before.before;
        size--;
        temp.before = null;
        temp.next = null;
        return temp.item;
        } else {
            return null;
        }
    }

    public T get(int index) {
        if (sentinel.next == sentinel || index < 0 || index > size) {
            return null;
        } else {
            IntNode ptr = sentinel.next;
            while (index != 0 && ptr.next != sentinel) {
                index--;
                ptr = ptr.next;
            }

            if (index != 0) {
                return null;
            } else {
                return ptr.item;
            }

        }
    }

    public T getRecursive(int index) {
        return getRecursiveHelper(sentinel.next, index);
    }

    private T getRecursiveHelper(IntNode node, int index) {
        if (node.next != sentinel && index > 0 && index < size) {
            return getRecursiveHelper(node.next, index - 1);
        } else if (index == 0) {
            return node.item;
        } else {
            return null;
        }
    }




//        public void insert(int item, int position) {
//            if (first == null || position == 0) {
//                addFirst(item);
//            } else {
//                IntNode ptr = first;
//                while(position != 1 && ptr.next != null) {
//                    position--;
//                    ptr = ptr.next;
//                }
//                ptr.next = new IntNode(item, ptr.next);
//
//            }
//        }

//        public void reverseByiter(){
//            if (first != null && first.next != null) {
//                IntNode temp;
//                IntNode before = first;
//                IntNode ptr= first.next;
//                while (ptr != null) {
//                    temp = ptr.next;
//                    ptr.next = before;
//                    before = ptr;
//                    ptr = temp;
//                }
//                first.next = null;
//                first = before;
//
//            }
//        }
    public void printDeque() {
        System.out.println(this.toString());
    }

    public String toString() {
        if (sentinel.next == sentinel) {
            return "null";
        } else {
            IntNode ptr = sentinel.next;
            String result = "" + ptr.item;
            ptr = ptr.next;
            while (ptr != sentinel) {
                result += ", ";
                result += ptr.item;
                ptr = ptr.next;
            }
            return result;
        }

    }

//    public static void main(String[] args) {
//
//        LinkedListDeque<String> ll = new LinkedListDeque("a5");
//        ll.addFirst("a4");
//        ll.addLast("a6");
//        ll.addFirst("a3");
//        System.out.println(ll.getRecursive(3));
//
//    }





}

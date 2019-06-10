public class ArrayDeque<T> {

    private T[] array;
    private int size;
    private int capacity;
    private int first;
    private int last;
    private static final double RATIO = 0.25;

    public ArrayDeque() {
        this(8);
    }

    public ArrayDeque(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        array = (T[]) new Object[this.capacity];
        first = capacity - 1;
        last = 0;
    }

    public ArrayDeque(ArrayDeque other) {
        this(other.size());

        for (int i = 0; i < other.size(); i++) {
            this.addLast((T) other.get(i));
        }
    }

    public double getRatio() {
        return Double.parseDouble(String.format("%.2f", size * 1.0 / capacity));
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        System.out.println(this);
    }

    public void addFirst(T item) {
        if (size == capacity) {
            // resize;
            this.resize(2);
        }
        array[first] = item;
        first = (capacity + first - 1) % capacity;
        size++;

    }

    public void addLast(T item) {
        if (size == capacity) {
            this.resize(2);

        }
        array[last] = item;
        last = (capacity + last + 1) % capacity;
        size++;
    }


    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            first = (capacity + first + 1) % capacity;
            T temp = array[first];
            array[first] = null;
            size--;
            if (capacity > 16 && getRatio() < RATIO) {
                resize(0.5);
            }
            return temp;
        }


    }
    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            last = (capacity + last - 1) % capacity;
            T temp = array[last];
            array[last] = null;
            size--;
            if (capacity > 16 && getRatio() < RATIO) {
                resize(0.5);
            }
            return temp;

        }
    }


    public T get(int index) {
        if (size == 0 || index < 0 || index > size) {
            return null;
        } else {
            int current = (capacity + first + 1 + index) % capacity;
            return array[current];
        }
    }

    private void resize(double ratio) {

        int recap = (int) (capacity * ratio);
        T[] temp = (T[]) new Object[recap];

        for (int i = 0; i < size; i++) {
            temp[i] = this.get(i);
        }
        this.capacity = recap;
        this.first = this.capacity - 1;
        this.last = this.size ;
        this.array = temp;
    }

    public String toString() {
        if (size == 0) {
            return "null";
        } else {
            String result = "" + get(0);
            for (int i = 1; i < size; i++) {
                result += " " + get(i);
            }
            return result;
        }
    }


    public static void main(String[] args) {
        ArrayDeque<Integer> queue = new ArrayDeque();
        for (int i = 0; i < 36; i++) {
            queue.addLast(i);
        }
        System.out.println(queue);
        System.out.println(queue.get(7));

    }





}

public class arraylist {
    private int capacity = 100;
    private int size = 0;
    private int[] array;

    public arraylist() {
        this.array = new int[capacity];
    }
    public int size() {
        return size;
    }

    public int get(int index) {
        if (index < size) {
            return array[index];
        } else {
            System.out.println("index error");
            return null;
        }
        
    }

    public int removeLast() {
        if (size > 1) {
            size--;
            return array[index-1];
        } else {
            System.out.println("array is null");
            return null;
        }
        
    }
    
    public void addLast(int value) {
        if (size < capacity) {
            array[size++] = value;
        } else {
            int[] temp = new int[capacity * 2];
            System.arraycopy(array, 0, temp, 0, capacity);
            temp[capacity] = value;
            capacity *=2;
            array = temp;
        }

    }


}
public class NumberList {
    private Integer[] list;
    private int size;

    public NumberList() {
        list = new Integer[2];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void doubleCapacity() {
        final int listLength = list.length;
        Integer[] newList = new Integer[listLength * 2];
        System.arraycopy(list, 0, newList, 0, listLength);
        list = newList;
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        
        return list[index];
    }

    public void add(int index, int value) {
        if (index < 0 || index > size) 
            throw new IndexOutOfBoundsException();

        if (size == list.length) 
            doubleCapacity();

        System.arraycopy(list, index, list, index + 1, size - index); // push values forward
        list[index] = value;
        size++;
    }

    public boolean add(int value) {
        add(size, value);
        return true;
    }

    public void set(int index, int value) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        
        list[index] = value;
    }

    public int remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        
        int value = list[index];
        System.arraycopy(list, index + 1, list, index, size - index - 1); // push values back
        size--;
        return value;
    }

    public String toString() {
        String output = "[";
        for (int i = 0; i < size; i++) 
            if (list[i] != null) 
                output += list[i] + ", ";

        if (size > 0)
            output = output.substring(0, output.length() - 2) + "]";
        
        else
            output += "]";
    
        return output;
    }
}

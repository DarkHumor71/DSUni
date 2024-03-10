import java.util.Arrays;

public class ArrayList<E> {
    private E[] data;
    private int lastIndex = -1;

    public ArrayList(int initialCapacity) {
        data = (E[]) new Object[initialCapacity];
    }

    public ArrayList() {
        this(10);
    }

    public boolean add(E e) {
        if (lastIndex + 1 == data.length)
            data = Arrays.copyOf(data, data.length + 10);
        data[++lastIndex] = e;
        return true;
    }

    public void add(E e, int indx) throws Exception {
        if (indx < 0 || indx > lastIndex)
            throw new RuntimeException("ArrayList index out of bounds");
        if (lastIndex + 1 == data.length)
            data = Arrays.copyOf(data, data.length + 10);
        for (int i = lastIndex; i >= indx; i--) {
            data[i + 1] = data[i];
        }
        data[indx] = e;
        lastIndex++;
    }

    public E get(int indx) throws Exception {
        if (indx < 0 || indx > lastIndex)
            throw new RuntimeException("ArrayList index out of bounds");
        return data[indx];
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size(); i++) {
            if (data[i].equals(o)) return i;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        for (int i = lastIndex; i > -1; i--) {
            if (data[i].equals(o)) return i;
        }
        return -1;
    }
    public E remove(int indx)throws Exception{
        if (indx < 0 || indx > lastIndex)
            throw new RuntimeException("ArrayList index out of bounds");
        E temp=data[indx];
        for (int i = indx; i <lastIndex-1 ; i++) {
            data[i]=data[i+1];
        }
        data[lastIndex--]=null;
        return temp;
    }

    public int size() {
        return lastIndex + 1;
    }

    public boolean isEmpty() {
        return lastIndex == -1;
    }

    public void clear() {
        lastIndex = -1;
        data = (E[]) new Object[data.length];
    }
//public String toString(){}
}

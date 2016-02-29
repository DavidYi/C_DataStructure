package interfaces.bca.util;

/**
 * Created by David on 1/21/2016.
 */
public class BCAArrayList implements BCAList {

    protected Object[] array;
    protected int listSize;

    public BCAArrayList() {
        array = new Object[10];
        listSize = 0;
    }

    private void expand() {
        Object[] temp = new Object[array.length + 5];
        for (int i = 0; i < listSize; i++)
            temp[i] = array[i];
        array = temp;
    }

    @Override
    public void add(Object o) {
        if (listSize >= array.length)
            expand();

        array[listSize] = o;
        listSize++;
    }

    @Override
    public void add(int index, Object o) {
        if (index < 0 || index > listSize)
            throw new ArrayIndexOutOfBoundsException("Index is invalid");

        Object temp;

        if (listSize >= array.length)
            expand();
        if (listSize == index)
            array[listSize] = o;
        else {
            temp = array[index];
            array[index] = o;
            array[index + 1] = temp;
            for (int i = listSize - 1; i >= index; i--)
                array[i + 1] = array[i];
        }
        listSize++;
    }

    @Override
    public void clear() {
        array = new Object[0];
        listSize = 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < listSize; i++)
            if (array[i].equals(o))
                return true;

        return false;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > listSize)
            throw new ArrayIndexOutOfBoundsException("Index is invalid");

        return array[index];
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < listSize; i++)
            if (array[i].equals(o))
                return i;

        return -1;
    }

    @Override
    public boolean isEmpty() {
        if (listSize == 0)
            return true;
        return false;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        for (int i = 0; i < listSize; i++)
            if (array[i].equals(o))
                index = i;
        return index;
    }

    @Override
    public Object remove(int index) {
        if (index >= listSize || index < 0)
            throw new ArrayIndexOutOfBoundsException("Index not valid");

        Object o = array[index];

        for (int i = index; i < listSize; i++)
            array[i] = array[i + 1];

        array[listSize - 1] = null;
        listSize--;

        return o;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < listSize; i++)
            if (array[i].equals(o)) {
                remove(i);
                return true;
            }

        return false;
    }

    @Override
    public int size() {
        return listSize;
    }
}
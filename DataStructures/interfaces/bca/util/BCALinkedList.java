package interfaces.bca.util;

/**
 * Created by David on 1/21/2016.
 */

class Node {
    public Object data = null;
    public Node next = null;

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }
    public Node(Object data) {
        this.data = data;
    }
    public Node() {
    }
}

public class BCALinkedList implements BCAList {
    protected Node head = null;
    protected Node tail = null;
    int listSize;

    public BCALinkedList() {
        listSize = 0;
    }

    @Override
    public void add(Object o) {
        add(listSize, o);
    }

    @Override
    public void add(int index, Object o) {
        if (index < 0 || index > listSize)
            throw new ArrayIndexOutOfBoundsException("Index of" + index + " is invalid");

        if (index == 0) {
            head = new Node(o, head);

            if (tail == null)
                tail = head;
        } else if (index == listSize){
            tail.next = new Node(o);
            tail = tail.next;
        } else {
            Node temp = head;
            for (int i = 0; i < listSize; i++) {
                if (index == i - 1) {
                    temp.next = new Node(o, temp.next.next);
                    break;
                }
                temp = temp.next;
            }
        }
        listSize++;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        listSize = 0;
    }

    @Override
    public boolean contains(Object o) {
        Node temp = head;
        for (int i = 0; i < listSize; i++){
            if (temp.data.equals(o))
                return true;
            temp = temp.next;
        }
        return false;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > listSize)
            throw new ArrayIndexOutOfBoundsException("Index of" + index + " is invalid");

        Node temp = head;

        for (int i = 0; i < index; i++)
            temp = temp.next;

        return temp.data;
    }

    @Override
    public int indexOf(Object o) {
        Node temp = head;

        for (int i = 0; i < listSize; i++){
            if (temp.data.equals(o))
                return i;
            temp = temp.next;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return listSize == 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node temp = head;
        int lastIndex = -1;

        for (int i = 0; i < listSize; i++) {
            if (temp.data.equals(o))
                lastIndex = i;
            temp = temp.next;
        }
        return lastIndex;
    }

    @Override
    public Object remove(int index) {
        if (index < 0 || index > listSize)
            throw new ArrayIndexOutOfBoundsException("Index of" + index + " is invalid");

        Node temp = head;
        for (int i = 0; i < index; i++){
            temp = temp.next;
        }
        Node remove = new Node(temp.next.data);
        temp.next = temp.next.next;

        listSize--;
        return remove;
    }

    @Override
    public boolean remove(Object o) {
        Node temp = head;

        for (int i = 0; i < listSize - 1; i++){
            if (temp.next.data.equals(o))
                break;
            else if (i == listSize - 1)
                return false;
            temp = temp.next;
        }

        temp.next = temp.next.next;

        listSize--;
        return true;
    }

    @Override
    public int size() {
        return listSize;
    }
}

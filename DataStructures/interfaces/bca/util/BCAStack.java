package interfaces.bca.util;

/**
 * Created by David on 2/3/2016.
 */

public class BCAStack {
    private BCAArrayList array = new BCAArrayList();

    public BCAStack(){

    }

    public void push(Object o){
        array.add(o);
    }

    public Object pop(){
        if (array.isEmpty())
            throw new StackEmptyException();

        return array.remove(array.size() - 1);
    }

    public Object peek(){
        if (array.isEmpty())
            throw new StackEmptyException();

        return array.get(array.size() - 1);
    }

    public void clear(){
        array.clear();
    }

    public boolean isEmpty(){
        return array.isEmpty();
    }

    public int size(){
        return array.size();
    }
}

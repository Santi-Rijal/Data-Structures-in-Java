import java.util.ArrayList;

public class StackWithArrayList<T> {

    int size = 0;
    T top = null;

    ArrayList<T> stack;

    public StackWithArrayList() {
        this.stack = new ArrayList<>();
    }

    public void push(T element) {
        stack.add(element);

        top = stack.get(size);

        size++;
    }

    public T pop() {
        T element = top;

        if (size == 1) {
            size--;
            top = null;
        }
        else if (size > 1){
            size--;

            top = stack.get(size - 1);

            stack.remove(size);
        }

        return element;
    }

    public int search(T element) {
        int index = -1;

        for (int i = 0; i < size; i++) {
            if (stack.get(i) == element || stack.get(i).equals(element)) {
                index = i + 1;
            }
        }

        return index;
    }

    public T peek() {
        return top;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

public class StackWithLinkedList <T> {

    public static class Node<T> {
        T value;
        Node<T> next;

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setValue(T element) {
            this.value = element;
        }

        public void setNext(Node<T> node) {
            this.next = node;
        }
    }

    int size = 0;
    Node<T> top;

    public StackWithLinkedList() {
        this.top = null;
    }

    public void push(T element) {
        Node<T> newNode = new Node<>();
        newNode.setValue(element);

        if (size == 0) {
            top = newNode;
            size++;
        }
        else if (size > 0) {
            newNode.setNext(top);
            top = newNode;
            size++;
        }
    }

    public T pop() {
        T element = null;
        Node<T> temp;

        if (size == 1) {
            element = top.getValue();
            top = null;
        }
        else if (size > 1) {
            element = top.getValue();
            temp = top.getNext();
            top.setNext(null);
            top = temp;

            size--;
        }

        return element;
    }

    public int search(T element) {
        int index = -1;
        int tempIndex = 1;
        Node<T> node = top;

        if (size > 0) {
            while (node != null) {
                if (node.getValue() == element || node.getValue().equals(element)) {
                    index = tempIndex;
                    break;
                }
                else {
                    node = node.getNext();
                    index++;
                }
            }
        }

        return index;
    }

    public T peek() {
        if (size == 0) {
            return null;
        }

        return top.getValue();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

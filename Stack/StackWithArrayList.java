/*
 * @Author: Santi Rijal
 * Date: 2022-02-20
 * @Description: ADT Stack implementation with ArrayList DS.
 */

////////////////////////////////////////////////////// IMPORTS /////////////////////////////////////////////////////////

import java.util.ArrayList;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class StackWithArrayList<T> {

    int size = 0;
    T top = null;               // Initialize the stack's top value to null.

    ArrayList<T> stack;

    // Stack constructor.
    public StackWithArrayList() {
        this.stack = new ArrayList<>();
    }

    /*
        * Method Name: push()
        * @Parameters: T element.
        * @Return: none.
        * @Description: A method that pushes the element at the top of the stack.
     */
    public void push(T element) {
        stack.add(element);     // Add the given element at the end of the arraylist stack. The last value in the
                                // arraylist is the top value in the stack.

        top = stack.get(size);  // Set top to the last value in the arraylist stack.

        size++;                 // Increment the size.
    }

    /*
     * Method Name: pop()
     * @Parameters: none.
     * @Return: T element.
     * @Description: A method that removes the top value in the stack and returns it.
     */
    public T pop() {
        T element = top;                // Get the top value using the top variable.

        /*
            * If there is only one value in the stack, decrease the size and set top to null.
            * Else if size is greater than 1, decrease the size and set top to the value at size - 1.
              Then remove the value at size using the remove() method of the arraylist.
         */
        if (size == 1) {
            size--;
            top = null;
        }
        else if (size > 1){
            size--;

            top = stack.get(size - 1);

            stack.remove(size);
        }

        return element;                 // Return the element just removed.
    }

    /*
     * Method Name: search()
     * @Parameters: T element.
     * @Return: integer value.
     * @Description: A method that searches the stack for the given element and returns its index. Index start at 1, if
                     element doesn't exist in the stack return -1.
     */
    public int search(T element) {
        int index = -1;             // Initially set index to -1, assuming the element isn't in the stack.

        // Loop through the stack, if element is found get its index by subtracting i from size. Then break.
        for (int i = 0; i < size; i++) {
            if (stack.get(i) == element || stack.get(i).equals(element)) {
                index = size - i;
                break;
            }
        }

        return index;               // Return the index.
    }

    /*
     * Method Name: peek()
     * @Parameters: none.
     * @Return: T top.
     * @Description: A method that returns the top value in the stack without removing it.
     */
    public T peek() {
        return top;
    }

    /*
     * Method Name: size()
     * @Parameters: none.
     * @Return: integer value.
     * @Description: A method that returns the stack size.
     */
    public int size() {
        return size;
    }

    /*
     * Method Name: isEmpty()
     * @Parameters: none.
     * @Return: boolean true/false.
     * @Description: A method that returns true if size is 0, else false.
     */
    public boolean isEmpty() {
        return size == 0;
    }
}

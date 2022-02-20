/*
 * @Author: Santi Rijal
 * Date: 2022-02-19
 * @Description: ADT ArrayList implementation with Array DS.
 */

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Generic ArrayList class.
public class ArrayList<T> {

    private static final int DEFAULT_CAP = 10;          // The initial size of the array.
    public int size = 0;

    private Object[] array;                             // An Object arrays.

    // ArrayList constructor that initializes the array with a default capacity.
    public ArrayList() {
        this.array = new Object[DEFAULT_CAP];
    }

    /*
     * Method Name: add()
     * @Parameters: T element.
     * @Return: none.
     * @Description: Add an element to the array at the end of the array.
     */
    public void add(T element) {

        // If the array is full (size == DEFAULT_CAP), resize the array using the resize() method.
        if (size == DEFAULT_CAP) {
            resize();
        }

        array[size] = element;              // Add the element in the array using the size variable as the index.
        size++;                             // Increment the size.
    }

    /*
     * Method Name: add()
     * @Parameters: int index, T element.
     * @Return: none.
     * @Description: Add element to the array at the given index.
     */
    public void add(int index, T element) {

        // If the array is full (size == DEFAULT_CAP), resize the array using the resize() method.
        if (size == DEFAULT_CAP) {
            resize();
        }

        // Try the code in this block, if an exception is thrown catch it.
        try {

            // If the given index is not within the bounds throw an IndexOutOfBoundsException() exception.
            if (0 <= index && index < size) {
                Object temp = null;            // A temp Object that's initialized to null, it will hold the value at i.
                Object temp2;                  // A temp variable.

                for (int i = 0; i < size; i++) {

                    /*
                        * If i == index, get the value at i and store it in temp. Then using the set() method set the new
                          value at i and increase the size.
                        * else if i is greater than index, store the value at i in temp2. Then set i to the value in temp.
                          After that store the value in temp2 in temp.
                        * else, continue.
                     */
                    if (i == index) {
                        temp = array[i];
                        set(index, element);
                        size++;
                    }
                    else if (i > index) {
                        temp2 = array[i];
                        set(i, (T) temp);
                        temp = temp2;
                    }
                }
            }
            else {
                throw new IndexOutOfBoundsException();
            }
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("The given array index " + index + " is out of bound, of array size " + size());
        }
    }

    /*
     * Method Name: set()
     * @Parameters: int index, T element.
     * @Return: none.
     * @Description: A method that sets an element at the given index replacing the already existing value at that index.
     */
    public void set(int index, T element) {

        // If the given index is not within the bounds throw an IndexOutOfBoundsException() exception.
        try {

            // If the index is within bounds, replace element at given index with the new element.
            if (index < size && index > -1) {
                array[index] = element;
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("The given array index " + index + " is out of bound, of array size " + size);
        }

    }

    /*
     * Method Name: get()
     * @Parameters: int index.
     * @Return: Object element.
     * @Description: A method that gets the value at the given index, if it's a valid index. Else, throw's an exception
                     if it's not a valid index and return null.
     */
    public Object get(int index) {

        Object element = null;      // Initialize return Object to null.

        // If the given index is not within the bounds throw an IndexOutOfBoundsException() exception.
        try {

            /*
                * If the index is within bounds, loop through the array and get the value at index and set it to element.
                  Then break.
                * Else, throw an exception.
             */
            if (0 <= index && index < size) {
                for (int i = 0; i <= index; i++) {
                    if (i == index) {
                        element = array[i];
                        break;
                    }
                }
            }
            else {
                throw new IndexOutOfBoundsException();
            }
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("The given array index " + index + " is out of bound, of array size " + size);
        }

        return element;             // Return element.
    }

    /*
     * Method Name: remove()
     * @Parameters: int index.
     * @Return: Object element.
     * @Description: A method that removes the value at the given index and returns it. If the index is valid,
                     else return null.
     */
    public Object remove(int index) {

        Object element = null;      // Initialize return Object to null.

        // If the given index is not within the bounds throw an IndexOutOfBoundsException() exception.
        try {

            /*
                * If the index is valid, loop through until at the given index. Store the value at the index in element.
                * When i is greater than index, shift rest of the values.
             */
            if (index < size && index > -1) {
                for (int i = 0; i < size; i++) {
                    if (i > index) {
                        array[i - 1] = array[i];
                        array[i] = null;
                    } else if (i == index) {
                        element = array[i];
                    }
                }

                size--;             // Decrease array size.
            }
            else {
                throw new IndexOutOfBoundsException();
            }
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("The given array index " + index + " is out of bound, of array size " + size);
        }

        return element;              // Return element.
    }

    /*
     * Method Name: indexOf()
     * @Parameters: T element.
     * @Return: A integer value.
     * @Description: A method that returns the index of the given element, if it's in the array.
     */
    public int indexOf(T element) {
        int index = -1;             // Initialize index to -1, assuming the element isn't in the array.

        // Loop over the array and if the element was found set the index to i then break.
        for (int i = 0; i < size; i++) {
            if (array[i] == element || array[i].equals(element)) {
                index = i;
                break;
            }
        }

        return index;               // Return the index.
    }

    /*
     * Method Name: contains()
     * @Parameters: T element.
     * @Return: boolean true/false.
     * @Description: A method that returns true if the given element is in the array, else false.
     */
    public boolean contains(T element) {
        boolean isThere = false;            // Flag initialized to false, assuming that the element isn't in the array.

        // Loop over the array and if the element was found set the flag to true then break.
        for (int i = 0; i < size; i++) {
            if (array[i] == element || array[i].equals(element)) {
                isThere = true;
                break;
            }
        }

        return isThere;                     // Return the flag.
    }

    /*
     * Method Name: resize()
     * @Parameters: none.
     * @Return: none.
     * @Description: A method that resizes the array by doubling its capacity.
     */
    public void resize() {
        int newCap = size * 2;              // New array capacity.

        Object [] arr = new Object[newCap]; // A new array with the new capacity.

        // Copy the values in the old array into the new one.
        for (int i = 0; i < size; i++) {
            arr[i] = get(i);
        }

        array = arr;                        // Set the new array to the old one.
    }

    /*
     * Method Name: size()
     * @Parameters: none.
     * @Return: A integer value.
     * @Description: A method that returns the array size.
     */
    public int size() {
        return size;
    }

    /*
     * Method Name: isEmpty()
     * @Parameters: none.
     * @Return: boolean true/false.
     * @Description: A method that return as true is the size is 0, else false.
     */
    public boolean isEmpty() {
        return size() == 0;
    }
}

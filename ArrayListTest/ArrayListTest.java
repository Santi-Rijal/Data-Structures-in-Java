import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    @Test
    public void add_int() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        assertEquals(3, arrayList.size());
    }

    @Test
    public void add_string() {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");

        assertEquals(3, arrayList.size());
    }

    @Test
    public void add_arraylist() {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<ArrayList<String>> arrayList1 = new ArrayList<>();

        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");

        arrayList1.add(arrayList);

        assertEquals(1, arrayList1.size());
    }

    @Test
    public void add_null() {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(null);

        assertEquals(1, arrayList.size());
    }

    @Test
    public void add_with_index() {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("1");
        arrayList.add("2");
        arrayList.add(1, "3");

        assertEquals(3, arrayList.size());
    }

    @Test
    public void add_with_index_error() {
        ArrayList<String> arrayList = new ArrayList<>();

        try {
            arrayList.add("1");
            arrayList.add("2");

            arrayList.add(20, "3");
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("The given array index 20 is out of bound, of array size " + arrayList.size);
        }
    }

    @Test
    public void get_int() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        assertEquals(1, arrayList.get(0));
        assertEquals(2, arrayList.get(1));
        assertEquals(3, arrayList.get(2));
    }

    @Test
    public void get_string() {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");

        assertEquals("1", arrayList.get(0));
        assertEquals("2", arrayList.get(1));
        assertEquals("3", arrayList.get(2));
    }

    @Test
    public void get_arraylist() {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<ArrayList<String>> arrayList1 = new ArrayList<>();

        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");

        arrayList1.add(arrayList);

        assertEquals(arrayList, arrayList1.get(0));
    }

    @Test
    public void get_with_negative_index() {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("1");
        arrayList.add("2");

        assertNull(arrayList.get(-1));
    }

    @Test
    public void get_with_positive_out_of_bound_index() {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("1");
        arrayList.add("2");

        assertNull(arrayList.get(100));
    }

    @Test
    public void isEmpty_true() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void isEmpty_false() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);

        assertFalse(arrayList.isEmpty());
    }

    @Test
    public void resize() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);
        arrayList.add(10);
        arrayList.add(11);

        assertEquals(11, arrayList.size());
    }

    @Test
    public void contains_true() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);
        arrayList.add(2);

        assertTrue(arrayList.contains(2));
    }

    @Test
    public void contains_false() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);

        assertFalse(arrayList.contains(2));
        assertFalse(arrayList.contains(null));
    }

    @Test
    public void set_inBound() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        arrayList.set(1, 5);

        assertEquals(5, arrayList.get(1));
    }

    @Test
    public void set_outOfBound() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        try {
            arrayList.add(1);
            arrayList.add(2);
            arrayList.add(3);
            arrayList.add(4);

            arrayList.set(12, 1);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("The given array index 12 is out of bound, of array size " + arrayList.size);
        }
    }

    @Test
    public void remove_inBound() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        try {
            arrayList.add(1);
            arrayList.add(2);
            arrayList.add(3);
            arrayList.add(4);

            assertEquals(2,arrayList.remove(1));
            assertEquals(3, arrayList.size());
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("The given array index 12 is out of bound, of array size " + arrayList.size);
        }
    }

    @Test
    public void remove_outBound_negative() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        try {
            arrayList.add(1);
            arrayList.add(2);
            arrayList.add(3);
            arrayList.add(4);

            arrayList.remove(-1);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("The given array index 12 is out of bound, of array size " + arrayList.size);
        }
    }

    @Test
    public void remove_outBound_positive() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        try {
            arrayList.add(1);
            arrayList.add(2);
            arrayList.add(3);
            arrayList.add(4);

            arrayList.remove(20);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("The given array index 12 is out of bound, of array size " + arrayList.size);
        }
    }

    @Test
    public void indexOf_in_array() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        assertEquals(0, arrayList.indexOf(1));
        assertEquals(1, arrayList.indexOf(2));
        assertEquals(2, arrayList.indexOf(3));
    }

    @Test
    public void indexOf_not_in_array() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        assertEquals(-1, arrayList.indexOf(-121));
        assertEquals(-1, arrayList.indexOf(2121));
        assertEquals(-1, arrayList.indexOf(31));
    }
}
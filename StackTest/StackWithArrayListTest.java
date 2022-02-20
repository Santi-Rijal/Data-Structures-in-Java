import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackWithArrayListTest {

    @Test
    void push_numbers() {
        StackWithArrayList<Integer> stack = new StackWithArrayList<>();

        stack.push(-23);
        stack.push(-1);
        stack.push(90);

        assertEquals(3, stack.size());
    }

    @Test
    void push_string() {
        StackWithArrayList<String> stack = new StackWithArrayList<>();

        stack.push("cat");
        stack.push("dog");
        stack.push("cow");

        assertEquals(3, stack.size());
    }

    @Test
    void pop_numbers() {
        StackWithArrayList<Integer> stack = new StackWithArrayList<>();

        stack.push(-23);
        stack.push(-1);
        stack.push(90);

        assertEquals(90, stack.pop());
        assertEquals(2, stack.size());
        assertEquals(-1, stack.pop());
        assertEquals(1, stack.size());
        assertEquals(-23, stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    void pop_string() {
        StackWithArrayList<String> stack = new StackWithArrayList<>();

        stack.push("cat");
        stack.push("dog");
        stack.push("cow");

        assertEquals("cow", stack.pop());
        assertEquals(2, stack.size());
        assertEquals("dog", stack.pop());
        assertEquals(1, stack.size());
        assertEquals("cat", stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    void pop_null_stack() {
        StackWithArrayList<String> stack = new StackWithArrayList<>();

        assertNull(stack.pop());
    }

    @Test
    void search_numbers() {
        StackWithArrayList<Integer> stack = new StackWithArrayList<>();

        stack.push(-23);
        stack.push(-1);
        stack.push(90);

        assertEquals(2, stack.search(-1));
        assertEquals(1, stack.search(90));
        assertEquals(3, stack.search(-23));
        assertEquals(-1, stack.search(20));
    }

    @Test
    void search_string() {
        StackWithArrayList<String> stack = new StackWithArrayList<>();

        stack.push("cat");
        stack.push("dog");
        stack.push("cow");

        assertEquals(2, stack.search("dog"));
        assertEquals(1, stack.search("cow"));
        assertEquals(3, stack.search("cat"));
        assertEquals(-1, stack.search("hog"));
    }

    @Test
    void search_null() {
        StackWithArrayList<String> stack = new StackWithArrayList<>();

        stack.push("cat");
        stack.push("dog");
        stack.push("cow");

        assertEquals(-1, stack.search(null));
    }

    @Test
    void peek_numbers() {
        StackWithArrayList<Integer> stack = new StackWithArrayList<>();

        stack.push(-23);
        stack.push(-1);
        stack.push(90);

        assertEquals(90, stack.peek());
        stack.pop();
        assertEquals(-1, stack.peek());
        stack.pop();
        assertEquals(-23, stack.peek());
        stack.pop();
        assertNull(stack.peek());
    }

    @Test
    void peek_string() {
        StackWithArrayList<String> stack = new StackWithArrayList<>();

        stack.push("cat");
        stack.push("dog");
        stack.push("cow");

        assertEquals("cow", stack.peek());
        stack.pop();
        assertEquals("dog", stack.peek());
        stack.pop();
        assertEquals("cat", stack.peek());
        stack.pop();
        assertNull(stack.peek());
    }

    @Test
    void size() {
        StackWithArrayList<Integer> stack = new StackWithArrayList<>();

        stack.push(-23);
        stack.push(-1);
        stack.push(90);
        stack.push(-23);
        stack.push(-1);
        stack.push(90);

        assertEquals(6, stack.size());
    }

    @Test
    void isEmpty_true() {
        StackWithArrayList<Integer> stack = new StackWithArrayList<>();

        assertTrue(stack.isEmpty());
    }

    @Test
    void isEmpty_false() {
        StackWithArrayList<Integer> stack = new StackWithArrayList<>();

        stack.push(-23);
        stack.push(-1);

        assertFalse(stack.isEmpty());
    }
}
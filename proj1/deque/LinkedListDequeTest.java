package deque;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    @Test
    /* Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
		lld1.addFirst("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

		lld1.addLast("middle");
		assertEquals(2, lld1.size());

		lld1.addLast("back");
		assertEquals(3, lld1.size());

		System.out.println("Printing out deque: ");
		lld1.printDeque();

    }

    @Test
    /* Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {


        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty
		assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty
		assertFalse("lld1 should contain 1 item", lld1.isEmpty());

		lld1.removeFirst();
		// should be empty
		assertTrue("lld1 should be empty after removal", lld1.isEmpty());

    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {


        LinkedListDeque<String>  lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double>  lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertNull("Should return null when removeFirst is called on an empty Deque,", lld1.removeFirst());
        assertNull("Should return null when removeLast is called on an empty Deque,",  lld1.removeLast());


    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }


    }

    @Test
    /* Get the item of the given index starting from zero */
    public void getLLDequeTest(){
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        lld1.addFirst(10);
        lld1.addLast(20);
        lld1.addLast(30);
        // should be 10
        assertEquals("Should return 10", 10, (double) lld1.get(0), 0.0);

        // should  be 30
        assertEquals("Should return 30", 30, (double) lld1.get(2), 0.0);

        // should be null
        assertNull("Should return null",lld1.get(4));

    }

    @Test
    /* Test the empty deque*/
    public void iterateEmptyTest(){
       LinkedListDeque<Integer> empty = new LinkedListDeque<>();
       //should return false for empty deque
        assertFalse(empty.iterator().hasNext());
    }

    @Test
    /* Iterate the Deque and get the item in order */
    public void iterateTest(){
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        lld1.addFirst(10);
        lld1.addLast(20);
        lld1.addLast(30);

        int[] container = new int[lld1.size()];
        int count = 0;
        for (Iterator<Integer> it = lld1.iterator(); it.hasNext(); ) {
            System.out.println(it);
            container[count] = it.next();
            count += 1;
        }

        // should be 10
        assertEquals("Should return 10", 10, container[0], 0.0);
        // should  be 30
        assertEquals("Should return 30", 30, container[2], 0.0);
        // should be null
        assertNull("Should return null",lld1.get(4));
    }


    @Test
    /* Iterate the Deque with String type elements and get the item in order */
    public void iterateReferenceTest(){
        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();
        lld1.addFirst("hello");
        lld1.addLast("world");

        String[] container = new String[lld1.size()];
        int count = 0;

        for (Iterator<String> it = lld1.iterator(); it.hasNext(); ) {
            System.out.println(it);
            container[count] = it.next();
            count += 1;
        }

        // should be hello
        assertEquals("Should return hello", "hello", container[0] );
        // should  be world
        assertEquals("Should return world", "world", container[2]);
        // should be null
        assertNull("Should return null",lld1.get(4));
    }

    @Test
    /* Test the iterator method with more than one instance at one time */
    public void iterateMultipleTest(){
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        lld1.addFirst(10);
        lld1.addLast(20);
        lld1.addLast(30);

        LinkedListDeque<Integer> lld2 = new LinkedListDeque<Integer>();
        lld2.addFirst(40);
        lld2.addLast(55);
        lld2.addLast(60);
        lld2.addLast(66);

        int[] container1 = new int[lld1.size()];
        int[] container2 = new int[lld2.size()];
        int count = 0;

        for (Iterator<Integer> it = lld1.iterator(); it.hasNext(); ) {
            container1[count] = it.next();
            count += 1;
        }

        count = 0;
        for (Iterator<Integer> it = lld2.iterator(); it.hasNext(); ) {
            container2[count] = it.next();
            count += 1;
        }

        // should be 10
        assertEquals("Should return 10", 10, container1[0], 0.0);
        // should  be 30
        assertEquals("Should return 30", 30, container1[2], 0.0);
        // should be null
        assertNull("Should return null",lld1.get(4));


        // should be 40
        assertEquals("Should return 40", 40, container2[0], 0.0);
        // should  be 60
        assertEquals("Should return 30", 60, container2[2], 0.0);
        // should be null
        assertNull("Should return null",lld1.get(4));
    }

    @Test
    /* Test the equal method */
    public void equalTest(){
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        lld1.addFirst(10);
        lld1.addLast(20);
        lld1.addLast(30);


        LinkedListDeque<Integer> lld2 = new LinkedListDeque<Integer>();
        lld2.addFirst(40);
        lld2.addLast(55);
        lld2.addLast(60);
        lld2.addLast(66);


        LinkedListDeque<Integer> lld3 = new LinkedListDeque<Integer>();
        lld3.addFirst(10);
        lld3.addLast(20);
        lld3.addLast(30);

        LinkedListDeque<Integer> lld4 = new LinkedListDeque<Integer>();
        lld4.addFirst(40);
        lld4.addLast(55);
        lld4.addLast(60);

        int[] lld5 = new int[]{10,20,30};

        String[] lld6 = new String[]{"hello", "I'm","Lisa."};

        assertEquals(false, lld1.equals(lld2));
        assertEquals(true, lld1.equals(lld3));
        assertEquals(false, lld1.equals(lld4));
        assertEquals(false, lld1.equals(lld5));
        assertEquals(false, lld1.equals(lld5));
        assertEquals(false, lld1.equals(null));

    }
}

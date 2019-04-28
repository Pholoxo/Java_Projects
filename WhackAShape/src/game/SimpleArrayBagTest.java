package game;

import student.TestCase;
import student.TestableRandom;

/**
 * Test class for SimpleArrayBag
 * 
 * @author Jairo Diaz-Ortiz
 * @version 2017.09.28
 */
public class SimpleArrayBagTest extends TestCase {

    // ~Fields
    private SimpleArrayBag<Integer> arrayBag;


    // ~Constructor
    /**
     * This is the setUp
     */
    public void setUp() {
        arrayBag = new SimpleArrayBag<Integer>();
    }


    // ~Methods
    /**
     * Test method for add
     */
    public void testadd() {
        assertFalse(arrayBag.add(null));
        assertEquals(arrayBag.getCurrentSize(), 0);
        for (int i = 0; i < 24; i++) {
            arrayBag.add(i);
        }
        assertTrue(arrayBag.add(1));

        assertFalse(arrayBag.add(2));
    }


    /**
     * Test method for getCurrentSize
     */
    public void testGetCurrentSize() {
        arrayBag.add(3);

        assertEquals(arrayBag.getCurrentSize(), 1);
    }


    /**
     * Test method for isEmpty
     */
    public void testIsEmpty() {
        assertTrue(arrayBag.isEmpty());

        arrayBag.add(4);

        assertFalse(arrayBag.isEmpty());
    }


    /**
     * Test method for pick
     */
    public void testpick() {
        assertNull(arrayBag.pick());

        arrayBag.add(1);
        arrayBag.add(2);

        TestableRandom.setNextInts(1);
        assertEquals(arrayBag.pick(), 2, 0.01);
        TestableRandom.setNextInts(2);
        assertEquals(arrayBag.pick(), 1, 0.01);
    }


    /**
     * Test method for remove
     */
    public void testRemove() {
        assertFalse(arrayBag.remove(1));
        assertEquals(arrayBag.getCurrentSize(), 0);

        arrayBag.add(1);
        arrayBag.add(2);

        assertTrue(arrayBag.remove(2));
        assertEquals(arrayBag.getCurrentSize(), 1);
    }
}

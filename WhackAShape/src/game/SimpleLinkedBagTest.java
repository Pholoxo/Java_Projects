package game;

import student.TestCase;
import student.TestableRandom;

/**
 * Test class for SimpleLinkedBag
 * 
 * @author Jairo Diaz-Ortiz
 * @version 2017.09.28
 * @param <T>
 */
public class SimpleLinkedBagTest<T> extends TestCase {

    // ~Fields
    private SimpleLinkedBag<String> linkBag;


    // ~Constructor
    /**
     * This is a constructor
     */
    public void setUp() {
        linkBag = new SimpleLinkedBag<String>();
        
    }


    // ~Methods
    /**
     * Test method for add
     */
    public void testadd() {
        assertFalse(linkBag.add(null));
        assertTrue(linkBag.add("first Entry"));
    }


    /**
     * Test method for getCurrentSize
     */
    public void testGetCurrentSize() {
        linkBag.add("first");

        assertEquals(linkBag.getCurrentSize(), 1);
    }


    /**
     * Test method for isEmpty
     */
    public void testIsEmpty() {
        assertTrue(linkBag.isEmpty());

        linkBag.add("Something");

        assertFalse(linkBag.isEmpty());
    }


    /**
     * Test method for pick
     */
    public void testPick() {
        assertNull(linkBag.pick());

        linkBag.add("cheese");
        linkBag.add("milk");

        TestableRandom.setNextInts(3);
        assertEquals(linkBag.pick(), "cheese");
        TestableRandom.setNextInts(4);
        assertEquals(linkBag.pick(), "milk");
    }


    /**
     * Test method for remove
     */
    public void testRemove() {
        assertFalse(linkBag.remove(""));
        assertEquals(linkBag.getCurrentSize(), 0);

        linkBag.add("cheese");
        linkBag.add("beef");

        assertTrue(linkBag.remove("cheese"));
        assertEquals(linkBag.getCurrentSize(), 1);
    }
}

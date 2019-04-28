package project1;

import bag.BagInterface;
import student.TestCase;

/**
 * Test class for DisplayCollection
 * 
 * @author Jairo Diaz-Ortiz
 * @version September 14, 2017
 *
 */
public class DisplayCollectionTest extends TestCase {

    /**
     * This sets up the test cases for DisplayColleciton
     */
    public void setUp() {
        // this is empty intentionally
    }

    // ~ Methods ...............................................................
    
    /**
     * This tests the BagContents() method
     */
    public void testBagContents() {
        DisplayCollection display = new DisplayCollection();

        BagInterface<String> bag = display.getItemBag();

        int bagSize = bag.getCurrentSize();

        for (int i = 0; i < bagSize; i++) {
            String str = bag.remove();
 
            assertTrue(str.equals(DisplayCollection.STRINGS[0]) || str.equals(
                DisplayCollection.STRINGS[1]) || str.equals(
                    DisplayCollection.STRINGS[2]) || str.equals(
                        DisplayCollection.STRINGS[3]));
        }
    }

    // .........................................................................

    /**
     * This tests the BagSize() method
     */
    public void testBagSize() {
        for (int i = 0; i < 20; i++) {
            DisplayCollection display = new DisplayCollection();

            BagInterface<String> bag = display.getItemBag();

            bag.getCurrentSize();

            assertTrue(bag.getCurrentSize() <= 15 || bag.getCurrentSize() >= 5);

            assertFalse(bag.getCurrentSize() > 16 || bag.getCurrentSize() < 5);
        }
    }
}

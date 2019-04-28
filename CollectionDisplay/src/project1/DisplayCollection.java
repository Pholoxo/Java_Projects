package project1;

import bag.Bag;
import bag.BagInterface;
import java.util.Random;

/**
 * This is the DisplayCollection class. It contains a constant reference array
 * that is inside of a bag.The bag contains random content from the reference
 * array in its constructor. It can be accessed through the getItemBag() method.
 * 
 * @author Jairo Diaz-Ortiz
 * @version September 18, 2017
 *
 */
public class DisplayCollection {

    // Fields...................................................................
    /** Field below is an array that contains all possible strings **/
    public static final String[] STRINGS = { "red circle", "blue circle",
        "red square", "blue square" }; // 
    private BagInterface<String> itemBag;


    // Constructor..............................................................
    /**
     * This is a constructor for DisplayCollection.
     * It randomly generates size of bag(five to fifteen)
     * Then adds strings based on number of that size
     * Then for each iteration it randomly chooses strings to add to bag
     */
    public DisplayCollection() {
        this.itemBag = new Bag<>();
        Random random = new Random();
        int count = random.nextInt(11) + 5;
        for (int i = 0; i < count; i++) {
            int possibleString = random.nextInt(4);
            String randomString = DisplayCollection.STRINGS[possibleString];
            itemBag.add(randomString);
        }
    }


    // methods..................................................................

    /**
     * This returns itemBag.
     * 
     * @return itemBag
     */
    public BagInterface<String> getItemBag() {
        return itemBag;
    }
}

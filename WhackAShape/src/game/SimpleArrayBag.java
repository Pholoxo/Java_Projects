package game;

import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * This is the class for the SimpleArrayBag that can be used by the
 * WhackAShape class
 * 
 * @author Jairo Diaz-Ortiz
 * @version 2017.09.28
 * @param <T>
 */
public class SimpleArrayBag<T> implements SimpleBagInterface<T> {

    // Fields
    private T[] bag;
    private static final int MAX = 25;
    private int numberOfEntries;


    // Constructor
    /**
     * This is a constructor for SimpleArrayBag.It creates a
     * bag and the number of entries is 0.
     */
    public SimpleArrayBag() {
        @SuppressWarnings("unchecked")
        T[] tempbag = (T[])new Object[MAX];
        bag = tempbag;
        numberOfEntries = 0;
    }


    // Methods

    /**
     * Adds a new entry to this bag.
     * 
     * @return True
     **/
    @Override
    public boolean add(T anEntry) {
        if (numberOfEntries < 25) {
            if (anEntry == null) {
                return false;
            }
            else {
                bag[numberOfEntries] = anEntry;
            }
            numberOfEntries++;
            return true;
        }
        else {
            return false;
        }
    }


    /**
     * method for returning the number of entries in the bag
     */
    @Override
    public int getCurrentSize() {

        return numberOfEntries;
    }


    /**
     * method for returning the number of entries if it is 0.
     */
    @Override
    public boolean isEmpty() {

        return getCurrentSize() == 0;
    }


    /**
     * method for randomly picking a T object from the bag.
     */
    @Override
    public T pick() {
        TestableRandom generator = new TestableRandom();

        if (isEmpty()) {
            return null;
        }
        else {
            int index = generator.nextInt(numberOfEntries);
            return bag[index];
        }
    }


    /**
     * Removes one occurrence of a given entry from this bag.
     * 
     * @param anEntry
     *            The entry to be removed.
     * @return True if the removal was successful, or false otherwise.
     */
    @Override
    public boolean remove(T anEntry) {
        int number = getIndexOf(anEntry);
        if (number == -1) {
            return false;
        }
        else {
            bag[number] = bag[numberOfEntries - 1];
            numberOfEntries--;
        }
        return true;

    }


    /**
     * method for getIndexOf
     * 
     * @param anEntry
     * @return
     */
    private int getIndexOf(T anEntry) {
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                return i;
            }
        }
        return -1;
    }
}

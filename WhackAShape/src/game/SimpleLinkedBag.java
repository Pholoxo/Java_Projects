package game;

import bag.Node;
import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * This is the class for the SimpleLinkedBag that can be used by the
 * WhackAShape class
 * 
 * @author Jairo Diaz-Ortiz
 * @version 2017.09.28
 * @param <T>
 */
public class SimpleLinkedBag<T> implements SimpleBagInterface<T> {

    // fields
    private Node<T> firstNode;

    private int numberOfEntries;


    // Constructor
    /**
     * This is the constructor for SimpleLinkedBag
     * The first node is null and the number of entries is 0.
     */
    public SimpleLinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }


    // methods
    /**
     * Adds a new entry to this bag. If an entry is null it return false.
     * If it isn't then it adds to the bag.
     * 
     * @return True
     **/
    @Override
    public boolean add(T anEntry) {
        if (anEntry == null) {
            return false;
        }
        else {
            Node<T> newNode = new Node<T>(anEntry);
            newNode.setNext(firstNode);
            firstNode = newNode;
            numberOfEntries++;
            return true;
        }
    }


    /**
     * Gets the number of entries currently in this bag.
     * 
     * @return The integer number of entries currently in the bag.
     */
    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }


    /**
     * This method sees whether this bag is empty.
     * 
     * @return True if the bag is empty, or false if not.
     */
    @Override
    public boolean isEmpty() {
        return getCurrentSize() == 0;
    }


    /**
     * This method randomly picks a T object in the bag
     */
    @Override
    public T pick() {
        TestableRandom generator = new TestableRandom();

        if (isEmpty()) {
            return null;
        }
        else {
            int index = generator.nextInt(numberOfEntries);
            Node<T> tempNode = firstNode;
            for (int i = 0; i < index; i++) {
                tempNode = tempNode.next();
            }
            return tempNode.data();
        }
    }


    /**
     * Removes one occurrence of a given entry from the nodes
     * 
     * @param anEntry
     *            The entry to be removed.
     * @return True if the removal was successful, or false otherwise.
     */
    @Override
    public boolean remove(T anEntry) {
        boolean result = false;
        localNode = getReferenceTo(anEntry);
        if (localNode != null) {
            firstNode.setData(firstNode.data());
            numberOfEntries--;
            result = true;
        }
        return result;
    }


    /**
     * Searches for a specified entry.
     * 
     */
    private Node<T> getReferenceTo(T anEntry) {
        boolean found = false;

        Node<T> currentNode = firstNode;
        //firstNode = currentNode;

        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data())) {
                found = true;
            }
            else {
                currentNode = currentNode.next();
            }
        }
        return currentNode;
    }
}

package project1;

/**
 * @author Jairo Diaz-Ortiz
 * @version September 14, 2017
 *
 */
public class ProjectRunner {

    /**
     * This methods creates a new instance of DisplayCollection class
     * Then it creates a new ShapeWindow instance
     * itemBag of new instance of DisplayCollection passes through constructor
     * of ShapeWindow.
     * 
     * @param args
     */
    public static void main(String[] args) {
        DisplayCollection display = new DisplayCollection();

        @SuppressWarnings("unused")
        ShapeWindow shape = new ShapeWindow(display.getItemBag());
    }
}

package project1;

import bag.BagInterface;
import CS2114.TextShape;
import java.awt.Color;
import CS2114.Window;
import CS2114.Button;
import CS2114.WindowSide;

/**
 * @author Jairo Diaz-Ortiz
 * @version September 14, 2017
 */
public class ShapeWindow {
    // ~ Fields ................................................................

    private Window window;
    private TextShape textShape;
    private Button quitButton;
    private Button chooseButton;
    private BagInterface<String> itemBag;


    // ~ Constructor ...........................................................

    /**
     * This is the ShapeWindow constructor
     * 
     * @param itemBag
     */
    public ShapeWindow(BagInterface<String> itemBag) {
        this.window = new Window();
        window.setTitle("Project 1");

        this.itemBag = itemBag;

        // this adds the quit button on the winodw
        this.quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.NORTH);

        // this adds the choose button on the window
        this.chooseButton = new Button("Choose");
        chooseButton.onClick(this, "clickedChoose");
        window.addButton(chooseButton, WindowSide.SOUTH);

        // this adds the textShape on the window
        this.textShape = new TextShape(0, 0, "");
        window.addShape(textShape);
    }


    // ~ Methods ...............................................................

    /**
     * 
     * @param quitButton
     */
    public void clickedQuit(Button quitButton) {
        System.exit(0);
    }


    // .........................................................................
    
    /**
     * This method picks a string from a bag.
     * If there's none it will say No more items.
     * 
     * @param chooseButton
     */
    public void clickedChoose(Button chooseButton) {

        String item = itemBag.remove();

        if (item != null) {
            textShape.setText(item);
        }
        else {
            textShape.setText("No more items");
        }

        colorText();

        centerText();

    }

    // .........................................................................
    
    /**
     * This method sets a color corresponding to the textShape based on the
     * string that says a color it gets.
     * 
     */
    public void colorText() {
        String colorText = textShape.getText();

        if (colorText.contains("blue")) {
            textShape.setForegroundColor(Color.BLUE);
        }
        else if (colorText.contains("red")) {
            textShape.setForegroundColor(Color.RED);
        }
        else {
            textShape.setForegroundColor(Color.BLACK);
        }
    }

    // .........................................................................

    /**
     * This method is to center the text in the center
     */
    public void centerText() {
        int w = window.getGraphPanelWidth() / 2;
        int h = window.getGraphPanelHeight() / 2;

        int textW = textShape.getWidth() / 2;
        int textH = textShape.getHeight() / 2;

        textShape.setX(w - textW);
        textShape.setY(h - textH);
    }
}

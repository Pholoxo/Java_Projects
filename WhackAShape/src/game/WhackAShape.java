package game;

import java.awt.Color;
import CS2114.Button;
import CS2114.CircleShape;
import CS2114.Shape;
import CS2114.SquareShape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;
import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * This class is the WhackAShape which converts strings into words and
 * creates a window for you to interact. If you click on the shape it will
 * dissapear and other shape will appear. Once you run out of shapes a message
 * will appear that says You Win!
 * 
 * @author Jairo Diaz-Ortiz
 * @version 2017.09.28
 */
public class WhackAShape {

    // Fields
    private SimpleBagInterface<Shape> bag;

    private Window window;

    private TestableRandom randomGenerator;


    // Constructors
    /**
     * This is a constructor for WhackAShape
     * It creates a window and a bag with a quitbutton
     * It creates shapes and adds them to the bag.
     * And then the window adds them and the bag picks them.
     */
    public WhackAShape() {
        bag = new SimpleLinkedBag<>();
        window = new Window();
        window.setTitle("Project 2");

        // this adds the quit button on the window
        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.NORTH);

        // These are the added strings
        bag.add(buildShape("blue square"));
        bag.add(buildShape("blue circle"));
        bag.add(buildShape("red square"));
        bag.add(buildShape("red circle"));

        bag.pick();
        // this addes the shapes that are picked by the bag.
        Shape currentShape = bag.pick();
        window.addShape(currentShape);
        
        
        //this.shape = new TextShape();
       // window.addShape(textShape);

      
    }


    /**
     * This is a constructor for WhackAShape but with strings
     * It creates a window and a bag with a quitbutton
     * It creates shapes and adds them to the bag.
     * The bag then picks and addes it to the window
     * 
     * @param inputs
     */
    public WhackAShape(String[] inputs) {
        bag = new SimpleLinkedBag<>();
        window = new Window();
        window.setTitle("Project 2");

        // this creates the quit buttonin the wondow
        Button quitButton = new Button("Quit");
        quitButton.onClick(this, "clickedQuit");
        window.addButton(quitButton, WindowSide.NORTH);

        // this will build the shape based on how many many
        // strings from the inputs.
        String[] string = new String[inputs.length];
        try {
            for (int i = 0; i < inputs.length; i++) {
                string[i] = inputs[i];
                this.buildShape(string[i]);
                bag.add(buildShape(string[i]));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        // this addes the shapes that are picked by the bag.
        Shape currentShape = bag.pick();
        window.addShape(currentShape);
    }


    // Methods
    /**
     * method for returning the bag
     * 
     * @return bag
     */
    public SimpleBagInterface<Shape> getBag() {
        return bag;
    }


    /**
     * method for returning the window
     * 
     * @return
     */
    public Window getWindow() {
        return window;
    }


    /**
     * method for clicking quit on the window to exit out
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * method for clicking on shape to remove it from the
     * bag and the next one shape will appear. If there are no
     * shapes left a message will appear that says You Win!
     */
    public void clickedShape(Shape shape) {

        window.removeShape(shape);
        bag.remove(shape);

        Shape nextShape = bag.pick();

        if (nextShape == null) {
            int w = window.getGraphPanelWidth() / 2;
            int h = window.getGraphPanelHeight() / 2;

            TextShape textShape = new TextShape(w, h, "");
            textShape.setText("You Win!");
        }
        else {
            window.addShape(nextShape);
        }

    }


    /**
     * method for building shapes based on string
     * method takes string that contains "circle" or "square"
     * if they have string that contains "red" or "blue"
     * then that what it will create. If they don't meet
     * that sufficient conditions then it will thrown an
     * IllegalArgumentException.
     */
    private Shape buildShape(String input) {
        if (input.contains("circle") && input.contains("blue")) {
            CircleShape currentShape = new CircleShape(x, y, size, Color.BLUE);
            currentShape.onClick(this, "clickedShape");
            return currentShape;
        }

        else if (input.contains("circle") && input.contains("red")) {
            CircleShape currentShape = new CircleShape(x, y, size, Color.RED);
            currentShape.onClick(this, "clickedShape");
            return currentShape;
        }

        else if (input.contains("square") && input.contains("blue")) {
            SquareShape currentShape = new CSquareShape(x, y, size, Color.BLUE);
            currentShape.onClick(this, "clickedShape");
            return currentShape;
        }

        else if (input.contains("square") && input.contains("red")) {
            SquareShape currentShape = new SquareShape(x, y, size, Color.RED);
            currentShape.onClick(this, "clickedShape");
            return currentShape;
        }
      
        throw new IllegalArgumentException("Wrong input");  
    }
}







private Shape buildShape(String input) {
        // This are the variables for size, x index and the y index
        int size = randomGenerator.nextInt(101) + 100;
        int x = randomGenerator.nextInt(window.getGraphPanelWidth() - size);
        int y = randomGenerator.nextInt(window.getGraphPanelHeight() - size);

        //This would creates the shapes and colors that corresponds to them
        if (input.contains("circle")) {
            if (input.contains("blue")) {
                CircleShape currentShape = new CircleShape(x, y, size,
                    Color.BLUE);
                currentShape.onClick(this, "clickedShape");
                return currentShape;
            }
            else if (input.contains("red")) {
                CircleShape currentShape = new CircleShape(x, y, size,
                    Color.RED);
                currentShape.onClick(this, "clickedShape");
                return currentShape;
            }
            else {
                throw new IllegalArgumentException("wrong input");
            }

        }

        else if (input.contains("square")) {

            if (input.contains("blue")) {
                SquareShape currentShape = new SquareShape(x, y, size,
                    Color.BLUE);
                currentShape.onClick(this, "clickedShape");
                return currentShape;
            }
            else if (input.contains("red")) {
                SquareShape currentShape = new SquareShape(x, y, size,
                    Color.RED);
                currentShape.onClick(this, "clickedShape");
                return currentShape;
            }
            else {
                throw new IllegalArgumentException("wrong input");
            }

        }
        throw new IllegalArgumentException("Wrong input");
    }

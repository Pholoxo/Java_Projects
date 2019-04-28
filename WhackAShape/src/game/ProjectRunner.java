package game;

/**
 * This is the ProjectRunner class that instantiates the WhackAShape class
 * 
 * @author Jairo Diaz-Ortiz
 * @version 2017.09.28
 */
public class ProjectRunner {

    public static void main(String[] args) {
        
        if (args.length > 0) {
            @SuppressWarnings("unused")
            WhackAShape whack = new WhackAShape(args);

        }
        else {
            @SuppressWarnings("unused")
            WhackAShape whack = new WhackAShape();

        }
    }
}

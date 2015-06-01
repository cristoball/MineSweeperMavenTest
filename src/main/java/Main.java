import java.applet.Applet;

import javax.swing.JApplet;

/**
 * 
 */


/**
 * @author Christoball
 *
 */
public class Main extends Applet
{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		runMineSweeper();
		
	}

	public static void runMineSweeper()
	{
		
		Controller controller = new Controller();
		controller.newGame();
		
	}
	
	public void init()
	{
		runMineSweeper();
	}
}

/**
 * 
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Christoball
 *
 */
public class MenuBeginnerObserver implements ActionListener 
{
	private Controller _controller;

	public MenuBeginnerObserver(Controller cntrl)
	{
		_controller = cntrl;
	}
	
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent arg0) 
	{
		Settings.PLAYER_LEVEL = Settings.BEGINNER;
		_controller.newGame();
	}

}



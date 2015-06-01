/**
 * 
 */


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * @author Christoball
 *
 */
public class GridSpaceObserver extends MouseAdapter
{
	private Controller _controller;
	private View _view;
	private boolean _bStartedTimer = false;

	
	public GridSpaceObserver(Controller msController, View msView)
	{
		_controller = msController;
		_view = msView;
	}

	
	
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	public void mouseClicked(MouseEvent evtMouse) 
	{
		if (evtMouse.getButton() == MouseEvent.BUTTON1) 
		{
			//JOptionPane.showMessageDialog(null, "Mouse 1 event btn mask = " + evtMouse.getButton());
			
			if (_bStartedTimer == false)	//start timer based on user's action
			{
				_view.startTimer();
				_bStartedTimer = true;
			}
			GridSpaceButton gridBtn = (GridSpaceButton) evtMouse.getComponent();
			
			//Shouldn't have to do this, but disabling buttons doesn't seem to work
			if (gridBtn.isEnabled() == false)
			{
				this._controller.getView().showHappyFace();
				return;
			}
			Icon iconBtn = gridBtn.getIcon();
			//Shouldn't have to do this, but disabling buttons doesn't seem to work
			if ((iconBtn.equals(Resources.getResources().iconDisarmed) || 
					iconBtn.equals(Resources.getResources().iconUntouched) || 
					iconBtn.equals(Resources.getResources().iconPossibleMine)))
			{
				this._controller.getView().showHappyFace();
				return;
			}
			if (gridBtn.getGridSpace().getIsMine() == false)
			{
				_view.showHappyFace();
				//reveal what is "underneath" button
				int nMineCount = gridBtn.getGridSpace().getMinesInProximity();
				//String sMinePath = Resources.IMG_DIRECTORY + Integer.toString(nMineCount) + "Mines" + Resources.IMG_TYPE;
				
				ImageIcon iconInGridSpace = Resources.htNumsToMineImages.get(nMineCount);
				gridBtn.setIcon(iconInGridSpace);
				
				//disable button with current icon displayed
				gridBtn.setDisabledIcon(gridBtn.getIcon());
				gridBtn.setEnabled(false);
				gridBtn.setUncovered(true);
				
				if (nMineCount == 0)	//uncover nearby spaces if there were no mines surrounding this space
				{
					_controller.uncoverNearGridSpaces(gridBtn.getButtonID());
				}
			}
			else
			{
				gameOver(gridBtn);
			}
		}
		else if (evtMouse.getButton() == MouseEvent.BUTTON2 || evtMouse.getClickCount() == 2)	//uncover nearby grid spaces when double-clicking or wheel mouse
		{
			
			GridSpaceButton btnGridSpace = (GridSpaceButton) evtMouse.getComponent();
			if (btnGridSpace.getIsUncovered() == true)
			{
				int nMineCount = btnGridSpace.getGridSpace().getMinesInProximity();
				int nGridSpacePos = btnGridSpace.getButtonID();
				if (nMineCount > 0) 
				{
					// TODO get mines identified correctly, if identified correctly then uncover non-mine spaces
					if (_controller.checkAdjacentMinesIdentified(nGridSpacePos) == false)
					{
						return;
					}
					_controller.uncoverNearGridSpaces(btnGridSpace.getButtonID());
				}
				
			}

		}
		else if (evtMouse.getButton() == MouseEvent.BUTTON3)
		{
			//JOptionPane.showMessageDialog(null, "Mouse 2 event btn mask = " + evtMouse.getButton());
			GridSpaceButton btnGridSpace = (GridSpaceButton) evtMouse.getComponent();
			
			
			if (btnGridSpace.getIsUncovered() == false) //only works if space has not been uncovered
			{
				if (btnGridSpace.getIsMarkedAsPossibleMine() == true)  //if marked as possible mine (?), set it as untouched
				{
					btnGridSpace.setMarkAsUntouched();
				}
				else if (btnGridSpace.getIsIdentified() == true) //if marked as disarmed (flag), set it as untouched
				{
					btnGridSpace.setMarkAsPossibleMine();
					this._controller.getView().increaseMineCount();
				}
				else //if not marked (untouched) mark it as disarmed
				{
					btnGridSpace.setMarkGridAsDisarmed();
					this._controller.getView().decreaseMineCount();
				}
			}		
			
			//doMarkPossibleMine();
		}
		
		_controller.checkGameIsWon();

	}

	

	/**
	 * Disable playing field, show mines, stop timer
	 * @param btnGrid
	 */
	protected void gameOver(GridSpaceButton btnMineGrid)
	{
		_view.stopTimer();	
		_view.showYuckFace();
		btnMineGrid.setIcon(Resources.getResources().iconRedMine);
		GridSpaceButton[] btnsGrid = _view.getGridSpaceBtns();
		for (int i = 0; i < btnsGrid.length; i++)	//loop through buttons and set them disabled, remove listeners, show hidden mines
		{
			if (btnsGrid[i].getGridSpace().getIsMine() == true)  //if this was an uncovered mine, then show it now
			{
				if (btnMineGrid.equals(btnsGrid[i]) == false) //don't change a red mine to a black mine image
				{
					btnsGrid[i].setIcon(Resources.getResources().iconBlackMine);
				}
			}
			btnsGrid[i].setDisabledIcon(btnsGrid[i].getIcon()); //set button's disabled image as what it already is showing to please Java
			btnsGrid[i].setEnabled(false);
			
			MouseListener[] lstnrMouse = btnsGrid[i].getMouseListeners();	//remove the listeners from the grid buttons
			for (int j = 0; j < lstnrMouse.length; j++)
			{
				btnsGrid[i].removeMouseListener(lstnrMouse[j]);
			}
		}
		//this._controller.gameOver();
			
	}
	
	
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent evtMouse) 
	{
		if (evtMouse.getButton() == MouseEvent.BUTTON1) 
		{		
			_view.showUncertainFace();
			GridSpaceButton gridBtn = (GridSpaceButton) evtMouse.getComponent();
			gridBtn.setIcon(Resources.getResources().icon0Mines);
		}
	}


	/**
	 * @param gameView
	 */
	public void setView(View gameView) 
	{
		this._view = gameView;
		
	}

	/**
	 * @param mineSweeperController
	 */
	public void setController(Controller mineSweeperController) 
	{
		this._controller = mineSweeperController;
		
	}



}

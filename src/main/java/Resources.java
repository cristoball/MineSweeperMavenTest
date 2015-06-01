/**
 *
 */


import java.util.Hashtable;

import javax.swing.ImageIcon;

/**
 * @author Christoball
 *
 */
public class Resources
{
	public static final String RESOURCE_DIR = ".";
	public static final String IMG_TYPE = ".png";

	public static final String GAME_TITLE = " Mine Sweeper";
	public static final String WINNING_MESSAGE = "Congratulations! You won the game! PLEASE ENTER YOUR NAME.\n\nYour winning time (seconds) is ";
	public static final String YourName = "Your Name";



	//public final ImageIcon iconHappyFace2 = new ImageIcon(getClass().getResource("HappyFace.png"));
	public ImageIcon iconHappyFace = new ImageIcon(getClass().getResource("HappyFace.png"));
	public ImageIcon iconHappyPressedFace = new ImageIcon(getClass().getResource("HappyPressedFace.png"));
	public ImageIcon iconUncertainFace = new ImageIcon(getClass().getResource("UncertainFace.png"));
	public ImageIcon iconYuckFace = new ImageIcon(getClass().getResource("YuckFace.png"));
	public ImageIcon iconCoolFace = new ImageIcon(getClass().getResource("CoolFace.png"));

	public ImageIcon iconUntouched = new ImageIcon(getClass().getResource("Untouched.png"));

	public ImageIcon icon0Mines = new ImageIcon(getClass().getResource("0Mines.png"));
	public ImageIcon icon1Mines = new ImageIcon(getClass().getResource("1Mines.png"));
	public ImageIcon icon2Mines = new ImageIcon(getClass().getResource("2Mines.png"));
	public ImageIcon icon3Mines = new ImageIcon(getClass().getResource("3Mines.png"));
	public ImageIcon icon4Mines = new ImageIcon(getClass().getResource("4Mines.png"));
	public ImageIcon icon5Mines = new ImageIcon(getClass().getResource("5Mines.png"));
	public ImageIcon icon6Mines = new ImageIcon(getClass().getResource("6Mines.png"));
	public ImageIcon icon7Mines = new ImageIcon(getClass().getResource("7Mines.png"));
	public ImageIcon icon8Mines = new ImageIcon(getClass().getResource("8Mines.png"));

	public ImageIcon iconRedMine = new ImageIcon(getClass().getResource("RedMine.png"));
	public ImageIcon iconBlackMine = new ImageIcon(getClass().getResource("BlackMine.png"));
	public ImageIcon iconDisarmed = new ImageIcon(getClass().getResource("DisarmedMine.png"));
	public ImageIcon iconPossibleMine = new ImageIcon(getClass().getResource("PossibleMine.png"));

	public ImageIcon icon0 = new ImageIcon(getClass().getResource("0.png"));
	public ImageIcon icon1 = new ImageIcon(getClass().getResource("1.png"));
	public ImageIcon icon2 = new ImageIcon(getClass().getResource("2.png"));
	public ImageIcon icon3 = new ImageIcon(getClass().getResource("3.png"));
	public ImageIcon icon4 = new ImageIcon(getClass().getResource("4.png"));
	public ImageIcon icon5 = new ImageIcon(getClass().getResource("5.png"));
	public ImageIcon icon6 = new ImageIcon(getClass().getResource("6.png"));
	public ImageIcon icon7 = new ImageIcon(getClass().getResource("7.png"));
	public ImageIcon icon8 = new ImageIcon(getClass().getResource("8.png"));
	public ImageIcon icon9 = new ImageIcon(getClass().getResource("9.png"));

	public static final String sfileBestTimes = "BestTimes.ser";

	public static Hashtable <ImageIcon, Integer> htMineImagesToNums = new Hashtable<ImageIcon, Integer>();
	public static Hashtable <Integer, ImageIcon> htNumsToMineImages = new Hashtable<Integer, ImageIcon>();
	public static Hashtable <Integer, ImageIcon> htDigits = new Hashtable<Integer, ImageIcon>();

	public static Resources resInstance = null;
	
	public Resources()
	{

//		URL url = getClass().getResource("HappyFace.png");
//		String sUrl = url.toExternalForm();
////
//		File file = new File(url.getFile());
//		String sPath = file.getAbsolutePath();
//
//		System.out.println(iconHappyFace2.getDescription());

		htMineImagesToNums.put(icon0Mines, 0 );
		htMineImagesToNums.put(icon1Mines, 1 );
		htMineImagesToNums.put(icon2Mines, 2 );
		htMineImagesToNums.put(icon3Mines, 3 );
		htMineImagesToNums.put(icon4Mines, 4 );
		htMineImagesToNums.put(icon5Mines, 5 );
		htMineImagesToNums.put(icon6Mines, 6 );
		htMineImagesToNums.put(icon7Mines, 7 );
		htMineImagesToNums.put(icon8Mines, 8 );

		htNumsToMineImages.put(0, icon0Mines);
		htNumsToMineImages.put(1, icon1Mines);
		htNumsToMineImages.put(2, icon2Mines);
		htNumsToMineImages.put(3, icon3Mines);
		htNumsToMineImages.put(4, icon4Mines);
		htNumsToMineImages.put(5, icon5Mines);
		htNumsToMineImages.put(6, icon6Mines);
		htNumsToMineImages.put(7, icon7Mines);
		htNumsToMineImages.put(8, icon8Mines);
		
		htDigits.put(0, icon0);
		htDigits.put(1, icon1);
		htDigits.put(2, icon3);
		htDigits.put(3, icon4);
		htDigits.put(4, icon4);
		htDigits.put(5, icon5);
		htDigits.put(6, icon6);
		htDigits.put(7, icon7);
		htDigits.put(8, icon8);
		htDigits.put(9, icon9);
	}

	public static Resources getResources()
	{
		if (resInstance == null)
		{
			resInstance = new Resources();
		}
		return resInstance;
	}
	
	public static void main(String[] args)
	{
//		Resources res = new Resources();
//		//String sDigits = res.htDigits.toString();
//		//System.out.println(sDigits);
//
//		String sMines = res.htNumsToMineImages.toString();
//		System.out.println(sMines);
	}


	/** Returns an ImageIcon, or null if the path was invalid. */
	protected ImageIcon createImageIcon(String path, String description)
	{
	    java.net.URL imgURL = getClass().getResource(path);
	    if (imgURL != null) {
	        return new ImageIcon(imgURL, description);
	    } else {
	        System.err.println("Couldn't find file: " + path);
	        return null;
	    }
	}
}

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class dieRoll implements Runnable{
	private JLabel _label;
	private int faceValue=0,finalVal=0;
	public dieRoll (JLabel label) {
		_label = label;
	}
	
	
	
	public void run() {
		Random rnd = new Random();
		for (int i = 25; i>0; i--) {//each die will be rolled 25 times
			ImageIcon img = dieFace();
			_label.setIcon(img);
			try {
				int delay = 15*((26-i))+50;//delay some amount of time, more each time the die is rolled, until it's done
				Thread.sleep(delay);
			}
			catch (InterruptedException ex) {;}
			
		}
		finalVal = faceValue+1;
		//System.out.printf("%s\n", faceValue+1);//for debugging
	}
	
	/**
	 * 
	 * @return finalVal is the final value of the die in question
	 */
	public int getValue() {
		return finalVal;
	}
	
	/**
	 * 
	 * @return an ImageIcon to be printed to the screen
	 */
	public ImageIcon dieFace() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		URL[] u = {getClass().getResource("/Resources/one.png"),getClass().getResource("/Resources/two.png"),getClass().getResource("/Resources/three.png"),getClass().getResource("/Resources/four.png"),getClass().getResource("/Resources/five.png"),getClass().getResource("/Resources/six.png")};
		//the locations of each of the six die faces
		Random rnd = new Random();
		faceValue=rnd.nextInt(6);//chooses the next number to be rolled
		int next = faceValue;
		
		Image img = toolkit.getImage(u[next]);//gets the corresponding image
		img = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);//scale the image
		return new ImageIcon(img);//return this image so it can be printed to the screen
	}

}

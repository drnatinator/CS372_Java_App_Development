/**
 * HW04_01 Yahtzee!
 * @author Nate Williams
 * @version 1.00, 22 January 2019
 */
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class Dice {

	private JFrame frame;
	private int chanceVal=0;
	JButton start = new JButton("Roll Dice");
	private static dieRoll[] dr = new dieRoll[5];//array of dieRoll objects
	static Thread[] t = {new Thread(), new Thread(), new Thread(), new Thread(), new Thread()};//array of threads, one for each dieRoll object

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dice window = new Dice();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public Dice() {
		initialize();
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		frame.setVisible(true);
		
		
		
		start.addActionListener(new ActionListener() {//listen for clicks on the button (which is called start)
			public void actionPerformed(ActionEvent e) {
				Thread t = new Thread(new Runnable() {//when the button is clicked, start a new thread and use it to call rollDice()

					@Override
					public void run() {
						Dice.this.rollDice();
						//System.out.printf("%s\n", chanceVal);
						
					}
				}
				);
				//System.out.println("here");
				t.start();//start this new thread
			}
		});
		frame.add(start);//add the start button to the frame
		
		}
	
	public void rollDice() {
		if (frame.getContentPane().getComponentCount()>1) {//if any objects are in the frame other than the start button,
			frame.getContentPane().removeAll();//remove them all
		}
		frame.getContentPane().add(start);//and add the start button back in
		
		for (int i=0;i<5;i++) {//initialize the array of dieRolls by calling the constructor
			JLabel l = new JLabel();
			dr[i] = new dieRoll(l);
			frame.add(l);//add each to the frame
		}
		Random rnd = new Random();	
		for (int i=0; i<5;i++) {//create a new thread associated with each dieRoll
			t[i] = new Thread(dr[i]);
			t[i].start();//start each thread
			try {
				int delay = rnd.nextInt(400)+50;//delay for between 50 ms and 450 ms
				Thread.sleep(delay);
			}
			catch (InterruptedException ex) {;}	//i know, i know, this is bad
		}

		try {
			for (int i=0; i<5;i++) 
				t[i].join();//wait for each of the five dice threads to be done before moving on
		}
		catch(InterruptedException ex) {
			System.out.println("bad things.");
		}
		chanceVal = 0;//clear any previous values
		for (int i=0;i<5;i++) chanceVal+=dr[i].getValue();//sum the five dice's values
		String msg = "Chance value: "+chanceVal;
		JLabel total = new JLabel(msg);//put the chance value message in a JLabel
		
		frame.add(total);//add the chance value message to the screen
		frame.revalidate();
		frame.repaint();//repaint the screen
		
	}


}


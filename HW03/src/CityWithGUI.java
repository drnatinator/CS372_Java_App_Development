/**
 * HW03 City
 * @author Nate Williams
 * @version 1.00, 13 January 2019
 */
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class CityWithGUI extends JFrame implements MouseMotionListener, ActionListener, MouseListener{
	
	public static String msg = "";//stores the message for the output window; modified my several methods
	//int colorIndex = 0;
	JButton btnNewOfficer, btnNewTeacher, btnNewKid, btnRight;//buttons that must be globally modifiable
	static JLabel PolLabel = null, TeachLabel = null, KidLabel = null, txtout = null;//labels that must be globally modifiable
	JPanel panel_1 = null, panel_9 = null, panel_10 = null, panel_11 = null;//panels that must be globally modifiable
	static JFrame output = null;//frame that must be globally modifiable
	JLayeredPane lpane = null;//pane must be globally modifiable
	Point diffDrag;//this point must be accessible from multiple methods
	
	//global arraylists which store people, labels pertaining to people, and such. Modified chiefly by removePerson() and the add person buttons
	public ArrayList<JLabel> labels = new ArrayList<JLabel>();
	public ArrayList<Integer> labelTypes = new ArrayList<Integer>();
	public ArrayList<Person> people = new ArrayList<Person>();
	public ArrayList<Person> CHpeople = new ArrayList<Person>();
	public ArrayList<Person> HSpeople = new ArrayList<Person>();
	public ArrayList<Person> MSpeople = new ArrayList<Person>();


	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CityWithGUI window = new CityWithGUI();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}}});}

	
	//constructor which simply calls initialize()
	public CityWithGUI() {
		initialize();
	}
	
	/**
	 * @param e is a mouse event, used to find button clicks
	 */
	public void actionPerformed(ActionEvent e) {
		//System.out.printf("here ");
		if (e.getSource()==btnNewOfficer) {createOfficer();}//calls createOfficer() to place an officer icon on the screen
		if (e.getSource()==btnNewTeacher) {createTeacher();}//calls createTeacher() to place a teacher icon on the screen
		if (e.getSource()==btnNewKid) {createKid();}//calls createKid() to place a kid icon on the screen
		if (e.getSource()==btnRight) {listOccupants();}//calls listOccupants(), which lists the occupants of each building in the output window

		this.validate();
		this.repaint();//refreshes the main window, to make the icons appear
	}

	//create an officer icon in the window, and create an Officer object
	public void createOfficer() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		//icon from pokemon, <https://bulbapedia.bulbagarden.net/wiki/Police_Officer_(Trainer_class)>, accessed 1/10/19
		URL polUrl = getClass().getResource("/resources/PoliceSprite.png");
		Image PolImage = toolkit.getImage(polUrl);
		PolImage = PolImage.getScaledInstance(50,50,Image.SCALE_SMOOTH);//scale the icon to the proper size
		ImageIcon PolIcon = new ImageIcon(PolImage);
		PolLabel = new JLabel(PolIcon);

		GridBagConstraints gbc_Label = new GridBagConstraints();
	    gbc_Label.gridheight = 1;
	    gbc_Label.gridwidth = 2;
	    gbc_Label.gridy = 10;
	    lpane.add(PolLabel, gbc_Label);//add the officer icon to the invisible box over the main portion of the main window
	    labels.add(PolLabel); 
	    labelTypes.add(1);
	    System.out.printf("New officer created.\n");//output to console for debugging purposes
	    people.add(new Police(nameGen(), ageGen(true), "911", roleGen()));//generate a new Officer object by calling random generators [below]; add to an arraylist
	}
	
	//create a teacher icon in the window, and create a Teacher object
	public void createTeacher() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		//icon from pokemon, <https://bulbapedia.bulbagarden.net/wiki/Teacher_(Trainer_class)>, accessed 1/10/19
		URL teachUrl = getClass().getResource("/resources/TeacherSprite.png");
		Image TeachImage = toolkit.getImage(teachUrl);
		TeachImage = TeachImage.getScaledInstance(50,50,Image.SCALE_SMOOTH);//scale the icon to the proper size
		ImageIcon TeachIcon = new ImageIcon(TeachImage);
		TeachLabel = new JLabel(TeachIcon);
		
		
		
		GridBagConstraints gbc_Label = new GridBagConstraints();
	    gbc_Label.gridheight = 1;
	    gbc_Label.gridwidth = 2;
	    gbc_Label.gridy = 10;
	    lpane.add(TeachLabel, gbc_Label);//add the teacher icon to the invisible box over the main portion of the main window
	    labels.add(TeachLabel); 
	    labelTypes.add(2);
	    System.out.printf("New teacher created.\n");//for debugging
		people.add(new Teacher(nameGen(), ageGen(true), phoneGen(), gradeGen(), certGen()));//generate a new Teacher object by calling random generators [below]; add to an arraylist
	}
	
	//create a kid icon in the window, and create a Kid object
	public void createKid() {
		System.out.printf("new kid\n");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		//icon from pokemon, <https://bulbapedia.bulbagarden.net/wiki/Schoolkid_(Trainer_class)>, accessed 1/10/19
		URL kidUrl = getClass().getResource("/resources/KidSprite.png");
		Image KidImage = toolkit.getImage(kidUrl);
		KidImage = KidImage.getScaledInstance(50,50,Image.SCALE_SMOOTH);//scale the icon to the proper size
		ImageIcon KidIcon = new ImageIcon(KidImage);
		KidLabel = new JLabel(KidIcon);
		
		
		GridBagConstraints gbc_Label = new GridBagConstraints();
	    gbc_Label.gridheight = 1;
	    gbc_Label.gridwidth = 2;
	    gbc_Label.gridy = 10;
	    lpane.add(KidLabel, gbc_Label);//add the kid icon to the invisible box over the main portion of the main window
	    labels.add(KidLabel); 
	    labelTypes.add(3);	
	    System.out.printf("New kid created.\n");
	    people.add(new Kid(nameGen(), ageGen(false), phoneGen(), cndyGen()));//generate a new Kid object by calling random generators [below]; add to an arraylist
	}

	//initializes both windows, and all the assorted panels and buttons and such. Generated using Eclipse's WindowBuilder, then hand-modified
	private void initialize() {
		output = new JFrame("Output Console");//generates the output window
		output.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		txtout = new JLabel(msg, JLabel.CENTER);
		output.add(txtout);
		output.setSize(1000, 300);
		output.setVisible(true);
		
		
		this.setBounds(100, 100, 947, 511);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		
		JPanel pnlLeft = new JPanel();//panel on the left for the buttons to add icons
		this.getContentPane().add(pnlLeft, BorderLayout.WEST);
		pnlLeft.setLayout(new GridBagLayout());
		
		
		btnNewOfficer = new JButton("New Officer");//new officer button
		GridBagConstraints gbc_newOfficer = new GridBagConstraints();
		gbc_newOfficer.gridheight = 3;
		gbc_newOfficer.gridwidth = 1;
		gbc_newOfficer.insets = new Insets(0,0,0,5);
		gbc_newOfficer.fill = GridBagConstraints.BOTH;
		gbc_newOfficer.gridx = 0;
	    gbc_newOfficer.gridy = 0;
		pnlLeft.add(btnNewOfficer, gbc_newOfficer);
		btnNewOfficer.addActionListener(this);
		
		
		
		btnNewKid = new JButton("New Kid");//new kid button
		GridBagConstraints gbc_newKid = new GridBagConstraints();
		gbc_newKid.gridheight = 3;
		gbc_newKid.gridwidth = 1;
		gbc_newKid.insets = new Insets(0,0,0,5);
		gbc_newKid.fill = GridBagConstraints.BOTH;
		gbc_newKid.gridx = 0;
	    gbc_newKid.gridy = 40;
		pnlLeft.add(btnNewKid, gbc_newKid);
		btnNewKid.addActionListener(this);
		
		btnNewTeacher = new JButton("New Teacher");//new teacher button
		GridBagConstraints gbc_newTeach = new GridBagConstraints();
		gbc_newTeach.gridheight = 3;
		gbc_newTeach.gridwidth = 1;
		gbc_newTeach.insets = new Insets(0,0,0,5);
		gbc_newTeach.fill = GridBagConstraints.BOTH;
		gbc_newTeach.gridx = 0;
	    gbc_newTeach.gridy = 80;
		pnlLeft.add(btnNewTeacher, gbc_newTeach);
		btnNewTeacher.addActionListener(this);
		
		btnRight = new JButton("List Building Occupants");//button on the right side to list the occupants of each building in the output window
		this.getContentPane().add(btnRight, BorderLayout.EAST);
		btnRight.addActionListener(this);
		
		JPanel panel = new JPanel();//panel at the top for a name
		this.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblMapOfNatesville = new JLabel("Map of Natesville");
		panel.add(lblMapOfNatesville);//add name to top of window
		
		panel_1 = new JPanel();//GridBagLayout for the center panel; where the map goes
		this.getContentPane().add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 26, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 43, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		
		lpane = new JLayeredPane();//invisible box over the map. The icons go here, so they can be dragged around without getting stuck in the grid
	    Color newC = new Color(0f,0f,0f,0f);
		lpane.setBackground(newC);
		GridBagConstraints gbc_lpane = new GridBagConstraints();
		gbc_lpane.gridheight = 15;
		gbc_lpane.gridwidth = 35;
		gbc_lpane.insets = new Insets(0,0,0,5);
		gbc_lpane.fill = GridBagConstraints.BOTH;
		gbc_lpane.gridx = 0;
	    gbc_lpane.gridy = 0;
		lpane.setOpaque(true);
	    panel_1.add(lpane, gbc_lpane);
	    lpane.setLayout(new GridBagLayout());	    
		
		JPanel panel_3 = new JPanel();//"main St." panel
		panel_3.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridheight = 14;
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 6;
		gbc_panel_3.gridy = 0;
		panel_1.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblMainSt = new JLabel(" Main St.");
		panel_3.add(lblMainSt, BorderLayout.CENTER);
		
		panel_9 = new JPanel();
		panel_9.setBackground(new Color(192, 192, 192));//George Washingotn School 
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.gridwidth = 3;
		gbc_panel_9.gridheight = 2;
		gbc_panel_9.insets = new Insets(0, 0, 5, 5);
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 3;
		gbc_panel_9.gridy = 1;
		panel_1.add(panel_9, gbc_panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JLabel lblWashingotnHighSchool = new JLabel("Washington");
		lblWashingotnHighSchool.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblWashingotnHighSchool, BorderLayout.CENTER);
		
		JLabel lblSchool = new JLabel("School");
		lblSchool.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblSchool, BorderLayout.SOUTH);
		
		JLabel lblWashington = new JLabel("George");
		lblWashington.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(lblWashington, BorderLayout.NORTH);
		
		JPanel panel_7 = new JPanel();//Bank panel
		panel_7.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.gridheight = 3;
		gbc_panel_7.gridwidth = 4;
		gbc_panel_7.insets = new Insets(0, 0, 5, 5);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 7;
		gbc_panel_7.gridy = 2;
		panel_1.add(panel_7, gbc_panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JLabel lblFirstNationalBank = new JLabel("First National Bank");
		lblFirstNationalBank.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(lblFirstNationalBank, BorderLayout.CENTER);
		
		panel_10 = new JPanel();//City Hall panel
		panel_10.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.gridwidth = 5;
		gbc_panel_10.gridheight = 3;
		gbc_panel_10.insets = new Insets(0, 0, 5, 5);
		gbc_panel_10.fill = GridBagConstraints.BOTH;
		gbc_panel_10.gridx = 1;
		gbc_panel_10.gridy = 6;
		panel_1.add(panel_10, gbc_panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JLabel lblWhiteHouse = new JLabel ("City Hall");
		lblWhiteHouse.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10.add(lblWhiteHouse, BorderLayout.CENTER);
		
		JPanel panel_8 = new JPanel();//Fountain panel
		panel_8.setBackground(new Color(30, 144, 255));
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.gridheight = 3;
		gbc_panel_8.gridwidth = 4;
		gbc_panel_8.insets = new Insets(0, 0, 5, 5);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 7;
		gbc_panel_8.gridy = 7;
		panel_1.add(panel_8, gbc_panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JLabel lblFountainForGlorious = new JLabel("Fountain for Glorious Leader");
		lblFountainForGlorious.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(lblFountainForGlorious, BorderLayout.CENTER);
		
		panel_11 = new JPanel();//Parkview School panel
		panel_11.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.gridwidth = 4;
		gbc_panel_11.gridheight = 3;
		gbc_panel_11.insets = new Insets(0, 0, 5, 5);
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.gridx = 15;
		gbc_panel_11.gridy = 7;
		panel_1.add(panel_11, gbc_panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JLabel lblParkviewMiddleSchool = new JLabel("Parkview School for Children");
		lblParkviewMiddleSchool.setHorizontalAlignment(SwingConstants.CENTER);
		panel_11.add(lblParkviewMiddleSchool, BorderLayout.CENTER);
		
		JPanel panel_12 = new JPanel();//Donut Shop panel
		panel_12.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_panel_12 = new GridBagConstraints();
		gbc_panel_12.gridwidth = 4;
		gbc_panel_12.gridheight = 3;
		gbc_panel_12.insets = new Insets(0, 0, 5, 5);
		gbc_panel_12.fill = GridBagConstraints.BOTH;
		gbc_panel_12.gridx = 11;
		gbc_panel_12.gridy = 7;
		panel_1.add(panel_12, gbc_panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDunkinDonuts = new JLabel("Dunkin' Donuts");
		lblDunkinDonuts.setHorizontalAlignment(SwingConstants.CENTER);
		panel_12.add(lblDunkinDonuts, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridwidth = 6;
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 10;
		panel_1.add(panel_4, gbc_panel_4);
		
		JPanel panel_5 = new JPanel();//Park Blvd. panel
		panel_5.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.gridwidth = 16;
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 7;
		gbc_panel_5.gridy = 10;
		panel_1.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel lblParkBlvd = new JLabel("Park Blvd.");
		lblParkBlvd.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblParkBlvd, BorderLayout.CENTER);
		
		JPanel panel_13 = new JPanel();//Grocery store panel
		panel_13.setBackground(new Color(192, 192, 192));
		GridBagConstraints gbc_panel_13 = new GridBagConstraints();
		gbc_panel_13.gridwidth = 5;
		gbc_panel_13.gridheight = 3;
		gbc_panel_13.insets = new Insets(0, 0, 0, 5);
		gbc_panel_13.fill = GridBagConstraints.BOTH;
		gbc_panel_13.gridx = 1;
		gbc_panel_13.gridy = 11;
		panel_1.add(panel_13, gbc_panel_13);
		panel_13.setLayout(new BorderLayout(0, 0));
		
		JLabel lblChildFactory = new JLabel("Joe's Groceries");
		lblChildFactory.setHorizontalAlignment(SwingConstants.CENTER);
		panel_13.add(lblChildFactory, BorderLayout.CENTER);
		
		JPanel panel_6 = new JPanel();//City park panel
		panel_6.setBackground(new Color(0, 128, 0));
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.gridheight = 3;
		gbc_panel_6.gridwidth = 15;
		gbc_panel_6.insets = new Insets(0, 0, 0, 5);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 7;
		gbc_panel_6.gridy = 11;
		panel_1.add(panel_6, gbc_panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNatePark = new JLabel("Nate Park");
		lblNatePark.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblNatePark, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 22;
		gbc_panel_2.gridy = 13;
		panel_1.add(panel_2, gbc_panel_2);
	
	    
	    
		
		lpane.addMouseMotionListener(this);//initializes the mous listeners
		lpane.addMouseListener(this);
		
		
		}

	/**
	 * @param e is a mouse event. Doesn't matter in this case, as mouseMoved is an empty method
	 */
	public void mouseMoved(MouseEvent e) {diffDrag = null;}
	/**
	 * @param e is a mouse event. In this case, we're listening for drags
	 */
	public void mouseDragged(MouseEvent e) {
		int person = 0, index = 0;//local variables to be used for temporary storage
		JLabel label = null;
		//System.out.printf("Label coords: %s", PolLabel.getBounds());//for debugging
		
		for (int i = 0; i< lpane.getComponentCount();i++) {//for each component in lpane [the Perosn icons], check to see if the mouse is over it
			if (lpane.getComponent(i) instanceof JLabel && lpane.getComponent(i).getBounds().contains(e.getPoint())) {
				label = (JLabel)lpane.getComponent(i);//save this label
				person = labelTypes.get(i);//save this person's type [Officer, Teacher, or Kid]
				//System.out.printf("%s",i);//for debugging
				index = i;//save the index in the array of this person
			}
		}
		
		if (label != null) {//if the mouse drag is over some person
			
			if (diffDrag == null) 
				diffDrag = new Point(e.getX() - label.getBounds().x, e.getY() - label.getBounds().y);//keep track of how far the mouse moves, and move the icon with it
			label.setBounds(e.getX() - diffDrag.x, e.getY()-diffDrag.y, label.getBounds().width, label.getBounds().height);
			this.repaint();//refresh the main window to show the icon's movement
	       // System.out.printf("moved label to <%d, %d>", e.getX() - diffDrag.x, e.getY()-diffDrag.y);
		}	
		removePerson(label, index, person, e);//call removePerson to determine whether any icon has been dragged over the correct building [and then remove their icons]
	}

	/**
	 * 
	 * @param label is a JLabel containing a person's icon
	 * @param index is the place in the array people where the person in question is stored [so they can be removed, if appropriate]
	 * @param person stores the sort of person [Officer, Teacher, or Kid]
	 * @param e is a mouse event [in this case, a drag]
	 */
	private void removePerson(JLabel label, int index, int person, MouseEvent e) {
		if (person == 1 && panel_10.getBounds().contains(e.getPoint())) {//if the person is an officer and was dragged over city hall
			lpane.remove(label);//remove the officer's icon
			labelTypes.remove(index);//remove the reference to the person in labelTypes
			CHpeople.add(people.get(index));//add this person to the array of officers in City Hall
			people.remove(index);//remove this person from the arraylist of people not in a building
			}
		else if (person == 2 && (panel_9.getBounds().contains(e.getPoint()))){//if the person is a teacher and over Washington School
			labelTypes.remove(index);//remove the teacher's icon
			lpane.remove(label);//remove the reference to the person in labelTypes
			HSpeople.add(people.get(index));//ass this person to the array of Teachers and Kids in Washington School
			people.remove(index);//remove this person from the arraylist of people not in a building
		}
		else if (person == 2 && (panel_11.getBounds().contains(e.getPoint()))){//if this person is a teacher and over Parkview school
			labelTypes.remove(index);//remoce the teacher's icon
			lpane.remove(label);//remove the reference to the person in labelTypes
			MSpeople.add(people.get(index));//add this person to teh array of Teachers and Kids in Parkview School
			people.remove(index);//remove this person from the array of people not in a building
		}
		else if (person == 3 && (panel_9.getBounds().contains(e.getPoint()))){//if this person is a Kid and over Washington School
			labelTypes.remove(index);//remove the kid's icon
			lpane.remove(label);//remove the reference to the person in labelTypes
			HSpeople.add(people.get(index));//add this person to the array of Kids and Teachers in Washington School
			people.remove(index);//remove this person from the array of people not in a building
		}
		else if (person == 3 && (panel_11.getBounds().contains(e.getPoint()))){//if this person is a kid and over Parkview School
			labelTypes.remove(index);//remove the kid's icon
			lpane.remove(label);//remove the reference to the person in labelTypes
			MSpeople.add(people.get(index));//add this person to the array of Kids and Teachers in Parkview School
			people.remove(index);//remove this person from the array of people not in a building
		}
	}
	
/**
 * 
 * @return the kid's favorite candy in a string
 */
	private String cndyGen() {
		String[] cndy = {"Snickers", "Heath", "Tootsie Pop", "Broccoli", "Candy Corn", "Jolly Rancher", "Laffy Taffy", "Runts", "Gummy Worms", "Liquorice"};
		Random rnd = new Random();
		int r = rnd.nextInt(10);
		return cndy[r];
	}
	
	/**
	 * @return the teacher's certification in a string
	 */
	private String certGen() {
		Random rnd = new Random();
		int c = rnd.nextInt(2);
		if (c == 0)
			return "Elementary";
		else
			return "Secondary";
	}
	
	/**
	 * 
	 * @return the grade level that the teacehr teaches in a string
	 */
	private String gradeGen() {
		String gradelvl = "";
		Random rnd = new Random();
		int g = rnd.nextInt(12)+1;
		if (g<9) {gradelvl=Integer.toString(g);}
		else if (g == 9){gradelvl = "Freshman";}
		else if (g==10) {gradelvl = "Sophomore";}
		else if (g == 11) {gradelvl = "Junior";}
		else {gradelvl = "Senior";}
		return gradelvl;
	}
	
	/**
	 * 
	 * @return a phone number in a string, of the format xxx-xxxx
	 */
	private String phoneGen() {
		Random rnd = new Random();
		int p1 = rnd.nextInt(999), p2 = rnd.nextInt(9999);
		String output = "";
		if(p1<100) {output += "0";}
		if (p1<10) {output += "0";}
		if(p1==0) {output+="0";}
		output += Integer.toString(p1)+"-";
		if (p2<1000) {output+="0";}
		if (p2<100) {output+="0";}
		if (p2<10) {output+="0";}
		if (p2==0) {output+="0";}
		output+=Integer.toString(p2);
		return output;
	}
	/**
	 * 
	 * @return a first and last name in a string
	 */
	private String nameGen() {
		String[] firsts = {"Tom", "Mary", "Joe", "David", "Reginald", "Methusalah", "Marge", "Sarah"};
		String[] lasts = {"O'Donnel","Smith","Davidson","Wilson","Meyers"};
		Random rnd = new Random();
		int f = rnd.nextInt(firsts.length);
		int l = rnd.nextInt(lasts.length);
		//System.out.printf(firsts[f]+" "+lasts[l]);
		return firsts[f]+" "+lasts[l];
		
	}
	/**
	 * 
	 * @param adult boolean value to tell ageGen whether it should generate a schoolkid's age or an adult's age
	 * @return an age as an int
	 */
	private int ageGen(boolean adult) {
		int age;
		Random rnd = new Random();
		if (adult) {
			age = rnd.nextInt(60)+20;
		}
		else {
			age = rnd.nextInt(12)+4;
		}
		//System.out.printf("%s, %s", adult, age);
		return age;
	}
	
	/**
	 * 
	 * @return a Police Role, such as Chief or Captain
	 */
	private Police.role roleGen() {
		int role;
		Random rnd = new Random();
		role = rnd.nextInt(3);
		if (role == 0) return Police.role.Patrol_Officer;
		else if (role == 1) return Police.role.Chief;
		else if (role == 2) return Police.role.Sergeant;
		else return Police.role.Captain;
	}
	
	//lists the occupants of each of the three buildings that are monitored [called when the button on the right is pressed]
	private void listOccupants() {
		msg = "";//building the message for the output console
		if (CHpeople.size()==0) {
			msg += "City Hall is empty!\n";		
			System.out.printf("\nCity Hall is empty!\n");
		}
		else {
			msg += "\nCurrently occupying City Hall:\n";
			System.out.printf("\nCurrently occupying City Hall:\n");
		for (int i=0; i<CHpeople.size();i++) {//outputs all the info for each officer in City Hall, if any
			msg += ((Police) CHpeople.get(i)).getRole() + " " + CHpeople.get(i).getName() + ", " + CHpeople.get(i).getAge() + " years old, phone: " + CHpeople.get(i).getPnum()+".\n";
			//also prints it to the console, for posterity
			System.out.printf("%s %s, %s years old, phone: %s.\n",((Police) CHpeople.get(i)).getRole(), CHpeople.get(i).getName(),CHpeople.get(i).getAge(), CHpeople.get(i).getPnum());
			}
		}
		//rinse, repeat for the other two buildings
		if (HSpeople.size()==0) {
			msg += "\nWashington High School is empty!\n";
			System.out.printf("\nWashington High School is empty!\n");}
		else {
			msg += "\nCurrently occupying George Washington School:\n";
			System.out.printf("\nCurrently occupying George Washington School:\n");
			for (int i=0; i<HSpeople.size();i++) {
				if (HSpeople.get(i) instanceof Teacher) {
					msg += "(Teacher) " + HSpeople.get(i).getName() + ", " + HSpeople.get(i).getAge() + " years old, teaches grade " + ((Teacher) HSpeople.get(i)).getGrdLvl() +", certified for "+((Teacher) HSpeople.get(i)).getCert() + ", phone: " +  HSpeople.get(i).getPnum() + ".\n"; 
					System.out.printf("(Teacher) %s, %s years old, teaches grade %s, certified for %s, phone: %s.\n",HSpeople.get(i).getName(),HSpeople.get(i).getAge(), ((Teacher) HSpeople.get(i)).getGrdLvl(), ((Teacher) HSpeople.get(i)).getCert(), HSpeople.get(i).getPnum());
					}
				else {
					msg += "(Student) " + HSpeople.get(i).getName() + ", " + HSpeople.get(i).getAge() + " years old, phone: " + HSpeople.get(i).getPnum() + ". Favorite candy: " + ((Kid) HSpeople.get(i)).getCndy() + ".\n";
					System.out.printf("(Student) %s, %s years old, phone: %s. Favorite candy: %s\n",HSpeople.get(i).getName(),HSpeople.get(i).getAge(), HSpeople.get(i).getPnum(), ((Kid) HSpeople.get(i)).getCndy());
					}
				}
			
		}
		
		if (MSpeople.size()==0) {
			msg +="\nParkview School For Children is empty!\n";
			System.out.printf("\nParkview School For Children is empty!\n");}
		else {
			msg += "\nCurrently occupying Parkview School For Children:\n";
			System.out.printf("\nCurrently occupying Parkview School For Children:\n");
			for (int i=0; i<MSpeople.size();i++) {
				if (MSpeople.get(i) instanceof Teacher) {
					msg += "(Teacher) " + MSpeople.get(i).getName() + ", " +MSpeople.get(i).getAge() + " years old, teaches grade " + ((Teacher) MSpeople.get(i)).getGrdLvl() + ", certified for " +((Teacher) MSpeople.get(i)).getCert() + ", phone: " +MSpeople.get(i).getPnum();
					System.out.printf("(Teacher) %s, %s years old, teaches grade %s, certified for %s, phone: %s.\n",MSpeople.get(i).getName(),MSpeople.get(i).getAge(), ((Teacher) MSpeople.get(i)).getGrdLvl(), ((Teacher) MSpeople.get(i)).getCert(), MSpeople.get(i).getPnum());
					}
				else {
					msg += "(Student) " +  MSpeople.get(i).getName() + ", " + MSpeople.get(i).getAge()+" years old, phone: " +MSpeople.get(i).getPnum()+". Favorite candy: " + ((Kid) MSpeople.get(i)).getCndy()+".\n";
					System.out.printf("(Student) %s, %s years old, phone: %s. Favorite candy: %s\n",MSpeople.get(i).getName(),MSpeople.get(i).getAge(), MSpeople.get(i).getPnum(), ((Kid) MSpeople.get(i)).getCndy());
					}
				}
			
		}
		//must convert the \n's to html for proper formatting in the window [taken from Stack Overflow: <https://stackoverflow.com/questions/1090098/newline-in-jlabel>]
	msg = "<html>" + msg.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>";
	txtout.setText(msg);//place this new message in the label in the output console
	repaint();	//refresh the output console to show the new text
	}

	//empty functions
	public void mouseClicked(MouseEvent arg0) {}

	public void mouseEntered(MouseEvent arg0) {}

	public void mouseExited(MouseEvent arg0) {}

	

	/**
	 * @param e is a mouse event [in this case, a press on the mouse--could be a click or the start of a drag]
	 * I did this rather than just putting this in mouseDragged so the message would be output only once, rather than hundreds of times
	 */
	public void mousePressed(MouseEvent e) {	
		int person = 0, index = -1;//local variables to be used below
		msg = "";//as above, building a message for the output console

		JLabel label = null;
		JPanel panel = null;
	
		for (int i = 0; i< lpane.getComponentCount();i++) {//checking every icon to find the one [if any] that the user has clicked
			if (lpane.getComponent(i) instanceof JLabel && lpane.getComponent(i).getBounds().contains(e.getPoint())) {
				label = (JLabel)lpane.getComponent(i);
				person = labelTypes.get(i);
				index = i;
				}
			}
		if (person == 1) {//outputs the details about whatever persont he user has clicked
			msg += "Dragging " + ((Police) people.get(index)).getRole() + " " + people.get(index).getName() + ", " + people.get(index).getAge() + " years old, phone: " + people.get(index).getPnum() + ".\n";
			System.out.printf("Dragging %s %s, %s years old, phone: %s.\n",((Police) people.get(index)).getRole(), people.get(index).getName(),people.get(index).getAge(), people.get(index).getPnum());
		}
		else if (person == 2) {
			msg += "Dragging (Teacher) "+ people.get(index).getName() + ", "+people.get(index).getAge()+" years old, teaches grade "+((Teacher) people.get(index)).getGrdLvl()+", certified for "+((Teacher) people.get(index)).getCert()+", phone: "+people.get(index).getPnum()+".\n";
			System.out.printf("Dragging (Teacher) %s, %s years old, teaches grade %s, certified for %s, phone: %s.\n",people.get(index).getName(),people.get(index).getAge(), ((Teacher) people.get(index)).getGrdLvl(), ((Teacher) people.get(index)).getCert(), people.get(index).getPnum());
		}
		else if (person == 3) {
			msg+="Dragging (Student) "+people.get(index).getName()+", "+people.get(index).getAge()+" years old, phone: "+ people.get(index).getPnum()+". Favorite candy: "+ ((Kid) people.get(index)).getCndy()+".\n";
			System.out.printf("Dragging (Student) %s, %s years old, phone: %s. Favorite candy: %s\n",people.get(index).getName(),people.get(index).getAge(), people.get(index).getPnum(), ((Kid) people.get(index)).getCndy());
		}
		else {//if no person icon was clicked, perhaps a building was. Checks these
			for (int i = 0; i< panel_1.getComponentCount();i++) {
				if (panel_1.getComponent(i) instanceof JPanel && panel_1.getComponent(i).getBounds().contains(e.getPoint())) {
					panel = (JPanel)panel_1.getComponent(i);
					index = i;
					}
				}
			if (index == 2) {//if one of the three buildings we track was clicked, outputs the details for each person in this building
				if (HSpeople.size()==0) {
					msg +="\nWashington High School is empty!\n";
					System.out.printf("\nWashington High School is empty!\n");
				}
				else {
					msg +="\nCurrently occupying George Washington School:\n";
					System.out.printf("\nCurrently occupying George Washington School:\n");
					for (int i=0; i<HSpeople.size();i++) {
						if (HSpeople.get(i) instanceof Teacher) {
							msg+="(Teacher) "+HSpeople.get(i).getName()+", "+HSpeople.get(i).getAge()+" years old, teaches grade "+((Teacher) HSpeople.get(i)).getGrdLvl()+", certified for "+((Teacher) HSpeople.get(i)).getCert()+", phone: "+HSpeople.get(i).getPnum()+".\n";
							System.out.printf("(Teacher) %s, %s years old, teaches grade %s, certified for %s, phone: %s.\n",HSpeople.get(i).getName(),HSpeople.get(i).getAge(), ((Teacher) HSpeople.get(i)).getGrdLvl(), ((Teacher) HSpeople.get(i)).getCert(), HSpeople.get(i).getPnum());
							}
						else {
							msg+="(Student) "+HSpeople.get(i).getName()+", "+HSpeople.get(i).getAge()+" years old, phone: "+HSpeople.get(i).getPnum()+". Favorite candy: "+((Kid) HSpeople.get(i)).getCndy()+".\n";
							System.out.printf("(Student) %s, %s years old, phone: %s. Favorite candy: %s\n",HSpeople.get(i).getName(),HSpeople.get(i).getAge(), HSpeople.get(i).getPnum(), ((Kid) HSpeople.get(i)).getCndy());
							}
						}
					
				}
			}
			
			else if (index == 4) {
				if (CHpeople.size()==0) {
					System.out.printf("City Hall is empty!\n");
					msg+="City Hall is empty!\n";
				}
				else {
					msg+="\nCurrently occupying City Hall:\n";
					System.out.printf("\nCurrently occupying City Hall:\n");
				for (int i=0; i<CHpeople.size();i++) {
					msg+=((Police) CHpeople.get(i)).getRole()+" "+CHpeople.get(i).getName()+", "+CHpeople.get(i).getAge()+" years old, phone: "+CHpeople.get(i).getPnum()+".\n";
					System.out.printf("%s %s, %s years old, phone: %s.\n",((Police) CHpeople.get(i)).getRole(), CHpeople.get(i).getName(),CHpeople.get(i).getAge(), CHpeople.get(i).getPnum());
					}
				}
			}
			else if (index == 6) {
				if (MSpeople.size()==0) {
					msg+="Parkview School For Children is empty!\n";
					System.out.printf("Parkview School For Children is empty!\n");}
				else {
					msg+="Currently occupying Parkview School For Children:\n";
					System.out.printf("Currently occupying Parkview School For Children:\n");
					for (int i=0; i<MSpeople.size();i++) {
						if (MSpeople.get(i) instanceof Teacher) {
							msg+="(Teacher) "+MSpeople.get(i).getName()+", "+MSpeople.get(i).getAge()+" years old, teaches grade "+((Teacher) MSpeople.get(i)).getGrdLvl()+", certified for "+((Teacher) MSpeople.get(i)).getCert()+", phone: "+MSpeople.get(i).getPnum()+".\n";
							System.out.printf("(Teacher) %s, %s years old, teaches grade %s, certified for %s, phone: %s.\n",MSpeople.get(i).getName(),MSpeople.get(i).getAge(), ((Teacher) MSpeople.get(i)).getGrdLvl(), ((Teacher) MSpeople.get(i)).getCert(), MSpeople.get(i).getPnum());
							}
						else {
							msg+="(Student) "+MSpeople.get(i).getName()+", "+MSpeople.get(i).getAge()+" years old, phone: "+MSpeople.get(i).getPnum()+". Favorite candy: "+((Kid) MSpeople.get(i)).getCndy()+".\n";
							System.out.printf("(Student) %s, %s years old, phone: %s. Favorite candy: %s\n",MSpeople.get(i).getName(),MSpeople.get(i).getAge(), MSpeople.get(i).getPnum(), ((Kid) MSpeople.get(i)).getCndy());
							}
						}
					
				}
			}
			else {//if a structure that is not being tracked we clicked, explains that we don't know who's in it
				msg+="\n We don't currently monitor the people in this structure, sorry!";
				System.out.printf("\n We don't currently monitor the people in this structure, sorry!");}
			
			//System.out.printf("Component number: %s\n", index);
		}
		//must convert the \n's to html for proper formatting in the window [taken from Stack Overflow: <https://stackoverflow.com/questions/1090098/newline-in-jlabel>]
		msg = "<html>" + msg.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>";
		txtout.setText(msg);//place this message in the label in the output window
		repaint();//refreshes the output window
	}


	//empty function
	public void mouseReleased(MouseEvent arg0) {}

}

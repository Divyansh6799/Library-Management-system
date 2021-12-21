package lms;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Cursor;
import java.awt.Dialog.ModalExclusionType;

public class User_Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	public static   JLabel USERNAME;
	public static JPanel panel;
	JLabel datetime;
	JLabel L1;
	private static JTextField NAME;
	public static  JButton btnNewButton_1;
	public static  JButton btnNewButton_8;
	public static  JButton btnNewButton_9;
	public static JButton btnNewButton_3;
	public static JButton btnNewButton_4;
	public static JButton btnNewButton_5;
	public static JButton btnNewButton_10;
	public static JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_Menu frame = new  User_Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void name() {
		try {
			Connection con=Connectionclass.getConnection();
			 String sql = "select s.first_name,s.last_name FROM  STUDENT  s   JOIN login  l"
	            		+ " on s.ROLL_NUMBER=l.ROLL_NUMBER"
	            		+ " WHERE l.USERNAME=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, USERNAME.getText());
 			ResultSet rs = st.executeQuery();
 			if (rs.next()) {
            	String s=rs.getString(1);
            	String s1=rs.getString(2);
 				NAME.setText(s+"\n\n"+s1);
 			}else {
 				NAME.setText("ADMIN");
 			}
            
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void datetime() {
		DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		LocalDateTime n=LocalDateTime.now();
		datetime.setText(dt.format(n));
	}

	/**
	 * Create the frame.
	 */
	public  User_Menu() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("GURUKUL-The Standard Library");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1680, 960);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		final JPanel panel = new JPanel();
		panel.setBackground(new Color(0,0,0,40));
		panel.setBounds(0, 0, 442, 647);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.setLayout(null);
		contentPane.add(panel);
		
		
		
		
		JButton btnNewButton_6 = new JButton("BACK TO LOGIN");
		btnNewButton_6.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_6.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_6.setIcon(new ImageIcon(User_Menu.class.getResource("/images/LOGOUT.png")));
		btnNewButton_6.setBounds(10, 497, 182, 81);
		btnNewButton_6.setForeground(Color.RED);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Login frame = new Login();
				frame.setVisible(true);
			}
		});
		
		btnNewButton_1 = new JButton("MY PROFILE");
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setIcon(new ImageIcon(User_Menu.class.getResource("/images/student.png")));
		btnNewButton_1.setBounds(10, 210, 182, 69);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sr = USERNAME.getText();
		    	Profile sr1= new Profile();
	           	Profile.USERNAME.setText(sr);
	           	sr1.setVisible(true);
	           	Profile.student();
			}
		});
		panel.setLayout(null);
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_1.setBackground(Color.CYAN);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ABOUT US");
		btnNewButton_2.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setIcon(new ImageIcon(User_Menu.class.getResource("/images/user-login-305 (1).png")));
		btnNewButton_2.setBounds(10, 306, 182, 69);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				Aboutus frame = new Aboutus();
				frame.setVisible(true);
				
			
			}
		});
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setFont(new Font("Rockwell Extra Bold", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_2.setBackground(Color.CYAN);
		btnNewButton_6.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_6.setBackground(Color.CYAN);
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("MESSAGE");
		btnNewButton_7.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_7.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_7.setIcon(new ImageIcon(User_Menu.class.getResource("/images/message.png")));
		btnNewButton_7.addActionListener(new ActionListener() {
			@SuppressWarnings("resource")
			public void actionPerformed(ActionEvent e) {
//				panel.setVisible(false);
				Messages frame = new Messages();
				frame.setVisible(true);
				String g=USERNAME.getText();
				Messages.USERNAME.setText(g);
				try {
					
					@SuppressWarnings("unused")
					BufferedReader br=null;
					FileReader fr=null;
					fr=new FileReader("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\message.txt");
					br = new BufferedReader(fr);
					int i;
					String s="";
						while((i=fr.read()) != -1) {
						s +=(char)i;
						Messages.textarea.setText(s);
						}
			    }catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_7.setBackground(Color.CYAN);
		btnNewButton_7.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_7.setForeground(Color.RED);
		btnNewButton_7.setBounds(10, 399, 182, 75);
		panel.add(btnNewButton_7);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(User_Menu.class.getResource("/images/student-study-5438.png")));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(148, 0, 182, 140);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("VERSION- 1.0.0.321");
		lblNewLabel_6.setForeground(Color.CYAN);
		lblNewLabel_6.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_6.setBounds(119, 589, 254, 27);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("WELCOME :");
		lblNewLabel_7.setForeground(Color.PINK);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_7.setBounds(176, 134, 113, 27);
		panel.add(lblNewLabel_7);
		
		NAME = new JTextField();
		NAME.setForeground(Color.RED);
		NAME.setHorizontalAlignment(SwingConstants.CENTER);
		NAME.setBorder(null);
		NAME.setEditable(false);
		NAME.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		NAME.setBackground(Color.GRAY);
		NAME.setBounds(118, 161, 230, 27);
		panel.add(NAME);
		NAME.setColumns(10);
		
		btnNewButton_9 = new JButton("STUDENT RECORD");
		btnNewButton_9.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_9.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_9.setBounds(247, 399, 187, 72);
		panel.add(btnNewButton_9);
		btnNewButton_9.setBackground(Color.CYAN);
		btnNewButton_9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Studentdetails().setVisible(true);
			}
		});
		btnNewButton_9.setIcon(new ImageIcon(User_Menu.class.getResource("/images/student.png")));
		btnNewButton_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_9.setForeground(Color.RED);
		
		btnNewButton_8 = new JButton("STATISTICS");
		btnNewButton_8.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_8.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_8.setBounds(247, 497, 187, 81);
		panel.add(btnNewButton_8);
		btnNewButton_8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_8.setBackground(Color.CYAN);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Statistics().setVisible(true);
			}
		});
		btnNewButton_8.setIcon(new ImageIcon(User_Menu.class.getResource("/images/statistics.png")));
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_8.setForeground(Color.RED);
		
		btnNewButton_3 = new JButton("BOOKS  RECORDS");
		btnNewButton_3.setBounds(247, 211, 187, 69);
		panel.add(btnNewButton_3);
		btnNewButton_3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_3.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton_3.setBackground(Color.CYAN);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Bookdetails().setVisible(true);
				String w=USERNAME.getText();
				Bookdetails.USERNAME.setText(w);
				
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(User_Menu.class.getResource("/images/books.png")));
		btnNewButton_3.setForeground(Color.RED);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		
		
		btnNewButton_4 = new JButton("ISSUE BOOKS");
		btnNewButton_4.setBounds(247, 306, 187, 81);
		panel.add(btnNewButton_4);
		btnNewButton_4.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_4.setIcon(new ImageIcon(User_Menu.class.getResource("/images/icons8-book-64.png")));
		btnNewButton_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_4.setBackground(Color.CYAN);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
					String dt=datetime.getText();
				 	String s = USERNAME.getText();
				 	Issuebook s1= new Issuebook();
	         	 	Issuebook.USERNAME.setText(s);
	         	 	Issuebook.datetime.setText(dt);
	         	 	s1.setVisible(true);
	         	 	Issuebook.issue();
			}
		});
		btnNewButton_4.setForeground(Color.RED);
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		
		btnNewButton_5 = new JButton("RETURN BOOKS");
		btnNewButton_5.setBounds(247, 399, 187, 75);
		panel.add(btnNewButton_5);
		btnNewButton_5.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_5.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_5.setIcon(new ImageIcon(User_Menu.class.getResource("/images/icons8-return-book-48.png")));
		btnNewButton_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_5.setBackground(Color.CYAN);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = USERNAME.getText();
			 	Returnbook s1= new Returnbook ();
			 	Returnbook .USERNAME.setText(s);
         	 	s1.setVisible(true);
         	 	Returnbook .user();
         	 }
		});
		btnNewButton_5.setForeground(Color.RED);
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		
		btnNewButton = new JButton("STATUS");
		btnNewButton.setBounds(247, 497, 187, 81);
		panel.add(btnNewButton);
		btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setIcon(new ImageIcon(User_Menu.class.getResource("/images/statistics.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
         	 	Status s1= new Status();
         	 	String h=USERNAME.getText();
         		Status.USERNAME.setText(h);
         		Status.student();
         	 	s1.setVisible(true);
       
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(Color.CYAN);
		
		btnNewButton_10 = new JButton("ADD BOOKS");
		btnNewButton_10.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNewButton_10.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_10.setForeground(Color.RED);
		btnNewButton_10.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_10.setBackground(Color.CYAN);
		btnNewButton_10.setBounds(247, 306, 187, 82);
		panel.add(btnNewButton_10);
		setSize(1367,672);
		getContentPane().setLayout(null);
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("GURUKUL");
		lblNewLabel_2.setBounds(550, 0, 294, 74);
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 55));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("The Standard Library");
		lblNewLabel_3.setBounds(550, 62, 284, 38);
		lblNewLabel_3.setForeground(Color.CYAN);
		lblNewLabel_3.setFont(new Font("Impact", Font.BOLD | Font.ITALIC, 30));
		contentPane.add(lblNewLabel_3);
		
		
		
		USERNAME = new JLabel();
		USERNAME.setSize(138, 34);
		USERNAME.setLocation(887, 9);
		USERNAME.setText("ADMIN");
		USERNAME.setBackground(Color.LIGHT_GRAY);
		contentPane.add(USERNAME);
		USERNAME.setHorizontalAlignment(SwingConstants.CENTER);
		USERNAME.setBorder(null);
		USERNAME.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		USERNAME.setForeground(Color.RED);
		

		
//		final JToggleButton tglbtnNewToggleButton = new JToggleButton("");
//		tglbtnNewToggleButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		tglbtnNewToggleButton.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\menu (1).png"));
//		tglbtnNewToggleButton.setBounds(10, 9, 75, 53);
//		contentPane.add(tglbtnNewToggleButton);
//		tglbtnNewToggleButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
//		tglbtnNewToggleButton.setBackground(Color.CYAN);
//		tglbtnNewToggleButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			    if(tglbtnNewToggleButton.isSelected()) {
//			    	panel.setSize(304, 505);
//			    	panel.setVisible(true);
//			    }else {
//			    	panel.setSize(0,0);
//			    }
//			}
//		});
		
		datetime = new JLabel("");
		datetime.setHorizontalAlignment(SwingConstants.LEFT);
		datetime.setForeground(Color.BLUE);
		datetime.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		datetime.setBounds(1098, 9, 182, 34);
		contentPane.add(datetime);
		
		
		JLabel lblNewLabel_8 = new JLabel("DATE-");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_8.setForeground(Color.BLUE);
		lblNewLabel_8.setBounds(1035, 9, 86, 34);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1.setBounds(-10, 0, 1361, 647);
		lblNewLabel_1.setIcon(new ImageIcon(User_Menu.class.getResource("/images/login (2).jpg")));
		contentPane.add(lblNewLabel_1);
		
		datetime();
		name();
		}
	protected static void issuebook() {
		// TODO Auto-generated method stub
		
	}
}

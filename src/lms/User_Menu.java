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
import javax.swing.JToggleButton;
import javax.swing.border.LineBorder;
import java.awt.Cursor;

public class User_Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	public static   JTextField USERNAME;
	public static JPanel panel;
	JLabel datetime;
	JLabel L1;
	private static JTextField NAME;
	public static  JButton btnNewButton_1;
	public static  JButton btnNewButton_8;
	public static  JButton btnNewButton_9;
	public static  JButton btnNewButton_10;
	public static JButton btnNewButton_3;
	public static JButton btnNewButton_4;
	public static JButton btnNewButton_5;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1280, 960);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		final JPanel panel = new JPanel();
		panel.setBackground(Color.MAGENTA);
		panel.setBounds(10, 62, 294, 508);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setVisible(false);
		contentPane.setLayout(null);
		contentPane.add(panel);
		
		
		
		
		JButton btnNewButton_6 = new JButton("LOGOUT");
		btnNewButton_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_6.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\LOGOUT.png"));
		btnNewButton_6.setBounds(30, 394, 230, 45);
		btnNewButton_6.setForeground(Color.RED);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Welcomepage frame = new Welcomepage();
				frame.setVisible(true);
			}
		});
		
		btnNewButton_1 = new JButton("MY PROFILE");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\student.png"));
		btnNewButton_1.setBounds(30, 209, 230, 53);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				String sr = USERNAME.getText();
		    	Profile sr1= new Profile();
	           	Profile.USERNAME.setText(sr);
	           	sr1.setVisible(true);
	           	Profile.student();
				
				
			}
		});
		panel.setLayout(null);
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ABOUT US");
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\user-login-305 (1).png"));
		btnNewButton_2.setBounds(30, 268, 230, 53);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				Aboutus frame = new Aboutus();
				frame.setVisible(true);
				
			
			}
		});
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setFont(new Font("Rockwell Extra Bold", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_6.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_6.setBackground(Color.BLACK);
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("MESSAGE");
		btnNewButton_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_7.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\message.png"));
		btnNewButton_7.addActionListener(new ActionListener() {
			@SuppressWarnings("resource")
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
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
		btnNewButton_7.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_7.setForeground(Color.RED);
		btnNewButton_7.setBounds(30, 332, 230, 51);
		panel.add(btnNewButton_7);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\student-study-5438.png"));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(51, 0, 182, 140);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("VERSION- 1.0.0.321");
		lblNewLabel_6.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_6.setBounds(30, 470, 254, 27);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("WELCOME :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_7.setBounds(87, 135, 113, 27);
		panel.add(lblNewLabel_7);
		
		NAME = new JTextField();
		NAME.setHorizontalAlignment(SwingConstants.CENTER);
		NAME.setBorder(null);
		NAME.setEditable(false);
		NAME.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		NAME.setBackground(new Color(255, 0, 255));
		NAME.setBounds(30, 161, 230, 27);
		panel.add(NAME);
		NAME.setColumns(10);
		setSize(1290,666);
		getContentPane().setLayout(null);
		
		
		btnNewButton = new JButton("STATUS");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBounds(970, 581, 294, 46);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\statistics.png"));
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
         	 	Status s1= new Status();
         	 	String h=USERNAME.getText();
         		Status.USERNAME.setText(h);
         		Status.student();
         	 	s1.setVisible(true);
       
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(Color.CYAN);
		
		
		btnNewButton_3 = new JButton("BOOKS  RECORDS");
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3.setBounds(10, 581, 309, 46);
		btnNewButton_3.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton_3.setBackground(Color.CYAN);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Bookdetails().setVisible(true);
				String w=USERNAME.getText();
				Bookdetails.USERNAME.setText(w);
				
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\books.png"));
		btnNewButton_3.setForeground(Color.RED);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("ISSUE BOOKS");
		btnNewButton_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_4.setBounds(318, 581, 304, 46);
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
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		contentPane.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("RETURN BOOKS");
		btnNewButton_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_5.setBounds(620, 581, 353, 46);
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
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		contentPane.add(btnNewButton_5);
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("GLOBAL");
		lblNewLabel_2.setBounds(358, 170, 332, 74);
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Lucida Handwriting", Font.BOLD | Font.ITALIC, 50));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("EVOLUTION");
		lblNewLabel_3.setBounds(554, 239, 382, 67);
		lblNewLabel_3.setForeground(Color.CYAN);
		lblNewLabel_3.setFont(new Font("Lucida Handwriting", Font.BOLD | Font.ITALIC, 50));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("LIBRARY");
		lblNewLabel_4.setBounds(840, 303, 326, 74);
		lblNewLabel_4.setForeground(Color.MAGENTA);
		lblNewLabel_4.setFont(new Font("Lucida Handwriting", Font.BOLD | Font.ITALIC, 50));
		contentPane.add(lblNewLabel_4);
		
		
		
		USERNAME = new JTextField();
		USERNAME.setText("");
		USERNAME.setBackground(Color.DARK_GRAY);
		USERNAME.setBounds(606, 11, 131, 34);
		contentPane.add(USERNAME);
		USERNAME.setHorizontalAlignment(SwingConstants.CENTER);
		USERNAME.setBorder(null);
		USERNAME.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		USERNAME.setForeground(Color.RED);
		USERNAME.setEditable(false);
		USERNAME.setColumns(10);
		
	
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\user-3297 (1).png"));
		lblNewLabel.setBounds(554, 11, 62, 34);
		contentPane.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setForeground(Color.RED);
		

		
		final JToggleButton tglbtnNewToggleButton = new JToggleButton("");
		tglbtnNewToggleButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tglbtnNewToggleButton.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\menu (1).png"));
		tglbtnNewToggleButton.setBounds(10, 9, 75, 53);
		contentPane.add(tglbtnNewToggleButton);
		tglbtnNewToggleButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		tglbtnNewToggleButton.setBackground(Color.CYAN);
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    if(tglbtnNewToggleButton.isSelected()) {
			    	panel.setSize(304, 505);
			    	panel.setVisible(true);
			    }else {
			    	panel.setSize(0,0);
			    }
			}
		});
		
		datetime = new JLabel("");
		datetime.setHorizontalAlignment(SwingConstants.LEFT);
		datetime.setForeground(Color.BLUE);
		datetime.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		datetime.setBounds(1037, 9, 182, 34);
		contentPane.add(datetime);
		
		
		JLabel lblNewLabel_8 = new JLabel("DATE-");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_8.setForeground(Color.BLUE);
		lblNewLabel_8.setBounds(968, 11, 86, 34);
		contentPane.add(lblNewLabel_8);
		
		btnNewButton_8 = new JButton("STATISTICS");
		btnNewButton_8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_8.setBackground(Color.CYAN);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Statistics().setVisible(true);
			}
		});
		btnNewButton_8.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\statistics.png"));
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_8.setForeground(Color.RED);
		btnNewButton_8.setBounds(970, 581, 294, 46);
		contentPane.add(btnNewButton_8);
		
		btnNewButton_9 = new JButton("STUDENT RECORD");
		btnNewButton_9.setBackground(Color.CYAN);
		btnNewButton_9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Studentdetails().setVisible(true);
			}
		});
		btnNewButton_9.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\student.png"));
		btnNewButton_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_9.setForeground(Color.RED);
		btnNewButton_9.setBounds(620, 581, 353, 46);
		contentPane.add(btnNewButton_9);
		
		btnNewButton_10 = new JButton("ADD BOOKS");
		btnNewButton_10.setBackground(Color.CYAN);
		btnNewButton_10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Addbooks().setVisible(true);
			}
		});
		btnNewButton_10.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\addbook.png"));
		btnNewButton_10.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_10.setForeground(Color.RED);
		btnNewButton_10.setBounds(318, 581, 308, 46);
		contentPane.add(btnNewButton_10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1.setBounds(0, 0, 1280, 853);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\ADMIN SECTION.jpg"));
		contentPane.add(lblNewLabel_1);
		
		datetime();
		name();
		}
	
	

	protected static void issuebook() {
		// TODO Auto-generated method stub
		
	}
}

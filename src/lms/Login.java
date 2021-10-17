package lms;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingConstants;
import javax.swing.JEditorPane;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final JLabel lblNewLabel_4 = null;
	protected static final JLabel lblNewLabel_5 = null;
	private JPanel contentPane;
	public static JTextField USERNAME;
	public static JPasswordField PASSWORD;
	public static JLabel lblNewLabel_7;
	public static JLabel lblNewLabel_31;
	public static JButton btnNewButton_1;
	public static  JButton btnNewButton_2;
	public static JLabel lblNewLabel_3;
	private static JLabel lblNewLabel_8;
	private static JLabel lblNewLabel_9;

	/**
	 * Launch the application.
	 */
	  public static void main(String[] args) {
			new Login().setVisible(true);
			lblNewLabel_8.setVisible(false);
		    }

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 30, 1141, 640);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
		JPanel panel = new JPanel();
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panel.setBackground(new Color(255, 20, 147));
		panel.setBounds(283, 170, 613, 431);
		panel.setBackground(new Color(0,0,0,100));
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_7 = new JLabel("ADMIN   LOGIN");
		lblNewLabel_7.setBounds(182, 3, 236, 34);
		panel.add(lblNewLabel_7);
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 36));
		
		USERNAME = new JTextField();
		USERNAME.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 16));
		USERNAME.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(USERNAME.getText().equals("ENTER USERNAME/USER-ID")) {
					USERNAME.setText("");
					USERNAME.setForeground(Color.CYAN);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(USERNAME.getText().equals("")) {
					USERNAME.setText("ENTER USERNAME/USER-ID");
					USERNAME.setForeground(Color.CYAN);
				}
			}
		});
		USERNAME.setForeground(Color.CYAN);
		USERNAME.setText("ENTER USERNAME/USER-ID");
		USERNAME.setBackground(Color.BLACK);
		USERNAME.setBounds(111, 84, 364, 42);
		panel.add(USERNAME);
		USERNAME.setColumns(10);
		
		PASSWORD = new  JPasswordField();
		PASSWORD.setForeground(Color.CYAN);
		PASSWORD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ae) {
				if(ae.getKeyCode()==KeyEvent.VK_ENTER) {
				}
			}
		});
		PASSWORD.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 17));
		PASSWORD.setEchoChar((char)0);
		PASSWORD.addFocusListener(new FocusAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusGained(FocusEvent e) {
				if(PASSWORD.getText().equals("ENTER PASSWORD/PIN")) {
					PASSWORD.setText("");
					PASSWORD.setEchoChar('*');
					PASSWORD.setForeground(Color.CYAN);
				}
			}
			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(FocusEvent e) {
				if(PASSWORD.getText().equals("")) {
					PASSWORD.setEchoChar((char)0);
					PASSWORD.setText("ENTER PASSWORD/PIN");
					PASSWORD.setForeground(Color.CYAN);
				}
			}
		});
		PASSWORD.setBackground(Color.BLACK);
		PASSWORD.setText("ENTER PASSWORD/PIN");
		PASSWORD.setBounds(111, 174, 364, 42);
		panel.add(PASSWORD);
		PASSWORD.setColumns(10);
		 
		
		 
		 lblNewLabel_3 = new JLabel("i forget my password.......");
		 lblNewLabel_3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		 lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 lblNewLabel_3.addMouseListener(new MouseAdapter() {
		 	@SuppressWarnings("unlikely-arg-type")
			@Override
		 	public void mouseClicked(MouseEvent e) {
		 		String n= JOptionPane.showInputDialog(null, "ENTER YOUR SECURITY CODE:");
				if(n.isEmpty()) {
					JOptionPane.showInputDialog(null, "please enter your code:");
				}
				    else if(n.equals(JOptionPane.CANCEL_OPTION)) {
						System.exit(0);
					}
				
					else {
					try {
						Connection con=Connectionclass.getConnection();
			    		String sql = "Select USERNAME,PASSWORD from ADMIN_LOGIN where CODE=?";
	    	            PreparedStatement st = con.prepareStatement(sql);
	                    st.setString(1, n);
	                   
	                    ResultSet rs = st.executeQuery();
	                    if (rs.next()) 
	                    {
	                    	String s=rs.getString(1);
	                    	String s1=rs.getString(2);
	                    	USERNAME.setText(s);
	                    	PASSWORD.setText(s1);
	                    	
	                    }
	                    else {
	                    	JOptionPane.showMessageDialog(null, "PLEASE ENTER CORRECT CODE....!");
	                    }
						
					}catch(Exception e1) {
						e1.printStackTrace();
					}
				}
		 	}
		 });
		 lblNewLabel_3.setForeground(new Color(255, 99, 71));
		 lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		 lblNewLabel_3.setBounds(249, 248, 222, 20);
		 panel.add(lblNewLabel_3);
		 
		 lblNewLabel_9 = new JLabel("");
		 lblNewLabel_9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\eye-view-6451(1).png"));
		 lblNewLabel_9.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		if(e.getSource().equals(lblNewLabel_9)) {
		 			PASSWORD.setEchoChar((char)0);
		 			lblNewLabel_8.setVisible(true);
		 			lblNewLabel_9.setVisible(false);
		 		}
		 	}
		 });
		 lblNewLabel_9.setBackground(new Color(0, 0, 0));
		 lblNewLabel_9.setForeground(Color.CYAN);
		 lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		 lblNewLabel_9.setBounds(496, 174, 64, 42);
		 panel.add(lblNewLabel_9);
		 
		 	btnNewButton_2 = new JButton("i forget my password....");
		 	btnNewButton_2.setBounds(249, 227, 225, 23);
		 	panel.add(btnNewButton_2);
		 	btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 19));
		 	btnNewButton_2.setForeground(new Color(255, 99, 71));
		 	btnNewButton_2.setBackground(new Color(0, 0, 0));
		 	btnNewButton_2.addActionListener(new ActionListener() {
		 		public void actionPerformed(ActionEvent e) {
		 			setVisible(false);
		 			Forgetpassword frame = new Forgetpassword();
		 			frame.setVisible(true);
		 		}
		 	});
		 	 JButton btnNewButton = new JButton("LOGIN");
		 	 btnNewButton.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\user-login-305 (1).png"));
			 btnNewButton.setBounds(165, 305, 212, 42);
			 panel.add(btnNewButton);
			 btnNewButton.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 26));
			 btnNewButton.setForeground(new Color(153, 51, 51));
			 btnNewButton.setBackground(Color.BLACK);
			 
			 lblNewLabel_31 = new JLabel("YOU DON'T HAVE AN ACCOUNT?...");
			 lblNewLabel_31.setBounds(57, 388, 293, 27);
			 panel.add(lblNewLabel_31);
			 lblNewLabel_31.setForeground(Color.GREEN);
			 lblNewLabel_31.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
			 
			 btnNewButton_1 = new JButton("CREATE NOW..!");
			 btnNewButton_1.setBounds(360, 388, 180, 27);
			 panel.add(btnNewButton_1);
			 btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			 btnNewButton_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
			 btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			 btnNewButton_1.setBackground(Color.BLUE);
			 btnNewButton_1.setForeground(new Color(199, 21, 133));
			 
			 JLabel lblNewLabel = new JLabel("");
			 lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			 lblNewLabel.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\user-3297 (1).png"));
			 lblNewLabel.setBounds(57, 76, 47, 50);
			 panel.add(lblNewLabel);
			 
			 JLabel lblNewLabel_1 = new JLabel("New label");
			 lblNewLabel_1.setIcon(new ImageIcon("C:\\\\Users\\\\divya\\\\eclipse-workspace\\\\liberary management system\\\\library management system\\\\images\\key-6312.png"));
			 lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			 lblNewLabel_1.setBounds(64, 174, 47, 42);
			 panel.add(lblNewLabel_1);
			 
			 lblNewLabel_8 = new JLabel("");
			 lblNewLabel_8.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mouseClicked(MouseEvent e) {
			 		if(e.getSource().equals(lblNewLabel_8)) {
			 			PASSWORD.setEchoChar('*');
			 			
			 			lblNewLabel_8.setVisible(false);
			 			lblNewLabel_9.setVisible(true);
			 			
			 		}
			 	}
			 });
			 lblNewLabel_8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			 lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\hide.png"));
			 lblNewLabel_8.setBounds(496, 172, 52, 50);
			 panel.add(lblNewLabel_8);
			 btnNewButton_1.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		setVisible(false);
			 		Signup frame = new Signup();
			 		frame.setVisible(true);
			 	}
			 });
			 	
		 	btnNewButton.addActionListener(new ActionListener() {
		 	@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
		 		try{
		 			
		 			Connection con=Connectionclass.getConnection();
		 			PreparedStatement st = con.prepareStatement("Select USERNAME,PASSWORD from ADMIN_LOGIN where username=? and password=?");
		 			st.setString(1, USERNAME.getText());
		 			st.setString(2, PASSWORD.getText());
		 			ResultSet rs = st.executeQuery();
		 			if (rs.next()) 
                {
		 				
                	 setVisible(false);
                     System.out.print("welcome");
                     st.setString(1, USERNAME.getText());
                     String s = USERNAME.getText();
                     User_Menu s1= new User_Menu();
             	 	 User_Menu.USERNAME.setText(s);
             	 	 s1.setVisible(true);
             	 	 User_Menu.btnNewButton_1.setVisible(false);
             	 	 User_Menu. btnNewButton_4.setVisible(false);
             	 	 User_Menu. btnNewButton_5.setVisible(false);
             	 	 User_Menu. btnNewButton.setVisible(false);
                }
               
		 		else  {
		 		PreparedStatement st1 = con.prepareStatement("Select USERNAME,PASSWORD from LOGIN where username=? and password=?");
		 	
                st1.setString(1, USERNAME.getText());
                st1.setString(2, PASSWORD.getText());
                ResultSet rs1 = st1.executeQuery();
                if (rs1.next()) 
                {
                	 setVisible(false);
                     User_Menu frame = new User_Menu();
                     frame.setVisible(true);
                     System.out.print("welcome user");
                     st.setString(1, USERNAME.getText());
                     String s = USERNAME.getText();
                     User_Menu s1= new User_Menu();
             	 	 User_Menu.USERNAME.setText(s);
             	 	 s1.setVisible(true);
             	 	 User_Menu. name();
             	 	 User_Menu.btnNewButton_8.setVisible(false);
             	 	 User_Menu.btnNewButton_9.setVisible(false);
             	 	 User_Menu.btnNewButton_10.setVisible(false);
             	 	
                }else {
                	
				 JOptionPane.showMessageDialog(null, "Invalid Login crediential....!");
			   }
		 	}
		 }catch(Exception ex){
		 	ex.printStackTrace();
		 	}
		 }
		 });
	
		 	
		 	JButton btnNewButton_3 = new JButton("BACK");
		 	btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\back.png"));
		 	btnNewButton_3.addActionListener(new ActionListener() {
		 		public void actionPerformed(ActionEvent e) {
		 			setVisible(false);
		 			new Welcomepage().setVisible(true);
		 		}
		 	});
		 	btnNewButton_3.setBackground(Color.LIGHT_GRAY);
			btnNewButton_3.setForeground(Color.RED); 
			btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
			btnNewButton_3.setBounds(0, 11, 125, 35);
			contentPane.add(btnNewButton_3);
			
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\student-study-5438.png"));
			lblNewLabel_2.setBounds(496, 11, 149, 142);
			contentPane.add(lblNewLabel_2);
			
			
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon( new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\login (2).jpg"));
		lblNewLabel_6.setBounds(0, -11, 1142, 665);
		contentPane.add(lblNewLabel_6);
		
	
		
	}
}
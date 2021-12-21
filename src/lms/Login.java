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
	private static JLabel lblNewLabel_8;
	JLabel lblNewLabel_3;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;

	/**
	 * Launch the application.
	 */
	  public static void main(String[] args) {
			new Login().setVisible(true);
			
		    }

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(180, 50, 1040, 620);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panel.setBounds(302, 0, 738, 620);
		panel.setBackground(Color.DARK_GRAY);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_7 = new JLabel("SIGN IN ");
		lblNewLabel_7.setBackground(Color.BLACK);
		lblNewLabel_7.setBounds(210, 97, 197, 65);
		panel.add(lblNewLabel_7);
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 60));
		
		 JLabel lblNewLabel = new JLabel("");
		 lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/images/key-6312.png")));
		 lblNewLabel.setBounds(78, 311, 47, 42);
		 panel.add(lblNewLabel);
		 
		USERNAME = new JTextField();
		USERNAME.setHorizontalAlignment(SwingConstants.LEFT);
		USERNAME.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 20));
		USERNAME.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(USERNAME.getText().equals("ENTER USERNAME")) {
					USERNAME.setText("");
					USERNAME.setForeground(Color.CYAN);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(USERNAME.getText().equals("")) {
					USERNAME.setText("ENTER USERNAME");
					USERNAME.setForeground(Color.CYAN);
				}
			}
		});
		USERNAME.setForeground(Color.CYAN);
		USERNAME.setText("ENTER USERNAME");
		USERNAME.setBackground(Color.BLACK);
		USERNAME.setBounds(135, 218, 403, 42);
		panel.add(USERNAME);
		USERNAME.setColumns(10);
		
		 lblNewLabel_8 = new JLabel("");
		 lblNewLabel_8.setBackground(Color.BLACK);
		 lblNewLabel_8.setForeground(Color.BLACK);
		 
		 lblNewLabel_8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 lblNewLabel_8.setIcon(new ImageIcon(Login.class.getResource("/images/icons8-eye-48.png")));
		 lblNewLabel_8.setBounds(548, 311, 47, 42);
		 lblNewLabel_8.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mouseEntered(MouseEvent e) {
			 		if(e.getSource().equals(lblNewLabel_8)) {
			 			PASSWORD.setEchoChar((char)0);
			 			lblNewLabel_3.setText("Show/Hide Password");
//			 			 lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\hide.png"));
			 		}
			 	}
		 	@Override
		 	public void mouseExited(MouseEvent e) {
		 		if(e.getSource().equals(lblNewLabel_8)) {
		 			PASSWORD.setEchoChar('*');
		 			lblNewLabel_3.setText("");
//		 			 lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\eye-view-6451 (1).png"));
		 		}
		 	}
			 });
		 panel.add(lblNewLabel_8);
		
		 JLabel lblNewLabel_1 = new JLabel("");
		 lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/images/user-login-305 (1).png")));
		 lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel_1.setBounds(78, 218, 47, 42);
		 panel.add(lblNewLabel_1);
		 
		PASSWORD = new  JPasswordField();
		PASSWORD.setHorizontalAlignment(SwingConstants.LEFT);
		PASSWORD.setForeground(Color.CYAN);
		PASSWORD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ae) {
				if(ae.getKeyCode()==KeyEvent.VK_ENTER) {
				}
			}
		});
		PASSWORD.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 20));
		PASSWORD.setEchoChar((char)0);
		PASSWORD.addFocusListener(new FocusAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusGained(FocusEvent e) {
				if(PASSWORD.getText().equals("ENTER PASSWORD")) {
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
					PASSWORD.setText("ENTER PASSWORD");
					PASSWORD.setForeground(Color.CYAN);
				}
			}
		});
		PASSWORD.setBackground(Color.BLACK);
		PASSWORD.setText("ENTER PASSWORD");
		PASSWORD.setBounds(135, 311, 403, 42);
		panel.add(PASSWORD);
		PASSWORD.setColumns(10);
		 	 JButton btnNewButton = new JButton("SIGN IN");
		 	 btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 	 btnNewButton.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\user-login-305 (1).png"));
			 btnNewButton.setBounds(210, 394, 214, 42);
			 panel.add(btnNewButton);
			 btnNewButton.setFont(new Font("Dubai Medium", Font.ITALIC, 26));
			 btnNewButton.setForeground(Color.RED);
			 btnNewButton.setBackground(Color.BLACK);
			 
			
			 lblNewLabel_3 = new JLabel("");
			 lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 15));
			 lblNewLabel_3.setForeground(Color.RED);
			 lblNewLabel_3.setBounds(515, 375, 165, 23);
			 panel.add(lblNewLabel_3);
			 
			 JButton btnNewButton_3 = new JButton("");
			 btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			 btnNewButton_3.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		System.exit(0);
			 	}
			 });
			 btnNewButton_3.setBounds(689, 0, 47, 42);
			 panel.add(btnNewButton_3);
			 btnNewButton_3.setForeground(Color.CYAN);
			 btnNewButton_3.setBackground(Color.WHITE);
			 btnNewButton_3.setIcon(new ImageIcon(Login.class.getResource("/images/icons8-close-35.png")));
			 btnNewButton_3.setFont(new Font("Tahoma", Font.ITALIC, 23));
			 
			 
			 
			 JLabel lblNewLabel_2 = new JLabel("");
			 lblNewLabel_2.setVerticalTextPosition(SwingConstants.BOTTOM);
			 lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
			 lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
			 lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/images/student-study-5438.png")));
			 lblNewLabel_2.setBounds(91, 95, 128, 146);
			 contentPane.add(lblNewLabel_2);
			 
			 JEditorPane dtrpnTheOnlineLibrary = new JEditorPane();
			 dtrpnTheOnlineLibrary.setForeground(Color.PINK);
			 dtrpnTheOnlineLibrary.setBackground(Color.BLACK);
			 dtrpnTheOnlineLibrary.setFont(new Font("Snap ITC", Font.ITALIC, 25));
			 dtrpnTheOnlineLibrary.setText("THE \r\n     ONLINE\r\n              LIBRARY\r\n\r\n*  *  *  *  *  *  *  * ");
			 dtrpnTheOnlineLibrary.setBounds(0, 277, 302, 191);
			 contentPane.add(dtrpnTheOnlineLibrary);
			 
			 lblNewLabel_6 = new JLabel("GURUKUL");
			 lblNewLabel_6.setForeground(Color.RED);
			 lblNewLabel_6.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 49));
			 lblNewLabel_6.setBounds(0, 0, 302, 102);
			 contentPane.add(lblNewLabel_6);
			 
			 lblNewLabel_10 = new JLabel("FORGET YOUR PASSWORD ! Click Here");
			 lblNewLabel_10.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mouseClicked(MouseEvent e) {
			 			new Forgetpassword().setVisible(true);
			 	}
			 	@Override
			 	public void mouseEntered(MouseEvent e) {
			 		 lblNewLabel_10.setForeground(Color.BLACK);
			 	}
			 	@Override
			 	public void mouseExited(MouseEvent e) {
			 		 lblNewLabel_10.setForeground(Color.CYAN);
			 	}
			 });
			 lblNewLabel_10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			 lblNewLabel_10.setForeground(Color.CYAN);
			 lblNewLabel_10.setFont(new Font("Segoe UI Historic", Font.BOLD | Font.ITALIC, 20));
			 lblNewLabel_10.setBounds(169, 468, 384, 42);
			 panel.add(lblNewLabel_10);
			 
			 
			 
			 
			 
			 lblNewLabel_31 = new JLabel("DON'T HAVE AN ACCOUNT  ?");
			 lblNewLabel_31.setBounds(124, 573, 292, 32);
			 panel.add(lblNewLabel_31);
			 lblNewLabel_31.setForeground(Color.CYAN);
			 lblNewLabel_31.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
			 
			 btnNewButton_1 = new JButton("SIGN UP");
			 btnNewButton_1.setBounds(415, 567, 190, 42);
			 panel.add(btnNewButton_1);
			 btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			 btnNewButton_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
			 btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
			 btnNewButton_1.setBackground(Color.LIGHT_GRAY);
			 btnNewButton_1.setForeground(Color.BLACK);
			 btnNewButton_1.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
//			 		setVisible(false);
			 		new Signup().setVisible(true);
			 	}
			 });
			 lblNewLabel_9 = new JLabel("");
			 lblNewLabel_9.setIcon(new ImageIcon(Login.class.getResource("/images/ADMIN SECTION.jpg")));
			 lblNewLabel_9.setBounds(0, 0, 736, 621);
			 panel.add(lblNewLabel_9);
			 
			 JLabel lblNewLabel_11 = new JLabel("VERSION--1.1.0.01");
			 lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
			 lblNewLabel_11.setBounds(39, 545, 216, 46);
			 contentPane.add(lblNewLabel_11);
			 
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
             	 	 User_Menu.USERNAME.setText(s);
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
		}
}
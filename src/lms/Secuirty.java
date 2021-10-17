package lms;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Secuirty extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3178939921086537860L;
	private JPanel contentPane;
	public  JTextField ROLL_NUMBER;
	private JTextField USERNAME;
	private JPasswordField PASSWORD;
	private JComboBox<?> comboBox;	
	private JTextField SECUIRTY_ANS;
	private JPasswordField CONFIRM_PASSWORD;
	private JLabel lblNewLabel_7;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Secuirty frame = new Secuirty();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Secuirty() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 656, 454);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PLEASE ENTER SOME DETAILS FOR SECUIRTY PURPOSE");
		lblNewLabel.setForeground(new Color(255, 255, 51));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(90, 11, 550, 33);
		contentPane.add(lblNewLabel);
		
		ROLL_NUMBER = new JTextField();
		ROLL_NUMBER.setBackground(Color.DARK_GRAY);
		ROLL_NUMBER.setForeground(Color.ORANGE);
		ROLL_NUMBER.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		ROLL_NUMBER.setText("7894");
		ROLL_NUMBER.setEditable(false);
		ROLL_NUMBER.setBounds(29, 90, 167, 23);
		contentPane.add(ROLL_NUMBER);
		ROLL_NUMBER.setColumns(10);
		
		USERNAME = new JTextField();
		USERNAME.setBackground(Color.DARK_GRAY);
		USERNAME.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(USERNAME.getText().equals("ENTER YOUR USERNAME")) {
					USERNAME.setText("");
					USERNAME.setForeground(Color.ORANGE);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(USERNAME.getText().equals("")) {
					USERNAME.setText("ENTER YOUR USERNAME");
					USERNAME.setForeground(Color.ORANGE);
				}
			}
		});
		USERNAME.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		USERNAME.setForeground(Color.ORANGE);
		USERNAME.setText("ENTER YOUR USERNAME");
		USERNAME.setBounds(354, 90, 286, 34);
		contentPane.add(USERNAME);
		USERNAME.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox.setBackground(Color.DARK_GRAY);
		comboBox.setForeground(Color.ORANGE);
		comboBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Your NickName?", "Your Lucky Number?", "Your child SuperHero?", "Your Favourite game?"}));
		comboBox.setBounds(29, 286, 288, 29);
		contentPane.add(comboBox);
		
		SECUIRTY_ANS = new JTextField();
		SECUIRTY_ANS.setBackground(Color.DARK_GRAY);
		SECUIRTY_ANS.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(SECUIRTY_ANS.getText().equals("ENTER YOUR SECURITY ANSWER")) {
					SECUIRTY_ANS.setText("");
					SECUIRTY_ANS.setForeground(Color.ORANGE);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(SECUIRTY_ANS.getText().equals("")) {
					SECUIRTY_ANS.setText("ENTER YOUR SECURITY ANSWER");
					SECUIRTY_ANS.setForeground(Color.ORANGE);
				}
			}
		});
		SECUIRTY_ANS.setText("ENTER YOUR SECURITY ANSWER");
		SECUIRTY_ANS.setForeground(Color.ORANGE);
		SECUIRTY_ANS.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		SECUIRTY_ANS.setBounds(352, 282, 288, 33);
		contentPane.add(SECUIRTY_ANS);
		SECUIRTY_ANS.setColumns(10);
		
		final JButton btnNewButton = new JButton("CREATE NEW ACCOUNT");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				try{
					Connection con=Connectionclass.getConnection();
					String sql = "INSERT INTO LOGIN(ROLL_NUMBER,USERNAME,PASSWORD,SECUIRTY_QUES,SECUIRTY_ANS) VALUES(?,?,?,?,?)";
    	            PreparedStatement st = con.prepareStatement(sql);
    	            st.setString(1, ROLL_NUMBER.getText());
    	            st.setString(2, USERNAME.getText());
					st.setString(3, PASSWORD.getText());
					st.setString(4 ,(String) comboBox.getSelectedItem());
					st.setString(5, SECUIRTY_ANS.getText());
					String pass=PASSWORD.getText();
					String con_pas=CONFIRM_PASSWORD.getText();
					if(pass.equals(con_pas)) {
                    int i = st.executeUpdate();
                    if(i>0) {
                    	
                    	setVisible(false);
                    	JOptionPane.showMessageDialog(null, "your account is created");	
                    	setVisible(false);
        				new Login().setVisible(true);
        				Login.lblNewLabel_7.setText("USER LOGIN");
        				Login.lblNewLabel_3.setVisible(false); 
   					}
                    else {
   						JOptionPane.showMessageDialog(null, "SOMETHING WENT WRONG", "ERROR", JOptionPane.ERROR_MESSAGE);
   						
   					}
					}else {
                    		JOptionPane.showMessageDialog(null, "password and confirm password must be same", "error", JOptionPane.ERROR_MESSAGE);
                    		PASSWORD.setText("");
                    		CONFIRM_PASSWORD.setText("");
                    	}
					
				
				}catch(NullPointerException ex)
				{
					
				ex.printStackTrace();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
	});
		btnNewButton.setBounds(203, 352, 256, 33);
		contentPane.add(btnNewButton);
		
		
		PASSWORD = new JPasswordField();
		PASSWORD.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
					lblNewLabel_7.setText("ENTER ONLY NUMBERS");
				}if(PASSWORD.getText().length()>3) {
					e.consume();
					lblNewLabel_7.setText("PASSWORD MUST BE 4 DIGITS");
				}
				else {
					lblNewLabel_7.setText("");
				}
			}
		});
		PASSWORD.setBackground(Color.DARK_GRAY);
		PASSWORD.setEchoChar((char)0);
		PASSWORD.addFocusListener(new FocusAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusGained(FocusEvent e) {
				if(PASSWORD.getText().equals("ENTER PASSWORD(ONLY 4 DIGITS EX-1234)")) {
					PASSWORD.setText("");
					PASSWORD.setEchoChar('*');
					PASSWORD.setForeground(Color.ORANGE);
				}
			}
			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(FocusEvent e) {
				if(PASSWORD.getText().equals("")) {
					PASSWORD.setEchoChar((char)0);
					PASSWORD.setText("ENTER PASSWORD(ONLY 4 DIGITS EX-1234)");
					PASSWORD.setForeground(Color.ORANGE);
				}
			}
		});
		PASSWORD.setText("ENTER PASSWORD(ONLY 4 DIGITS EX-1234)");
		PASSWORD.setForeground(Color.ORANGE);
		PASSWORD.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		PASSWORD.setBounds(29, 173, 299, 33);
		contentPane.add(PASSWORD);
		
		final JCheckBox chckbxNewCheckBox = new JCheckBox("SHOW");
		chckbxNewCheckBox.setForeground(Color.RED);
		chckbxNewCheckBox.setBackground(Color.LIGHT_GRAY);
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					PASSWORD.setEchoChar((char)0);
					CONFIRM_PASSWORD.setEchoChar((char)0);
				}
				else {
					PASSWORD.setEchoChar('*');
					CONFIRM_PASSWORD.setEchoChar('*');
				}
			}
		});
		chckbxNewCheckBox.setBounds(516, 217, 124, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(355, 67, 104, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ROLL_NUMBER :");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_2.setBounds(30, 64, 139, 23);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PASSWORD");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_3.setBounds(27, 149, 102, 23);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("SECURITY QUESTION");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_4.setBounds(29, 251, 155, 24);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("SECURITY ANSWER");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_5.setBounds(354, 250, 139, 27);
		contentPane.add(lblNewLabel_5);
		
		final JButton btnNewButton_1 = new JButton("<<");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con=Connectionclass.getConnection();
		    		String sql = "DELETE FROM STUDENT WHERE ROLL_NUMBER=?";
    	            PreparedStatement st = con.prepareStatement(sql);
    	            st.setString(1, ROLL_NUMBER.getText());
                    int i = st.executeUpdate();
                    if(i>0) {
                    	JOptionPane.showMessageDialog(null, "YOUR DATA HAS BEEN LOST,PLEASE RE-CREATE YOUR ACCOUNT");	
                    	setVisible(false);
                    	new Signup().setVisible(true);
                    	
                    }else {
                    		JOptionPane.showMessageDialog(null, "somewent wrong! TRY AGAIN.....");	
                    	}
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1.setBounds(0, 11, 60, 33);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("CONFIRM PASSWORD");
		lblNewLabel_6.setForeground(Color.BLACK);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_6.setBounds(354, 149, 161, 23);
		contentPane.add(lblNewLabel_6);
		
		CONFIRM_PASSWORD = new JPasswordField();
		CONFIRM_PASSWORD.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!Character.isDigit(c)) {
					e.consume();
					lblNewLabel_7.setText("ENTER ONLY NUMBERS");
				}if(CONFIRM_PASSWORD.getText().length()>3) {
					e.consume();
					lblNewLabel_7.setText("PASSWORD MUST BE 4 DIGITS");
				}
				else {
					lblNewLabel_7.setText("");
				}
			}
		});
		CONFIRM_PASSWORD.setEchoChar((char)0);
		CONFIRM_PASSWORD.addFocusListener(new FocusAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusGained(FocusEvent e) {
				if(CONFIRM_PASSWORD.getText().equals("ENTER PASSWORD(ONLY 4 DIGITS EX-1234)")) {
					CONFIRM_PASSWORD.setText("");
					CONFIRM_PASSWORD.setEchoChar('*');
					CONFIRM_PASSWORD.setForeground(Color.ORANGE);
				}
			}
			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(FocusEvent e) {
				if(CONFIRM_PASSWORD.getText().equals("")) {
					CONFIRM_PASSWORD.setEchoChar((char)0);
					CONFIRM_PASSWORD.setText("ENTER PASSWORD(ONLY 4 DIGITS EX-1234)");
					CONFIRM_PASSWORD.setForeground(Color.ORANGE);
				}
			}
		});
		CONFIRM_PASSWORD.setText("ENTER PASSWORD(ONLY 4 DIGITS EX-1234)");
		CONFIRM_PASSWORD.setForeground(Color.ORANGE);
		CONFIRM_PASSWORD.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		CONFIRM_PASSWORD.setBackground(Color.DARK_GRAY);
		CONFIRM_PASSWORD.setBounds(352, 173, 288, 33);
		contentPane.add(CONFIRM_PASSWORD);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_7.setBounds(133, 217, 380, 23);
		contentPane.add(lblNewLabel_7);

//		if(JFrame.DISPOSE_ON_CLOSE==getDefaultCloseOperation()) {
//			try {
//				Connection con=Connectionclass.getConnection();
//	    		String sql = "DELETE FROM STUDENT WHERE ROLL_NUMBER=?";
//	            PreparedStatement st = con.prepareStatement(sql);
//	            st.setString(1, ROLL_NUMBER.getText());
//                int i = st.executeUpdate();
//                if(i>0) {
//                	JOptionPane.showMessageDialog(null, "YOUR DATA HAS BEEN LOST,PLEASE RE-CREATE YOUR ACCOUNT");	
//                	setVisible(false);
//                	new Signup().setVisible(true);
//                	
//                }else {
//                		JOptionPane.showMessageDialog(null, "somewent wrong! TRY AGAIN.....");	
//                	}
//			}catch(Exception e1) {
//				e1.printStackTrace();
//			} 
//		}
		
	}
}

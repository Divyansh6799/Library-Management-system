package lms;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public  class Signup extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ROLL_NUMBER;
	private JTextField FIRST_NAME;
	private JTextField LAST_NAME;
	private JComboBox<?> comboBox;	
	private JComboBox<?> comboBox_1;	
	private JComboBox<?> comboBox_2;	
	private JComboBox<?> comboBox_3;	
	private JTextField CONTACT;
	private JTextField MAIL_ID;
	private JTextField USERNAME;
	private JPasswordField PASSWORD;
	private JComboBox<?> comboBox_4;
	private JTextField SECUIRTY_ANS;
	private JLabel lblNewLabel_7;
	private JRadioButton femaleRadioButton_1;
	private JRadioButton otherRadioButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Signup() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(480, 50, 738, 620);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(128, 0, 0));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		contentPane.setBounds(67, 54, 793, 368);
		setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SIGN UP");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Imprint MT Shadow", Font.BOLD | Font.ITALIC, 37));
		lblNewLabel.setBounds(249, 11, 201, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("SELECT YOUR GENDER :");
		lblNewLabel_4.setForeground(Color.CYAN);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_4.setBounds(30, 215, 256, 22);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("CREATE ACCOUNT");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try{
					String gender="MALE";
					if(femaleRadioButton_1.isSelected()) {
						gender="FEMALE";
					}if(otherRadioButton_2.isSelected()){
						gender="OTHER";
					}
					Connection con=Connectionclass.getConnection();
    	           	CallableStatement st = con.prepareCall("{call signup(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
    	            st.setString(1, ROLL_NUMBER.getText());
                    st.setString(2, FIRST_NAME.getText());
                    st.setString(3, LAST_NAME.getText());
                    st.setString(4, gender);
                    st.setString(5, (String) comboBox.getSelectedItem());
                    st.setString(6, (String) comboBox_1.getSelectedItem());
                    st.setString(7, (String) comboBox_2.getSelectedItem());
                    st.setString(8, (String) comboBox_3.getSelectedItem());
                    st.setString(9,  CONTACT.getText());
                    st.setString(10, MAIL_ID.getText());
    	            st.setString(11, USERNAME.getText());
					st.setString(12, PASSWORD.getText());
					st.setString(13 ,(String) comboBox_4.getSelectedItem());
					st.setString(14, SECUIRTY_ANS.getText());
					int i = st.executeUpdate();
                    if(i>0) {

                    		System.out.print("execute signup procedure");
	                    	setVisible(false);
	                    	JOptionPane.showMessageDialog(null, "your account is created","MESSAGE", JOptionPane.INFORMATION_MESSAGE);
	                        setVisible(false);
//	        				new Login().setVisible(true);
                    }
				}
                    	catch(Exception ex){
                    		setVisible(false);
                    		JOptionPane.showMessageDialog(null, "SOMETHING WENT WRONG ..Try Again!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    		ex.printStackTrace();
        				}
                    	
                    }
        });
		btnNewButton.setBounds(249, 506, 277, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setIcon(new ImageIcon(Signup.class.getResource("/images/icons8-close-35.png")));
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		btnNewButton_1.setForeground(new Color(220, 20, 60));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				setVisible(false);			
			}
		});
		btnNewButton_1.setBounds(676, 0, 62, 36);
		contentPane.add(btnNewButton_1);
		
		ROLL_NUMBER = new JTextField();
		ROLL_NUMBER.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(ROLL_NUMBER.getText().equals("ENTER YOUR ROLL NUMBER")) {
					ROLL_NUMBER.setText("");
					ROLL_NUMBER.setForeground(Color.ORANGE);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(ROLL_NUMBER.getText().equals("")) {
					ROLL_NUMBER.setText("ENTER YOUR ROLL NUMBER");
					ROLL_NUMBER.setForeground(Color.ORANGE);
				}
			}
		});
		ROLL_NUMBER.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		ROLL_NUMBER.setText("ENTER YOUR ROLL NUMBER");
		ROLL_NUMBER.setForeground(Color.ORANGE);
		ROLL_NUMBER.setBackground(Color.BLACK);
		ROLL_NUMBER.setBounds(30, 77, 318, 36);
		contentPane.add(ROLL_NUMBER);
		ROLL_NUMBER.setColumns(10);
		
		FIRST_NAME = new JTextField();
		FIRST_NAME.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(FIRST_NAME.getText().equals("ENTER YOUR FIRST NAME")) {
					FIRST_NAME.setText("");
					FIRST_NAME.setForeground(Color.ORANGE);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(FIRST_NAME.getText().equals("")) {
					FIRST_NAME.setText("ENTER YOUR FIRST NAME");
					FIRST_NAME.setForeground(Color.ORANGE);
				}
			}
		});
		FIRST_NAME.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		FIRST_NAME.setText("ENTER YOUR FIRST NAME");
		FIRST_NAME.setForeground(Color.ORANGE);
		FIRST_NAME.setBackground(Color.BLACK);
		FIRST_NAME.setBounds(30, 124, 318, 36);
		contentPane.add(FIRST_NAME);
		FIRST_NAME.setColumns(10);
		
		LAST_NAME = new JTextField();
		LAST_NAME.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(LAST_NAME.getText().equals("ENTER YOUR LAST NAME")) {
					LAST_NAME.setText("");
					LAST_NAME.setForeground(Color.ORANGE);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(LAST_NAME.getText().equals("")) {
					LAST_NAME.setText("ENTER YOUR LAST NAME");
					LAST_NAME.setForeground(Color.ORANGE);
				}
			}
		});
		LAST_NAME.setText("ENTER YOUR LAST NAME");
		LAST_NAME.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		LAST_NAME.setForeground(Color.ORANGE);
		LAST_NAME.setBackground(Color.BLACK);
		LAST_NAME.setBounds(30, 171, 318, 33);
		contentPane.add(LAST_NAME);
		LAST_NAME.setColumns(10);
		
		CONTACT = new JTextField();
		CONTACT.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(CONTACT.getText().equals("ENTER YOUR MOBILE NUMBER")) {
					CONTACT.setText("");
					CONTACT.setForeground(Color.ORANGE);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(CONTACT.getText().equals("")) {
					CONTACT.setText("ENTER YOUR MOBILE NUMBER");
					CONTACT.setForeground(Color.ORANGE);
				}
			}
		});
		CONTACT.setForeground(Color.ORANGE);
		CONTACT.setText("ENTER YOUR MOBILE NUMBER");
		CONTACT.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		CONTACT.setBackground(Color.BLACK);
		CONTACT.setBounds(30, 284, 318, 42);
		contentPane.add(CONTACT);
		CONTACT.setColumns(10);
		
		MAIL_ID = new JTextField();
		MAIL_ID.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(MAIL_ID.getText().equals("ENTER YOUR MAIL-ID")) {
					MAIL_ID.setText("");
					MAIL_ID.setForeground(Color.ORANGE);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(MAIL_ID.getText().equals("")) {
					MAIL_ID.setText("ENTER YOUR MAIL-ID");
					MAIL_ID.setForeground(Color.ORANGE);
				}
			}
		});
		MAIL_ID.setText("ENTER YOUR MAIL-ID");
		MAIL_ID.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		MAIL_ID.setForeground(Color.ORANGE);
		MAIL_ID.setBackground(Color.BLACK);
		MAIL_ID.setBounds(432, 284, 292, 42);
		contentPane.add(MAIL_ID);
		MAIL_ID.setColumns(10);
		
		JRadioButton maleRadioButton = new JRadioButton("MALE");
		maleRadioButton.setForeground(Color.RED);
		maleRadioButton.setBackground(Color.BLACK);
		maleRadioButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		maleRadioButton.setSelected(true);
		maleRadioButton.setBounds(30, 244, 102, 36);
		contentPane.add(maleRadioButton);
		
		femaleRadioButton_1 = new JRadioButton("FEMALE");
		femaleRadioButton_1.setForeground(Color.RED);
		femaleRadioButton_1.setBackground(Color.BLACK);
		femaleRadioButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		femaleRadioButton_1.setBounds(134, 244, 108, 36);
		contentPane.add(femaleRadioButton_1);
		
		otherRadioButton_2 = new JRadioButton("OTHER");
		otherRadioButton_2.setForeground(Color.RED);
		otherRadioButton_2.setBackground(Color.BLACK);
		otherRadioButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		otherRadioButton_2.setBounds(246, 247, 102, 31);
		contentPane.add(otherRadioButton_2);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(maleRadioButton);
		bg.add(femaleRadioButton_1);
		bg.add(otherRadioButton_2);
		
		comboBox = new JComboBox<>();
		comboBox.setName("");
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox.setAutoscrolls(true);
		comboBox.setForeground(Color.RED);
		comboBox.setBackground(Color.BLACK);
		comboBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		/*comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if("DIPLOMA".equals(comboBox.getSelectedItem())) {
					comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"EC", "ME", "CE", "EE"}));
				}else if("BCA".equals(comboBox.getSelectedItem())) {
					comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", }));
				}
			}
		});*/
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"SELECT YOUR COURSE", "B.TECH", "DIPLOMA", "BBA", "BCA", "MBA", "MCA", "M.TECH"}));
		comboBox.setBounds(432, 76, 292, 36);
		contentPane.add(comboBox);
	
		
		comboBox_1 = new JComboBox<>();
		comboBox_1.setAutoscrolls(true);
		comboBox_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox_1.setForeground(Color.RED);
		comboBox_1.setBackground(Color.BLACK);
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"SELECT YOUR BRANCH", "CSE", "IT", "EC", "ME", "CE", "EE"}));
		comboBox_1.setBounds(432, 130, 292, 30);
		contentPane.add(comboBox_1);
		
		comboBox_2 = new JComboBox<>();
		comboBox_2.setAutoscrolls(true);
		comboBox_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox_2.setForeground(Color.RED);
		comboBox_2.setBackground(Color.BLACK);
		comboBox_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"SELECT YOUR YEAR", "1", "2", "3", "4"}));
		comboBox_2.setBounds(432, 176, 292, 36);
		contentPane.add(comboBox_2);
		
		comboBox_3 = new JComboBox<>();
		comboBox_3.setAutoscrolls(true);
		comboBox_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox_3.setForeground(Color.RED);
		comboBox_3.setBackground(Color.BLACK);
		comboBox_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"SELECT YOUR SEMESTER", "1 ", "2  ", "3  ", "4  ", "5  ", "6  ", "7  ", "8  "}));
		comboBox_3.setBounds(432, 226, 292, 42);
		contentPane.add(comboBox_3);
		
		
		
		JLabel lblNewLabel_11 = new JLabel("ALREADY HAVE AN ACCOUNT !");
		lblNewLabel_11.setForeground(Color.CYAN);
		lblNewLabel_11.setFont(new Font("Stencil", Font.ITALIC, 17));
		lblNewLabel_11.setBounds(165, 578, 271, 35);
		contentPane.add(lblNewLabel_11);
		
		JButton btnNewButton_2 = new JButton("SIGN IN");
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_2.setBounds(432, 573, 152, 36);
		contentPane.add(btnNewButton_2);
		
		USERNAME = new JTextField();
		USERNAME.setBackground(Color.BLACK);
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
		USERNAME.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		USERNAME.setForeground(Color.ORANGE);
		USERNAME.setText("ENTER YOUR USERNAME");
		USERNAME.setBounds(30, 337, 318, 42);
		contentPane.add(USERNAME);
		USERNAME.setColumns(10);
		
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
		PASSWORD.setBackground(Color.BLACK);
		PASSWORD.setEchoChar((char)0);
		PASSWORD.addFocusListener(new FocusAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusGained(FocusEvent e) {
				if(PASSWORD.getText().equals("ENTER YOUR PASSWORD")) {
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
					PASSWORD.setText("ENTER YOUR PASSWORD");
					PASSWORD.setForeground(Color.ORANGE);
				}
			}
		});
		PASSWORD.setText("ENTER YOUR PASSWORD");
		PASSWORD.setForeground(Color.ORANGE);
		PASSWORD.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		PASSWORD.setBounds(30, 392, 318, 42);
		contentPane.add(PASSWORD);
		
		final JCheckBox chckbxNewCheckBox = new JCheckBox("SHOW PASSWORD");
		chckbxNewCheckBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		chckbxNewCheckBox.setForeground(Color.RED);
		chckbxNewCheckBox.setBackground(Color.LIGHT_GRAY);
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					PASSWORD.setEchoChar((char)0);
				}
				else {
					PASSWORD.setEchoChar('*');
				}
			}
		});
		chckbxNewCheckBox.setBounds(29, 441, 193, 23);
		contentPane.add(chckbxNewCheckBox);
		

		comboBox_4 = new JComboBox();
		comboBox_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox_4.setBackground(Color.BLACK);
		comboBox_4.setForeground(Color.RED);
		comboBox_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"SELECT YOUR SECUIRTY QUESTION", "Your NickName?", "Your Lucky Number?", "Your child SuperHero?", "Your Favourite game?"}));
		comboBox_4.setBounds(432, 337, 292, 42);
		contentPane.add(comboBox_4);
		
		SECUIRTY_ANS = new JTextField();
		SECUIRTY_ANS.setBackground(Color.BLACK);
		SECUIRTY_ANS.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(SECUIRTY_ANS.getText().equals("ENTER YOUR SECUIRTY ANSWER")) {
					SECUIRTY_ANS.setText("");
					SECUIRTY_ANS.setForeground(Color.ORANGE);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(SECUIRTY_ANS.getText().equals("")) {
					SECUIRTY_ANS.setText("ENTER YOUR SECUIRTY ANSWER");
					SECUIRTY_ANS.setForeground(Color.ORANGE);
				}
			}
		});
		SECUIRTY_ANS.setText("ENTER YOUR SECUIRTY ANSWER");
		SECUIRTY_ANS.setForeground(Color.ORANGE);
		SECUIRTY_ANS.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		SECUIRTY_ANS.setBounds(436, 392, 288, 42);
		contentPane.add(SECUIRTY_ANS);
		SECUIRTY_ANS.setColumns(10);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setForeground(Color.CYAN);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_7.setBounds(30, 472, 303, 23);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setIcon(new ImageIcon(Signup.class.getResource("/images/ADMIN SECTION.jpg")));
		lblNewLabel_12.setBounds(0, 0, 738, 620);
		contentPane.add(lblNewLabel_12);
		
		

		}		

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}	
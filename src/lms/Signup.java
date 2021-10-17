package lms;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;

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
	public Signup() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 484);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(128, 0, 0));
		contentPane.setBackground(new Color(204, 102, 204));
		contentPane.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 128), 3, true), "PERSONAL  INFORMATION", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 128, 0)));
		contentPane.setBounds(67, 54, 793, 368);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CREATE YOUR ACCOUNT");
		lblNewLabel.setForeground(new Color(0, 51, 255));
		lblNewLabel.setFont(new Font("Juice ITC", Font.BOLD | Font.ITALIC, 37));
		lblNewLabel.setBounds(237, 21, 340, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ROLL_NUMBER :");
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1.setBounds(49, 62, 152, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("FIRST NAME :");
		lblNewLabel_2.setForeground(Color.CYAN);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_2.setBounds(49, 124, 156, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("LAST NAME :");
		lblNewLabel_3.setForeground(Color.CYAN);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_3.setBounds(49, 188, 139, 18);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(" GENDER :");
		lblNewLabel_4.setForeground(Color.CYAN);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_4.setBounds(49, 246, 110, 22);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(" COURSE :");
		lblNewLabel_5.setForeground(Color.CYAN);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_5.setBounds(432, 58, 99, 26);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(" BRANCH :");
		lblNewLabel_6.setForeground(Color.CYAN);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_6.setBounds(432, 124, 89, 30);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("NEXT PAGE");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try{
					String gender="MALE";
					if(femaleRadioButton_1.isSelected()) {
						gender="FEMALE";
					}if(otherRadioButton_2.isSelected()){
						gender="OTHER";
					}
					Connection con=Connectionclass.getConnection();
		    		String sql = "INSERT INTO STUDENT(ROLL_NUMBER,FIRST_NAME,LAST_NAME,GENDER, COURSE, BRANCH, YEAR,SEMESTER, CONTACT,MAIL_ID) VALUES(?,?,?,?, ?, ?, ?, ?, ?,?)";
    	            PreparedStatement st = con.prepareStatement(sql);
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
					
					
                    int i = st.executeUpdate();
                    if(i>0) {
                    	setVisible(false);
                    	JOptionPane.showMessageDialog(null, "PLEASE ENTER MORE DETAILS FOR SECUIRTY PURPOSE");	
                    	setVisible(false);
                    	st.setString(1, ROLL_NUMBER.getText());
    					String s = ROLL_NUMBER.getText();
                   	 	Secuirty s1= new Secuirty();
                   	 	s1.ROLL_NUMBER.setText(s);
                   	 	s1.setVisible(true);
                    }else {
                    		JOptionPane.showMessageDialog(null, "somewent wrong");	
                    	}
				}catch(NullPointerException ex)
				{
					
				ex.printStackTrace();
					
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "FIRST COMPLETE THIS PAGE!");				}
				
			}

			
		});
		btnNewButton.setBounds(266, 377, 201, 42);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<<<<");
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		btnNewButton_1.setForeground(new Color(220, 20, 60));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				Login frame = new Login ();
				frame.setVisible(true);
				Login.lblNewLabel_7.setText("USER LOGIN");
				Login.lblNewLabel_3.setVisible(false); 
			}
		});
		btnNewButton_1.setBounds(0, 11, 105, 23);
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
		ROLL_NUMBER.setBounds(49, 83, 256, 36);
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
		FIRST_NAME.setBounds(49, 145, 256, 36);
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
		LAST_NAME.setBounds(49, 205, 256, 33);
		contentPane.add(LAST_NAME);
		LAST_NAME.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("YEAR :");
		lblNewLabel_7.setForeground(Color.CYAN);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_7.setBounds(432, 184, 79, 26);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("SEMESTER :");
		lblNewLabel_8.setForeground(Color.CYAN);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_8.setBounds(432, 243, 110, 24);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("CONTACT :");
		lblNewLabel_9.setForeground(Color.CYAN);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_9.setBounds(49, 313, 110, 26);
		contentPane.add(lblNewLabel_9);
		
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
		CONTACT.setBounds(97, 341, 247, 25);
		contentPane.add(CONTACT);
		CONTACT.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("MAIL-ID :");
		lblNewLabel_10.setForeground(Color.CYAN);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_10.setBounds(443, 313, 109, 22);
		contentPane.add(lblNewLabel_10);
		
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
		MAIL_ID.setBounds(442, 341, 292, 25);
		contentPane.add(MAIL_ID);
		MAIL_ID.setColumns(10);
		
		JRadioButton maleRadioButton = new JRadioButton("MALE");
		maleRadioButton.setForeground(Color.RED);
		maleRadioButton.setBackground(Color.BLACK);
		maleRadioButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		maleRadioButton.setSelected(true);
		maleRadioButton.setBounds(49, 273, 110, 23);
		contentPane.add(maleRadioButton);
		
		femaleRadioButton_1 = new JRadioButton("FEMALE");
		femaleRadioButton_1.setForeground(Color.RED);
		femaleRadioButton_1.setBackground(Color.BLACK);
		femaleRadioButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		femaleRadioButton_1.setBounds(165, 273, 110, 23);
		contentPane.add(femaleRadioButton_1);
		
		otherRadioButton_2 = new JRadioButton("OTHER");
		otherRadioButton_2.setForeground(Color.RED);
		otherRadioButton_2.setBackground(Color.BLACK);
		otherRadioButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		otherRadioButton_2.setBounds(288, 273, 110, 23);
		contentPane.add(otherRadioButton_2);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(maleRadioButton);
		bg.add(femaleRadioButton_1);
		bg.add(otherRadioButton_2);
		
		comboBox = new JComboBox<>();
		comboBox.setForeground(Color.RED);
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setFont(new Font("Tahoma", Font.ITALIC, 15));
		/*comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if("DIPLOMA".equals(comboBox.getSelectedItem())) {
					comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"EC", "ME", "CE", "EE"}));
				}else if("BCA".equals(comboBox.getSelectedItem())) {
					comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", }));
				}
			}
		});*/
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"B.TECH", "DIPLOMA", "BBA", "BCA", "MBA", "MCA", "M.TECH"}));
		comboBox.setBounds(432, 84, 219, 27);
		contentPane.add(comboBox);
	
		
		comboBox_1 = new JComboBox<>();
		comboBox_1.setForeground(Color.RED);
		comboBox_1.setBackground(Color.LIGHT_GRAY);
		comboBox_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"CSE", "IT", "EC", "ME", "CE", "EE"}));
		comboBox_1.setBounds(432, 153, 219, 22);
		contentPane.add(comboBox_1);
		
		comboBox_2 = new JComboBox<>();
		comboBox_2.setForeground(Color.RED);
		comboBox_2.setBackground(Color.LIGHT_GRAY);
		comboBox_2.setFont(new Font("Tahoma", Font.ITALIC, 15));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboBox_2.setBounds(432, 218, 219, 22);
		contentPane.add(comboBox_2);
		
		comboBox_3 = new JComboBox<>();
		comboBox_3.setForeground(Color.RED);
		comboBox_3.setBackground(Color.LIGHT_GRAY);
		comboBox_3.setFont(new Font("Tahoma", Font.ITALIC, 15));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"1 ", "2  ", "3  ", "4  ", "5  ", "6  ", "7  ", "8  "}));
		comboBox_3.setBounds(432, 275, 219, 22);
		contentPane.add(comboBox_3);
		
		JLabel lblNewLabel_11 = new JLabel("+91");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_11.setBounds(59, 341, 46, 26);
		contentPane.add(lblNewLabel_11);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

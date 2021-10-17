package lms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Forgetpassword extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ROLL_NUMBER;
	private JTextField SECUIRTY_ANS;
	private JTextField PASSWORD;
	private JTextField USERNAME;	
	private JTextField SECUIRTY_QUES;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forgetpassword frame = new Forgetpassword();
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
	public Forgetpassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 408);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GET   YOUR   PASSWORD");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(145, 28, 293, 30);
		contentPane.add(lblNewLabel);
		
		ROLL_NUMBER = new JTextField();
		ROLL_NUMBER.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(ROLL_NUMBER.getText().equals("ENTER YOUR ROLL NUMBER")) {
					ROLL_NUMBER.setText("");
					ROLL_NUMBER.setForeground(Color.RED);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(ROLL_NUMBER.getText().equals("")) {
					ROLL_NUMBER.setText("ENTER YOUR ROLL NUMBER");
					ROLL_NUMBER.setForeground(Color.RED);
				}
			}
		});
		ROLL_NUMBER.setText("ENTER YOUR ROLL NUMBER");
		ROLL_NUMBER.setForeground(Color.RED);
		ROLL_NUMBER.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		ROLL_NUMBER.setBackground(Color.LIGHT_GRAY);
		ROLL_NUMBER.setBounds(25, 70, 382, 30);
		contentPane.add(ROLL_NUMBER);
		ROLL_NUMBER.setColumns(10);
		
		SECUIRTY_ANS = new JTextField();
		SECUIRTY_ANS.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(SECUIRTY_ANS.getText().equals("SUBMIT YOUR SECURITY ANSWER")) {
					SECUIRTY_ANS.setText("");
					SECUIRTY_ANS.setForeground(Color.RED);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(SECUIRTY_ANS.getText().equals("")) {
					SECUIRTY_ANS.setText("SUBMIT YOUR SECURITY ANSWER");
					SECUIRTY_ANS.setForeground(Color.RED);
				}
			}
		});
		SECUIRTY_ANS.setForeground(Color.RED);
		SECUIRTY_ANS.setText("SUBMIT YOUR SECURITY ANSWER");
		SECUIRTY_ANS.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		SECUIRTY_ANS.setBackground(Color.LIGHT_GRAY);
		SECUIRTY_ANS.setBounds(25, 250, 382, 35);
		contentPane.add(SECUIRTY_ANS);
		SECUIRTY_ANS.setColumns(10);
		
		PASSWORD = new JTextField();
		PASSWORD.setText("HERE IS  YOUR PASSWORD");
		PASSWORD.setForeground(Color.RED);
		PASSWORD.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		PASSWORD.setBackground(Color.LIGHT_GRAY);
		PASSWORD.setEditable(false);
		PASSWORD.setBounds(25, 307, 265, 28);
		contentPane.add(PASSWORD);
		PASSWORD.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Connection con=Connectionclass.getConnection();
		    		String sql = "SELECT PASSWORD FROM LOGIN WHERE ROLL_NUMBER=? AND USERNAME=? AND SECUIRTY_QUES=? AND SECUIRTY_ANS=?";
    	            PreparedStatement st = con.prepareStatement(sql);
    	            st.setString(1, ROLL_NUMBER.getText());
    	            st.setString(2, USERNAME.getText());
					st.setString(3, SECUIRTY_QUES.getText());
					st.setString(4, SECUIRTY_ANS.getText());
					ResultSet rs = st.executeQuery();
                    if(rs.next()) {
                    	String s=rs.getString(1);
                    	PASSWORD.setText(s);
                    }
                    	else {
                    		JOptionPane.showMessageDialog(null, "ENTERIES ARE NOT MATCHED WITH DATABASE !"
                    				+ "PLEASE ENTER CORRECT DETAILS");	
                    	}
                    
 	            	
    	            
				}
                    
                
				 catch(NullPointerException ex)
				{
					
				ex.printStackTrace();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(433, 249, 132, 30);
		contentPane.add(btnNewButton);
		
		USERNAME = new JTextField();
		USERNAME.setEditable(false);
		USERNAME.setForeground(Color.RED);
		USERNAME.setText("HERE IS YOUR USERNAME");
		USERNAME.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		USERNAME.setBackground(Color.LIGHT_GRAY);
		USERNAME.setBounds(25, 131, 382, 31);
		contentPane.add(USERNAME);
		USERNAME.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("SEARCH");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Connection con=Connectionclass.getConnection();
		    		String sql = "SELECT USERNAME,SECUIRTY_QUES FROM LOGIN WHERE ROLL_NUMBER=?";
		    		
    	            PreparedStatement st = con.prepareStatement(sql);
    	            st.setString(1, ROLL_NUMBER.getText());
    	       
    	            ResultSet rs  = st.executeQuery();
                    if(rs.next()) {
                    	String s=rs.getString(1);
                    	String s1=rs.getString(2);
                    	
                        USERNAME.setText(s);
                    	SECUIRTY_QUES.setText(s1);
                    	
                    
                    }
                    	else {
                    		JOptionPane.showMessageDialog(null, "ENTERIES ARE NOT MATCHED WITH DATABASE !"
                    				+ "PLEASE ENTER CORRECT DETAILS");	
                    	}
                    
 	            	
    	            
				}
                    
                
				 catch(NullPointerException ex)
				{
					
				ex.printStackTrace();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1.setBounds(433, 70, 132, 28);
		contentPane.add(btnNewButton_1);
		
		SECUIRTY_QUES = new JTextField();
		SECUIRTY_QUES.setText("HERE IS YOUR SECURITY QUESTION");
		SECUIRTY_QUES.setForeground(Color.RED);
		SECUIRTY_QUES.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		SECUIRTY_QUES.setBackground(Color.LIGHT_GRAY);
		SECUIRTY_QUES.setEditable(false);
		SECUIRTY_QUES.setBounds(25, 191, 382, 30);
		contentPane.add(SECUIRTY_QUES);
		SECUIRTY_QUES.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Login().setVisible(true);
				Login.lblNewLabel_7.setText("USER LOGIN");
				Login.lblNewLabel_3.setVisible(false); 
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setBounds(0, 11, 89, 23);
		contentPane.add(btnNewButton_2);
		
		final JLabel lblNewLabel_1 = new JLabel(" if you want to auto fill the username and password in login page?");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String z=USERNAME.getText();
				String a=PASSWORD.getText();
				setVisible(false);
				new Login().setVisible(true);
				Login.USERNAME.setText(z);
				Login.PASSWORD.setText(a);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setForeground(Color.CYAN);
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setForeground(Color.BLACK);
			}
		});
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_1.setBounds(10, 341, 581, 28);
		contentPane.add(lblNewLabel_1);
	}
}

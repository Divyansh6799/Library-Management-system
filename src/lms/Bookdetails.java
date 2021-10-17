package lms;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.*;

public class Bookdetails extends JFrame implements ActionListener{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTable table;
    private JTextField search;
    static  JTextField USERNAME;
    
    public static void main(String[] args) {
	new Bookdetails().setVisible(true);
    }
    
    public void books() {
				try {
					Connection con=Connectionclass.getConnection();
		            String sql = "select * from BOOKS";
		            PreparedStatement st = con.prepareStatement(sql);
		            ResultSet rs = st.executeQuery();
		            table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
		            st.close();
		            con.close();
			}catch (Exception e) {
				}
//				try {
//					Connection con=Connectionclass.getConnection();
//		            String sql1 = "select * from student";
//		            PreparedStatement st1 = con.prepareStatement(sql1);
//		            ResultSet rs1 = st1.executeQuery();
//		            table.setModel(DbUtils.resultSetToTableModel(rs1));
//					rs1.close();
//		            st1.close();
//		            con.close();
//			}catch (Exception e) {
//				}
			}
    
    public Bookdetails() {
        setBounds(100, 60, 890, 475);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
	
	final JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(79, 133, 771, 282);
	contentPane.add(scrollPane);

	table = new JTable();
	table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 0).toString());
            }
	});
	table.setBackground(new Color(0, 255, 255));
	table.setForeground(new Color(255, 0, 0));
	table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
	scrollPane.setViewportView(table);
	
	
	


	JLabel l1 = new JLabel("BOOKS DETAILS");
	l1.setForeground(new Color(107, 142, 35));
	l1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
	l1.setBounds(171, 11, 319, 47);
	contentPane.add(l1);

        
	search = new JTextField();
	search.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent ae) {
			if(ae.getKeyCode()==KeyEvent.VK_ENTER) {
				 try{
	    	            
	    	        	Connection con=Connectionclass.getConnection();
	    	            String sql = "select * from BOOKS where concat(BOOK_NAME,BOOK_ID) like ?";
	    	            PreparedStatement st = con.prepareStatement(sql);
	    	            st.setString(1, "%" + search.getText() + "%");
	    	            ResultSet rs = st.executeQuery();
	    	            table.setModel(DbUtils.resultSetToTableModel(rs));
	    	            rs.close();
	    	            st.close();
	    	            con.close();
	    	        }catch(Exception e1){
	    	        	e1.printStackTrace();
	    	         }
			}
		}
	});
	search.setText("ENTER BOOK ID OR BOOK NAME");
	search.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
			if(search.getText().equals("ENTER BOOK ID OR BOOK NAME")) {
				search.setText("");
				search.setForeground(new Color(0, 0, 0));
			}
		}
	});
	search.setBackground(Color.DARK_GRAY);
	search.setBorder(new LineBorder(new Color(255, 105, 180), 2, true));
	search.setForeground(Color.ORANGE);
	search.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
	search.setBounds(189, 89, 390, 33);
	contentPane.add(search);
	search.setColumns(10);

	JLabel l3 = new JLabel("Back");
	l3.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\back.png"));
	l3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				if(User_Menu.getFrames().equals(this)) {
					User_Menu home = new User_Menu();
				home.setVisible(true);
				}else {
					User_Menu m=new User_Menu();
					m.setVisible(false);
				}
			}
		});
	l3.setForeground(Color.GRAY);
	l3.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
	//ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/tenth.png"));
        //Image i8 = i7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
       // ImageIcon i9 = new ImageIcon(i8);
       // l3.setIcon(i9);
	l3.setBounds(97, 89, 72, 33);
	contentPane.add(l3);

	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 128), 3, true), "BOOKS-DETAILS",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
	panel.setBounds(67, 54, 793, 368);
	contentPane.add(panel);
    panel.setBackground(new Color(102, 0, 153));
    panel.setLayout(null);
    
    JButton btnNewButton = new JButton("SEARCH");
    btnNewButton.setBackground(new Color(255, 105, 180));
    btnNewButton.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 16));
    btnNewButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		 try{
    	            
    	        	Connection con=Connectionclass.getConnection();
    	            String sql = "select * from BOOKS where concat(BOOK_NAME,BOOK_ID) like ?";
    	            PreparedStatement st = con.prepareStatement(sql);
    	            st.setString(1, "%" + search.getText() + "%");
    	            ResultSet rs = st.executeQuery();

    	            table.setModel(DbUtils.resultSetToTableModel(rs));
    	            rs.close();
    	            st.close();

    	            
    	         con.close();
    	        }catch(Exception e1){
    	        	e1.printStackTrace();
    	         }
    		
    	}
    });
    btnNewButton.setBounds(527, 33, 128, 35);
    panel.add(btnNewButton);
    
    JButton btnNewButton_1 = new JButton("ISSUE");
    btnNewButton_1.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		if(search.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "FIRST SELECT BOOK ID ?");
			}else if(search.getText().equals("ENTER BOOK ID OR BOOK NAME")) {
				JOptionPane.showMessageDialog(null, "FIRST SELECT BOOK ID ?");
			}
    		else {
    			
    			
    			try {
    				Connection con=Connectionclass.getConnection();
    	            String sql = "select * FROM BOOKS WHERE BOOK_ID=? AND TOTAL_BOOKS>0";
    	            PreparedStatement st = con.prepareStatement(sql);
    	            st.setString(1,search.getText());
    	            ResultSet rs = st.executeQuery();
    	            if(rs.next()) {
    	            	setVisible(false);
    	        		Issuebook frame = new Issuebook();
    	    			frame.setVisible(true);
    	    			String j=search.getText();
    	    			Issuebook.comboBox_book.setSelectedItem(j);
    	    			Issuebook.issue();
    	    			
    	    			
    	           }else {
    	        	   new Issuebook().setVisible(false);
    	        	   JOptionPane.showMessageDialog(null, "SORRY ! THIS BOOK IS NOT AVAILABLE");
    	        	   setVisible(true);
    	        	   
    	           }
    			
    		}catch(SQLException e1) {
    			JOptionPane.showMessageDialog(null, "PLEASE SELECT BOOK ID FOR ISSUE BOOKS.");
    		}
    		
			
			try{
				Connection con=Connectionclass.getConnection();
	    		String sql = "select s.ROLL_NUMBER,s.FIRST_NAME,s.CONTACT FROM  STUDENT  s   JOIN login  l"
	            		+ " on s.ROLL_NUMBER=l.ROLL_NUMBER"
	            		+ " WHERE l.USERNAME=?";
	            PreparedStatement st = con.prepareStatement(sql);
	            st.setString(1, USERNAME.getText());
	        
	            ResultSet rs  = st.executeQuery();
              if(rs.next()) {
              	String s=rs.getString(1);
              	String s1=rs.getString(2);
              	String s2=rs.getString(3);
              	Issuebook.ROLL_NUMBER.setText(s);
              	Issuebook.FIRST_NAME.setText(s1);
              	Issuebook.CONTACT.setText(s2);
            }
		  }catch(NullPointerException ex)
			{
				
			ex.printStackTrace();
				
			} catch (SQLException e1) {
				// 
				e1.printStackTrace();
			}
			}
    	}
    });
    btnNewButton_1.setBackground(Color.MAGENTA);
    btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
    btnNewButton_1.setForeground(Color.BLACK);
    btnNewButton_1.setBounds(665, 33, 118, 35);
    panel.add(btnNewButton_1);
    
    USERNAME = new JTextField();
    USERNAME.setToolTipText("");
    USERNAME.setForeground(Color.RED);
    USERNAME.setBackground(Color.DARK_GRAY);
    USERNAME.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
    USERNAME.setBounds(572, 31, 128, 20);
    contentPane.add(USERNAME);
    USERNAME.setColumns(10);
	books();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

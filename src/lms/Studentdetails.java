package lms;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.*;

public class Studentdetails extends JFrame implements ActionListener{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTable table;
    private JTextField search;
 

    public static void main(String[] args) {
	new Studentdetails().setVisible(true);
    }
    
    public void student() {
	try {
			Connection con=Connectionclass.getConnection();
            String sql = "select * from STUDENT";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.close();
	} catch (Exception e) {
	
	}
    }

    public Studentdetails() {
        setBounds(100, 60, 890, 475);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
	
	JScrollPane scrollPane = new JScrollPane();
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
	
	
	


	JLabel l1 = new JLabel("STUDENT DETAILS");
	l1.setForeground(new Color(107, 142, 35));
	l1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
	l1.setBounds(171, 11, 357, 47);
	contentPane.add(l1);

        
	search = new JTextField();
	search.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent ae) {
			if(ae.getKeyCode()==KeyEvent.VK_ENTER) {
				 try{
	    	            
	    	        	Connection con=Connectionclass.getConnection();
	    	            String sql = "select * from STUDENT where concat(FIRST_NAME, ROLL_NUMBER) like ?";
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
	search.setText("enter your roll number");
	search.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
			if(search.getText().equals("enter your roll number")) {
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
	l3.setIcon(new ImageIcon("C:\\Users\\divya\\OneDrive\\Pictures\\back.png"));
	l3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				User_Menu home = new User_Menu();
				home.setVisible(true);
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
	panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 128), 3, true), "STUDENT-DETAILS",
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
    	            String sql = "select * from STUDENT where concat(FIRST_NAME, ROLL_NUMBER) like ?";
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
    btnNewButton.setBounds(527, 33, 144, 35);
    panel.add(btnNewButton);
    	
    		
    		JButton btnNewButton_7 = new JButton("UPDATE STUDENT DETAILS");
    		btnNewButton_7.setBorderPainted(false);
    		btnNewButton_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    		btnNewButton_7.setBounds(538, 29, 312, 29);
    		contentPane.add(btnNewButton_7);
    		btnNewButton_7.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				setVisible(false);
    				new Updatestudent().setVisible(true);
    				String z=search.getText();
    				Updatestudent.ROLL_NUMBER.setText(z);
    			}
    		});
    		btnNewButton_7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
    		btnNewButton_7.setForeground(Color.BLACK);
    		btnNewButton_7.setBackground(new Color(255, 255, 0)); 
	student();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

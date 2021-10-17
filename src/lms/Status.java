package lms;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.*;

public class Status extends JFrame implements ActionListener{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    public static  JTable table;
    private JTextField search;
    public static   JTextField USERNAME;
   
 

    public static void main(String[] args) {
	new Status().setVisible(true);
    }
    
    public static void student() {
	try {
			Connection con=Connectionclass.getConnection();
			 String sql = "select s.*FROM  ISSUEBOOKS  s   JOIN login  l"
	            		+ " on s.ROLL_NUMBER=l.ROLL_NUMBER"
	            		+ " WHERE l.USERNAME=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, USERNAME.getText());
            ResultSet rs = st.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.close();
            
	} catch (Exception e) {
	
	}
    }

    public Status() {
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
                search.setText(table.getModel().getValueAt(row, 2).toString());
            }
	});
	table.setBackground(new Color(0, 255, 255));
	table.setForeground(new Color(255, 0, 0));
	table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
	scrollPane.setViewportView(table);
	
	JLabel l1 = new JLabel("STATUS");
	l1.setForeground(new Color(107, 142, 35));
	l1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
	l1.setBounds(288, 11, 157, 47);
	contentPane.add(l1);

        
	search = new JTextField();
	search.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent ae) {
			if(ae.getKeyCode()==KeyEvent.VK_ENTER) {
				 try{
	    	            
	    	        	Connection con=Connectionclass.getConnection();
	    	            String sql = "select * from ISSUEBOOKS where concat(NAME, ROLL_NUMBER) like ?";
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
	panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 128), 3, true), "STATUS",
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
    	            String sql = "select * from ISSUEBOOKS where concat(NAME, ROLL_NUMBER) like ?";
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
    
    JButton btnNewButton_1 = new JButton("RETURN");
    btnNewButton_1.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		 int row = table.getSelectedRow();
             String L=table.getModel().getValueAt(row, 8).toString();
    		
    		if("enter your roll number".equals(search.getText())) {
    			JOptionPane.showMessageDialog(null, "FIRST SELECT BOOK ID");
 		}
    		else if("YES".equals(L)) {
    			JOptionPane.showMessageDialog(null, "YOU ALREADY RETURNED THIS BOOK!");
    		}
    		else {
    			String s=search.getText();
        		String u=USERNAME.getText();
        		setVisible(false);
        		new Returnbook().setVisible(true);
        		Returnbook.USERNAME.setText(u);
        		Returnbook.user();
        		Returnbook.comboBox_book.setSelectedItem(s);
    		}
    				
    	}
    });
    btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
    btnNewButton_1.setForeground(Color.BLACK);
    btnNewButton_1.setBackground(Color.MAGENTA);
    btnNewButton_1.setBounds(681, 33, 102, 35);
    panel.add(btnNewButton_1);
    
    USERNAME = new JTextField();
    USERNAME.setText("AYUSHI");
    USERNAME.setBounds(577, 26, 132, 26);
    contentPane.add(USERNAME);
    USERNAME.setEditable(false);
    USERNAME.setBackground(Color.DARK_GRAY);
    USERNAME.setForeground(Color.CYAN);
    USERNAME.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
    USERNAME.setColumns(10);
	student();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

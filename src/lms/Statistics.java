package lms;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.*;

public class Statistics extends JFrame implements ActionListener{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTable table;
    private JTextField search;
   

    public static void main(String[] args) {
	new Statistics().setVisible(true);
    }
    
    public void issueBook() {
	try {
			Connection con=Connectionclass.getConnection();
            String sql = "select * from ISSUEBOOKS";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            con.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
    }

    public Statistics() {
        setBounds(100, 60, 890, 475);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 192, 203));
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
	table.setBackground(new Color(154, 205, 50));
	table.setForeground(Color.DARK_GRAY);
	table.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
	scrollPane.setViewportView(table);


	JLabel l1 = new JLabel("STATISTICS");
	l1.setForeground(new Color(107, 142, 35));
	l1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 30));
	l1.setBounds(300, 15, 400, 47);
	contentPane.add(l1);

        
	search = new JTextField();
	search.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent ae) {
			if(ae.getKeyCode()==KeyEvent.VK_ENTER) {
				 try{
	        	        
	        	    	Connection con=Connectionclass.getConnection();
	        	    	String sql = "select * from issuebooks where concat(ROLL_NUMBER, book_id) like ?";
	        	 		PreparedStatement st = con.prepareStatement(sql);
	        	 		st.setString(1, "%" + search.getText() + "%");
	        	 		ResultSet rs = st.executeQuery();
	        	 		table.setModel(DbUtils.resultSetToTableModel(rs));
	        	        rs.close();
	        	        st.close();
	        	        con.close();
	        	    }catch(Exception e){
	        	        e.printStackTrace();
	        	    }
			}
		}
	});
	search.setText("ENTER ROLL NUMBER OR BOOK ID");
	search.addFocusListener(new FocusAdapter() {
		@Override
		public void focusGained(FocusEvent e) {
			if(search.getText().equals("ENTER ROLL NUMBER OR BOOK ID")) {
				search.setText("");
				search.setForeground(new Color(0, 0, 0));
			}
		}
	});
	
	search.setBackground(new Color(0, 255, 255));
	search.setBorder(new LineBorder(new Color(255, 105, 180), 2, true));
	search.setForeground(new Color(128, 0, 0));
	search.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 17));
	search.setBounds(79, 89, 400, 33);
	contentPane.add(search);
	search.setColumns(10);

	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 128, 128), 3, true), "STATISTICS",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
	panel.setBounds(67, 54, 793, 368);
	contentPane.add(panel);
        panel.setBackground(new Color(255, 222, 173));
        panel.setLayout(null);
        
        	JButton b1 = new JButton("Search");
        	b1.setBounds(432, 35, 157, 33);
        	panel.add(b1);
        	b1.setBackground(new Color(139, 0, 139));
        	b1.setIcon(new ImageIcon());
        	b1.addActionListener(this);
        	b1.setBorder(new LineBorder(new Color(255, 20, 147), 2, true));
        	//ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("C:\\Users\\dive\\Downloads\\eight.png"));
       // Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
       // ImageIcon i3 = new ImageIcon(i2);
       // b1.setIcon(i3);
        	b1.setForeground(new Color(0, 0, 0));
        	b1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 19));
        	
        	JButton btnNewButton = new JButton("BACK");
        	btnNewButton.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent e) {
        			setVisible(false);
        			User_Menu home = new User_Menu();
    				home.setVisible(true);
        		}
        	});
        	btnNewButton.setForeground(Color.RED);
        	btnNewButton.setBackground(new Color(0, 0, 0));
        	btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        	btnNewButton.setBounds(0, 0, 126, 33);
        	contentPane.add(btnNewButton);
        	
        	b1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae){
        	    try{
        	        
        	    	Connection con=Connectionclass.getConnection();
        	    	String sql = "select * from issuebooks where concat(ROLL_NUMBER, book_id) like ?";
        	 		PreparedStatement st = con.prepareStatement(sql);
        	 		st.setString(1, "%" + search.getText() + "%");
        	 		ResultSet rs = st.executeQuery();
        	 		table.setModel(DbUtils.resultSetToTableModel(rs));
        	        rs.close();
        	        st.close();
        	        con.close();
        	    }catch(Exception e){
        	        
        	    }
        	}
        	});
	issueBook();
   }
    @Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
    }
package lms;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class MDL extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static void main(String[] args) {
				try {
					MDL frame = new MDL();
					frame.setVisible(true);
					int i;
			        int x=1;
			        for(i=1;i<=590;i+=4,x+=1){
			        	frame.setLocation((550-((i+x)/2) ),250-(i/3));
			        	frame.setSize(i+3*x,i+x/5);
			        	Thread.sleep(1);
			        }  
			        Thread.sleep(3000);
					frame.setVisible(false);
					new Loading().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
	
	

	/**
	 * Create the frame.
	 */
	public MDL() {
		setBackground(Color.DARK_GRAY);
		setTitle("GLOBAL EVOLUTION LIBRARY");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 1111, 603);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("GLOBAL  EVOLUTION  LIBRARY");
		lblNewLabel_1.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(296, 181, 559, 47);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Smart Library Management Software........");
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel.setBounds(296, 222, 535, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\mdl.jpg"));
		lblNewLabel_3.setBounds(0, 0, 1108, 569);
		contentPane.add(lblNewLabel_3);
		
	}
}

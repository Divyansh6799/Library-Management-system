package lms;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class MDL extends JFrame implements Runnable  {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JProgressBar progressBar;
	JLabel lblNewLabel_2;
	JLabel lblNewLabel_3;
	static JButton get;
	int s;
	static Thread th;

	
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
			        
				} catch (Exception e) {
					e.printStackTrace();
				}
				
	}
	
	public void setUploading() {
        setVisible(false);
        th.start();
    }
	public void run() {
       try {
         for (int i = 0; i < 200; i++) {
            s = s + 1;
            int m = progressBar.getMaximum();
            int v = progressBar.getValue();
            if (v < m) {
                progressBar.setValue(progressBar.getValue()+1);
                if(v==20) {
                	lblNewLabel_3.setText("initializing component loading............");
                	//lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\divya\\OneDrive\\Pictures\\addbook.png"));
                	
                }
                else if(v==33) {
                	lblNewLabel_3.setText("setup software requirement ............");
                	//lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\divya\\OneDrive\\Pictures\\books.png"));
                	
                }
                else if(v==66) {
                	lblNewLabel_3.setText("connecting to database ............");
                	//lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\divya\\OneDrive\\Pictures\\returnbook.png"));
                }
                else if(v==90) {
                	lblNewLabel_3.setText("software ready to process ............");
                	//lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\divya\\OneDrive\\Pictures\\search.png"));
                }
            } else {
                i = 201;
                setVisible(false);
                new Login().setVisible(true);
                
                
            }
            Thread.sleep(50);
        }
    } catch (Exception e) {
       e.printStackTrace();
     }
   }


	/**
	 * Create the frame.
	 */
	public MDL() {
		 super("Loading");
         setForeground(Color.BLUE);
         setBackground(Color.DARK_GRAY);
         th = new Thread((Runnable) this);
         
				setBackground(Color.DARK_GRAY);
				setTitle("GLOBAL EVOLUTION LIBRARY");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(300, 200, 1100, 600);
				contentPane = new JPanel();
				contentPane.setBackground(Color.DARK_GRAY);
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setUndecorated(true);
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
			
				JLabel lblNewLabel_1 = new JLabel("GURUKUL---THE ONLINE LIBRARY ");
				lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 53));
				lblNewLabel_1.setForeground(Color.CYAN);
				lblNewLabel_1.setBounds(142, 11, 888, 73);
				contentPane.add(lblNewLabel_1);
				
				JLabel lblNewLabel = new JLabel("WELCOME \tIN  GURUKUL");
				lblNewLabel.setForeground(Color.ORANGE);
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 50));
				lblNewLabel.setBounds(248, 238, 644, 103);
				contentPane.add(lblNewLabel);
				
				lblNewLabel_2 = new JLabel("");
				lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\libraryWEL.png"));
				lblNewLabel_2.setBounds(401, 89, 264, 251);
				contentPane.add(lblNewLabel_2);	
				
				
				get = new JButton("GET STARTED");
				get.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				get.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					    get.setVisible(false);
					    lblNewLabel_3.setVisible(true);
					    progressBar.setVisible(true);
						th.start();
					}
				});
				get.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 40));
				get.setForeground(Color.BLACK);
				get.setBackground(UIManager.getColor("Button.background"));
				get.setBounds(373, 352, 379, 57);
				contentPane.add(get);
				
				 lblNewLabel_3 = new JLabel("starting........");
				 lblNewLabel_3.setVisible(false);
                 lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
                 lblNewLabel_3.setForeground(Color.GREEN);
                 lblNewLabel_3.setBounds(49, 528, 713, 36);
                 contentPane.add(lblNewLabel_3);
				
				 progressBar = new JProgressBar();
				 progressBar.setVisible(false);
		         progressBar.setBackground(new Color(0, 0, 0));
		         progressBar.setStringPainted(true);
		         progressBar.setIndeterminate(true);
		         progressBar.setForeground(Color.RED);
		         progressBar.setBounds(59, 539, 911, 31);
		         contentPane.add(progressBar);
		         progressBar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		         
		        
				JLabel lblNewLabel_3 = new JLabel("");
				lblNewLabel_3.setIcon(new ImageIcon(MDL.class.getResource("/images/mdl.jpg")));
				lblNewLabel_3.setBounds(0, 0, 1101, 623);
				contentPane.add(lblNewLabel_3);
		}
}

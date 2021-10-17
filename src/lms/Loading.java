package lms;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Loading extends JFrame implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JProgressBar progressBar;
	JLabel lblNewLabel_3;
	JLabel lblNewLabel;
	JLabel lblNewLabel_4;
	Connection conn;
	int s;
	Thread th;

	public static void main(String[] args) {
            new Loading().setVisible(true);
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
                        progressBar.setValue(progressBar.getValue() + 3);
                        if(v==12) {
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
                        new Welcomepage().setVisible(true);
                    }
                    Thread.sleep(170);
                }
            } catch (Exception e) {
		e.printStackTrace();
            }
	}

	public Loading() {
           
            super("Loading");
            setForeground(Color.BLUE);
            setBackground(Color.DARK_GRAY);
            th = new Thread((Runnable) this);

            			setBounds(200, 200, 961, 279);
            			contentPane = new JPanel();
            			contentPane.setBackground(Color.BLACK);
            			setContentPane(contentPane);
            			setUndecorated(true);
            			contentPane.setLayout(null);
            		

            			JPanel panel = new JPanel();
            			panel.setBackground(new Color(0, 0, 128));
            			panel.setBounds(0, 0, 962, 280);
            			contentPane.add(panel);
                        panel.setLayout(null);
                        
                        progressBar = new JProgressBar();
                        progressBar.setBackground(new Color(0, 0, 0));
                        progressBar.setStringPainted(true);
                        progressBar.setIndeterminate(true);
                        progressBar.setForeground(Color.RED);
                        progressBar.setBounds(436, 138, 516, 25);
                        panel.add(progressBar);
                        progressBar.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
                        
                        lblNewLabel_3 = new JLabel("starting........");
                        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
                        lblNewLabel_3.setForeground(Color.CYAN);
                        lblNewLabel_3.setBounds(436, 167, 516, 40);
                        panel.add(lblNewLabel_3);
                        
                       lblNewLabel_4 = new JLabel("");
                       lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\LOAD.jpg"));
                       lblNewLabel_4.setBounds(0, 0, 962, 280);
                       panel.add(lblNewLabel_4);
                       setUploading();
	}
}
package lms;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Messages extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField message;
	public static JLabel USERNAME;
	public static   JTextArea textarea;
	JButton btnNewButton;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
//			@SuppressWarnings("resource")
			public void run() {
				try {
					Messages frame = new Messages();
					frame.setVisible(true);
//					@SuppressWarnings("unused")
//					BufferedReader br=null;
//					FileReader fr=null;
//					fr=new FileReader("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\messages.txt");
//					br = new BufferedReader(fr);
//					int i;
//					String s="";
//					while((i=fr.read()) != -1) {
//					s+=(char)i;
//					textarea.setText(s);
//					
//					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}

	/**
	 * Create the frame.
	 */
	public Messages() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(360, 130, 468, 460);
		contentPane = new JPanel(); 
		contentPane.setBackground(new Color(0, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		message = new JTextField();
		message.setText("Type a Message...");
		message.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(message.getText().equals("Type a Message...")) {
					message.setText("");
					message.setForeground(Color.CYAN);
				}
			}
			@Override
		   public void focusLost(FocusEvent e) {
			if(message.getText().equals("")) {
				message.setText("Type a Message...");
				message.setForeground(Color.CYAN);
			}
		}
	});
		message.setForeground(Color.CYAN);
		message.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ae) {
				if(ae.getKeyCode()==KeyEvent.VK_ENTER) {
					try {
						if(message.getText().trim().isEmpty()) {
							JOptionPane.showMessageDialog(null, "ENTER MESSAGE!");
						}else {
						String s=message.getText();
						String a= textarea.getText();
						textarea.setText(a+"\n"+USERNAME.getText()+":"+s);
						message.setText("");
						}
					}catch(Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		message.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		message.setBackground(Color.BLACK);
		message.setBounds(0, 414, 343, 34);
		contentPane.add(message);
		message.setColumns(10);
		
		JButton btnNewButton = new JButton("SEND");
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(message.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "ENTER MESSAGE!");
					}else {
					String s=message.getText();
					String a= textarea.getText();
					
					textarea.setText(a+"\n"+USERNAME.getText()+":"+s);
					message.setText("");
					}
				}catch(Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "SOMETHING WENT WRONG !");
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBounds(369, 416, 89, 32);
		contentPane.add(btnNewButton);
		
		USERNAME = new JLabel("ADMIN");
		USERNAME.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\user-3297 (1).png"));
		USERNAME.setForeground(Color.RED);
		USERNAME.setHorizontalAlignment(SwingConstants.CENTER);
		USERNAME.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		USERNAME.setBounds(45, 22, 137, 34);
		contentPane.add(USERNAME);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 56, 343, 340);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 343, 340);
		panel.add(scrollPane);
		
		textarea = new JTextArea();
		textarea.setWrapStyleWord(true);
		textarea.setLineWrap(true);
		textarea.setFont(new Font("SimSun-ExtB", Font.BOLD | Font.ITALIC, 20));
		textarea.setBackground(Color.CYAN);
		textarea.setEditable(false);
		scrollPane.setViewportView(textarea);
		
		
		
		
		final JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\back.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			@SuppressWarnings("resource")
			public void actionPerformed(ActionEvent e) {
				try {
				String fileName="messages";
			    FileWriter outFile = null;
				outFile = new FileWriter(fileName+".txt",true);
				outFile.write(textarea.getText());
				outFile.close();
				String filePath="C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\messages.txt";
				String input=null;
				Scanner sc=new Scanner(new File(filePath));
				FileWriter writer=new FileWriter("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\message.txt");
				Set<String> set=new HashSet<String>();
				while(sc.hasNextLine()) {
					input=sc.nextLine();
					if(set.add(input)) {
						writer.append(input+"\n");
					}
				}
				writer.flush();
				setVisible(false);
				new User_Menu().setVisible(true);
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		btnNewButton_1.setBounds(0, 21, 45, 35);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\divya\\eclipse-workspace\\liberary management system\\library management system\\images\\message-4643.png"));
		lblNewLabel.setBounds(340, 0, 128, 128);
		contentPane.add(lblNewLabel);
		
	}
}

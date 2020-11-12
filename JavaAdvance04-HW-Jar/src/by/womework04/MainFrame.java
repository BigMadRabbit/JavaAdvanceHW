package by.womework04;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;


public class MainFrame extends JFrame {
	private JLabel label0 = new JLabel("File 1");
	private JTextArea textArea0 = new JTextArea();
	private JLabel label1 = new JLabel("File 2");
	private JTextArea textArea1 = new JTextArea();
	private JButton button0 = new JButton("Load file 0.txt in jar");
	private JButton button1 = new JButton("Load file 1.txt out jar");
	private String file0 = "0.txt"; 
	private String file1 = "1.txt";
	
	public MainFrame() {
		super("MainFrame");			
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    JLayeredPane lp = getLayeredPane(); 	    
	    Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	    
	    label0.setBounds(20, 3, 290, 15);	   
		//label0.setBorder(border);	
		label0.setText(file0);	    
		lp.add(label0);	
		
		textArea0.setBounds(20, 20, 290, 120);	   
		textArea0.setBorder(border);
	    lp.add(textArea0);	
	    
	    button0.setActionCommand("0");
	    button0.addActionListener(new ButtonEventListener());
		button0.setBounds(20, 145, 290, 15);	 
		lp.add(button0, JLayeredPane.PALETTE_LAYER);
	    
	    
	    label1.setBounds(20, 170, 290, 15);	   
	    //label1.setBorder(border);
	    label1.setText(file1);
	    lp.add(label1);	
	    
	    textArea1.setBounds(20, 187, 290, 120);	   
		textArea1.setBorder(border);
	    lp.add(textArea1);	
		    
	    button1.setActionCommand("1");
		button1.addActionListener(new ButtonEventListener());
		button1.setBounds(20, 315, 290, 15);
		lp.add(button1, JLayeredPane.PALETTE_LAYER);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setSize(345,390);
	    this.setVisible(true);
	}
	
	class ButtonEventListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			StringBuilder builder = new StringBuilder();
			switch (e.getActionCommand()) {
			case "0":
				URL urlTextFile = this.getClass().getClassLoader().getResource(file0);
				try(InputStream is = urlTextFile.openStream();) {
				  int c;
				  while ((c = is.read()) !=-1) {
				    builder.append((char) c);  
				  }
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				textArea0.setText(builder.toString());				
				
				break;
			case "1":
				try {
					BufferedReader reader = new BufferedReader(new FileReader(file1));
					String line = reader.readLine();
		              while (line != null) {
		                builder.append(line);
		                builder.append("\n");
		                line = reader.readLine();
		              }		
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				textArea1.setText(builder.toString());					
				break;
			default:
				break;
			}
		}
	}

}

package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.border.Border;


public class WidnowHW02 extends JFrame {
	
	String language = null;
	String country = null;
	
	
	private JLabel label0 = new JLabel("Hero");
	private ImageIcon icon = new ImageIcon("DotaArtPudge.png");
	private JLabel label1 = new JLabel(icon);	
	private JLabel label2 = new JLabel("Message");
	private JRadioButton radioEN = new JRadioButton("EN");
	private JRadioButton radioDE = new JRadioButton("DE");
	private JRadioButton radioBY = new JRadioButton("BY");
	private JButton button1 = new JButton("Save");
	private JButton button2 = new JButton("Load");
	
	public String getLanguage() {
		return language;
	}
	
	public String getcountry() {
		return country;
	}

	public void setlocale(String locale) {
		this.language = locale;
		this.country = locale.toUpperCase();
	}

	public JLabel getLabel2() {
		return label2;
	}

	public void setLabels() {		
		Locale locale = new Locale(language,country);  
		ResourceBundle resourceBundle = ResourceBundle.getBundle("MessageBundle", locale);
		this.label0.setText(resourceBundle.getString("hero"));
		this.label2.setText(resourceBundle.getString("replic"));
		switch (language) {
		case "by":
			  radioBY.setSelected(true);
			break;
		case "de":
			  radioDE.setSelected(true);
			break;	
		default:
			radioEN.setSelected(true);
			break;
		}
		
	}	
		
	public WidnowHW02() {
		super("MainHW02");			
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    JLayeredPane lp = getLayeredPane(); 	    
	    Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
	    
	    label0.setBounds(140, 3, 50, 15);	   
		//label0.setBorder(border);	        
		lp.add(label0);	
	    
	    label1.setBounds(30, 20, 270, 320);	   
		lp.add(label1);	
		
		label2.setBounds(15, 350, 300, 20);	   
		lp.add(label2);
		
		ButtonGroup group = new ButtonGroup();		
		radioEN.setActionCommand("en");
	    radioEN.addActionListener(new GroupEventListener());	    
	    radioEN.setBounds(35, 370, 50, 20);
	    group.add(radioEN);
	    lp.add(radioEN, JLayeredPane.PALETTE_LAYER);
	    
	    radioDE.setActionCommand("de");
	    radioDE.addActionListener(new GroupEventListener());	    
	    radioDE.setBounds(105, 370, 50, 20);
	    group.add(radioDE);
	    lp.add(radioDE, JLayeredPane.PALETTE_LAYER);
	    
	    radioBY.setActionCommand("by");
	    radioBY.addActionListener(new GroupEventListener());	    
	    radioBY.setBounds(165, 370, 50, 20);
	    group.add(radioBY);
	    lp.add(radioBY, JLayeredPane.PALETTE_LAYER);
	        
	    button1.setActionCommand("save");
		button1.addActionListener(new ButtonEventListener());
		button1.setBounds(30, 395, 80, 20);
		lp.add(button1, JLayeredPane.PALETTE_LAYER);
		
		button2.setActionCommand("load");
		button2.addActionListener(new ButtonEventListener());
		button2.setBounds(220, 390, 80, 20);
		lp.add(button2, JLayeredPane.PALETTE_LAYER);
		
		if(language == null) {
			setlocale("en");			
		}		
		setLabels();		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setSize(345,470);
	    this.setVisible(true);
	}
	
	class GroupEventListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		  	setlocale(e.getActionCommand());	 
		  	setLabels();
		}
	}
	
	class ButtonEventListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {			
			switch (e.getActionCommand()) {
			case "save":
				try(DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("local.cfg"))){
				  outputStream.writeUTF(getLanguage());
				  outputStream.flush();				  
				} catch (IOException e2) {
					e2.printStackTrace();
				}				
				break;
			case "load":
				try(DataInputStream inputStream = new DataInputStream(new FileInputStream("local.cfg"))){
				  setlocale(inputStream.readUTF());					  
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				setLabels();
				break;
			default:
				break;
			}
			JOptionPane.showMessageDialog(null,	e.getActionCommand()+' '+getcountry(),"Output",  JOptionPane.PLAIN_MESSAGE);
		}
	}

}

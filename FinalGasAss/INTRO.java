package FinalGasAss;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class INTRO {

	public static void main(String[] args) { //main frame Intro
		GUX gui = new GUX();
		gui.setVisible(true);

	}
}
class GUX extends JFrame implements ActionListener {
	public GUX() {
		setSize(500,700);
		setLayout(null);
		setLocationByPlatform(true);                      
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Intro
		ImageIcon bg = new ImageIcon("finui.png");
		JLabel background=new JLabel("",bg,JLabel.CENTER);
		background.setBounds(-10,-30,500,700);
	
		JButton program_butt = new JButton();
		program_butt.setBounds(145,301,200,50); 
		program_butt.setContentAreaFilled(false); //No ground
		program_butt.setBorderPainted(false); //No BorderLine
		add(program_butt);
		
		JButton about_butt = new JButton();
		about_butt.setContentAreaFilled(false); //No ground
		about_butt.setBorderPainted(false); //No BorderLine
		about_butt.setBounds(145,428,200,50);
		add(about_butt);
		
		setTitle("Gas Calculator");
	 
		
	    //add  intro
		
		add(background);
		program_butt.addActionListener(this);
		about_butt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				about a = new about();
				a.setVisible(true);
				
			}
		});
		
	}
		public void actionPerformed(ActionEvent e) { // mathod  mainGui
			mainGui gui = new mainGui();
			gui.setVisible(true);
			dispose(); //  frame intro
		}	
}

class about extends JFrame{
	public about() {
		setTitle("About");
		setSize(400,400);
		setLayout(null);
		setLocationByPlatform(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JLabel program_name = new JLabel("Gas Calculator Program");
		Font font = new Font("Tahoma",Font.BOLD,20);
		program_name.setFont(font);
		program_name.setBounds(70, 20, 300, 30);
		add(program_name);
		
		JLabel program_abt = new JLabel("<html> This Program is Midterm Mini GUI Project in<br>"+"   1204208 Object Oriented Programming 1/2564 <html>");
		program_abt.setBounds(70, 70, 400, 30);
		add(program_abt);
		
		JPanel line = new JPanel();
		line.setBounds(40, 120, 300, 3);
		line.setBackground(Color.GRAY);
		add(line);
		
		JLabel ath = new JLabel("Author By");
		Font font2 = new Font("Tahoma",Font.BOLD,18);
		ath.setFont(font2);
		ath.setBounds(140, 140, 300, 30);
		add(ath);
		
		JLabel program_author = new JLabel("<html>63011212045   Podchara Kampan <br><br>"+"	63011212099	  Peerapat Thuenpha <br><br>"+"63011212062   Adithep Ponlong<html>");
		program_author.setBounds(100, 150, 400, 150);
		//Font font1 = new Font("Tahoma",Font.BOLD,13);
		//program_author.setFont(font1);
		add(program_author);
		
		Button close = new Button("Close");
		close.setBounds(125, 300, 120, 40);
		add(close);
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e1) {
				dispose();
			}
		});
		
	}
	
}

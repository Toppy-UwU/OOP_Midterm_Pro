package FinalGasAss;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.JOptionPane;
class mainGui extends JFrame {  //  frame
	
	protected static final Object Int = null;

	String Line(int n) {
		String str = "\n";
		for(int i=0;i<n;i++) str += "-";
		return str += "\n";
	}
	
	private String path = ""; //file file 
	Panel palmain = new Panel();
	Panel palWater = new Panel(new BorderLayout());
	Panel palInfo= new Panel(new BorderLayout());
	Panel panelA = new Panel(new BorderLayout());
	Panel palco = new Panel(new BorderLayout());
	Panel palimport = new Panel(new BorderLayout());
	Panel palbtn = new Panel(new FlowLayout());
	Panel palbtn2 = new Panel(new FlowLayout());
	Panel panelSideInfo = new Panel(new BorderLayout());
	Panel panelBasicInfo = new Panel(new GridLayout(2,1));
	Panel panelMMA = new Panel(new GridLayout(3,1));
	
	JPanel panel = new JPanel(new BorderLayout());
	JPanel panel2 = new JPanel(new BorderLayout());
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel(null);
	JPanel panel5 = new JPanel(null);
	JPanel panel6 = new JPanel(null);
	
	
	JPanel Upper = new JPanel(new GridLayout());
	JPanel Lower = new JPanel(new GridLayout());
	
	TextArea infoArea = new TextArea("",7,40, TextArea.SCROLLBARS_NONE);
	TextArea infofile = new TextArea("",7,40, TextArea.SCROLLBARS_NONE);
	TextArea text1 = new TextArea("",0,0,TextArea.SCROLLBARS_VERTICAL_ONLY);
	JTextArea tips = new JTextArea(20,20);
	
	
	inserFile dept = new inserFile();
	
	TextField WaterLevel = new TextField(20);
    TextField ImFile= new TextField(30);
   
    Panel color = new Panel();//red
    Panel color1 = new Panel();//or
    Panel color2 = new Panel();//yellow
    Panel color3 = new Panel();//green
    
    JLabel Max = new JLabel("Max Gas Volume:        0.0      m^3"); //Max Gas Value
    JLabel Min = new JLabel("Min Gas Volume: 		0.0      m^3"); //Min Gas Value
    JLabel Avg = new JLabel("Average Gas Volume: 	0.0		 m^3"); //Average Gas Value
    
    JLabel lblGas = new JLabel("Gas: 0.0  m^3 | Gas Percent: 0%");
    JLabel lblFluid = new JLabel("Fluid: 0.0  m^3 | Fluid Percent: 0%");
    
	public mainGui() { // set ,panel ,  add frame
	
		setTitle("Gas Calculator");

		// frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(1500,823);
		setLayout(null);
   	   //  text
		text1.setSize(300, 70);
		
		
		
		JButton btnIm = new JButton("Import File");
		JButton btnEn = new JButton("OK");
		JButton btnRe = new JButton("clear");
		JButton btnEx = new JButton("Exit Program");
		JButton btnCr = new JButton("claer");
		
		btnIm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent exc) {//import file 
				actionImport(exc);
				ImFile.setText(path);
				
			}
		});
		btnEx.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		btnCr.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				WaterLevel.setText("");
			}
		});
		palbtn.add(btnIm);
		palbtn.add(btnRe);
		
		palimport.add(new JLabel("  File"),BorderLayout.NORTH);
		palimport.add(ImFile,BorderLayout.CENTER);
		palimport.add(palbtn,BorderLayout.SOUTH);
		
		palbtn2.add(btnEn);
		palbtn2.add(btnCr);
		
		palWater.add(new JLabel("  Fluid Contact"),BorderLayout.NORTH);
		palWater.add(WaterLevel,BorderLayout.CENTER);
		palWater.add(palbtn2,BorderLayout.SOUTH);

		
		palInfo.add(palimport,BorderLayout.NORTH);
		palInfo.add(palWater, BorderLayout.CENTER);
		
		panelA.add(palInfo, BorderLayout.CENTER);
		
		panelBasicInfo.setBounds(5, 25, 290, 300);
	    panelBasicInfo.setBackground(new Color(190,190,190));
	    panelBasicInfo.add(infoArea);
	    
	    infoArea.setFont(new Font("Tahoma", Font.BOLD, 15));
	    
	    panelBasicInfo.add(panelMMA);
	    panelMMA.add(Max);
	    panelMMA.add(Min);
	    panelMMA.add(Avg);
	    
		
	    panelSideInfo.add(panelBasicInfo);
	    panelSideInfo.add(new JLabel("  Gas Information"),BorderLayout.NORTH);
	    
		palco.add(panelA,BorderLayout.NORTH);
		palco.add(panelSideInfo,BorderLayout.CENTER);
		
		panel6.setBounds(0, 0, 1500,823);
		panel6.setBackground(new Color(64,64,64));
		
		panel.add(palco,BorderLayout.CENTER);
		panel.add(text1,BorderLayout.SOUTH);
		panel.setBounds(10,10,300,500);
		
		
		
		panel2.setBounds(330,10,1125,550);
		panel2.add(palmain, BorderLayout.CENTER);
		
		panel3.setBounds(330,575,600,200);
		
	    panel4.setBounds(955,575,500,200);
	    
	    lblGas.setHorizontalAlignment(JLabel.CENTER);
		lblFluid.setHorizontalAlignment(JLabel.CENTER);
	  
	    panel5.setBounds(10,515,300,220);
	   
	    panel5.add(Upper); 
	    Upper.setBounds(0, 0, 300, 110);
	    Upper.setBackground(new Color(192, 255, 149));
	    Upper.add(lblGas);
	    
	    panel5.add(Lower);
	    Lower.setBounds(0, 110, 300, 110);
	    Lower.setBackground(new Color(3, 167, 255));
	    Lower.add(lblFluid);
	    
		panel5.setBackground(new Color(210,210,210));
		
		Border col = BorderFactory.createTitledBorder("Color");
		panel4.setBorder(col);
		
		color.setBounds(25,50, 50, 50);
		color.setBackground(new Color(255,0,0));
		
		color1.setBounds(25,115,  50, 50);
		color1.setBackground(new Color(255,128,0));
		
		color2.setBounds(280, 50,  50, 50); 
		color2.setBackground(new Color(255,255,0)); 
		
		color3.setBounds(280,115,  50, 50);
		color3.setBackground(new Color(0,255,0));
		
		JLabel r = new JLabel("No gas (0%-25%)");
		r.setBounds(90,50, 150, 50);
		JLabel o = new JLabel("Gas Quite a few (25%-50%)");
		o.setBounds(90,115,  160, 50);
		JLabel y = new JLabel("Gas Medium (50%-75%)");
		y.setBounds(345, 50,  150, 50); 
		JLabel g = new JLabel("More gas (75%-100%)");
		g.setBounds(345,115,  150, 50);
		
		panel4.add(r);
		panel4.add(o);
		panel4.add(y);
		panel4.add(g);
		
		
		panel4.add(color);
		panel4.add(color1);
		panel4.add(color2);
		panel4.add(color3);
		
		Max.setHorizontalAlignment(JLabel.CENTER);
		Min.setHorizontalAlignment(JLabel.CENTER);
		Avg.setHorizontalAlignment(JLabel.CENTER);
		

		Border border = BorderFactory.createTitledBorder("Message");
		panel3.setBorder(border);
		panel3.add(text1);
		
		
		btnEx.setBounds(10,745,300,30);
		
		panel.setBackground(new Color(142,142,142));
		panel2.setBackground(new Color(142,142,142));
		panel3.setBackground(new Color(142,142,142));
		panel4.setBackground(new Color(142,142,142));
		panel5.setBackground(new Color(142,142,142));
		
		panel6.add(btnEx);
		panel6.add(panel);	//Import Clear Button
		panel6.add(panel2); //Center Frame
		panel6.add(panel3); //Panel Message Text Area show when import file
		panel6.add(panel4); //Show Color Info
		panel6.add(panel5); //Show Value between Gas and fluid 
		
		add(panel6);
	    
		WaterLevel.addTextListener(new TextListener() {
					
					@Override
					public void textValueChanged(TextEvent exc)  {
						dept.setWaterLevel(Integer.parseInt(WaterLevel.getText()));
					}
				});
		btnEn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent exc) {// Refrash
				try {
					Integer.parseInt(WaterLevel.getText());
					submitValue(exc);
					text1.append("Input WaterLevel: "+WaterLevel.getText()+"\nTime: "+dept.getTime()+""+Line(75));
				} catch (NumberFormatException ex) {
					text1.append("Input Mismatch Please Input Integer!!!!!!"+"\nTime: "+dept.getTime()+""+Line(75));
				}	
				
			}
		});
		btnRe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ImFile.setText("");
			}
		});
		
	}
	
	void setMainFrame(int x,int y) { 
		palmain.removeAll();
		dept.setGasStat();
		dept.setMMA(Max,Min,Avg);
		Line(25);
		
		int n = x*y;
		
		Button btn[] = new Button[n]; // 
		
		for(int i = 0;i<n;i++) {
			btn[i] = new Button(dept.getPercent(i));
			btn[i].setFont(new Font("Tahoma",Font.PLAIN,10));
			
			palmain.add(btn[i]);
			
			btn[i].setActionCommand(""+i);
			
			
			btn[i].addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent exc) { // btn[i]
					actionLis(exc,infoArea);
					
				}
			});
			
			
			btn[i].addMouseListener(new MouseListener() {
				
				public void mouseReleased(MouseEvent e) {}
				
				public void mousePressed(MouseEvent e) {}
				
				public void mouseExited(MouseEvent e) {}
				
				public void mouseEntered(MouseEvent e) {

				}
				
				public void mouseClicked(MouseEvent exc) {
					if(exc.getClickCount()==2) {
						JOptionPane.showMessageDialog(null, infoArea.getText());
					}
				}
			});
			
			

			int value = dept.getValue(i);// gas area  btn[i]
			
			if(value == 1) {
				btn[i].setBackground(new Color(0,255,0)); // green
			}else if(value == 2) {
				btn[i].setBackground(new Color(255,255,0)); // yellow
			}else if(value == 3){
				btn[i].setBackground(new Color(255,128,0)); // Orange
			}else {
				btn[i].setBackground(new Color(255,0,0)); // Red
			}
			
		}
		
		
		palmain.setLayout(new GridLayout(y,x));
		
		setVisible(true);
		
		Line(25);
		
	}
	
	void actionLis(ActionEvent exc,TextArea infoArea) { 
		infoArea.setText(dept.getInfo(Integer.parseInt(exc.getActionCommand()))); 
		compareValue(Integer.parseInt(exc.getActionCommand()));
	}
	
	void actionImport(ActionEvent exc) { 
		JFileChooser filech = new JFileChooser();
		filech.setDialogTitle("Import File");  
		
		int selbut = filech.showDialog(null, "Open");
		
		if(selbut == JFileChooser.APPROVE_OPTION) {
			
			String diname = filech.getCurrentDirectory().getAbsolutePath();
			String filname = filech.getName(filech.getSelectedFile());
			
			this.path = diname+"\\"+filname;
		}
		
		dept.setPath(this.path); 
		dept.setArea(); //setArea
		
		setMainFrame(dept.getX(), dept.getY());
		
		text1.append("Import File Path: "+path+"\nTime: "+dept.getTime()+""+Line(75));
		
		Line(25);
	}
	
	
	void submitValue(ActionEvent exc) { //  Refrash  Refrash
		dept.setWaterLevel(Integer.parseInt(WaterLevel.getText()));
		setMainFrame(dept.getX(), dept.getY());
	}
	
	void compareValue(int n) {
		int size = (int)(dept.getGasPercent(n)*180)/100;
		panel5.add(Upper);
	    Upper.setBounds(0, 0, 300, size+20);
	    Upper.setBackground(new Color(192, 255, 149));
	    
	    lblGas.setText("Gas: "+dept.getgasVolume(n)+"   m^3 | Gas Percent: "+dept.getGasPercent(n)+"%");
	    Upper.add(lblGas);
	    
	    panel5.add(Lower);
	    Lower.setBounds(0, size, 300, 220-size);
	    Lower.setBackground(new Color(3, 167, 255));
	    lblFluid.setText("<html><br/>Fluid: "+((150*150*200)-dept.getgasVolume(n))+"  m^3 | Fluid Percent: "+(100-dept.getGasPercent(n))+"%</html>");
	    Lower.add(lblFluid);
	}
	
}
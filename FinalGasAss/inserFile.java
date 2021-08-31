package FinalGasAss;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JLabel;

public class inserFile {
	private int x=0,y=0; 
	private float WaterLavel=0; 
	private ArrayList<String> layer = new ArrayList<String>();
	private ArrayList<Float> Area = new ArrayList<Float>(); 
	private ArrayList<Float> gasVolume = new ArrayList<Float>();
	private ArrayList<Float> gasPercent = new ArrayList<Float>();
	private String time;
	private float avgGas, maxGas, minGas;
	
	
	public inserFile() {	
	}
	
	public void setPath(String path) {
		File fil = new File(path); 
		this.layer.clear();
		
		
		try {
			Scanner dept = new Scanner(new FileReader(fil)); 
			while(dept.hasNext()) {
				layer.add(dept.nextLine()); 
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
		
		 
		this.y = layer.size(); 
		this.x = layer.get(0).split(" ").length; 
		
	}
	
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setArea() {
		Area.clear();
		for(int i = 0;i<y;i++) {
			String str[] = layer.get(i).split(" ");
			
			String editStr[] = errorCheck(str);
			
			for(int j = 0;j<x;j++ ) { 
				editStr[j] = editStr[j].replace("O", "0");
				Area.add(Float.parseFloat(editStr[j])); 
			}
		}
	}
	
	String[] errorCheck(String[] str) {
		
		ArrayList<String> editStr = new ArrayList<String>();
		int n=1;
		for(int i=0;i<str.length;i++) {
			if(str[i].equals("")&&n==5) {
				editStr.add("9999");
				n=1;
			}else if(str[i].equals("")&&n<5) {
				n++;
			}else {
				editStr.add(str[i]);
			}
		}
		
		this.x = editStr.size();
		return  editStr.toArray(new String[0]);
	}
	
	public void setWaterLevel(int x) { 
		WaterLavel = x;
	}
	
	public String getInfo(int n) { 
		String str;
		float top = (Area.get(n)-200), base = Area.get(n);
		str = "Top Horizon: "+top+" m\nFluid Contact: "+WaterLavel+" m\nBase Horizon: "+base+" m";
		if(Area.get(n) == 9999) {
			str = "NO DATA!!!";
		}else if(WaterLavel-top<0) {
			str += "\n\nGas Volume: 0  m^3\nGas Percent: 0%";
		}else if(WaterLavel > base){
			str += "\n\nGas Volume: "+gasVolume.get(n)+"  m^3\n";
			str += "Gas Percent: "+String.format("%.1f", gasPercent.get(n))+"%";
		}else {
			str += "\n\nGas Volume: "+gasVolume.get(n)+"  m^3\n";
			str += "Gas Percent: "+String.format("%.1f", gasPercent.get(n))+"%";
		}
		return str; 
	}
	
	int getValue(int n){ 
		float top = (this.Area.get(n)-200), base = this.Area.get(n);
		float Area = 150*150*200;
		float result = 150*150*(WaterLavel-top);
		if(WaterLavel < top) {
			return 4;
		}else if(WaterLavel > base) {
			return 1;
		}else if(result >= (Area*3)/4) {
			return 1;
		}else if(result < (Area*3)/4 && result >= Area/2) {
			return 2;
		}else if(result < Area/2 && result >= (Area*1)/4) {
			return 3;
		}else {
			return 4;
		}
		 
	}
	
	
	String getTime() {
		DateTimeFormatter dtt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		this.time = ""+dtt.format(LocalDateTime.now());
		return this.time;
	}
	
	
	void setGasStat() {
		clearGasStat();
		for(int i=0;i<Area.size();i++) {
			float n = 150*150*(WaterLavel-(Area.get(i)-200));
			if(n<0) {
				gasVolume.add((float)0);
			}else if(n>=150*150*200){
				gasVolume.add((float)150*150*200);
			}else {
				gasVolume.add(n);
			}
		}
		
		for(int i=0;i<gasVolume.size();i++) {
			gasPercent.add((float)((gasVolume.get(i)*100)/(150*150*200)));
		}
		
		this.maxGas = Collections.max(gasVolume);
		this.minGas = Collections.min(gasVolume);
		float tmp=0;
		for(int i=0;i<gasVolume.size();i++) {
			tmp += gasVolume.get(i);
		}
		this.avgGas = tmp / gasVolume.size();
	}
	
	void clearGasStat() {
		gasVolume.clear();
		gasPercent.clear();
	}
	
	String getPercent(int n) {
		if(Area.get(n)==9999){
			return "NO DATA";
		}else if(WaterLavel == 0) {
			return "0%";
		}else {
			return String.format("%.1f", gasPercent.get(n))+"%";
		}
	}
	
	
	void setMMA(JLabel Max, JLabel Min, JLabel Avg) {
		Max.setText(" Max Gas Volume: "+this.maxGas+"  m^3");
		Min.setText(" Min Gas Volume: "+this.minGas+"  m^3");
		Avg.setText(" Average Gas Volume: "+this.avgGas+" m^3");
	}
	
	float getGasPercent(int n) {
		return gasPercent.get(n);
	}
	
	float getgasVolume(int n) {
		return gasVolume.get(n);
	}
	
	
	
}
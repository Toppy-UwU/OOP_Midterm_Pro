package DeptMaker;

import java.io.FileWriter;   
import java.io.IOException;
import java.util.Scanner;

public class DeptFile {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		try {
			FileWriter myWriter = new FileWriter("1.txt");
			String str = "";
			System.out.println("Enter X,Y: ");
			int x = key.nextInt();
			int y = key.nextInt();
			
			for(int i=0;i<x;i++) {
				for(int j=0;j<y;j++) {
					str += (int)(Math.random()*500+2200)+" ";
				}
				str += "\n";
			}
		    myWriter.write(str);
		    myWriter.close();
		    System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
		    System.out.println("An error occurred.");
		    e.printStackTrace();
		}    
	}  
}

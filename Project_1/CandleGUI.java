import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class CandleGUI {
	File orgfile;
	Candle[] sortlist;
	
	public CandleGUI(File orgfile, Candle[] sortlist) {
		this.orgfile = orgfile;
		this.sortlist = sortlist;
	}

	
	public void display() {
		JFrame frame = new JFrame("Project1 CandleGUI"); //create a container
		   
		GridLayout grid = new GridLayout(1,2); //one row, two col,
		frame.setSize(200, 200); //width, height
		frame.setLayout(grid);
		JTextArea orgTextArea = new JTextArea();  //area where we can put text
		JTextArea sortTextArea = new JTextArea();
		try {
			//read line and put it into JTextArea
			FileReader theInputReader = new FileReader(orgfile); 
			BufferedReader theReader = new BufferedReader(theInputReader);
			String theCurrentLine = theReader.readLine();
		
			while (theCurrentLine != null) {

			orgTextArea.append(theCurrentLine+"\n");
			theCurrentLine = theReader.readLine();
			
			}
			theReader.close();
		}
			catch(Exception  e) { //if file can't be read, find or error occur, debug
				e.printStackTrace();
			}
				
			frame.add(orgTextArea); //add content to the frame
			for (int i = 0; i < sortlist.length; i++)  		          
				sortTextArea.append(sortlist[i].getH()+","+sortlist[i].getW()+","+sortlist[i].getP()+"\n");
				
			//Display the GUI window.
			frame.add(sortTextArea);
			frame.setVisible(true);
	}
}

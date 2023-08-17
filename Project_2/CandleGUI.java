import javax.swing.*;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class CandleGUI {
	
		public JTextArea Unsorted = new JTextArea();
		public JTextArea Sorted = new JTextArea();
	   
	   public CandleGUI(UnsortedCandleList x, SortedCandleList y, int z) {//constructor
		  
	      JFrame myFrame=new JFrame("Candles");
	      myFrame.setSize(800,800);//w, h
	      myFrame.setLocation(400, 400); //pixel
	      myFrame.setTitle("");
	      myFrame.setLayout(new GridLayout(1,2)); //one row, two col
	      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
	      JTextArea Unsorted = new JTextArea();
	      JTextArea Sorted = new JTextArea();
	      myFrame.getContentPane().add(Unsorted);
	      myFrame.getContentPane().add(Sorted);
		  
		  //Display the GUI window.
	      Unsorted.append("unsorted:\n "+x.toString()+"\n");
          Sorted.append("sorted: \n" + y.toString()+"\n");

          myFrame.pack();
		  myFrame.setVisible(true);
	   }
}

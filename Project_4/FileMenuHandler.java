import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.StringTokenizer;
import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.swing.*;

/**Event Handlers are written in a class that implements an interface called ActionListener
 * If an interface is implemented, all methods specified in the interface must be provided 
 * by that class
*/
public class FileMenuHandler implements ActionListener { 
	private CandleGUI GUI_1;
	private JFrame jframe;
   public FileMenuHandler (CandleGUI GUI_2, JFrame jframe) { // (JFrame jf) constructor
		this.GUI_1=GUI_2;
		this.jframe=jframe;
   }
   public void actionPerformed(ActionEvent event) {
      String menuName = event.getActionCommand();
      
      if (menuName.equals("Open"))
      {
    	  JFileChooser fc=new JFileChooser("./"); 
    	  int returnVal = fc.showOpenDialog(null);
    	  if (returnVal == JFileChooser.APPROVE_OPTION) { //approves user option
              String fileName = fc.getSelectedFile().getAbsolutePath();
              GUI_1.readFile(fileName);
    	  //create Jfile Chooser
    	  //call ShowOpenDialogue(null)
    	  //check if it is approved
    	  //   ./ means current directory
      }  
      }
      if (menuName.equals("Quit")) {
    	  jframe.setVisible(false);
          System.exit(0);
      
   } 
}
}
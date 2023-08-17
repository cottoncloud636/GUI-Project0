import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EditMenuHandler implements ActionListener { 
	public CandleGUI GUI_1;
	public JFrame jframe;
   public EditMenuHandler (CandleGUI GUI_2, JFrame jframe) { // (JFrame jf) constructor
		this.GUI_1=GUI_2;
		this.jframe=jframe;
   }
   public void actionPerformed(ActionEvent event) {
      String menuName = event.getActionCommand();
      
      if (menuName.equals("Search")){
         //note: JOptionPane.showInputDialog() always return a String type
    	   String myprice = JOptionPane.showInputDialog("Please enter the price you like to seach:");

         
         // System.out.println("The price you entered is: "+ myprice);
         GUI_1.search(myprice);
         // JOptionPane.showMessageDialog(null,"The price you entered is: " + myprice);
         //Im returning a node.................................................
      }
}
}


import javax.swing.JOptionPane;

//Xian Zhou Lab Section:11E

/**
 * Xian Zhou
 */
public class Project0{
	
	public static void main(String[] args) {
		int countLower_e=0;
		int countUpper_E=0;
		String inputWord;
	
		while (true) {

			/*inputWord is used to store user input
			 showInputDialog(null, "Please enter a sentence: "); can be explained as:
			 	- null:  null is used, means dialog box will be displayed in the center of the screen or window
			    - "Please enter a sentence: " will be displaed in the input dialog box.
			*/
			inputWord=JOptionPane.showInputDialog(null, "Please enter a sentence: ");

	    	if(inputWord.equalsIgnoreCase("Stop"))
	    		System.exit(0);
			
			for (int i=0; i<inputWord.length(); i++){
				if (inputWord.charAt(i)=='e')
					countLower_e ++;
				if (inputWord.charAt(i)=='E')
					countUpper_E ++;
			}

			/**
			*Using JOptionPane.showMessageDialog method to dislay how many *lower e and uPPer E has in the sentence that user inPut.
			*Using number function to count number of e and E.
			**/
			JOptionPane.showMessageDialog(null, "Number of lower case e's: " + countLower_e + "\n" + "Number of upper case E's: " + countUpper_E);
        	
   		}
	}
}


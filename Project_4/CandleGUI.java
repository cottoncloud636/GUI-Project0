import javax.swing.*;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class CandleGUI extends JFrame{	
	public JTextArea orgTextArea;  
	public JTextArea sortTextArea ;
	public UnsortedCandleList Unsorted;
	public SortedCandleList Sorted;
	JFrame frame = new JFrame("Project4 CandleGUI"); //create a container
	   
	public CandleGUI(String Title) {//constructor
		
		setSize(600,600);//w, h
		setLocation(400, 0); //pixel
		setTitle("Candle");
		setLayout(new GridLayout(1,2)); //one row, two col
		createMenu();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		


		setVisible(true);
	}
	   
	public void createMenu() {
		JMenuBar menuBar  = new JMenuBar(); //JMenuBar is a builtin method
		JMenu fileMenu = new JMenu("File");
		JMenuItem item;
		
		FileMenuHandler fmh  = new FileMenuHandler(this,frame);

		item = new JMenuItem("Open");    //Open...
		item.addActionListener(fmh); //keep listening
		fileMenu.add(item);

		fileMenu.addSeparator();           //add a horizontal separator line
		JMenuItem itemquit;
		itemquit = new JMenuItem("Quit");
		FileMenuHandler fmq  = new FileMenuHandler(this,frame);
		itemquit.addActionListener(fmq);
		fileMenu.add(itemquit);	
		
		//start: add edit menuS
		JMenu fileMenuedit = new JMenu("Edit");
		JMenuItem itemsearch;
		itemsearch = new JMenuItem("Search");
		EditMenuHandler fme  = new EditMenuHandler(this,frame);
		itemsearch.addActionListener(fme);
		fileMenuedit.add(itemsearch);
		//end

		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		menuBar.add(fileMenuedit);
	}

	public void readFile(String myFile) { // read file
		JTextArea orgTextArea = new JTextArea();
		JTextArea sortTextArea = new JTextArea();
		UnsortedCandleList Unsorted = new UnsortedCandleList();
		SortedCandleList Sorted = new SortedCandleList();

		TextFileInput CandleFile = new TextFileInput(myFile);
		String line = CandleFile.readLine();
		while (true) {

			if (line == null)
				break;
			// orgTextArea.append(line+"\n");
			StringTokenizer candleTokens = new StringTokenizer(line, ",");
			StringBuilder debugLog = new StringBuilder();
			StringBuilder debugLog2 = new StringBuilder();
			if (candleTokens.countTokens() == 3) {
				int h = Integer.parseInt(candleTokens.nextToken());
				int w = Integer.parseInt(candleTokens.nextToken());
				float p = Float.parseFloat(candleTokens.nextToken());
				Candle newCandle = new Candle(h, w, p);
				Unsorted.add(newCandle);
				debugLog.append("for unsorted ").append(h).append(", ").append(w).append(", ").append(p).append("the end");
				
				System.out.println(debugLog.toString());
				
				Sorted.add(newCandle);
				debugLog2.append("for sorted ").append(h).append(", ").append(w).append(", ").append(p).append("the end");
				System.out.println(debugLog2.toString());
			} 
			else
				System.out.println("Incomplete candle's information: " + line);
			
			
			line = CandleFile.readLine();

			
			orgTextArea.append(line + "\n");
			add(orgTextArea);
			sortTextArea.append(Sorted.toString());
			// Display the GUI window.
			add(sortTextArea);
			setVisible(true);
		}
		returnSorted(Sorted);
		// line = CandleFile.readLine();
		System.out.println("good");

	}

	SortedCandleList returnSorted(SortedCandleList Sorted){
		return Sorted;
	}


	   public void search(String myprice) { 
		if (Sorted != null ) {
			// CandleNode p = new CandleNode(null); // CandleNode p = Sorted.first.next;
			CandleNode p = Sorted.first;
			String returnString = "";
			while (p != null) {
				if(p.data.getP()<Float.parseFloat(myprice)) {
				returnString += p.data + " \n";
			//	System.out.println("-----returnString:"+returnString);
				}
				p = p.next;
			}
			orgTextArea.setText(returnString);
		    sortTextArea.setText("");
			JOptionPane.showMessageDialog(null,"The price at or below your input is: " + p.data);
			setVisible(true);
			System.out.println("Good");
		}
		
	}

}
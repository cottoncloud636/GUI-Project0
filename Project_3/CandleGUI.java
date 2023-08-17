
import javax.swing.*;
import java.awt.GridLayout;
import java.util.StringTokenizer;

public class CandleGUI extends JFrame {
	public JTextArea Unsorted = new JTextArea();
	public JTextArea Sorted = new JTextArea();
	JFrame frame = new JFrame("Project3 CandleGUI"); // create a container

	public CandleGUI(String Title) {// constructor

		setSize(600, 600);// w, h
		setLocation(400, 0); // pixel
		setTitle("Candle");
		setLayout(new GridLayout(1, 2)); // one row, two col
		createMenu();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);
	}

	public void createMenu() {
		JMenuBar menuBar = new JMenuBar(); // JMenuBar is a builtin method
		JMenu fileMenu = new JMenu("File");
		JMenuItem item;

		FileMenuHandler fmh = new FileMenuHandler(this, frame);

		item = new JMenuItem("Open"); // Open...
		item.addActionListener(fmh); // keep listening
		fileMenu.add(item);

		fileMenu.addSeparator(); // add a horizontal separator line
		JMenuItem itemquit;
		itemquit = new JMenuItem("Quit");
		FileMenuHandler fmq = new FileMenuHandler(this, frame);
		itemquit.addActionListener(fmq);
		fileMenu.add(itemquit);

		setJMenuBar(menuBar);
		menuBar.add(fileMenu);

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
			if (candleTokens.countTokens() == 3) {
				int h = Integer.parseInt(candleTokens.nextToken());
				int w = Integer.parseInt(candleTokens.nextToken());
				float p = Float.parseFloat(candleTokens.nextToken());
				Candle newCandle = new Candle(h, w, p);
				Unsorted.add(newCandle);
				Sorted.add(newCandle);
			} 
			else
				System.out.println("Incomplete candle's information: " + line);
			line = CandleFile.readLine();

			// print incorrect information to the console
			orgTextArea.append(line + "\n");
			add(orgTextArea);
			sortTextArea.append(Sorted.toString());
			// Display the GUI window.
			add(sortTextArea);
			setVisible(true);
		}
		// line = CandleFile.readLine();

		
	}
}

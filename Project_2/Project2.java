import java.util.StringTokenizer;
import java.io.File;


//Xian Zhou Lab Section:11E

/**
* Xian Zhou
* Date: 11/13
* @author zhxi2872
* This project uses Linked List to do sort and insert 
*/
public class Project2 {
		public static int count = 0;
		
		
		public static void main(String[] args) { //read file
			String filePath = "input.txt";
			TextFileInput CandleFile = new TextFileInput(filePath);
			UnsortedCandleList Unsorted = new UnsortedCandleList();
			SortedCandleList Sorted = new SortedCandleList();
			
			while(true){
				String line = CandleFile.readLine();
				if(line == null) break;
				
				StringTokenizer candleTokens = new StringTokenizer(line,",");
				if(candleTokens.countTokens()==3) {
					int h = Integer.parseInt(candleTokens.nextToken());
					int w = Integer.parseInt(candleTokens.nextToken());
					float p = Float.parseFloat(candleTokens.nextToken());
					Candle newCandle = new Candle(h,w,p);
					Unsorted.add(newCandle);
					Sorted.add(newCandle);
					count++;
				}
				//print incorrect information to the console
				else System.out.println("Incomplete candle's information: " + line);
			}
						
			
			new CandleGUI(Unsorted,Sorted,count);//CandleGUI GUI = new CandleGUI(Unsorted,Sorted,count);
			
		}

	}

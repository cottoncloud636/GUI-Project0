import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.StringTokenizer;
import java.util.ArrayList;


//Xian Zhou Lab Section:11E

/**
* Xian Zhou
* @author zhxi2872
* This program will read a textfile include candle information: height, width and price. Seperate the file by comma and put them into array
* sort the array by price and display on a GUI window.
* 1. read file
* 2. read each line and tokenize each line until the whole file was read and tokenized
* 3. put each candle to array and create a new candle array
* 4. sort the array by price and display on a GUI
*/
public class Project1 {
	public static StringTokenizer candleTokens;
	public static String candleSorted[];
	public static String candleUnsorted[]; 
	
	
   public static void main(String[] args0) {
	  //open a file, read file and read line
	   try{
			String filePath="input.txt";//   ..\\ -- relative path, go one level up and find this file
			File candleFile = new File(filePath); //open a file
			FileReader theInputReader = new FileReader(candleFile); //read a file
			BufferedReader theReader = new BufferedReader(theInputReader); //put a file into a buffer waiting for read
			String theCurrentLine = theReader.readLine(); //read line of a file

			//parse out the three pieces of info from input.txt for the Candle using a StringTokenizer and save them into ArrayList
			ArrayList<Candle> candles = new ArrayList<Candle>(); //build an empty array list, and we can randomly access this list
			while (theCurrentLine != null) {
		
				candleTokens = new StringTokenizer(theCurrentLine,",");//stringTokenize
				if(candleTokens.countTokens()<3) { //if tokens are smaller than 3, directly console out
					System.out.println("information incomplete"+theCurrentLine);
					theCurrentLine=theReader.readLine(); //read the whole line
					continue;
				} //end of if statement and line read
					
				String height = candleTokens.nextToken(); //tokenize single object, here tokenize height
				String width = candleTokens.nextToken(); 
				String price = candleTokens.nextToken();	
			
				candles.add(new Candle(Integer.parseInt(height), Integer.parseInt(width), Float.parseFloat(price))); //put each candles into array list 
				theCurrentLine =theReader.readLine();//read next line
			} 
			//end of while loop
			
			theReader.close(); //end of reading candleFile

			/*after input.txt file is tokenized into the ArrayList, create two arrays, one to store the unsorted
			raw data from candles ArrayList, one to store the sorted candles ArrayList */
			Candle[] candleUnsorted =  (Candle[])candles.toArray(new Candle[candles.size()]); //add unsorted candle information straight to array name candleUnsorted
			Candle[] candleSorted = sortByPrice(candleUnsorted); //call sortByPrice method
			
			//last step display the array on the GUI
			CandleGUI candlegui = new CandleGUI(candleFile, candleSorted);
			candlegui.display();
	   }
   
	   	catch(FileNotFoundException e){//if file can't be read, find or error occur, debug
			e.printStackTrace();
	   	}
		catch(Exception e){
			e.printStackTrace();
		}
   		}

		//sort array
		public static Candle[] sortByPrice(Candle[] candleUnsorted){  //sortByPrice method
			Candle[] newlist = new Candle[candleUnsorted.length];
			for (int i = 0; i <= candleUnsorted.length-1; i++) {
				Candle minPrice = candleUnsorted[i];
				//find lowest price of candle
				for (int j = i + 1; j < candleUnsorted.length; j++){  
					Candle temp = candleUnsorted[j];
					if (candleUnsorted[j].getP() < minPrice.getP()){  
						candleUnsorted[j] = candleUnsorted[i]; //swap
						minPrice=temp;
						candleUnsorted[i] = temp;   	
					}  
				}  
					newlist[i]=minPrice;
			}
			return newlist;
		}
}


	   
	  
	  

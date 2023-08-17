
public class UnsortedCandleList extends CandleList {
	
  public UnsortedCandleList() { //constructor
	  super();
  }
  
  public void add(Candle cd) { //append a node to the unsorted list regardless the order
	  append(cd);
  }
}


public class SortedCandleList extends CandleList {
 
	public SortedCandleList() { //no argument constructor, use the constructor from super class
		super();
	}
	
	public void add(Candle cd) {
		
		CandleNode previous = first;
		
		
		   while(previous.next!=null) {
			   if (cd.getP()<previous.next.data.getP()) {
			   break;
		   }
		   previous=previous.next;
	}
		   CandleNode newNode=new CandleNode(cd);
		   newNode.next=previous.next; 
		   previous.next=newNode;
		   
		   
		   
		   } 
			   
		   }



public class SortedCandleList extends CandleList {
 
	public SortedCandleList() { //no argument constructor, use the constructor from super class
		super();
	}
	
	public void add(Candle cd) {
		
		//start: to find this specific position that the new node want to add in
		CandleNode previous = first;
		
		while(previous.next!=null) {
			if (cd.getP()<previous.next.data.getP()) {
				break;
			}
			previous=previous.next;
		}
		//end

		//start: to insert this new node and ensure the link does not break
		CandleNode newNode=new CandleNode(cd);
		newNode.next=previous.next; 
		previous.next=newNode;
		//end
	}
}
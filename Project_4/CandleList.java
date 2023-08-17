//LinkedList.java
//
//This version uses three instance variables,
//a pointer to the first node, a pointer to
//the last node, and length, to make our
//append and getLength methods more efficient
//than the would be if our only instance
//variable were a pointer to the first node.
//
//This version uses a dummy first node.  Hence
//it needs less decision-making than it would
//need if a dummy first node were not used.
//

/**
* Encapsulates a linked list of <code>String</code>.
*/
public class CandleList {

	/** First node in linked list - dummy node */ //dummy node means data part is null
	protected CandleNode first;

	/** Last node in linked list */
	protected CandleNode last; //because these is only one dummy node

	/** Number of data items in the list. */
	protected int length;
 
	public CandleList() { //create no argument constructor
		first = new CandleNode(null);
		last = first;
		length = 0;
		
	}

	/**
	 * Appends a String data element to this LinkedList.
	 */
	
 public void append(Candle cd) {
 	CandleNode newNode=new CandleNode(cd);//create an instance for CandleNode class
 	last.next=newNode; //put newNode to last.next node
 	last=newNode; //make newNode as the last node
 	length++; //length updates by one
}
 
 /**
	 * @return String representation of elements in linked list delimited by a
	 *         space character
	 */
	public String toString() {
		CandleNode p = first.next;
		String returnString = "";
		while (p != null) {
			returnString += p.data + " \n";
			p = p.next;
		}
		return returnString;
	}
}


//CandleNode.java


/**
* This class constructs the CandleNode for use in linked lists.
* @author Xian Zhou
*
*/

public class CandleNode{
   Candle data;
   CandleNode next;

   public CandleNode(Candle cd){ //Constructor for CandleNode.

      this.data= cd;
      next=null;
   }
}
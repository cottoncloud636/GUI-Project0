
public class Candle {
	private int h; //all four belong to the class
	private int w;
	private float p;
	private boolean litOrNot;
  
	public Candle(int height, int width, float price) {
		super();
		this.h=height;   //constructor used to initialize the value for instance variable set values
	    this.w=width;
	    this.p=price;
	    this.litOrNot=false;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public float getP() {
		return p;
	}

	public void setP(float p) {
		this.p = p;
	}

	@Override
	public String toString() {
		return h+","+w+","+p+",";
	}
	
	
}
	
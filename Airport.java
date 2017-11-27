package cell;
public class Airport extends Cell {

	private int price,own,rent;
	public Airport(String name,int price, int pos) {
		super(name, pos);
		this.price=price;
		rent=250;
	}
	public void setOwn(int own)
	{
		this.own=own;
	}
	public int getOwn()
	{
		return own;
	}
}

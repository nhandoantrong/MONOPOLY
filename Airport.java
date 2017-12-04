package cell;
public class Airport extends Cell {

	private int price,own=0,rent;
	public Airport(String name,int price, int pos) {
		super(name, pos);
		this.price=price;
		rent=250;
	}
	@Override
	public void setOwn(int own)
	{
		this.own=own;
	}
	@Override
	public int getOwn()
	{
		return own;
	}
	@Override
	public String getType()
	{
		return "airport";
	}
	@Override
	public int getPrice() {
		return price;
		
	}
}

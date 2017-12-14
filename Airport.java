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
		/*Set the owner*/
		this.own=own;
	}
	@Override
	public int getOwn()
	{
		/*Return the owner*/
		return own;
	}
	@Override
	public String getType()
	{
		/*Return the type*/
		return "airport";
	}
	@Override
	public int getPrice() {
		/*Return the airport price*/
		return price;
		
	}
	@Override
	public int getCost()
	{
		/*Return rent cost of the airport*/
		return rent;
	}
}

package cell;
public class Company extends Cell {
	private int own=0,price;
	public Company(String name, int price, int pos)
	{
		super(name,pos);
		this.price=price;
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
		return "company";
	}
	@Override
	public int getPrice() {
		return price;
	}
	
}

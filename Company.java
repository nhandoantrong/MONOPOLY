package cell;
public class Company extends Cell {
	private int own,price;
	public Company(String name, int price, int pos)
	{
		super(name,pos);
		this.price=price;
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

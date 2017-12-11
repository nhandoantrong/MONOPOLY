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
	@Override
	public String toString()
	{
		String str=super.getName();
		str+="\nIf one UTILITY is owned, rent is 40 times amount shown on dice";
		str+="\nIf both UTILYTY are own, rent is 100 times amount shown on dice";
		return str;
	}
}

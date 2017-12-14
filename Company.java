package cell;
public class Company extends Cell {
	private int own=0,price,cost;
	public Company(String name, int price, int pos)
	{
		super(name,pos);
		this.price=price;
		cost=250;
	}
	@Override
	public int getCost()
	{
		/*Return the rent cost*/
		return cost;
	}
	@Override
	public void setOwn(int own) 
	{
		/*set the owner*/
		this.own=own;
	}
	@Override
	public int getOwn()
	{
		/*return the owner */
		return own;
	}
	@Override
	public String getType()
	{
		/*return the company's type*/
		return "company";
	}
	@Override
	public int getPrice() {
		/*return the company's price*/
		return price;
	}
	@Override
	public String toString()
	{
		/*return the company's information*/
		String str=super.getName();
		str+="\nIf one UTILITY is owned, rent is 40 times amount shown on dice";
		str+="\nIf both UTILYTY are own, rent is 100 times amount shown on dice";
		return str;
	}
}

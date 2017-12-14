package cell;
public class Land extends Cell {
	private int price,housePrice,hotelPrice,own=0,cost,houseNumber=0;
	private String name;
	public Land(String name,int price, int housePrice,int hotelPrice,int pos)
	{
		super(name,pos);
		this.price=price;
		this.hotelPrice=hotelPrice;
		this.housePrice=housePrice;
		this.name=name;
		cost=price/10;
	}
	@Override
	public int getPrice() {
		/*return the land's price*/
		return price;
	}
	public void setPrice(int price) {
		/*set the land's price*/
		this.price = price;
	}
	@Override
	public int getHousePrice() {
		/*return the land's house price*/
		return housePrice;
	}
	public void setHousePrice(int housePrice) {
		/*set the land's house price*/
		this.housePrice = housePrice;
	}
	@Override
	public int getHotelPrice() {
		/*return the land's hotel price*/
		return hotelPrice;
	}
	public void setHotelPrice(int hotelPrice) {
		/*set the land's hotel price*/
		this.hotelPrice = hotelPrice;
	}
	@Override
	public int getHouse()
	{
		/*return the land's house number*/
		return houseNumber;
	}
	@Override
	public void setOwn(int o)
	{
		/*set the land's owner*/
		own=o;
	}
	@Override
	public int getOwn()
	{
		/*return the land's owner*/
		return own;
	}
	@Override
	public void houseUpgrade()
	{
		/*upgrade the number of houses*/
		houseNumber++;
		if (houseNumber==1)
		{
			cost*=5;
		}
		else if (houseNumber==2)
		{
			cost*=3;
		}
		else if (houseNumber==3)
		{
			cost*=3;
		}
		else if (houseNumber==4)
		{
			cost*=5/4;
		}
		else if (houseNumber==5)
		{
			cost*=5/4;
		}
		else houseNumber=5;
	}
	@Override
	public String toString()
	{
		/*return the land's information*/
		String str="Land Name : "+ name+"\n"+"price: "+price;
		int rent=price/10;
		str+="RENT : "+rent+"\n";
		str+="With 1 house : "+rent*5+"\n";
		str+="with 2 houses : "+rent*5*3+"\n";
		str+="with 3 house s: "+rent*5*3*3+"\n";
		str+="with 4 houses : "+rent*5*3*3*5/4+"\n";
		str+="with hotel : "+rent*5*3*3*5/4*5/4+"\n";
		str+="Houses Cost : "+housePrice+"\n";
		str+="Hotel Cost : "+hotelPrice+"\n";
		str+="Mortgage Value : "+ price/2+"\n";
		return str;
	}
	
	@Override
	public String getType()
	{
		/*return the type of cell*/
		return "land";
	}
	@Override
	public int getCost()
	{
		/*return the rent cost*/
		return cost;
	}
}

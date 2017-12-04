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
		cost=price/10;
	}
	@Override
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getHousePrice() {
		return housePrice;
	}
	public void setHousePrice(int housePrice) {
		this.housePrice = housePrice;
	}
	public int getHotelPrice() {
		return hotelPrice;
	}
	public void setHotelPrice(int hotelPrice) {
		this.hotelPrice = hotelPrice;
	}
	@Override
	public int getHouse()
	{
		return houseNumber;
	}
	@Override
	public void setOwn(int o)
	{
		own=o;
	}
	@Override
	public int getOwn()
	{
		return own;
	}
	@Override
	public void houseUpgrade()
	{
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
			cost*=1.25;
		}
		else if (houseNumber==5)
		{
			cost*=1.25;
		}
		else houseNumber=5;
	}
	@Override
	public String toString()
	{
		String str="Land Name : "+ name+"\n"+"price: "+price;
		int rent=price/10;
		str+="RENT : "+rent+"\n";
		str+="With 1 house : "+rent*5+"\n";
		str+="with 2 houses : "+rent*5*3+"\n";
		str+="with 3 house : "+rent*5*3*3+"\n";
		str+="with 4 house : "+rent*5*3*3*1.25+"\n";
		str+="with 4 house : "+rent*5*3*3*1.25*1.25+"\n";
		str+="Houses Cost : "+housePrice+"\n";
		str+="Hotel Cost : "+hotelPrice+"\n";
		str+="Mortgage Value : "+ price/2+"\n";
		return str;
	}
	
	@Override
	public String getType()
	{
		return "land";
	}
}

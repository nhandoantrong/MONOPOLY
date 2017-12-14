package cell;
import java.util.*;
public class ChanceCell extends Cell {
	private int number;
	private int price,a;
	private Random r=new Random();
	public ChanceCell(String name, int pos)
	{
		super(name,pos);
	}
	@Override
	public int getPrice()
	{
		/*Return the money player gets or pays*/
		price=r.nextInt(3000)+1;
		a=r.nextInt(2);
		if (a==1)
		return price;
		else
		return -price;
	}
	@Override
	public String getType()
	{
		/*return the cell's type*/
		return "chance";
	}
	@Override
	public void setOwn(int own) {
		
	}
	@Override
	public int getOwn() {
		return 0;
	}
}

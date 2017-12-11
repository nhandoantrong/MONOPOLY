package cell;
import java.util.*;
public class ChanceCell extends Cell {
	private int number;
	private ChanceCardList list= new ChanceCardList();
	private int price,a;
	private Random r=new Random();
	public ChanceCell(String name, int pos)
	{
		super(name,pos);
	}
	public int getprice()
	{
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
		return "chance";
	}
	@Override
	public void setOwn(int own) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getOwn() {
		// TODO Auto-generated method stub
		return 0;
	}
}

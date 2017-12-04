package cell;
import java.util.*;
public class ChanceCell extends Cell {
	private int number;
	private ChanceCardList list= new ChanceCardList();
	private ChanceCard card;
	private Random r=new Random();
	public ChanceCell(String name, int pos)
	{
		super(name,pos);
	}
	public ChanceCard getCard()
	{
		if (list.isEmpty()) list=new ChanceCardList();
		number=r.nextInt(list.size())+1;
		card=list.getChanceCard(number);
		list.removeChanceCard(number);
		return card;
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

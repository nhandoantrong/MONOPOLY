package cell;
import java.util.*;
public class ChanceCardList 
{
	private ArrayList <ChanceCard> list=new ArrayList<ChanceCard>();
	public ChanceCardList()
	{
		list.add(new ChanceCard("Take a trip to HONGKONG AIRPORT.\nIf you pass GO collect $2000 ",0,0,5));
		list.add(new ChanceCard("Advance to PARIS.\nIf you pass GO collect $2000 ",0,0,24));
		list.add(new ChanceCard("Make general repairs on all your property: \n"
				+ "for each house pay $250\n"
				+ "for each hotel pay $1000 ",0,0,-1));
		list.add(new ChanceCard("Go to jail.\n Go directly to jail.\nDo not pass GO,\n do not collect $2000 ",1,0,10));
		list.add(new ChanceCard("Building loan matures.\n Collect $1500",0,1500,-1));
		list.add(new ChanceCard("Advance to RIO DE JANEIRO",0,0,39));
		
	}
	public ChanceCard getChanceCard(int num)
	{
		return list.get(num-1);
	}
	public void removeChanceCard(int num)
	{
		list.remove(num-1);
	}
	public int size()
	{
		return list.size();
	}
	public Boolean isEmpty()
	{
		return list.isEmpty();
	}
}

package player;
import cell.*;
public class Player 
{
	private int turn,pos;
	private String name;
	private Money money;
	private OwnLand landlist;
	
	public Player(String name,int turn, int pos,  Money money) {
		this.turn = turn;
		this.pos = pos;
		this.name = name;
		this.money = money;
		landlist = new OwnLand();
	}
	public void step(int st)
	{
		pos=(pos+st)%40;
	}
	public String getName()
	{
		return name;
	}
	public void addLand(Cell cell)
	{
		landlist.addLand(cell);
	}
	public OwnLand getList()
	{
		return landlist;
	}
	public Money getMoney()
	{
		return money;
	}
}

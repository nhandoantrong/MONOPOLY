package player;
import cell.*;
public class Player 
{
	private int turn,pos,jailturn=0;
	private String name;
	private Money money;
	private OwnLand landlist;
	private Boolean jail=false;
	
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
	public int getPos()
	{
		return pos;
	}
	public void setPos(int pos)
	{
		this.pos=pos;
	}
	public void setJail(Boolean n)
	{
		jail=n;
	}
	public void setJailturn(int jailturn)
	{
		this.jailturn=jailturn;
	}
	public Boolean getJail()
	{
		return jail;
	}
	public int getJailturn()
	{
		return jailturn;
	}
}

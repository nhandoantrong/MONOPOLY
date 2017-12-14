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
		/*move player's st steps ahead*/
		pos=(pos+st)%40;
	}
	public String getName()
	{
		/*return player's name*/
		return name;
	}
	public void addLand(Cell cell)
	{
		/*add cell to player's cell list*/
		landlist.addLand(cell);
	}
	public OwnLand getList()
	{
		/*return the player's cell list*/
		return landlist;
	}
	public Money getMoney()
	{
		/*return player's money*/
		return money;
	}
	public int getPos()
	{
		/*return player's position*/
		return pos;
	}
	public void setPos(int pos)
	{
		/*set player's position*/
		this.pos=pos;
	}
	public void setJail(Boolean n)
	{
		/*set player's jail state*/
		jail=n;
	}
	public void setJailturn(int jailturn)
	{
		/*set player's jail turn*/
		this.jailturn=jailturn;
	}
	public Boolean getJail()
	{
		/*return player's jail state*/
		return jail;
		
	}
	public int getJailturn()
	{
		/*return player's jail turn*/
		return jailturn;
	}
}

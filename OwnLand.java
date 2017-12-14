package player;

import cell.*;
import java.util.*;
public class OwnLand 
{
	private ArrayList<Cell> list;
	public OwnLand()
	{
		list= new ArrayList<Cell>();
	}
	public void addLand(Cell a)
	{
		/*add Cell a to player's land list*/
		list.add(a);
	}
	public void remove(Cell a)
	{
		/*remove cell from player's cell list*/
		list.remove(a);
	}
	public int size()
	{
		/*return the number of player's owned lands*/
		return list.size();
	}
	public Cell getLand(int i)
	{
		/*return the i'th land of player */
		return list.get(i);
	}
}

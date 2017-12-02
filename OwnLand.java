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
		list.add(a);
	}
	public void remove(Cell a)
	{
		list.remove(a);
	}
	public int size()
	{
		return list.size();
	}
	public Cell getLand(int i)
	{
		return list.get(i);
	}
}

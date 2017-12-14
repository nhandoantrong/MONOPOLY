package player;

public class Money  {
	private int value;
	public Money(int value)
	{
		this.value=value;
	}
	public void substract(int cost)
	{
		/*subtract money*/
		value-=cost;
	}
	public void add(int cost)
	{
		/*add money*/
		value+=cost;
	}
    public int getValue()
    {
    	/*return player's money*/
    	return value;
    }
    public String toString()
    {
    	/*return the amount of money*/
    	return String.valueOf(value);
    }
}
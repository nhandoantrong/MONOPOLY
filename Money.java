package player;

public class Money  {
	private int value;
	public Money(int value)
	{
		this.value=value;
	}
	public void substract(int cost)
	{
		value+=cost;
	}
	public void add(int cost)
	{
		value+=cost;
	}
    public int getValue()
    {
    	return value;
    }
    public String toString()
    {
    	return String.valueOf(value);
    }
}
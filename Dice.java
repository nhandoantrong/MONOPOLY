import java.util.*;
public class Dice
{
	private int  dice1,dice2;
	private Random r=new Random();
	public Dice()
	{
		dice1=dice2=1;
	}
	public void roll()
	{
		/*Roll dices*/
		dice1=r.nextInt(6)+1;
		dice2=r.nextInt(6)+1;
	}
	public int getDice1()
	{
		/*Return Dice 1 */
		return dice1;
	}
	public int getDice2()
	{
		/*Return Dice 2 */
		return dice2;
	}

}


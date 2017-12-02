import java.util.*;
import cell.*;
import player.*;
public class PlayingTurn
{
	Dice dice =new Dice();
	int x,y;
	
	public PlayingTurn()
	{
		dice.roll();
		x=dice.getDice1();
		y=dice.getDice2();
	}
}

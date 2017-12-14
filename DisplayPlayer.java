import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import player.*;
import cell.*;
public class DisplayPlayer extends JPanel {
	private String name;
	private int x=20,y=60;
	private Player player;
	private Font fi = new Font("Arial", Font.PLAIN, 20);
	private Font na = new Font("Arial", Font.BOLD, 15);
	private Font se = new Font("Arial", Font.BOLD, 12);
	public DisplayPlayer(Player player)
	{
		this.player=player;
		name=player.getName();
	}
	public void setPlayer(Player player)
	{
		/*Set player to display*/
		this.player=player;
	}
	@Override
	public void paintComponent(Graphics g)
	{
		/*display player*/
		super.paintComponent(g);
		g.setFont(fi);
		g.drawString("PLAYER",10,20);
		g.setFont(fi);
		g.setColor(Color.RED);
		g.drawString(name, 20, 40);
		g.setColor(Color.BLACK);
		g.setFont(se);
		g.drawString("Own Land :", 10, 80);
		y=80;
		g.drawString("Money : "+player.getMoney(), 10, 60);
		for (int i=0;i<player.getList().size();i++)
		{
			y+=20;
			if (player.getList().getLand(i).getType()=="land")
			g.drawString(player.getList().getLand(i).getName()+" ("+String.valueOf(player.getList().getLand(i).getHouse())+" house(s) ) "+"cost: "+String.valueOf(player.getList().getLand(i).getCost()), x, y);
			else g.drawString(player.getList().getLand(i).getName(),x,y);
		}
		
	}
}

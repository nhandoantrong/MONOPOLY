import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DisplayWinner extends JPanel
{
	private ImageIcon lulu=new ImageIcon("luluBackGround.png");
	private ImageIcon annie=new ImageIcon("AnnieBackGround.jpg");
	private int win;
	public DisplayWinner(int win)
	{
		this.win=win;
	}
	@Override
    public void paintComponent (Graphics g) 
	 {
		super.paintComponent(g);
		if (win==0)
		{
			g.drawImage(lulu.getImage(),0,0,1200,900,null);
		}
		else g.drawImage(annie.getImage(), 0, 0,1200,900, null);
	 }
}

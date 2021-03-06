import java.awt.*;
import javax.swing.*;
public class DisplayTurn extends JPanel
{
	private ImageIcon annie=new ImageIcon("AnnieSkin.jpg");
	private ImageIcon lulu=new ImageIcon("luludragon.png");
	private int turn;
	public DisplayTurn(int turn)
	{
		this.turn=turn;
	}
	public void setTurn(int turn)
	{
		/*Set turn to display the playerPicture */
		this.turn=turn;
	}
	@Override
    public void paintComponent (Graphics g) 
	 {
		/*Draw image of player who is playing */
		super.paintComponent(g);
		if (turn==0)
		{
			g.drawImage(lulu.getImage(),0,0,null);
		}
		else g.drawImage(annie.getImage(), 0, 0, null);
	 }
}

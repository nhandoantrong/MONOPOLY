import javax.swing.JPanel;
import java.awt.*;

import cell.*;
public class DisplayCell extends JPanel {

	private Cell cell;
	private int rent;
	private Font na = new Font("Arial", Font.BOLD, 15);
	private Font se = new Font("Arial", Font.BOLD, 12);
	public DisplayCell(Cell cell)
	{
		this.cell=cell;
		rent=cell.getPrice();
		rent/=10;
	}
	public void setCell(Cell cell)
	{
		/*Set cell to display */
		this.cell=cell;
		rent=cell.getPrice()/10;
	}
	@Override
	public void paintComponent(Graphics g)
	{
		/*Display cell's information */
		super.paintComponent(g);
		g.setFont(na);
		g.drawString("Land: "+cell.getName(), 5,20);
		g.setFont(se);
		if (cell.getType()=="land")
		{
			g.drawString("RENT : "+rent,5,32);
			g.drawString("With 1 house : "+rent*5,5,44);
			g.drawString("with 2 houses : "+rent*5*3,5,56);
			g.drawString("with 3 houses: "+rent*5*3*3,5,68);
			g.drawString("with 4 houses : "+rent*5*3*3*5/4,5,80);
			g.drawString("with hotel : "+rent*5*3*3*5*5/4/4,5,92);
			g.drawString("PRICE: "+cell.getPrice(), 5, 104);
			g.drawString("Houses Cost : "+cell.getHousePrice(),5,116);
		}
		else if (cell.getType()=="airport"||cell.getType()=="company")
		{
			g.drawString("RENT : 250",5,32);
			g.drawString("PRICE: "+cell.getPrice(), 5, 44);
		}
	}
}

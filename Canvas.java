import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Canvas extends JPanel //implements MouseListener
	{
		
		private ImageIcon[] dice= {new ImageIcon ("1.jpg"),new ImageIcon ("2.jpg"),new ImageIcon ("3.jpg"),
				new ImageIcon ("4.jpg"),new ImageIcon ("5.jpg"),new ImageIcon ("6.jpg")};
		
		private int x,y,d1,d2,x2,y2;

		public Canvas(int x,int y,int x2,int y2,int d1,int d2)
		{
			
			this.x=x;
			this.y=y; 	
			this.d1=d1;
			this.d2=d2;
			this.x2=x2;
			this.y2=y2;
			this.setLayout(new FlowLayout());
		}
		public void setXY(int x,int y)
		{
			/*Set position to display Lulu */
			this.x=x;
			this.y=y;
		}
		public void setXY2(int x2,int y2)
		{
			/*Set position to display Annie */
			this.x2=x2;
			this.y2=y2;
		}
		public void setDice(int d1,int d2)
		{
			/*Set dice faces */
			this.d1=d1;
			this.d2=d2;
		}
		
		@Override
	    public void paintComponent (Graphics g) 
		 {
			/*draw Canvas*/
	       super.paintComponent(g);
	       g.drawImage(board.getImage(),0 ,0 ,null );
	       g.drawImage(lulu.getImage(), x, y, null);
	       g.drawImage(annie.getImage(), x2, y2, null);
	       g.drawImage(dice[d1-1].getImage(),300,300,null);
	       g.drawImage(dice[d2-1].getImage(),400,300,null);
	     
	    }
//		  @Override
//		   public void mouseClicked(MouseEvent evt)
//		  {
//			  
//		  }
//		  @Override public void mousePressed(MouseEvent evt) 
//		  {
//			  
//		  }
//		   @Override public void mouseReleased(MouseEvent evt) { }
//		   @Override public void mouseEntered(MouseEvent evt) { }
//		   @Override public void mouseExited(MouseEvent evt) { }
	}

import java.awt.*;     
import java.net.URL;
import javax.swing.*;  
import java.util.concurrent.TimeUnit;
import java.util.Formatter;
import java.util.Random;
import java.awt.event.*;
import cell.*;
import player.*;
public class Field extends JFrame implements MouseMotionListener
{
	private JTextField t1 = new JTextField(""),t2=new JTextField("");
	private JButton rollButton= new JButton("Roll");
	private JButton buyButton= new JButton("Buy");
	private JButton upgradeButton= new JButton("Uprade House");
	
	private Player play1= new Player("LULU",0,0,new Money(2000));
	private Canvas canvas=new Canvas(630,620,1,1);
	private DisplayPlayer displayplayer=new DisplayPlayer(play1);
	private int x=630,y=620,co=0,d1=1,d2=1,turn=0;
	private Dice dice=new Dice();

	
	private CellList celllist= new CellList();
	public Field()
	{
		Container cp=getContentPane();
		cp.setLayout(null);
		d1=dice.getDice1();
		d2=dice.getDice2();
		
		displayplayer.setPlayer(play1);
		cp.add(canvas);
		cp.add(rollButton);
		cp.add(buyButton);
		cp.add(upgradeButton);
		cp.add(displayplayer);
		
		displayplayer.setBounds(701, 0, 200, 300);
		canvas.setBounds(0, 0, 700, 700);
		rollButton.setBounds(701, 400, 100, 50);
		rollButton.addActionListener(new rollListener());
		buyButton.setBounds(801, 400, 100, 50);
		buyButton.addActionListener(new buyListener());
		buyButton.setEnabled(false);
		upgradeButton.setBounds(901, 400, 200, 50);
		upgradeButton.setEnabled(false);
		upgradeButton.addActionListener(new upgradeListener());
		
		addMouseMotionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Exit program if close-window button clicked
	    setTitle("MONOPOLY"); // "super" JFrame sets title
	    setSize(1200,800);         // "super" JFrame sets initial size
	    setVisible(true);  
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent evt) {
	}
	private class rollListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent evt) 
		{
			dice.roll();
			d1=dice.getDice1();
			d2=dice.getDice2();
			canvas.setDice(d1, d2);
			play1.step(d1+d2);
			
			int pos = play1.getPos();
			String type=celllist.get(pos).getType();
			System.out.print(pos);
			System.out.println(" "+type);
			
			repaint();
			Thread move=new Thread()
			{
				@Override
				public void run() 
				{
					rollButton.setEnabled(false);
					buyButton.setEnabled(false);
					upgradeButton.setEnabled(false);
					for (int i=0;i<(d1+d2)*57;i++)
					{
						if ((x>630-57*10) &&y==620) x--;
						else if (x==630-57*10&&y>620-57*10) y--;
						else if (x<630&&y==620-57*10) x++;
						else if (x==630&& y<620) y++;
						canvas.setXY(x,y);
						repaint();
						try {
			                  // Delay and give other thread a chance to run
			                  Thread.sleep(3);  // milliseconds
			               } catch (InterruptedException ignore) {}
					}
					rollButton.setEnabled(true);
					buyButton.setEnabled(true);
					upgradeButton.setEnabled(true);
					if (type=="cell"||type=="chance")
					{
						buyButton.setEnabled(false);
						upgradeButton.setEnabled(false);
					}
					else if (celllist.get(pos).getOwn()==0)
					{
						buyButton.setEnabled(true);
						upgradeButton.setEnabled(false);
					}
					else if (celllist.get(pos).getType()=="land")
					{
						buyButton.setEnabled(false);
						upgradeButton.setEnabled(true);
					}
					else
					{
						buyButton.setEnabled(false);
						upgradeButton.setEnabled(false);
					}
					if (play1.getPos()==30) 
						{
							play1.setPos(10);
							x=630-57*10;
							y=620;
							canvas.setXY(x, y);
							repaint();
							play1.setJail(true);
							play1.setJailturn(0);
						}
				}
				
			};
			if (play1.getJail()==true)
			{
				if (d1==d2)
				{
					play1.setJail(false);
					move.start();
				}
				else
				{
					play1.setJailturn(play1.getJailturn()+1);
					if (play1.getJailturn()==3)
					{
						play1.setJail(false);
						play1.setJailturn(0);
						play1.getMoney().substract(50);
						move.start();
					}
				}
			}
			else move.start();
		}
	}
	
	private class buyListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent evt) 
		{
			int pos=play1.getPos();
			int own=celllist.get(pos).getOwn();
			if (own ==0)
			{
				play1.addLand(celllist.get(pos));
				play1.getMoney().substract(celllist.get(pos).getPrice());
				celllist.get(pos).setOwn(1);
				buyButton.setEnabled(false);
				repaint();
			}
		}
	}
	
	private class upgradeListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			int pos=play1.getPos();
			int own=celllist.get(pos).getOwn();
			Cell a= celllist.get(pos);
			if (own>0&&own<6)
			{
				celllist.get(pos).houseUpgrade();
				upgradeButton.setEnabled(false);
				repaint();
			}
		}
		
	}
	
	
	  
}

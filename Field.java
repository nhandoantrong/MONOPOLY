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
	
	private Player play1= new Player("LULU",0,0,new Money(20000));
	private Player play2= new Player("ANNIE",0,0,new Money(20000));
	private Canvas canvas=new Canvas(625,615,625+35,615+35,1,1);
	
	private DisplayPlayer displayplayer=new DisplayPlayer(play1);
	private DisplayPlayer displayplayer2=new DisplayPlayer(play2);
	
	private int x=625,y=615,d1=1,d2=1,turn=0,x2=625+35,y2=615+35;
	private Dice dice=new Dice();

	
	private CellList celllist= new CellList();
	private DisplayCell displaycell= new DisplayCell(celllist.get(0));
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
		cp.add(displayplayer2);
		cp.add(displaycell);
		
		displayplayer2.setBounds(951, 0, 250, 300);
		displayplayer.setBounds(701, 0, 250, 300);
		displaycell.setBounds(701,450,200,200);
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
			if (turn==0) {
			turn=1;
			dice.roll();
			d1=dice.getDice1();
			d2=dice.getDice2();
			canvas.setDice(d1, d2);
			play1.step(d1+d2);
			
			int pos = play1.getPos();
			if (pos-d1-d2<0) play1.getMoney().add(2000);
			String type=celllist.get(pos).getType();
			
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
						if ((x>625-57*10) &&y==615) x--;
						else if (x==625-57*10&&y>615-57*10) y--;
						else if (x<625&&y==615-57*10) x++;
						else if (x==625&& y<615) y++;
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
					if (celllist.get(pos).getOwn()==2)
					{
						play1.getMoney().substract(celllist.get(pos).getCost());
						buyButton.setEnabled(false);
						upgradeButton.setEnabled(false);
						repaint();
					}
					else if (type=="cell")
					{
						buyButton.setEnabled(false);
						upgradeButton.setEnabled(false);
						if (pos==4)
							play2.getMoney().substract(2000);
						else if (pos==38)
							play2.getMoney().substract(1000);
						repaint();
					}
					else if (type=="chance")
					{
						buyButton.setEnabled(false);
						upgradeButton.setEnabled(false);
						play2.getMoney().add(celllist.get(pos).getPrice());
						repaint();
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
							x=625-57*10;
							y=615;
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
					play1.setPos(10);
					if (play1.getJailturn()==3)
					{
						play1.setJail(false);
						play1.setJailturn(0);
						play1.step(d1+d2);
						play1.getMoney().substract(50);
						move.start();
					}
				}
			}
			else move.start();
			displaycell.setCell(celllist.get(play1.getPos()));
		}
		else
		{
			turn=0;
			dice.roll();
			d1=dice.getDice1();
			d2=dice.getDice2();
			canvas.setDice(d1, d2);
			play2.step(d1+d2);
			
			int pos = play2.getPos();
			if (pos-d1-d2<0) play2.getMoney().add(2000);
			String type=celllist.get(pos).getType();
			
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
						if ((x2==660) &&y2==650) 
						{
							for (int j =0;j<35;j++)
							{
								x2--;
								canvas.setXY2(x2,y2);
								repaint();
								try {
					                  // Delay and give other thread a chance to run
					                  Thread.sleep(3);  // milliseconds
					               } catch (InterruptedException ignore) {}
							}
							i--;
						}
						else if (x2>660-35-57*10&&y2==650)
						{
								x2--;
								canvas.setXY2(x2,y2);
								repaint();
								try {
					                  // Delay and give other thread a chance to run
					                  Thread.sleep(3);  // milliseconds
					               } catch (InterruptedException ignore) {}
						}
						else if (x2==660-35-57*10&&y2==650)
						{
							for (int j =0;j<35;j++)
							{
								x2--;
								canvas.setXY2(x2,y2);
								repaint();
								try {
					                  // Delay and give other thread a chance to run
					                  Thread.sleep(3);  // milliseconds
					               } catch (InterruptedException ignore) {}
							}
							for (int j =0;j<35;j++)
							{
								y2--;
								canvas.setXY2(x2,y2);
								repaint();
								try {
					                  // Delay and give other thread a chance to run
					                  Thread.sleep(3);  // milliseconds
					               } catch (InterruptedException ignore) {}
							}
							i--;
						}
						else if (x2==660-70-57*10&&y2>650-35-57*10)
						{
							y2--;
							canvas.setXY2(x2,y2);
							repaint();
							try {
				                  // Delay and give other thread a chance to run
				                  Thread.sleep(3);  // milliseconds
				               } catch (InterruptedException ignore) {}
						}
						else if (x2==660-70-57*10&&y2==650-35-57*10)
						{
							for (int j=0;j<35;j++)
							{
								y2--;
								canvas.setXY2(x2,y2);
								repaint();
								try {
					                  // Delay and give other thread a chance to run
					                  Thread.sleep(3);  // milliseconds
					               } catch (InterruptedException ignore) {}
							}
							for (int j=0;j<35;j++)
							{
								x2++;
								canvas.setXY2(x2,y2);
								repaint();
								try {
					                  // Delay and give other thread a chance to run
					                  Thread.sleep(3);  // milliseconds
					               } catch (InterruptedException ignore) {}
							}
							i--;
						}
						else if (x2<660-35&&y2==650-70-57*10) 
						{
							x2++;
							canvas.setXY2(x2,y2);
							repaint();
							try {
				                  // Delay and give other thread a chance to run
				                  Thread.sleep(3);  // milliseconds
				               } catch (InterruptedException ignore) {}
						}
						else if (x2==660-35&&y2==650-70-57*10)
						{
							for (int j=0;j<35;j++)
							{
								x2++;
								canvas.setXY2(x2,y2);
								repaint();
								try {
					                  // Delay and give other thread a chance to run
					                  Thread.sleep(3);  // milliseconds
					               } catch (InterruptedException ignore) {}
							}
							for (int j=0;j<35;j++)
							{
								y2++;
								canvas.setXY2(x2,y2);
								repaint();
								try {
					                  // Delay and give other thread a chance to run
					                  Thread.sleep(3);  // milliseconds
					               } catch (InterruptedException ignore) {}
							}
						}
						else if (x2==660 && y2<650-35) 
							{
								y2++;
								canvas.setXY2(x2,y2);
								repaint();
								try {
					                  // Delay and give other thread a chance to run
					                  Thread.sleep(3);  // milliseconds
					               } catch (InterruptedException ignore) {}
							}
						else if (x2==660 && y2==650-35) 
						{
							for (int j=0;j<35;j++)
							{
								y2++;
								canvas.setXY2(x2,y2);
								repaint();
								try {
					                  // Delay and give other thread a chance to run
					                  Thread.sleep(3);  // milliseconds
					               } catch (InterruptedException ignore) {}
							}
							i--;
						}
					}
					rollButton.setEnabled(true);
					buyButton.setEnabled(true);
					upgradeButton.setEnabled(true);
					if (celllist.get(pos).getOwn()==1)
					{
						play2.getMoney().substract(celllist.get(pos).getCost());
						
						buyButton.setEnabled(false);
						upgradeButton.setEnabled(false);
						repaint();
					}
					else if (type=="cell")
					{
						buyButton.setEnabled(false);
						upgradeButton.setEnabled(false);
						if (pos==4)
							play2.getMoney().substract(2000);
						else if (pos==38)
							play2.getMoney().substract(1000);
						repaint();
					}
					else if (type=="chance")
					{
						buyButton.setEnabled(false);
						upgradeButton.setEnabled(false);
						play2.getMoney().add(celllist.get(pos).getPrice());
						repaint();
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
					if (play2.getPos()==30) 
						{
							play2.setPos(10);
							x2=660-70-57*10;
							y2=650-35;
							canvas.setXY2(x2, y2);
							repaint();
							play2.setJail(true);
							play2.setJailturn(0);
						}
				}
				
			};
			if (play2.getJail()==true)
			{
				if (d1==d2)
				{
					play2.setJail(false);
					move.start();
				}
				else
				{
					play2.setJailturn(play2.getJailturn()+1);
					play2.setPos(10);
					if (play2.getJailturn()==3)
					{
						play2.setJail(false);
						play2.setJailturn(0);
						play2.step(d1+d2);
						play2.getMoney().substract(50);
						move.start();
					}
				}
			}
			else move.start();
			displaycell.setCell(celllist.get(play2.getPos()));
		}
		}
	}
	
	private class buyListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent evt) 
		{
			if (turn==1)
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
			else 
			{
				int pos=play2.getPos();
				int own=celllist.get(pos).getOwn();
				if (own ==0)
				{
					play2.addLand(celllist.get(pos));
					play2.getMoney().substract(celllist.get(pos).getPrice());
					celllist.get(pos).setOwn(2);
					buyButton.setEnabled(false);
					repaint();
				}
			}
		}
	}
	
	private class upgradeListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			if (turn==1)
			{
			int pos=play1.getPos();
			int own=celllist.get(pos).getOwn();
			if (own>0&&own<6)
			{
				celllist.get(pos).houseUpgrade();
				upgradeButton.setEnabled(false);
				repaint();
			}
			}
			else
			{
				int pos=play2.getPos();
				int own=celllist.get(pos).getOwn();
				if (own>0&&own<6)
				{
					celllist.get(pos).houseUpgrade();
					upgradeButton.setEnabled(false);
					repaint();
				}
			}
		}
		
	}
	
	
	  
}